CREATE TABLE IF NOT EXISTS Account(
    id INT NOT NULL AUTO_INCREMENT,
    number VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);