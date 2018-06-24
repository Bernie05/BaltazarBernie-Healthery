DROP TABLE IF EXISTS tblMyCart;
DROP TABLE IF EXISTS tblItems;
DROP TABLE IF EXISTS tblCustomers;
DROP TABLE IF EXISTS tblDeliverer;

CREATE TABLE tblCustomers(customerID VARCHAR(15) NOT NULL, 
	picture VARCHAR(50), 
	username VARCHAR(15) NOT NULL, 
	password VARCHAR(15) NOT NULL,
	fullname VARCHAR(50) NOT NULL, 
	address VARCHAR(40) NOT NULL, 
	birthday VARCHAR(16) NOT NULL, 
	gender VARCHAR(16) NOT NULL, 
	contact VARCHAR(40) NOT NULL, 
	status VARCHAR(20) NOT NULL,
	PRIMARY KEY(customerID));

INSERT INTO tblCustomers(customerID, username, password, fullname, address, birthday, gender, contact, status) VALUES 
("001", "username1", "password", "Bernie A. Baltazar", "Blk4 Lot10 France", "March 22 1995", "Male", "09308571062", "active");
INSERT INTO tblCustomers(customerID, username, password, fullname, address, birthday, gender, contact, status) VALUES 
("002", "username2", "password", "Princess Emmanuelle R. Espiel", "Blk4 Lot10 France", "March 22 1995", "Male","09308571062", "active");

CREATE TABLE tblItems(productID VARCHAR(15) NOT NULL,
	code VARCHAR(15) NOT NULL,
	picture VARCHAR(30),
	name VARCHAR(50) NOT NULL, 
	quantity VARCHAR(15) DEFAULT '0',
	description VARCHAR(255) NOT NULL, 
	price VARCHAR(50) NOT NULL,
	healthbenefits VARCHAR(255) NOT NULL,
	type VARCHAR(50) NOT NULL,
	PRIMARY KEY(code));

INSERT INTO tblItems(productID, code, picture, name, quantity, description, price, healthbenefits, type) VALUES
("20548648", "A1", "image", "Baked Parmesan Zucchini", 5,"It contains vitamin A, magnesium, folate, potassium, copper, and phosphorus", "900","Secret","food");
INSERT INTO tblItems(productID, code, picture, name, quantity, description, price, healthbenefits, type) VALUES
("20101020","A2", "image", "Smashed Chickpea Salad Toasts", 5,"Combo of coarsely mashed chickpeas, mayo, pickles, celery, and onion", "900","Secret","food");
INSERT INTO tblItems(productID, code, picture, name, quantity, description, price, healthbenefits, type) VALUES
("03020151","D1","image", "Green Tea", 2, "Hefty antioxidants it packs", "100","Help prevent inflammation, heart disease, and cancer.","beverage");
INSERT INTO tblItems(productID, code, picture, name, quantity, description, price, healthbenefits, type) VALUES
("85745120","D2","image", "Low Fat Milk", 2, "outed as an excellent source of calcium and vitamin D", "120", "great sources of protein and other essential micronutrients","beverage");

CREATE TABLE tblDeliverer(
	delivererID VARCHAR(15) NOT NULL, 
	picture VARCHAR(50), 
	fullname VARCHAR(20) NOT NULL, 
	companyname VARCHAR(30) NOT NULL, 
	address VARCHAR(30) NOT NULL, 
	birthday VARCHAR(15) NOT NULL,
	gender VARCHAR(6) NOT NULL,
	contactNo VARCHAR(12) NOT NULL, 
	PRIMARY KEY(delivererID));

INSERT INTO tblDeliverer(delivererID, fullname, companyname, address, birthday, gender, contactNo) VALUES ("20151", "Delivery Boy", "Healthery", "Blk 5 Lot 5", "March 22 1995", "Male", "09308571062");

CREATE TABLE tblMyCart(customerCart VARCHAR(15) NOT NULL, 
	code VARCHAR(15) NOT NULL, 
	name VARCHAR(50) NOT NULL, 
	quantity VARCHAR(15) DEFAULT '0',
	price VARCHAR(50) NOT NULL,
	delivererID VARCHAR(50) NOT NULL,
	FOREIGN KEY(code) REFERENCES tblItems(code),
	FOREIGN KEY(customerCart) REFERENCES tblCustomers(customerID),
	FOREIGN KEY(delivererID) REFERENCES tblDeliverer(delivererID));

INSERT INTO tblMyCart(customerCart, code, delivererID, name, quantity, price ) VALUES ("001", "A1", "20151", "Baked Parmesan Zucchini", 1, "900");

