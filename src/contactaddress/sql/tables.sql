
--address table
CREATE TABLE  APP.ADDRESS (
    ID          INTEGER NOT NULL 
  PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
  (START WITH 1, INCREMENT BY 1),
    LASTNAME    VARCHAR(30), 
    FIRSTNAME   VARCHAR(30),
    MIDDLENAME  VARCHAR(30),
    PHONE       VARCHAR(20),
    EMAIL       VARCHAR(30), 
    ADDRESS1    VARCHAR(30),
    ADDRESS2    VARCHAR(30),
    CITY        VARCHAR(30),
    STATE       VARCHAR(30),
    POSTALCODE  VARCHAR(20),
    COUNTRY     VARCHAR(30) );

--insert address
INSERT INTO APP.ADDRESS ( FIRSTNAME,LASTNAME, MIDDLENAME,
        PHONE, EMAIL, ADDRESS1, ADDRESS2,
       CITY, STATE, POSTALCODE, COUNTRY)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

--update contact
UPDATE APP.ADDRESS SET  FIRSTNAME=?, LASTNAME =?, MIDDLENAME=?,
        PHONE=?, EMAIL=?, ADDRESS1=?, ADDRESS2=?,
       CITY=?, STATE=?, POSTALCODE=?, COUNTRY=?
       WHERE ID = ?;

--address list
SELECT * FROM APP.ADDRESS;

--contact names
SELECT ID, LASTNAME, FIRSTNAME FROM APP.ADDRESS;

--contact details
SELECT * FROM APP.ADDRESS WHERE ID = ?;

--delete contact
DELETE FROM APP.ADDRESS WHERE ID = ?