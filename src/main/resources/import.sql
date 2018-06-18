INSERT into Account VALUES (1,'administrator','admin','admin');
INSERT into Account VALUES (2,'klient','karolm','karolm');
INSERT into Account VALUES (3,'klient','marekm','marekm');
INSERT into Account VALUES (4,'klient','mateuszm','mateuszm');
INSERT into Account VALUES (5,'klient','damianl','damianl');
INSERT into Account VALUES (6,'pracownik','pracownik1','aso1');
INSERT into Account VALUES (7,'pracownik','pracownik2','aso2');

INSERT INTO CUSTOMER VALUES (1,'marekm@aso.pl','Marek','93121244674','666710482','Madeła',3);
INSERT INTO CUSTOMER VALUES (2,'mateuszm@aso.pl','Mateusz','93121245739','534565452','Maciąg',4);
INSERT INTO CUSTOMER VALUES (3,'damianl@aso.pl','Damian','95121275636','345345756','Łyżwa',5);
INSERT INTO CUSTOMER VALUES (4,'karolm@aso.pl','Karol','93121278979','654656325','Marchewka',2);

INSERT INTO EMPLOYEE VALUES (1,'pracownik1@aso.pl','Andrzej','83121244364','363764235','Kowalski',6);
INSERT INTO EMPLOYEE VALUES (2,'pracownik2@aso.pl','Janusz','73121277539','865346856','Stefańczyk',7);

INSERT INTO CARS VALUES (1,1.6,'Seat','Leon',102,'TSA AU74','2018-10-20','JTJHW31U560039130');
INSERT INTO CARS VALUES (2,1.9,'Renault','Megan',110,'TST HF43G','2018-09-07','WF0AXXWPMAGR69936');
INSERT INTO CARS VALUES (3,1.1,'Volkswagen','Polo',55,'TK GF53G','2019-03-20','WAUZZZ8E86A040764');
INSERT INTO CARS VALUES (4,1.1,'Citroen','Saxo',55,'TK G45SH','2018-07-13','WF0AXXWPMAFY46539');

INSERT INTO REPLACMENT_CARS VALUES (1,'Ford','Mustang','TK HR54U','WF0GXXPSWGXS40039');
INSERT INTO REPLACMENT_CARS VALUES (2,'Mazda', 'Rx8', 'TK DVR53', 'WF0GXXPSWGXS40039');
INSERT INTO REPLACMENT_CARS VALUES (3,'Suzuki','Vitara','TK SMG2A','WBAAL71010KE15545');
INSERT INTO REPLACMENT_CARS VALUES (4,'Laxus','LC 500h','TK X353V','W0L0ZCF6861011982');

INSERT INTO CUSTOMER_CARS VALUES (1,1,1);
INSERT INTO CUSTOMER_CARS VALUES (2,2,2);
INSERT INTO CUSTOMER_CARS VALUES (3,3,3);
INSERT INTO CUSTOMER_CARS VALUES (4,4,4);

INSERT INTO PART VALUES (1,'klocki hamulcowe seat leon przód',250.34);
INSERT INTO PART VALUES (2,'wkład lusterka volkswagen polo prawe',25);
INSERT INTO PART VALUES (3,'świece zapłonowe citroen saxo',50.40);
INSERT INTO PART VALUES (4,'chłodnica renault megan',124.99);

INSERT INTO SERVICE VALUES (1,'wymiana klocków',100,'wymiana');
INSERT INTO SERVICE VALUES (2,'przegląd samochodu z gazem',120,'przegląd');
INSERT INTO SERVICE VALUES (3,'przegląd samochodu',80,'przegląd');
INSERT INTO SERVICE VALUES (4,'analia samochodu przed zakupem',150,'analiza');
INSERT INTO SERVICE VALUES (5,'naprawa układu zapłonowego',50,'naprawa');
INSERT INTO SERVICE VALUES (6,'wymiana wkład lusterka',300,'wymiana');
INSERT INTO SERVICE VALUES (7,'wymiana chłodnicy',130,'wymiana');

INSERT INTO PROMOTION VALUES (1,'przeglad kwiecień 2018','promocja na przeglad samochodu z instalacją gazową w kwietniu 2018 -20%','2018-04-01','2018-04-31',20,2);
INSERT INTO PROMOTION VALUES (2,'przeglad maj 2018','promocja na przeglad samochodu bez instalacji gazowej w maju 2018 -20%','2018-05-01','2018-05-31',20,3);

INSERT INTO NOTIFICATIONS VALUES (1,'przypomnienie','przypominamy o przeglądzie samochodu dnia 2018-04-20',1);
INSERT INTO NOTIFICATIONS VALUES (2,'przypomnienie','przypominamy o przeglądzie samochodu dnia 2018-05-20',2);
INSERT INTO NOTIFICATIONS VALUES (3,'powiadomienie','promocja na przeglad samochodu z instalacją gazową w kwietniu 2018 -20% 2018-04-01-2018-04-31',1);
INSERT INTO NOTIFICATIONS VALUES (4,'powiadomienie','promocja na przeglad samochodu z instalacją gazową w kwietniu 2018 -20% 2018-04-01-2018-04-31',2);
INSERT INTO NOTIFICATIONS VALUES (5,'powiadomienie','promocja na przeglad samochodu z instalacją gazową w kwietniu 2018 -20% 2018-04-01-2018-04-31',3);
INSERT INTO NOTIFICATIONS VALUES (6,'powiadomienie','promocja na przeglad samochodu z instalacją gazową w kwietniu 2018 -20% 2018-04-01-2018-04-31',4);
INSERT INTO NOTIFICATIONS VALUES (7,'powiadomienie','promocja na przeglad samochodu bez instalacji gazowej w maju 2018 -20% 2018-05-01-2018-05-31',1);
INSERT INTO NOTIFICATIONS VALUES (8,'powiadomienie','promocja na przeglad samochodu bez instalacji gazowej w maju 2018 -20% 2018-05-01-2018-05-31',2);
INSERT INTO NOTIFICATIONS VALUES (9,'powiadomienie','promocja na przeglad samochodu bez instalacji gazowej w maju 2018 -20% 2018-05-01-2018-05-31',3);
INSERT INTO NOTIFICATIONS VALUES (10,'powiadomienie','promocja na przeglad samochodu bez instalacji gazowej w maju 2018 -20% 2018-05-01-2018-05-31',4);

INSERT INTO SPECYFIC_SERVICE VALUES (1,'2018-04-20','2018-04-20','2018-04-20','zakończona','przegląd samochodu seat leon 2 b+g',1,1,1,1,2);
INSERT INTO SPECYFIC_SERVICE VALUES (2,'2018-05-20','2018-05-20','2018-05-20','zakończona','przegląd samochodu renault megan diesel',2,2,2,2,3);
INSERT INTO SPECYFIC_SERVICE VALUES (3,'2018-05-20','2018-05-20','2018-05-20','zakończona','wymiana chłodnicy w samochodzie',2,2,2,2,3);

INSERT INTO SERVICE_PART VALUES (1,1,4,3);

INSERT INTO INVOICE VALUES (1,96,'gotówka',1);
INSERT INTO INVOICE VALUES (2,80,'gotówka',2);