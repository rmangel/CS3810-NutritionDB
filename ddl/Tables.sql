ALTER TABLE DayPlans 
    DROP CONSTRAINT DayPlans_Users_FK ;
--
ALTER TABLE Dietition 
    DROP CONSTRAINT Dietition_Prescription_FK ;
--
ALTER TABLE Dietition 
    DROP CONSTRAINT Dietition_Users_FK ;
--
ALTER TABLE Emails 
    DROP CONSTRAINT Emails_Users_FK ;
--
ALTER TABLE MealsCourses 
    DROP CONSTRAINT FK_ASS_10 ;
--
ALTER TABLE MealsCourses 
    DROP CONSTRAINT FK_ASS_11 ;
--
ALTER TABLE MealsFoodAttributes 
    DROP CONSTRAINT FK_ASS_12 ;
--
ALTER TABLE MealsFoodAttributes 
    DROP CONSTRAINT FK_ASS_13 ;
--
ALTER TABLE PrescriptionAttributes 
    DROP CONSTRAINT FK_ASS_14 ;
--
ALTER TABLE PrescriptionAttributes 
    DROP CONSTRAINT FK_ASS_15 ;
--
ALTER TABLE UserFavoriteMeals 
    DROP CONSTRAINT FK_ASS_21 ;
--
ALTER TABLE UserFavoriteMeals 
    DROP CONSTRAINT FK_ASS_22 ;
--
ALTER TABLE Ingredients 
    DROP CONSTRAINT Ingredients_Course_FK ;
--
ALTER TABLE Meals 
    DROP CONSTRAINT Meals_DayPlans_FK ;
--
ALTER TABLE Prescription 
    DROP CONSTRAINT Prescription_Users_FK ;
--
ALTER TABLE Ratings 
    DROP CONSTRAINT Ratings_Meals_FK ;
--
ALTER TABLE Ratings 
    DROP CONSTRAINT Ratings_Users_FK ;
--
ALTER TABLE Stores 
    DROP CONSTRAINT Stores_Ingredients_FK ;
--
ALTER TABLE UserType 
    DROP CONSTRAINT UserType_Users_FK ;
-- Generated by Oracle SQL Developer Data Modeler 3.1.0.691
--   at:        2013-11-19 21:54:25 MST
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



DROP TABLE Attributes;
CREATE TABLE Attributes 
    ( 
     ATTRIBUTES_ID_PK NUMBER  NOT NULL , 
     NAME VARCHAR2 (50) 
    ) 
;



ALTER TABLE Attributes 
    ADD CONSTRAINT Attributes_PK PRIMARY KEY ( ATTRIBUTES_ID_PK ) ;


DROP TABLE Course;
CREATE TABLE Course 
    ( 
     COURSE_ID_PK NUMBER  NOT NULL , 
     NAME VARCHAR2 (50) , 
     SERVINGS INTEGER , 
     RECIPEE_ID_FK NUMBER 
    ) 
;



ALTER TABLE Course 
    ADD CONSTRAINT Course_PK PRIMARY KEY ( COURSE_ID_PK ) ;


DROP TABLE DayPlans;
CREATE TABLE DayPlans 
    ( 
     "DATE" DATE , 
     DAYPLANS_ID_PK NUMBER  NOT NULL , 
     USERS_ID_FK NUMBER  NOT NULL 
    ) 
;



ALTER TABLE DayPlans 
    ADD CONSTRAINT DayPlans_PK PRIMARY KEY ( DAYPLANS_ID_PK ) ;


DROP TABLE Dietition;
CREATE TABLE Dietition 
    ( 
     USER_ID_FK NUMBER  NOT NULL , 
     PRESCRIPTION_ID_FK NUMBER  NOT NULL 
    ) 
;



ALTER TABLE Dietition 
    ADD CONSTRAINT Dietition_PK PRIMARY KEY ( USER_ID_FK ) ;


DROP TABLE Emails;
CREATE TABLE Emails 
    ( 
     ADDRESS VARCHAR2 (1000) , 
     USERS_ID_FK NUMBER  NOT NULL 
    ) 
;




DROP TABLE Ingredients;
CREATE TABLE Ingredients 
    ( 
     NAME VARCHAR2 (50) , 
     FAT INTEGER , 
     CALORIES INTEGER , 
     INGREDIENTS_ID_PK NUMBER  NOT NULL , 
     COURSE_ID_FK NUMBER 
    ) 
;



ALTER TABLE Ingredients 
    ADD CONSTRAINT Ingredients_PK PRIMARY KEY ( INGREDIENTS_ID_PK ) ;


