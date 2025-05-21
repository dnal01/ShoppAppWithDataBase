package org.example.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.config.HibernateConfig;
import org.example.entities.Product;
import org.example.entities.Variant;
import org.example.repository.AppRepository;
import org.example.utils.ErrorMessage;
import org.example.utils.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;


public class ProductRepository implements AppRepository<Product, Variant> {

    private static final Logger LOGGER =
            LogManager.getLogger(ProductRepository.class);

    @Override
    public String add(Product product, Variant variant) {
        Transaction transaction = null;
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(product);
            variant.setProduct(product);
            session.persist(variant);
            session.flush();
//            String hql = "INSERT INTO Product " +
//                    "(description, title, category, typeId, vendorId, groupById, isWeiged, measureUnit) " +
//                    "VALUES (:description, :title, :category, :typeId, :vendorId, :groupById, :isWeiged, :measureUnit)";
//
//            String hql2 = "INSERT INTO Variant " +
//                    "(media, barcode, leftovers, cost, margin, price, orderLimits, productId) " +
//                    "VALUES (:media, :barcode, :leftovers, :cost, :margin, :price, :orderLimits, :productId)";
//
//            MutationQuery query = session.createMutationQuery(hql);
//            query.setParameter("description", product.getDescription());
//            query.setParameter("title", product.getTitle());
//            query.setParameter("category", product.getCategory());
//            query.setParameter("typeId", product.getTypeId());
//            query.setParameter("vendorId", product.getVendorId());
//            query.setParameter("groupById", product.getGroupById());
//            query.setParameter("isWeiged", product.getIsWeiged());
//            query.setParameter("measureUnit", product.getMeasureUnit());
//
//            MutationQuery query2 = session.createMutationQuery(hql2);
//            query2.setParameter("media",variant.getMedia());
//            query2.setParameter("barcode",variant.getBarcode());
//            query2.setParameter("leftovers",0);
//            query2.setParameter("cost",variant.getCost());
//            query2.setParameter("margin",variant.getMargin());
//            query2.setParameter("price",variant.getPrice());
//            query2.setParameter("orderLimits",0);
//            query2.setParameter("productId",1);
//            query2.executeUpdate();
//            query.executeUpdate();
            transaction.commit();

            return Status.DATA_INSERT_MSG.getMessage();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
            }
            return e.getMessage();
        }
    }

    @Override
    public Optional<List<Product>> read() {
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
    public String update(Product product) {
        if (readById(product.getId()).isEmpty()) {
            return Status.DATA_ABSENT_MSG.getMessage();
        } else {
            Transaction transaction = null;
            try (Session session =
                         HibernateConfig.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                String hql = "UPDATE Product " +
                        "SET description = :description, title = :title, category = :category, typeId = :typeId, vendorId = :vendorId, groupById = :groupById, isWeiged = :isWeiged," +
                        "measureUnit = :measureUnit WHERE id = :id";
                MutationQuery query = session.createMutationQuery(hql);
                query.setParameter("description", product.getDescription());
                query.setParameter("title", product.getTitle());
                query.setParameter("category", product.getCategory());
                query.setParameter("typeId", product.getTypeId());
                query.setParameter("vendorId", product.getVendorId());
                query.setParameter("groupById", product.getGroupById());
                query.setParameter("isWeiged", product.getIsWeiged());
                query.setParameter("measureUnit", product.getMeasureUnit());
                query.executeUpdate();
                transaction.commit();
                LOGGER.info(Status.DATA_UPDATE_MSG.getMessage());
                return Status.DATA_UPDATE_MSG.getMessage();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                    LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
                }
                return e.getMessage();
            }
        }
    }

    @Override
    public String delete(int id) {
        if (readById(id).isEmpty()) {
            LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
            return Status.DATA_ABSENT_MSG.getMessage();
        } else {
            Transaction transaction = null;
            try (Session session =
                         HibernateConfig.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                String hql = "DELETE FROM Product WHERE id = :id";
                MutationQuery query = session.createMutationQuery(hql);
                query.setParameter("id", id);
                query.executeUpdate();
                transaction.commit();
                return Status.DATA_DELETE_MSG.getMessage();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                    LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
                }
                return e.getMessage();
            }
        }
    }

    @Override
    public Optional<Product> readById(int id) {
        Transaction transaction = null;
        Optional<Product> optional;
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {

            String hql = " FROM Product c WHERE c.id = :id";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("id", id);
            optional = query.uniqueResultOptional();
            return optional;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                LOGGER.warn(ErrorMessage.LOG_DB_ERROR_MSG.getMessage());
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
