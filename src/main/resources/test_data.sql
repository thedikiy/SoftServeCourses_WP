
    INSERT INTO BUS (REGISTRATION_NUMBER, LAST_TI, NEXT_TI,BUS_MODEL)
    VALUES ("AE 1595", '20120516','20180619', "Audi");
    INSERT INTO BUS (REGISTRATION_NUMBER, LAST_TI, NEXT_TI,BUS_MODEL)
    VALUES ("AE 2094", '20150617','20200711', "Toyota");
    INSERT INTO BUS (REGISTRATION_NUMBER, LAST_TI, NEXT_TI,BUS_MODEL)
    VALUES ("AP 1312", '20170316','20190619', "BIG_BUS");
    INSERT INTO BUS (REGISTRATION_NUMBER, LAST_TI, NEXT_TI,BUS_MODEL)
    VALUES ("AE 2034", '20131119','20180612', "ROCKET");
    INSERT INTO DRIVER (PHONE_NUMBER, LICENCE_EXPIRE, DRIVER_NAME, DRIVER_SURNAME)
    VALUES ("050-974-48-50", "20201219","Виктор", "Князев");
    INSERT INTO DRIVER (PHONE_NUMBER, LICENCE_EXPIRE, DRIVER_NAME, DRIVER_SURNAME)
    VALUES ("067-935-98-51", '20250610', "Василий", "Миронов");
    INSERT INTO DRIVER (PHONE_NUMBER, LICENCE_EXPIRE, DRIVER_NAME, DRIVER_SURNAME)
    VALUES ("066-999-33-50", '20300920', "Борис", "Сложный");
    INSERT INTO JOURNEY (DRIVER_ID, BUS_ID, LEAVING_DATE, ARRIVING_DATE, FROM_PLACE, DESTINATION)
    VALUES (1,1,'20170715','20170717',"Днепр", "Одесса");
    INSERT INTO JOURNEY (DRIVER_ID, BUS_ID, LEAVING_DATE, ARRIVING_DATE, FROM_PLACE, DESTINATION)
    VALUES (3,4,'20170712','20170714',"Ужгород", "Харьков");
    INSERT INTO JOURNEY (DRIVER_ID, BUS_ID, LEAVING_DATE, ARRIVING_DATE, FROM_PLACE, DESTINATION)
    VALUES (3,2,'20170810','20170812',"Геническ", "Тернополь");
    INSERT INTO JOURNEY (DRIVER_ID, BUS_ID, LEAVING_DATE, ARRIVING_DATE, FROM_PLACE, DESTINATION)
    VALUES (2,3,'20170905','20170906',"Киев", "Запорожье");
    INSERT INTO JOURNEY (DRIVER_ID, BUS_ID, LEAVING_DATE, ARRIVING_DATE, FROM_PLACE, DESTINATION)
    VALUES (1,3,'20170721','20170723',"Черкассы", "Одесса");
    INSERT INTO JOURNEY (DRIVER_ID, BUS_ID, LEAVING_DATE, ARRIVING_DATE, FROM_PLACE, DESTINATION)
    VALUES (1,1,'20170715','20170717',"Днепр", "Николаев");
    INSERT INTO JOURNEY (DRIVER_ID, BUS_ID, LEAVING_DATE, ARRIVING_DATE, FROM_PLACE, DESTINATION)
    VALUES (3,3,'20171015','20171018',"Симферополь", "Запорожье");
    INSERT INTO JOURNEY (DRIVER_ID, BUS_ID, LEAVING_DATE, ARRIVING_DATE, FROM_PLACE, DESTINATION)
    VALUES (2,2,'20170915','20170918',"Бердянск", "Львов");
    INSERT INTO PASSENGER (PASSENGER_NAME, PASSENGER_SURNAME, PHONE_NUMBER)
    VALUES ("Виктор", "Белый","+380994569875");
    INSERT INTO PASSENGER (PASSENGER_NAME, PASSENGER_SURNAME, PHONE_NUMBER)
    VALUES ("Валентин", "Мазур","+38095-489-48-34");
    INSERT INTO PASSENGER (PASSENGER_NAME, PASSENGER_SURNAME, PHONE_NUMBER)
    VALUES ("Авдотья", "Седогрив","050-987-45-68");
    INSERT INTO PASSENGER (PASSENGER_NAME, PASSENGER_SURNAME, PHONE_NUMBER)
    VALUES ("Геральт", "Ривийский","099-489-78-12");
    INSERT INTO PASSENGER (PASSENGER_NAME, PASSENGER_SURNAME, PHONE_NUMBER)
    VALUES ("Лидия", "Синежабрая","077-788-49-98");
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (1, 1);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (2, 1);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (3, 1);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (4, 2);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (5, 2);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (2, 2);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (3, 3);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (4, 8);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (5, 8);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (4, 7);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (3, 5);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (1, 5);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (5, 6);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (2, 7);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (4, 3);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (5, 2);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (1, 6);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (2, 8);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (1, 1);
    INSERT INTO JOURNEYS_PASSENGERS (PASSENGER_ID, JOURNEY_ID) VALUES (4, 4);
    INSERT INTO USER (USERNAME, PASSWORD, ROLE) VALUES ('TDK','1234','ADMIN');
    INSERT INTO USER (USERNAME, PASSWORD, ROLE) VALUES ('MAN','1234','MANAGER');
    INSERT INTO USER (USERNAME, PASSWORD, ROLE) VALUES ('USER','1234','PASSENGER');