DROP TABLE Meals;
CREATE TABLE Meals 
    ( 
     MEALS_ID_PK NUMBER  NOT NULL , 
     NAME VARCHAR2 (50) , 
     DAYPLANS_ID_FK NUMBER 
    ) 
;



ALTER TABLE Meals 
    ADD CONSTRAINT Meals_PK PRIMARY KEY ( MEALS_ID_PK ) ;


DROP TABLE MealsCourses;
CREATE TABLE MealsCourses 
    ( 
     MEALS_ID_FK NUMBER  NOT NULL , 
     COURSE_ID_FK NUMBER  NOT NULL 
    ) 
;



ALTER TABLE MealsCourses 
    ADD CONSTRAINT MealsCourses__IDX PRIMARY KEY ( MEALS_ID_FK, COURSE_ID_FK ) ;


DROP TABLE MealsFoodAttributes;
CREATE TABLE MealsFoodAttributes 
    ( 
     MEALS_ID_FK NUMBER  NOT NULL , 
     ATTRIBUTES_ID_FK NUMBER  NOT NULL 
    ) 
;



ALTER TABLE MealsFoodAttributes 
    ADD CONSTRAINT MealsFoodAttributes__IDX PRIMARY KEY ( MEALS_ID_FK, ATTRIBUTES_ID_FK ) ;


DROP TABLE Prescription;
CREATE TABLE Prescription 
    ( 
     PRESCIPTION_ID_PK NUMBER  NOT NULL , 
     "DATE" DATE , 
     USER_ID_FK NUMBER  NOT NULL 
    ) 
;



ALTER TABLE Prescription 
    ADD CONSTRAINT Prescription_PK PRIMARY KEY ( PRESCIPTION_ID_PK ) ;


DROP TABLE PrescriptionAttributes;
CREATE TABLE PrescriptionAttributes 
    ( 
     PRESCRIPTION_ID NUMBER  NOT NULL , 
     ATTRIBUTES_ID NUMBER  NOT NULL 
    ) 
;



ALTER TABLE PrescriptionAttributes 
    ADD CONSTRAINT PrescriptionAttributes__IDX PRIMARY KEY ( PRESCRIPTION_ID, ATTRIBUTES_ID ) ;


DROP TABLE Ratings;
CREATE TABLE Ratings 
    ( 
     MEALS_ID_FK NUMBER  NOT NULL , 
     USERS_ID_FK NUMBER  NOT NULL , 
     STARS INTEGER 
    ) 
;




DROP TABLE Stores;
CREATE TABLE Stores 
    ( 
     NAME VARCHAR2 (50) , 
     INGREDIENTS_ID_FK NUMBER  NOT NULL , 
     PRICE NUMBER (2) 
    ) 
;




DROP TABLE UserFavoriteMeals;
CREATE TABLE UserFavoriteMeals 
    ( 
     USERS_ID_FK NUMBER  NOT NULL , 
     MEALS_ID_FK NUMBER  NOT NULL 
    ) 
;



ALTER TABLE UserFavoriteMeals 
    ADD CONSTRAINT UserFavoriteMeals__IDX PRIMARY KEY ( USERS_ID_FK, MEALS_ID_FK ) ;


DROP TABLE UserType;
CREATE TABLE UserType 
    ( 
     NAME VARCHAR2 (50)  NOT NULL , 
     USER_TYPE_ID_FK NUMBER  NOT NULL 
    ) 
;



ALTER TABLE UserType 
    ADD CONSTRAINT UserType_PK PRIMARY KEY ( NAME ) ;


DROP TABLE Users;
CREATE TABLE Users 
    ( 
     USERS_ID_PK NUMBER  NOT NULL , 
     FNAME VARCHAR2 (50) , 
     LNAME VARCHAR2 (50) , 
     UNAME VARCHAR2 (50) , 
     GENDER CHAR (1) , 
     PASSWORD VARCHAR2 (200) 
    ) 
;



ALTER TABLE Users 
    ADD CONSTRAINT Users_PK PRIMARY KEY ( USERS_ID_PK ) ;



ALTER TABLE DayPlans 
    ADD CONSTRAINT DayPlans_Users_FK FOREIGN KEY 
    ( 
     USERS_ID_FK
    ) 
    REFERENCES Users 
    ( 
     USERS_ID_PK
    ) 
;


ALTER TABLE Dietition 
    ADD CONSTRAINT Dietition_Prescription_FK FOREIGN KEY 
    ( 
     PRESCRIPTION_ID_FK
    ) 
    REFERENCES Prescription 
    ( 
     PRESCIPTION_ID_PK
    ) 
