

  CREATE TABLE TUTCOMPANIES
    (CONO      number       primary key,
     CONAME    CHAR    (45) NOT NULL,
     COSTREET  VARCHAR (45) NOT NULL,
     COSTRNO   VARCHAR (10),
     COTOWN    CHAR    (45) NOT NULL,
     COTOWNNO  CHAR    (10),
     COCOUNTR  CHAR     (4),
     COTEL     CHAR    (16),
     COVAT     CHAR    (11),
     COBANKNO  CHAR    (14),
     COC_PNO   number
    )
   ;
--
  CREATE TABLE TUTPERSONS
    (PNO       number  primary key,
     PLNAME    CHAR    (40) NOT NULL,
     PFNAME    VARCHAR (15),
     PFUNC     CHAR    (20),
     PA_CONO   number       constraint fk_pa_cono references TUTCOMPANIES ON DELETE SET NULL,
     PADEPT    CHAR    (30),
     PTEL      CHAR    (16),
     PSEX      CHAR     (1),
	 PTYPE	   VARCHAR	(10) DEFAULT 'Employee'
    )
   ;
--
  CREATE TABLE TUTCOURSES
    (CID       CHAR     (4) primary key,
     CSTITLE   CHAR    (45) NOT NULL,
     CLTITLE   VARCHAR (60),
     CDUR      number       NOT NULL,
     CAPRICE   number (9,2) NOT NULL
    )
   ;
--
	CREATE TABLE TUTPASSWORDS(
	pass_pno number(3) constraint fk_pass_pno  references TUTPERSONS (pno),
	password varchar(30),
	constraint pk_password primary key (pass_pno, password)
);
--




