package org.example.services;

import org.example.entities.Product;
import org.example.entities.VariantMapper;
import org.example.utils.AppValidator;
import org.example.entities.ProductMapper;
import org.example.exceptions.ProductException;
import org.example.repository.impl.ProductRepository;
import org.example.utils.ErrorMessage;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class ProductService {

    private static final Logger LOGGER =
            Logger.getLogger(ProductService.class.getName());

    ProductRepository repository = new ProductRepository();

    public String add(Map<String, String> data) {
        Map<String, String> errors = AppValidator.validateProductData(data);
        if (!errors.isEmpty()) {
            try {
                throw new ProductException("Check inputs", errors);
            } catch (ProductException e) {
//                LOGGER.err(ErrorMessage.DB_ABSENT_MSG);
                return e.getErrors(errors);
            }
        }
        return repository.add(new ProductMapper().mapProductData(data), new VariantMapper().mapVariantData(data));
    }

    public String read() {
        // Отримуємо дані
        Optional<List<Product>> optional = repository.read();
        // Якщо Optional не містить null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (optional.isPresent()) {
            // Отримуємо колекцію з Optional
            List<Product> list = optional.get();
            // Якщо колекція не порожня, формуємо виведення.
            // Інакше повідомлення про відсутність даних.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((product) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") ")
                                .append(product.toString())
                );
                return "\nPRODUCTS:\n" + stringBuilder;
            } else return ErrorMessage.DATA_ABSENT_MSG.getMessage();
        } else return ErrorMessage.DATA_ABSENT_MSG.getMessage();
    }

    public String update(Map<String, String> data) {
        Map<String, String> errors =
                AppValidator.validateProductData(data);
        if (!errors.isEmpty()) {
            try {
                throw new ProductException("Check inputs", errors);
            } catch (ProductException e) {
                return e.getErrors(errors);
            }
        }
        return repository.update(new ProductMapper().mapProductData(data));
    }

    public String delete(Map<String, String> data) {
        Map<String, String> errors =
                AppValidator.validateProductData(data);
        if (!errors.isEmpty()) {
            try {
                throw new ProductException("Check inputs", errors);
            } catch (ProductException e) {
                return e.getErrors(errors);
            }
        }
        return repository.delete(new ProductMapper().mapProductData(data).getId());
    }

    public String readById(Map<String, String> data) {
        Map<String, String> errors =
                AppValidator.validateProductData(data);
        if (!errors.isEmpty()) {
            try {
                throw new ProductException("Check inputs", errors);
            } catch (ProductException e) {
                return e.getErrors(errors);
            }
        }
        // Отримуємо дані
        Optional<Product> optional =
                repository.readById(Integer.parseInt(data.get("id")));
        // Якщо Optional не містить null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (optional.isPresent()) {
            // Отримуємо об'єкт з Optional
            Product product = optional.get();
            return "\nPRODUCT: " + product + "\n";
        } else return ErrorMessage.DATA_ABSENT_MSG.getMessage();
    }
}
