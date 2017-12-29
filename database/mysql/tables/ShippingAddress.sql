CREATE TABLE IF NOT EXISTS SHIPPING_ADDRESS
  (
     id VARCHAR(100) NOT NULL PRIMARY KEY,
     user_id VARCHAR(100) NOT NULL,
     consignee_address VARCHAR(150) NOT NULL,
     consignee_name VARCHAR(50) NOT NULL,
     identity_card_number VARCHAR(30),
     phone VARCHAR(20),
     default_address BOOLEAN default FALSE,
     create_time DATETIME NOT NULL,
     update_time DATETIME,
     
     CONSTRAINT FK_USER FOREIGN KEY (user_id) REFERENCES USER(id)
   );
   CREATE INDEX idx_consignee_name ON SHIPPING_ADDRESS (consignee_name);
   CREATE INDEX idx_identity_card_number ON SHIPPING_ADDRESS (identity_card_number);