-- LOAD DATA INTO THE 5 TABLES
INSERT INTO TUTCOMPANIES VALUES (1, 'LOC COMPUTER CORP.', 'RING', '189', 'BRUSSEL', '1020 ', 'B', '02/6784523 ', '345-786-890', NULL, 12);
INSERT INTO TUTCOMPANIES VALUES (2, 'DATAWISHES N.V.', 'AVENUE LAMBERT', '45 B6', 'BRUSSEL', '1060', 'B', '02/3421632 ', '403-146-747', '210-0040988-09', 8);
INSERT INTO TUTCOMPANIES VALUES (3, 'ABIS N.V.', 'DIESTSEVEST', '32', 'LEUVEN', '3000', 'B', '016/245610', '423-345-567', '739-0000673-02', 1);
INSERT INTO TUTCOMPANIES VALUES (4, 'ESCON', 'ANTONIUSLAAN', '2', 'GENT', '8200', 'B', '091/456213', '120-450-002', '009-4568791-45', 66);
INSERT INTO TUTCOMPANIES VALUES (5, 'COVERDAT', 'WARMTESTRAAT', '67', 'NAARDEN', '1411 AR ', 'NL', '08879-3844', NULL, '003-780034-54', 24);
INSERT INTO TUTCOMPANIES VALUES (6, 'ASC COMPANY', 'KAAI 345', '67 b5', 'ANTWERPEN', '2030', 'B', '03/3451298', '567-345-453', '009-0000345-45', 34);
INSERT INTO TUTCOMPANIES VALUES (9, 'TECHNISOFT B.V.', 'ZWARTEWEG', '112', 'ROTTERDAM', '1420-WK', 'NL', '02977-22456', NULL, NULL, 32);
INSERT INTO TUTCOMPANIES VALUES (10, 'BET MECHANICS NV.', 'INDUSTRIEPARK', '678', 'MECHELEN', '1240', 'B', '015/348778 ', '009-568-562', '021-0000456-78', 87);
INSERT INTO TUTCOMPANIES VALUES (11, 'CandC INTERNATIONAL', 'GOSWELL ROAD', '521', 'LONDON', 'EC1N7JQ', 'GB', '01 278 2377', NULL, NULL, 36);
INSERT INTO TUTCOMPANIES VALUES (12, 'BROWN AG', 'HELGA FELD', '3', 'MUNICH', '8906', 'D', '7-6566', NULL, NULL, 17);
INSERT INTO TUTCOMPANIES VALUES (13, 'FLYGT', 'HOOGSTRAAT', '67 ', 'TERNAT', '1200', 'B', '02/7800056', '900-120-324', '021-456098-45', 35);
INSERT INTO TUTCOMPANIES VALUES (15, 'DIRECT SOFT Ltd.', 'CORPORATION STREET', '14', 'BIRMINGHAM', 'B2 4RN', 'GB', '021 643 5072', NULL, NULL, 15);
INSERT INTO TUTCOMPANIES VALUES (17, 'POUDRE BELGE', 'RUE D''EAU', '67', 'NAMUR', '7200', 'B', '042/563409', '900-678-232', '009-4560004-56', 43);
INSERT INTO TUTCOMPANIES VALUES (20, 'OLIVER', 'GASTSTRAAT', '243', 'HASSELT', '3500', 'B', '011/459123', '451-546-789', '458-1285006-45', 92);
INSERT INTO TUTCOMPANIES VALUES (21, 'PROCESS', 'DESGUINLEI', '109 B56', 'ANTWERPEN', '2030', 'B', '03/3456723', '789-456-234', '410-4567894-67', 21);
INSERT INTO TUTCOMPANIES VALUES (22, 'BELGISCHE BANK', 'HOOFDSTRAAT', '675', 'ANTWERPEN', '2000', 'B', '03/3451078', '567-231-430', '554-4620439-45', 22);
INSERT INTO TUTCOMPANIES VALUES (25, 'DIEMEN', 'HEERBAAN', '250', 'AMSTERDAM', '1014 BA', 'NL', '01720-45665', NULL, NULL, 33);
INSERT INTO TUTCOMPANIES VALUES (32, 'BERENDSEN CP', 'EXSELSIORLAAN', '67 B45', 'BRUSSEL', '1220', 'B', '02/4568791', '125-002-021', '009-4587661-12', 14);
INSERT INTO TUTCOMPANIES VALUES (41, 'RALBERG', 'SCHIPHOLWEG', '34', 'LEIDEN', '6574 HK', 'NL', '071-218112', NULL, NULL, 132);
INSERT INTO TUTCOMPANIES VALUES (42, 'EDUCA Ltd.', 'WORSHIP STREET', '74', 'LONDON', 'EC2A 2EN', 'GB', '01 377 4645', NULL, NULL, 56);
INSERT INTO TUTCOMPANIES VALUES (43, 'COMPUTRAIN', 'SCHIEDAMSE VEST', '99A', 'ROTTERDAM', '3012', 'NL', '010-4134409', NULL, NULL, 5);
INSERT INTO TUTCOMPANIES VALUES (46, 'ASSUR', 'GRASMARKT', '67', 'GENT', '8000', 'B', '091/450065', '021-102-212', '079-4580056-45', 28);
INSERT INTO TUTCOMPANIES VALUES (52, 'BANC', 'AVENUE LOUISE', '78 B4', 'BRUSSEL ', '1000', 'B', '02/4561236 ', '002-456-442', '079-0007549-05', 18);
INSERT INTO TUTCOMPANIES VALUES (104, 'ASCO', 'DEEP LANE', '1A ', 'OXFORD', 'RG211RY', 'GB ', '0256 469460', NULL, '000-111111-54', 104);

-- persons

