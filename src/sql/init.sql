USE onlinestore;
DROP TABLE IF EXISTS orderhistory;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS sku;
DROP TABLE IF EXISTS productcatalog;

CREATE TABLE IF NOT EXISTS productcatalog (
    product_id VARCHAR(255) PRIMARY KEY,
    product_name VARCHAR(255),
    category VARCHAR(255) NOT NULL,
    sumbnail_image_path VARCHAR(255) NOT NULL,
    description TEXT,
    is_instock BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS sku (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    product_id VARCHAR(255),
    FOREIGN KEY (product_id)
        REFERENCES productcatalog (product_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS inventory (
    sku_id VARCHAR(255),
    stock INT,
    FOREIGN KEY (sku_id)
        REFERENCES sku (id)
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS orderhistory (
    order_id VARCHAR(255) PRIMARY KEY,
    sku_id VARCHAR(255),
    order_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sku_id)
        REFERENCES inventory (sku_id)
) ENGINE=InnoDB;