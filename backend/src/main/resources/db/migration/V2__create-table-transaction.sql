CREATE TABLE IF NOT EXISTS Transaction(
    id INT NOT NULL AUTO_INCREMENT,
    account_id INT NOT NULL,
    origin_account_id VARCHAR(255) NOT NULL,
    destination_account_id VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    fee DECIMAL(10, 2) DEFAULT 0.00,
    transfer_date DATE NOT NULL,
    scheduling_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);