;


ALTER TABLE Dietition 
    ADD CONSTRAINT Dietition_Users_FK FOREIGN KEY 
    ( 
     USER_ID_FK
    ) 
    REFERENCES Users 
    ( 
     USERS_ID_PK
    ) 
;


ALTER TABLE Emails 
    ADD CONSTRAINT Emails_Users_FK FOREIGN KEY 
    ( 
     USERS_ID_FK
    ) 
    REFERENCES Users 
    ( 
     USERS_ID_PK
    ) 
;


ALTER TABLE MealsCourses 
    ADD CONSTRAINT FK_ASS_10 FOREIGN KEY 
    ( 
     MEALS_ID_FK
    ) 
    REFERENCES Meals 
    ( 
     MEALS_ID_PK
    ) 
;


ALTER TABLE MealsCourses 
    ADD CONSTRAINT FK_ASS_11 FOREIGN KEY 
    ( 
     COURSE_ID_FK
    ) 
    REFERENCES Course 
    ( 
     COURSE_ID_PK
    ) 
;


ALTER TABLE MealsFoodAttributes 
    ADD CONSTRAINT FK_ASS_12 FOREIGN KEY 
    ( 
     MEALS_ID_FK
    ) 
    REFERENCES Meals 
    ( 
     MEALS_ID_PK
    ) 
;


ALTER TABLE MealsFoodAttributes 
    ADD CONSTRAINT FK_ASS_13 FOREIGN KEY 
    ( 
     ATTRIBUTES_ID_FK
    ) 
    REFERENCES Attributes 
    ( 
     ATTRIBUTES_ID_PK
    ) 
;


ALTER TABLE PrescriptionAttributes 
    ADD CONSTRAINT FK_ASS_14 FOREIGN KEY 
    ( 
     PRESCRIPTION_ID
    ) 
    REFERENCES Prescription 
    ( 
     PRESCIPTION_ID_PK
    ) 
;


ALTER TABLE PrescriptionAttributes 
    ADD CONSTRAINT FK_ASS_15 FOREIGN KEY 
    ( 
     ATTRIBUTES_ID
    ) 
    REFERENCES Attributes 
    ( 
     ATTRIBUTES_ID_PK
    ) 
;


ALTER TABLE UserFavoriteMeals 
    ADD CONSTRAINT FK_ASS_21 FOREIGN KEY 
    ( 
     USERS_ID_FK
    ) 
    REFERENCES Users 
    ( 
     USERS_ID_PK
    ) 
;


ALTER TABLE UserFavoriteMeals 
    ADD CONSTRAINT FK_ASS_22 FOREIGN KEY 
    ( 
     MEALS_ID_FK
    ) 
    REFERENCES Meals 
    ( 
     MEALS_ID_PK
    ) 
;


ALTER TABLE Ingredients 
    ADD CONSTRAINT Ingredients_Course_FK FOREIGN KEY 
    ( 
     COURSE_ID_FK
    ) 
    REFERENCES Course 
    ( 
     COURSE_ID_PK
    ) 
;


ALTER TABLE Meals 
    ADD CONSTRAINT Meals_DayPlans_FK FOREIGN KEY 
    ( 
     DAYPLANS_ID_FK
    ) 
    REFERENCES DayPlans 
    ( 
     DAYPLANS_ID_PK
    ) 
;


ALTER TABLE Prescription 
    ADD CONSTRAINT Prescription_Users_FK FOREIGN KEY 
    ( 
     USER_ID_FK
    ) 
    REFERENCES Users 
    ( 
     USERS_ID_PK
    ) 
;


ALTER TABLE Ratings 
    ADD CONSTRAINT Ratings_Meals_FK FOREIGN KEY 
    ( 
     MEALS_ID_FK
    ) 
    REFERENCES Meals 
    ( 
     MEALS_ID_PK
    ) 
;


ALTER TABLE Ratings 
    ADD CONSTRAINT Ratings_Users_FK FOREIGN KEY 
    ( 
     USERS_ID_FK
    ) 
    REFERENCES Users 
    ( 
     USERS_ID_PK
    ) 
;


ALTER TABLE Stores 
    ADD CONSTRAINT Stores_Ingredients_FK FOREIGN KEY 
    ( 
     INGREDIENTS_ID_FK
    ) 
    REFERENCES Ingredients 
    ( 
     INGREDIENTS_ID_PK
    ) 
;


