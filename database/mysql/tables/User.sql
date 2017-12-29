／／2017-12-28T00:18:40.518586Z 1 [Note] A temporary password is generated for root@localhost: testtest

CREATE TABLE IF NOT EXISTS USER
  (
     id VARCHAR(100) NOT NULL PRIMARY KEY,
     email VARCHAR(50) NOT NULL UNIQUE,
     password VARCHAR(30) NOT NULL,
     name VARCHAR(50) NOT NULL,
     role VARCHAR(10) NOT NULL default 'customer',
     mobile VARCHAR(20),
     sex CHAR(1),
     description varchar(255),
     disabled BOOLEAN default FALSE,
     create_time DATETIME NOT NULL,
     update_time DATETIME
   );
   CREATE INDEX idx_email ON USER (email);
   CREATE INDEX idx_name ON USER (name);
   CREATE INDEX idx_role ON USER (role);