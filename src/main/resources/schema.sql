CREATE TABLE IF NOT EXISTS User (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  dob DATE NOT NULL,
  email VARCHAR(50) NOT NULL,
  password  VARCHAR(10) NOT NULL
 );