INSERT INTO TUTPERSONS VALUES (1, 'SMITHS', 'JAN', 'TRAINING CONSULT', 3, 'SYSTEM SOFTWARE', '916/242569', 'M','Manager');
INSERT INTO TUTPERSONS VALUES (2, 'TAVERNIER', 'PETER', 'PROGRAMMER', 3, 'SYSTEM SOFTWARE', '016/242564', 'M','Employee');
INSERT INTO TUTPERSONS VALUES (3, 'DEKEYSER', 'ANN', 'PROGRAMMER', 3, 'SYSTEM SOFTWARE', NULL, 'F','Coworker');
INSERT INTO TUTPERSONS VALUES (4, 'NIEHOF', 'RUUD', 'EDP-MANAGER', 43, 'INFOCENTER', '010-4134409', 'M','Accountant');
INSERT INTO TUTPERSONS VALUES (5, 'DUCHEMIN', 'JUNIOR', 'EDP-MANAGER', 43, 'INFOCENTER', '010-4134409', 'M','Coworker');
INSERT INTO TUTPERSONS VALUES (6, 'VANHEIJKOOP', 'GERT ', 'ANALYST', 43, 'INFOCENTER', NULL, 'M');
INSERT INTO TUTPERSONS VALUES (7, 'DE GROOT', 'ATY', 'OPERATOR', 43, 'INFOCENTER', NULL, 'F');
INSERT INTO TUTPERSONS VALUES (8, 'PEREZ', 'MARIA', 'MANAGER', 2, NULL, '02/3421632 ', 'F');
INSERT INTO TUTPERSONS VALUES (9, 'LIVIER', 'F.', 'ANALYST', 2, NULL, NULL, 'M');
INSERT INTO TUTPERSONS VALUES (10, 'LUTZ', 'C.', 'ANALYST', 2, NULL, NULL, 'F');
INSERT INTO TUTPERSONS VALUES (11, 'LOOSE', 'K.', 'CONSULTANT', NULL, NULL, '02/4560215', 'M');
INSERT INTO TUTPERSONS VALUES (12, 'BENOIT', 'PHILIP', 'SOFTWARE ENGINEER', 1, 'DEVELOPMENT', '02/6784524', 'M');
INSERT INTO TUTPERSONS VALUES (13, 'BENOIT', 'DIRK', 'SYSTEM  ENGINEER', 1, 'SUPPORT', '02/6784523 ', 'M');
INSERT INTO TUTPERSONS VALUES (14, 'DETROIT', 'D.', 'SECRETARY', 32, NULL, '02/4568791 ', 'M');
INSERT INTO TUTPERSONS VALUES (15, 'SPENCER', 'THEODORE', 'SYSTEM MANAGER', 15, NULL, '021 643 5072', 'M');
INSERT INTO TUTPERSONS VALUES (17, 'SCHUMACHER', 'R.', NULL, 12, 'ENTWIKLUNG', '45', 'M');
INSERT INTO TUTPERSONS VALUES (18, 'GELADE', 'BENNY', 'MANAGER', 52, NULL, NULL, 'M');
INSERT INTO TUTPERSONS VALUES (19, 'COPPIETERS', 'C.', 'OPERATOR', 52, NULL, NULL, 'F');
INSERT INTO TUTPERSONS VALUES (20, 'DEWINDT', 'D.', 'ANALYST', 52, NULL, NULL, 'M');
INSERT INTO TUTPERSONS VALUES (21, 'DESCHRIJVER', 'E.', 'EDUCATION MANAGER', 21, 'TRAINING CENTER', NULL, 'M');
INSERT INTO TUTPERSONS VALUES (22, 'HENDERSON', 'DAVID', 'SUPPORT ENGINEER', 22, 'INFOCENTER', 'b 4567', 'M');
INSERT INTO TUTPERSONS VALUES (23, 'DELANGHE', 'G.', 'SYSTEM  ANALYST', 22, 'INFOCENTER', 'b 4587', 'M');
INSERT INTO TUTPERSONS VALUES (24, 'VANDEBROECK', 'L.', 'ANALYST', 5, 'AUTOMATISATION', 'B 456', 'M');
INSERT INTO TUTPERSONS VALUES (25, 'MEURIS', 'FRITS', 'PROGRAMMER', 5, 'AUTOMATISATION', 'b 457 ', 'M');
INSERT INTO TUTPERSONS VALUES (26, 'HEBBELYNCK', 'H.J.', 'PROJECT ENGINEER', 5, 'PRODUKTION', 'b 546 ', 'M');
INSERT INTO TUTPERSONS VALUES (28, 'TYTGAT', 'ADOLF', 'EDP-MANAGER', 46, NULL, 'b 7894', 'M');
INSERT INTO TUTPERSONS VALUES (29, 'DEVISSER', 'J.', 'ANALYST', 46, NULL, 'b 4569', 'M');
INSERT INTO TUTPERSONS VALUES (32, 'BUENK', 'G.J. ', 'MANAGER', 9, NULL, NULL, 'M');
INSERT INTO TUTPERSONS VALUES (33, 'PIELAGE', 'J.H. ', 'PROJECT MANAGER', 25, 'DATA SERVICES', '01720-45665', 'M');
INSERT INTO TUTPERSONS VALUES (34, 'DEBRUYN', 'PATRICK', 'PRODUCT MANAGER', 6, 'DATA SERVICES', '03/3451298 ', 'M');
INSERT INTO TUTPERSONS VALUES (35, 'DESMET', 'F.', 'MANAGER', 13, NULL, '02/7800056 ', 'M');
INSERT INTO TUTPERSONS VALUES (36, 'ADAMSON', 'BRUCE', 'EDUCATION MANAGER', 11, 'TRAINING CENTER', '01 278 2377', 'M');
INSERT INTO TUTPERSONS VALUES (43, 'DEHEM', 'F.', 'ADVISOR', 17, NULL, '042/566213', 'M');
INSERT INTO TUTPERSONS VALUES (47, 'GOYENS', 'F.', 'OPERATOR', 32, 'DATA SERVICES', '235', 'M');
INSERT INTO TUTPERSONS VALUES (48, 'GERRIES', 'G.', 'OPERATOR', 32, 'DATA SERVICES', '452', 'F');
INSERT INTO TUTPERSONS VALUES (49, 'DECORTE', 'EDMOND', 'PROGRAMMER', 32, NULL, NULL, 'M');
INSERT INTO TUTPERSONS VALUES (50, 'DEWILDE', 'P.', 'PROGRAMMER', 32, NULL, NULL, 'M');
INSERT INTO TUTPERSONS VALUES (56, 'PARKER', 'L.', 'TRAINING MANAGER', 42, 'TRAINING CENTER', '01 377 4645', 'M');
INSERT INTO TUTPERSONS VALUES (66, 'MOORS', 'SYLVAIN', NULL, 4, NULL, NULL, 'M');
INSERT INTO TUTPERSONS VALUES (87, 'DEWULF', 'G.', 'EDP_MANAGER', 10, 'INFOCENTER', '015/348778 ', 'F');
INSERT INTO TUTPERSONS VALUES (92, 'OLIVER', 'P.', 'MANAGER', 20, NULL, '011/459123 ', 'M');
INSERT INTO TUTPERSONS VALUES (104, 'NICHOLLS', 'D.', 'ACCOUNT MANAGER ', 104, NULL, '0256 469460', 'M');
INSERT INTO TUTPERSONS VALUES (132, 'BUNE', 'JAN', 'REGISTER ACCOUNT ', 41, 'AUDIT', '071-218112 ', 'M');
INSERT INTO TUTPERSONS VALUES (133, 'KOOPS', 'BART ', 'ASSISTANT ACCOUNT ', 41, 'AUDIT', NULL, 'M');
INSERT INTO TUTPERSONS VALUES (134, 'MAK', 'L.', 'ACCOUNT', 41, 'AUDIT', NULL, 'F');


