DROP TABLE IF EXISTS trade_store;

CREATE TABLE trade_store (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  trade-id VARCHAR(20) NOT NULL
  version INT(10) NOT NULL,
  counter-party-id VARCHAR(25) NOT NULL,
  book-id VARCHAR(250) NOT NULL,
  maturity-date DATE NOT NULL,
  created_date DATE default CURRENT_DATE,
  expired-flag CHAR(1) NOT NULL
);