ALTER TABLE UserType 
    ADD CONSTRAINT UserType_Users_FK FOREIGN KEY 
    ( 
     USER_TYPE_ID_FK
    ) 
    REFERENCES Users 
    ( 
     USERS_ID_PK
    ) 
;

DROP SEQUENCE Attributes;
CREATE SEQUENCE Attributes_ATTRIBUTES_ID_PK 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Attributes_ATTRIBUTES_ID_PK 
BEFORE INSERT ON Attributes 
FOR EACH ROW 
WHEN (NEW.ATTRIBUTES_ID_PK IS NULL) 
BEGIN 
    SELECT Attributes_ATTRIBUTES_ID_PK.NEXTVAL INTO :NEW.ATTRIBUTES_ID_PK FROM DUAL; 
END;
/

DROP SEQUENCE Course;
CREATE SEQUENCE Course_COURSE_ID_PK_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Course_COURSE_ID_PK_TRG 
BEFORE INSERT ON Course 
FOR EACH ROW 
WHEN (NEW.COURSE_ID_PK IS NULL) 
BEGIN 
    SELECT Course_COURSE_ID_PK_SEQ.NEXTVAL INTO :NEW.COURSE_ID_PK FROM DUAL; 
END;
/

DROP SEQUENCE DayPlans;
CREATE SEQUENCE DayPlans_DAYPLANS_ID_PK_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER DayPlans_DAYPLANS_ID_PK_TRG 
BEFORE INSERT ON DayPlans 
FOR EACH ROW 
WHEN (NEW.DAYPLANS_ID_PK IS NULL) 
BEGIN 
    SELECT DayPlans_DAYPLANS_ID_PK_SEQ.NEXTVAL INTO :NEW.DAYPLANS_ID_PK FROM DUAL; 
END;
/

DROP SEQUENCE Ingredients;
CREATE SEQUENCE Ingredients_INGREDIENTS_ID_PK 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Ingredients_INGREDIENTS_ID_PK 
BEFORE INSERT ON Ingredients 
FOR EACH ROW 
WHEN (NEW.INGREDIENTS_ID_PK IS NULL) 
BEGIN 
    SELECT Ingredients_INGREDIENTS_ID_PK.NEXTVAL INTO :NEW.INGREDIENTS_ID_PK FROM DUAL; 
END;
/

DROP SEQUENCE Meals;
CREATE SEQUENCE Meals_MEALS_ID_PK_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Meals_MEALS_ID_PK_TRG 
BEFORE INSERT ON Meals 
FOR EACH ROW 
WHEN (NEW.MEALS_ID_PK IS NULL) 
BEGIN 
    SELECT Meals_MEALS_ID_PK_SEQ.NEXTVAL INTO :NEW.MEALS_ID_PK FROM DUAL; 
END;
/

DROP SEQUENCE Prescription;
CREATE SEQUENCE Prescription_PRESCIPTION_ID_PK 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Prescription_PRESCIPTION_ID_PK 
BEFORE INSERT ON Prescription 
FOR EACH ROW 
WHEN (NEW.PRESCIPTION_ID_PK IS NULL) 
BEGIN 
    SELECT Prescription_PRESCIPTION_ID_PK.NEXTVAL INTO :NEW.PRESCIPTION_ID_PK FROM DUAL; 
END;
/

DROP SEQUENCE UserType;
CREATE SEQUENCE UserType_USER_TYPE_ID_FK_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER UserType_USER_TYPE_ID_FK_TRG 
BEFORE INSERT ON UserType 
FOR EACH ROW 
WHEN (NEW.USER_TYPE_ID_FK IS NULL) 
BEGIN 
    SELECT UserType_USER_TYPE_ID_FK_SEQ.NEXTVAL INTO :NEW.USER_TYPE_ID_FK FROM DUAL; 
END;
/

DROP SEQUENCE Users;
CREATE SEQUENCE Users_USERS_ID_PK_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Users_USERS_ID_PK_TRG 
BEFORE INSERT ON Users 
FOR EACH ROW 
WHEN (NEW.USERS_ID_PK IS NULL) 
BEGIN 
    SELECT Users_USERS_ID_PK_SEQ.NEXTVAL INTO :NEW.USERS_ID_PK FROM DUAL; 
END;
/



















-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- DROP TABLE ;
CREATE TABLE                            16
-- CREATE INDEX                             0
-- ALTER TABLE                             32
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           8
-- ALTER TRIGGER                            0
-- CREATE STRUCTURED TYPE                   0
-- CREATE COLLECTION TYPE                   0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- DROP SEQUENCE ;
CREATE SEQUENCE                          8
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
