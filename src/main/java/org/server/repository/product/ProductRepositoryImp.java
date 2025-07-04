package org.server.repository.product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.server.config.HibernateConfig;
import org.server.dto.ProductDtoRequest;
import org.server.entities.Product;
import org.server.entities.Variant;
import org.server.utils.ErrorMessage;
import org.server.utils.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;


public class ProductRepositoryImp implements ProductRepository {

    private static final Logger LOGGER =
            LogManager.getLogger(ProductRepositoryImp.class.getName());

    @Override
    public void save(ProductDtoRequest request) {
        Product product = new Product(request);
        Variant variant = new Variant(request);
        Transaction transaction = null;
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(product);
            variant.setProduct(product);
            session.persist(variant);
            session.flush();

            transaction.commit();
            LOGGER.info(Status.DATA_INSERT_MSG.getMessage());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
            }
        }
    }

    @Override
    public Optional<List<Product>> getAll() {
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {

            List<Product> list =
                    session.createQuery("FROM Product", Product.class)
                            .list();

            return Optional.of(list);
        } catch (Exception e) {
            LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
            return Optional.empty();
        }
    }


    @Override
    public void update(Long id, ProductDtoRequest request) {
            Transaction transaction = null;
            Product product = new Product(request);
            try (Session session =
                         HibernateConfig.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                // Is useful if it is necessary to update entry by specific parameter.
//                String hql = "UPDATE Product " +
//                        "SET description = :description, title = :title, category = :category, typeId = :typeId, vendorId = :vendorId, groupById = :groupById, isWeiged = :isWeiged," +
//                        "measureUnit = :measureUnit WHERE id = :id";
//                MutationQuery query = session.createMutationQuery(hql);
//                query.setParameter("description", product.getDescription());
//                query.setParameter("title", product.getTitle());
//                query.setParameter("category", product.getCategory());
//                query.setParameter("typeId", product.getTypeId());
//                query.setParameter("vendorId", product.getVendorId());
//                query.setParameter("groupById", product.getGroupById());
//                query.setParameter("isWeiged", product.getIsWeiged());
//                query.setParameter("measureUnit", product.getMeasureUnit());
//                query.executeUpdate();
                product.setId(id);
                session.merge(product);
                session.flush();
                transaction.commit();
                LOGGER.info(Status.DATA_UPDATE_MSG.getMessage());
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                    LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
                }
            }
        }
    

    @Override
    public boolean deleteById(Long id) {
        if (getById(id).isEmpty()) {
            LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
            return false;
        } else {
            Transaction transaction = null;
            try (Session session =
                         HibernateConfig.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                // Is useful if it is necessary to delete entry by not id.
//                String hql = "DELETE FROM Product WHERE id = :id";
//                MutationQuery query = session.createMutationQuery(hql);
//                query.setParameter("id", id);
//                query.executeUpdate();
                Optional<Product> product = getById(id);
                if (product.isPresent()) {
                    session.remove(product.get());
                }
                transaction.commit();
                LOGGER.warn(Status.DATA_DELETE_MSG.getMessage());
                return true;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                    LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
                }
                return false;
            }
        }
    }


    @Override
    public Optional<Product> getById(Long id) {
        Optional<Product> optional;
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {
            //Is useful if it is necessary to get entry by not id.
//            String hql = " FROM Product c WHERE c.id = :id";
//            Query<Product> query = session.createQuery(hql, Product.class);
//            query.setParameter("id", id);
            Product product = session.find(Product.class, id);
            optional = Optional.ofNullable(product);
            return optional;
        } catch (Exception e) {
            LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Product> getLastEntity() {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // Транзакція стартує
            transaction = session.beginTransaction();
            Query<Product> query =
                    session.createQuery("FROM Product ORDER BY id DESC", Product.class);
            query.setMaxResults(1);
            Product product = query.uniqueResult();
            // Транзакція виконується
            transaction.commit();
            return Optional.of(product);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    private boolean isEntityWithSuchIdExists(Product product) {
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {
            product = session.get(Product.class, product.getId());
            if (product != null) {
                Query<Product> query =
                        session.createQuery("FROM Product", Product.class);
                query.setMaxResults(1);
                query.getResultList();
            }
            return product != null;
        }
    }

}
