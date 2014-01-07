ALTER TABLE CUSTOMER DROP FOREIGN KEY FK_CUSTOMER_IDREGISTEREDUSER
ALTER TABLE TRAVELPACKAGE DROP FOREIGN KEY FK_TRAVELPACKAGE_IDCUSTOMERBUYER
ALTER TABLE TRAVELPACKAGE DROP FOREIGN KEY FK_TRAVELPACKAGE_IDCUSTOMERFRIENDOWNER
ALTER TABLE CUSTOMIZEDTRAVELPACKAGE DROP FOREIGN KEY FK_CUSTOMIZEDTRAVELPACKAGE_IDTRAVELPACKAGE
ALTER TABLE CUSTOMIZEDTRAVELPACKAGE DROP FOREIGN KEY FK_CUSTOMIZEDTRAVELPACKAGE_idregistereduser
ALTER TABLE EMPLOYEE DROP FOREIGN KEY FK_EMPLOYEE_IDREGISTEREDUSER
ALTER TABLE PRODUCT DROP FOREIGN KEY FK_PRODUCT_idtravelpackage
ALTER TABLE PRODUCT DROP FOREIGN KEY FK_PRODUCT_EMPLOYEECREATOR
ALTER TABLE FLIGHT DROP FOREIGN KEY FK_FLIGHT_IDPRODUCT
ALTER TABLE GIFTLIST DROP FOREIGN KEY FK_GIFTLIST_travelPackageFK
ALTER TABLE GIFTLIST DROP FOREIGN KEY FK_GIFTLIST_idCustomer
ALTER TABLE HOTEL DROP FOREIGN KEY FK_HOTEL_IDPRODUCT
ALTER TABLE OUTING DROP FOREIGN KEY FK_OUTING_IDPRODUCT
ALTER TABLE PREPACKEDTRAVELPACKAGE DROP FOREIGN KEY FK_PREPACKEDTRAVELPACKAGE_idTravelPackage
ALTER TABLE PREPACKEDTRAVELPACKAGE DROP FOREIGN KEY FK_PREPACKEDTRAVELPACKAGE_IDTRAVELPACKAGE
ALTER TABLE friendship DROP FOREIGN KEY FK_friendship_friendB
ALTER TABLE friendship DROP FOREIGN KEY FK_friendship_friendA
ALTER TABLE USER_GROUP DROP FOREIGN KEY FK_USER_GROUP_USERNAME
ALTER TABLE USER_GROUP DROP FOREIGN KEY FK_USER_GROUP_GROUPID
DROP TABLE REGISTEREDUSER
DROP TABLE CUSTOMER
DROP TABLE TRAVELPACKAGE
DROP TABLE CUSTOMIZEDTRAVELPACKAGE
DROP TABLE EMPLOYEE
DROP TABLE PRODUCT
DROP TABLE FLIGHT
DROP TABLE GIFTLIST
DROP TABLE HOTEL
DROP TABLE OUTING
DROP TABLE PREPACKEDTRAVELPACKAGE
DROP TABLE GROUPS
DROP TABLE friendship
DROP TABLE USER_GROUP
