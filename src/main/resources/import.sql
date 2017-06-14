CREATE TABLE IF NOT EXISTS PASSENGER (
    PASSENGER_NAME varchar(20) NOT NULL,
    PASSENGER_SURNAME varchar(20) NOT NULL,
    PASSENGER_ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE);

CREATE TABLE IF NOT EXISTS DRIVER(
    PHONE_NUMBER varchar(20),
    LICANCE_EXPIRE DATE,
    DRIVER_ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    DRIVER_NAME varchar(20) NOT NULL,
    DRIVER_SURNAME varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS BUS(
    REGISTRATION_NUMBER varchar(10) NOT NULL UNIQUE,
    LAST_TI DATE,
    NEXT_TI DATE,
    BUS_ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    BUS_MODEL VARCHAR(100) NOT NULL);

CREATE TABLE IF NOT EXISTS JOURNEY(
    DRIVER_ID INTEGER NOT NULL ,
    BUS_ID INTEGER NOT NULL,
    JOURNEY_ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    LEAVING_DATE DATE,
    ARRIVING_DATE DATE,
    constraint journey_fk_1 foreign key (DRIVER_ID) references DRIVER(DRIVER_ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
    constraint journey_fk_2 foreign key (BUS_ID) references BUS(BUS_ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS JOURNEY_CUSTOMER(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    PASSENGER_ID INTEGER NOT NULL REFERENCES PASSENGER(PASSENGER_ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
    JOURNEY_ID INTEGER NOT NULL REFERENCES JOURNEY(journey_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    constraint jc_fk_1 foreign key (PASSENGER_ID) references PASSENGER(PASSENGER_ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
    constraint jc_fk_2 foreign key (JOURNEY_ID) references JOURNEY(JOURNEY_ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);
