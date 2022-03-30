/* DELETE 'auctions_user' database*/
DROP SCHEMA IF EXISTS parkingDB;
/* DELETE USER 'auctions_user' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'%';

/* CREATE ''auctionsdb' DATABASE */
CREATE SCHEMA parkingDB;
/* CREATE THE USER 'auctions_user' AT LOCAL SERVER WITH PASSWORD 'auctions_user' */
CREATE USER 'spq'@'%' IDENTIFIED BY 'spq';
/* GRANT FULL ACCESS TO THE DATABASE 'auctionsdb' FOR THE USER 'auctions_user' AT LOCAL SERVER*/
GRANT ALL ON parkingDB.* TO 'spq'@'%';