-- Courses


INSERT INTO TUTCOURSES VALUES ('7800', 'IMSADFII', 'Development of conversational transactions using IMSADFII', 5, 550.00);
INSERT INTO TUTCOURSES VALUES ('7801', 'IMSADFII advanced topics', 'IMSADFII Advanced Topics', 3, 550.00);
INSERT INTO TUTCOURSES VALUES ('7810', 'ADFPLUS', 'ADFPLUS preprocessors and utilities', 2, 550.00);
INSERT INTO TUTCOURSES VALUES ('7820', 'IMS/DB', 'IMS/DB application programming ', 5, 550.00);
INSERT INTO TUTCOURSES VALUES ('7830', 'IMS/DC', 'IMS/DC application programming ', 3, 550.00);
INSERT INTO TUTCOURSES VALUES ('7840', 'Implementation of physical IMS data bases', 'Implementation of physical IMS data bases', 3, 550.00);
INSERT INTO TUTCOURSES VALUES ('7850', 'DB2, an overview', 'DB2, an overview', 5, 550.00);
INSERT INTO TUTCOURSES VALUES ('7860', 'ISPF dialog management', 'ISPF dialog management services', 3, 550.00);
INSERT INTO TUTCOURSES VALUES ('7870', 'Generalized audit exit', 'Generalized audit exit (GAEXIT)', 3, 550.00);
INSERT INTO TUTCOURSES VALUES ('7890', 'Design of IMS data bases', 'Design of IMS data bases', 3, 550.00);
INSERT INTO TUTCOURSES VALUES ('7900', 'Workshop SQL', 'Workshop SQL', 3, 550.00);
INSERT INTO TUTCOURSES VALUES ('8001', 'System development', 'System development : management and methodology', 2, 550.00);
INSERT INTO TUTCOURSES VALUES ('8002', 'Projectmanagement', 'Projectmanagement', 4, 550.00);
INSERT INTO TUTCOURSES VALUES ('8003', 'Information analysis', 'System analysis', 5, 550.00);
INSERT INTO TUTCOURSES VALUES ('8004', 'System design', 'System design', 5, 550.00);
INSERT INTO TUTCOURSES VALUES ('8005', 'Structured programming', 'Structured Programming', 5, 550.00);
INSERT INTO TUTCOURSES VALUES ('8006', 'Technical writing', 'Writing, evaluation and correction of technical manuals', 1, 475.00);
INSERT INTO TUTCOURSES VALUES ('8031', 'SAS fundamentals', 'SAS fundamentals course', 3, 550.00);
INSERT INTO TUTCOURSES VALUES ('8032', 'Advanced SAS ', 'Advanced SAS course', 2, 550.00);
INSERT INTO TUTCOURSES VALUES ('8041', 'Capacity planning ', 'Capacity planning : technics and strategies', 4, 550.00);
INSERT INTO TUTCOURSES VALUES ('8042', 'SRM parameters in MVS systems', 'Design of SRM parameters and tuning of MVS systems', 2, 550.00);
INSERT INTO TUTCOURSES VALUES ('8043', 'PC LAN', 'Seminar : PC LAN', 1, 500.00);
INSERT INTO TUTCOURSES VALUES ('8051', 'PC_DOS', 'Workshop PC-DOS', 2, 375.00);
INSERT INTO TUTCOURSES VALUES ('8052', 'DbaseIII programming', 'DbaseIII (Plus) programming', 3, 375.00);
INSERT INTO TUTCOURSES VALUES ('8053', 'CAD on PC ', 'CAD on PC', 1, 375.00);
INSERT INTO TUTCOURSES VALUES ('8054', 'DbaseIII systems', 'DbaseIII systems', 3, 500.00);
INSERT INTO TUTCOURSES VALUES ('8055', 'LOTUS 123 : programming', 'LOTUS 123 (versie 2) programming', 3, 375.00);
INSERT INTO TUTCOURSES VALUES ('8056', 'Autocad', 'Training Autocad', 3, 500.00);

