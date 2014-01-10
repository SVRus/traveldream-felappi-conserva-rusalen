CREATE TABLE REGISTEREDUSER (USERNAME VARCHAR(255) NOT NULL, REGISTEREDUSER_TYPE VARCHAR(31), EMAIL VARCHAR(255), NAME VARCHAR(255), PASSWORD VARCHAR(255), SURNAME VARCHAR(255), TELEPHONE VARCHAR(255), PRIMARY KEY (USERNAME))
CREATE TABLE CUSTOMER (USERNAME VARCHAR(255) NOT NULL, PRIMARY KEY (USERNAME))
CREATE TABLE TRAVELPACKAGE (IDTRAVELPACKAGE BIGINT AUTO_INCREMENT NOT NULL, TRAVELPACKAGE_TYPE VARCHAR(31), DESCRIPTION VARCHAR(255), FRIENDCODE BIGINT, IDCUSTOMERBUYER VARCHAR(255), IDCUSTOMERFRIENDOWNER VARCHAR(255), NAME VARCHAR(255) UNIQUE, PURCHASETIME DATETIME, TIME_END DATETIME, TIME_START DATETIME, PRIMARY KEY (IDTRAVELPACKAGE))
CREATE TABLE CUSTOMIZEDTRAVELPACKAGE (IDTRAVELPACKAGE BIGINT NOT NULL, idregistereduser VARCHAR(255), PRIMARY KEY (IDTRAVELPACKAGE))
CREATE TABLE EMPLOYEE (USERNAME VARCHAR(255) NOT NULL, PRIMARY KEY (USERNAME))
CREATE TABLE PRODUCT (IDPRODUCT BIGINT AUTO_INCREMENT NOT NULL, PRODUCT_TYPE VARCHAR(31), COST FLOAT, EMPLOYEECREATOR VARCHAR(255), TIMEEND DATETIME, TIMESTART DATETIME, idtravelpackage BIGINT, PRIMARY KEY (IDPRODUCT))
CREATE TABLE FLIGHT (IDPRODUCT BIGINT NOT NULL, AREA_END VARCHAR(255), AREA_START VARCHAR(255), FLIGHT_COMPANY VARCHAR(255), MORE_INFO VARCHAR(255), PLACE_END VARCHAR(255), PLACE_START VARCHAR(255), PRIMARY KEY (IDPRODUCT))
CREATE TABLE GIFTLIST (BOUGHT TINYINT(1) default 0, IDBUYER BIGINT, idCustomer VARCHAR(255), MOREINFO VARCHAR(255), travelPackageFK BIGINT, idProduct BIGINT NOT NULL, PRIMARY KEY (idProduct))
CREATE TABLE HOTEL (IDPRODUCT BIGINT NOT NULL, AREA VARCHAR(255), MORE_INFO VARCHAR(255), NAME VARCHAR(255), PLACE VARCHAR(255), ROOM_TYPE VARCHAR(255), PRIMARY KEY (IDPRODUCT))
CREATE TABLE OUTING (IDPRODUCT BIGINT NOT NULL, AREA VARCHAR(255), DESCRIPTION VARCHAR(255), PRIMARY KEY (IDPRODUCT))
CREATE TABLE PREPACKEDTRAVELPACKAGE (IDTRAVELPACKAGE BIGINT NOT NULL, EMPLOYEECREATOR BIGINT, idPrepackedTravelPackage VARCHAR(255), PRIMARY KEY (IDTRAVELPACKAGE))
CREATE TABLE CODE (CODE BIGINT AUTO_INCREMENT NOT NULL, PRIMARY KEY (CODE))
CREATE TABLE friendship (friendA VARCHAR(255) NOT NULL, friendB VARCHAR(255) NOT NULL, PRIMARY KEY (friendA, friendB))
CREATE TABLE USER_GROUP (username VARCHAR(255), groupname VARCHAR(255))
ALTER TABLE CUSTOMER ADD CONSTRAINT FK_CUSTOMER_USERNAME FOREIGN KEY (USERNAME) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE TRAVELPACKAGE ADD CONSTRAINT FK_TRAVELPACKAGE_IDCUSTOMERBUYER FOREIGN KEY (IDCUSTOMERBUYER) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE TRAVELPACKAGE ADD CONSTRAINT FK_TRAVELPACKAGE_IDCUSTOMERFRIENDOWNER FOREIGN KEY (IDCUSTOMERFRIENDOWNER) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE CUSTOMIZEDTRAVELPACKAGE ADD CONSTRAINT FK_CUSTOMIZEDTRAVELPACKAGE_IDTRAVELPACKAGE FOREIGN KEY (IDTRAVELPACKAGE) REFERENCES TRAVELPACKAGE (IDTRAVELPACKAGE)
ALTER TABLE CUSTOMIZEDTRAVELPACKAGE ADD CONSTRAINT FK_CUSTOMIZEDTRAVELPACKAGE_idregistereduser FOREIGN KEY (idregistereduser) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_USERNAME FOREIGN KEY (USERNAME) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE PRODUCT ADD CONSTRAINT FK_PRODUCT_idtravelpackage FOREIGN KEY (idtravelpackage) REFERENCES TRAVELPACKAGE (IDTRAVELPACKAGE)
ALTER TABLE PRODUCT ADD CONSTRAINT FK_PRODUCT_EMPLOYEECREATOR FOREIGN KEY (EMPLOYEECREATOR) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE FLIGHT ADD CONSTRAINT FK_FLIGHT_IDPRODUCT FOREIGN KEY (IDPRODUCT) REFERENCES PRODUCT (IDPRODUCT)
ALTER TABLE GIFTLIST ADD CONSTRAINT FK_GIFTLIST_idProduct FOREIGN KEY (idProduct) REFERENCES PRODUCT (IDPRODUCT)
ALTER TABLE GIFTLIST ADD CONSTRAINT FK_GIFTLIST_travelPackageFK FOREIGN KEY (travelPackageFK) REFERENCES TRAVELPACKAGE (IDTRAVELPACKAGE)
ALTER TABLE GIFTLIST ADD CONSTRAINT FK_GIFTLIST_idCustomer FOREIGN KEY (idCustomer) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE HOTEL ADD CONSTRAINT FK_HOTEL_IDPRODUCT FOREIGN KEY (IDPRODUCT) REFERENCES PRODUCT (IDPRODUCT)
ALTER TABLE OUTING ADD CONSTRAINT FK_OUTING_IDPRODUCT FOREIGN KEY (IDPRODUCT) REFERENCES PRODUCT (IDPRODUCT)
ALTER TABLE PREPACKEDTRAVELPACKAGE ADD CONSTRAINT FK_PREPACKEDTRAVELPACKAGE_idPrepackedTravelPackage FOREIGN KEY (idPrepackedTravelPackage) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE PREPACKEDTRAVELPACKAGE ADD CONSTRAINT FK_PREPACKEDTRAVELPACKAGE_IDTRAVELPACKAGE FOREIGN KEY (IDTRAVELPACKAGE) REFERENCES TRAVELPACKAGE (IDTRAVELPACKAGE)
ALTER TABLE friendship ADD CONSTRAINT FK_friendship_friendB FOREIGN KEY (friendB) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE friendship ADD CONSTRAINT FK_friendship_friendA FOREIGN KEY (friendA) REFERENCES REGISTEREDUSER (USERNAME)
ALTER TABLE USER_GROUP ADD CONSTRAINT FK_USER_GROUP_username FOREIGN KEY (username) REFERENCES REGISTEREDUSER (USERNAME)
