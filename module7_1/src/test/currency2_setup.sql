
DROP DATABASE IF EXISTS currency2;
CREATE DATABASE currency2;
USE currency2;

CREATE TABLE CURRENCY (
                          abbreviation VARCHAR(3) NOT NULL,
                          name VARCHAR(50) NOT NULL,
                          conversion_rate_to_EUR DECIMAL(10, 6) NOT NULL,
                          PRIMARY KEY (abbreviation)
);

INSERT INTO currency (abbreviation, name, conversion_rate_to_EUR) VALUES
                                                                      ('EUR', 'Euro', 1.000000),
                                                                      ('USD', 'US Dollar', 0.939000),
                                                                      ('GBP', 'British Pound', 1.146000),
                                                                      ('JPY', 'Japanese Yen', 0.006400),
                                                                      ('AUD', 'Australian Dollar', 0.601000),
                                                                      ('CAD', 'Canadian Dollar', 0.695000),
                                                                      ('CHF', 'Swiss Franc', 1.023000),
                                                                      ('CNY', 'Chinese Yuan', 0.129000),
                                                                      ('NZD', 'New Zealand Dollar', 0.560000),
                                                                      ('SEK', 'Swedish Krona', 0.090000),
                                                                      ('NOK', 'Norwegian Krone', 0.087000),
                                                                      ('MXN', 'Mexican Peso', 0.050000),
                                                                      ('INR', 'Indian Rupee', 0.011000),
                                                                      ('RUB', 'Russian Ruble', 0.011500),
                                                                      ('BRL', 'Brazilian Real', 0.190000),
                                                                      ('ZAR', 'South African Rand', 0.054000);

DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT,INSERT,UPDATE,DELETE ON currency2.* TO 'appuser'@'localhost';

GRANT CREATE, DROP, ALTER ON currency2.* TO 'appuser'@'localhost';