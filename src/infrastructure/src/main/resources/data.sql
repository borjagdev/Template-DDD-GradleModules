DROP TABLE IF EXISTS resource_table;

CREATE TABLE resource_table (
  resource_id VARCHAR(250)  PRIMARY KEY,
  resource_name VARCHAR(250) NOT NULL,
  resource_date VARCHAR(250) NOT NULL
);