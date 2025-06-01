CREATE TABLE IF NOT EXISTS vendors
(
    id SMALLINT NOT NULL AUTO_INCREMENT,
    name TEXT(32) NOT NULL,
    phone VARCHAR(32),
    address VARCHAR(32),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS product_types
(
    id SMALLINT NOT NULL AUTO_INCREMENT,
    type TEXT(32) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS products
(
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    description TEXT(612) NOT NULL,
    title VARCHAR(64) NOT NULL,
    category VARCHAR(64) NOT NULL,
    type_id SMALLINT NOT NULL,
    vendor_id SMALLINT NOT NULL,
    group_by_id SMALLINT NOT NULL,
    #     collections
    #     tags
    is_weighed BOOL NOT NULL,
    measure VARCHAR(12) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (type_id) REFERENCES product_types (id),
    FOREIGN KEY (vendor_id) REFERENCES vendors (id)
    );

CREATE TABLE IF NOT EXISTS variants
(
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    media VARCHAR(16) NOT NULL,
    barcode VARCHAR(20) NOT NULL,
    #     expire_date DATE NOT NULL, (several expire_dates based on deliveries)
    #     deliveries
    #     Inventories
    leftovers TINYINT NOT NULL,
    cost DECIMAL(6,2) NOT NULL,
    margin DECIMAL(6,2) NOT NULL,
    price DECIMAL(6,2) NOT NULL,
    order_limits TINYINT NOT NULL,
    product_id MEDIUMINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES products(id)
    );