commit;

alter table TUTCOMPANIES
add constraint fk_coc_pno foreign key(coc_pno) references TUTPERSONS ON DELETE SET NULL;
commit;


INSERT INTO TUTPASSWORDS VALUES (1, '1');
INSERT INTO TUTPASSWORDS VALUES (2, '2');
INSERT INTO TUTPASSWORDS VALUES (3, '3');
INSERT INTO TUTPASSWORDS VALUES (4, '4');
INSERT INTO TUTPASSWORDS VALUES (5, 'abc213');
INSERT INTO TUTPASSWORDS VALUES (6, 'abc213');
INSERT INTO TUTPASSWORDS VALUES (7, 'def456');
INSERT INTO TUTPASSWORDS VALUES (8, 'def456');
INSERT INTO TUTPASSWORDS VALUES (9, 'def456');
INSERT INTO TUTPASSWORDS VALUES (10, 'def456');
INSERT INTO TUTPASSWORDS VALUES (11, 'def456');
INSERT INTO TUTPASSWORDS VALUES (12, '123456');
INSERT INTO TUTPASSWORDS VALUES (13, '456789');
INSERT INTO TUTPASSWORDS VALUES (14, 'voiture');



INSERT INTO TUTPROJECTS VALUES ('7800', 'IMSADFII');
INSERT INTO TUTPROJECTS VALUES ('7801', 'IMSADFII advanced topics');
INSERT INTO TUTPROJECTS VALUES ('7810', 'ADFPLUS');
INSERT INTO TUTPROJECTS VALUES ('7820', 'IMS/DB');
INSERT INTO TUTPROJECTS VALUES ('7830', 'IMS/DC');
INSERT INTO TUTPROJECTS VALUES ('7840', 'Implementation of physical IMS data bases');
INSERT INTO TUTPROJECTS VALUES ('7850', 'DB2, an overview');
INSERT INTO TUTPROJECTS VALUES ('7860', 'ISPF dialog management');
INSERT INTO TUTPROJECTS VALUES ('7870', 'Generalized audit exit');
INSERT INTO TUTPROJECTS VALUES ('7890', 'Design of IMS data bases');
INSERT INTO TUTPROJECTS VALUES ('7900', 'Workshop SQL');
INSERT INTO TUTPROJECTS VALUES ('8001', 'System development');
INSERT INTO TUTPROJECTS VALUES ('8002', 'Projectmanagement');
INSERT INTO TUTPROJECTS VALUES ('8003', 'Information analysis');
INSERT INTO TUTPROJECTS VALUES ('8004', 'System design');
INSERT INTO TUTPROJECTS VALUES ('8005', 'Structured programming');
INSERT INTO TUTPROJECTS VALUES ('8006', 'Technical writing');
INSERT INTO TUTPROJECTS VALUES ('8031', 'SAS fundamentals');
INSERT INTO TUTPROJECTS VALUES ('8032', 'Advanced SAS');
INSERT INTO TUTPROJECTS VALUES ('8041', 'Capacity planning ');
INSERT INTO TUTPROJECTS VALUES ('8042', 'SRM parameters in MVS systems');
INSERT INTO TUTPROJECTS VALUES ('8043', 'PC LAN');
INSERT INTO TUTPROJECTS VALUES ('8051', 'PC_DOS');
INSERT INTO TUTPROJECTS VALUES ('8052', 'DbaseIII programming');
INSERT INTO TUTPROJECTS VALUES ('8053', 'CAD on PC ');
INSERT INTO TUTPROJECTS VALUES ('8054', 'DbaseIII systems');
INSERT INTO TUTPROJECTS VALUES ('8055', 'LOTUS 123 : programming');
INSERT INTO TUTPROJECTS VALUES ('8056', 'Autocad', 'Training Autocad');

