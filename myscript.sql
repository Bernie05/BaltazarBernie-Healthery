DROP TABLE IF EXISTS tblLogin;
CREATE TABLE tblLogin(personid INTEGER NOT NULL AUTO_INCREMENT, picture	VARCHAR(255), username VARCHAR(255) NOT NULL, 
	password VARCHAR(255) NOT NULL, 
	birthday VARCHAR(255) NOT NULL, 
	address VARCHAR(255) NOT NULL, 
	contact INTEGER NOT NULL, PRIMARY KEY(personid));

INSERT INTO tblLogin(username, password, birthday, address, contact) VALUES 
("admin", "admin", "March 22 1995","Blk4 Lot10 France", 09308571062);

CREATE TABLE tblItems(itemsid INTEGER NOT NULL AUTO_INCREMENT, 
	itempicture VARCHAR(255), 
	name VARCHAR(255) NOT NULL, 
	description VARCHAR(255) NOT NULL, 
	price INTEGER NOT NULL,
	healthbenefits VARCHAR(255) NOT NULL, PRIMARY KEY(itemsid));

INSERT INTO tblLogin(name, description, price, nutritionfacts, ingredient) VALUES 
("Baked Parmesan Zucchini", "Crisp, tender zucchini sticks oven-roasted to perfection." + 
"It’s healthy, nutritious and completely addictive!", 900,"zucchini is also the best " + 
"source of dietary fiber that will keep your body in the best shape for the long " + 
"run. It also contains vitamin A, magnesium, folate, potassium, copper, and phosphorus");