INSERT INTO TUTPROJECTS VALUES ('0001', 'Administrations Work');
INSERT INTO TUTPROJECTS VALUES ('0002', 'collegues meetings');
INSERT INTO TUTPROJECTS VALUES ('0010', 'webSite adjustments');
INSERT INTO TUTPROJECTS VALUES ('0020', 'creation of a course');
INSERT INTO TUTPROJECTS VALUES ('0003', 'partners contacts');
INSERT INTO TUTPROJECTS VALUES ('0040', 'business meetings');
INSERT INTO TUTPROJECTS VALUES ('1010', 'Update hardware');
INSERT INTO TUTPROJECTS VALUES ('1020', 'cleaning computers');
INSERT INTO TUTPROJECTS VALUES ('1030', 'arrangments locals');


/* Junior update here*/

/*ALTER TABLE Tutpersons drop column PTYPE;*/



/*  
  UPDATE tutpersons SET PTYPE = 'Manager' where PNO = 1 ;
  UPDATE tutpersons SET PTYPE = 'Accountant' where PNO = 2 ;
  UPDATE tutpersons SET PTYPE = 'Employee' where PNO = 3 ;
  UPDATE tutpersons SET PTYPE = 'Coworker' where PNO = 4 ;

  UPDATE TUTPASSWORDS SET password ='1' WHERE pass_pno = 1;
  UPDATE TUTPASSWORDS SET password ='2' WHERE pass_pno = 2;
  UPDATE TUTPASSWORDS SET password ='3' WHERE pass_pno = 3;
*/
	
/*

UPDATE tutpersons SET PTYPE = 'Coworker' where PLNAME = 'Duchemin' ;
  
 
update TUTPERSONS SET PLNAME='DEKEYSER' where PLNAME ='DE KEYSER';

update TUTPERSONS SET PLNAME='VANHEIJKOOP' where PLNAME ='VAN HEIJKOOP';

update TUTPasswords SET Password='4' where pass_pno ='5';


INSERT INTO TUTPERSONS VALUES (4, 'Duchemin', 'Junior', 'ACCOUNT', 41, 'AUDIT', NULL, 'F','Coworker');

INSERT INTO TUTPASSWORDS VALUES (4,'4');

update TUTPERSONS SET PFNAME='RUUD' where PLNAME ='NIEHOF';
*/
	