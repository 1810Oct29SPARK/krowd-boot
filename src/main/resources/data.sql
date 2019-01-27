
INSERT ALL
INTO ADDRESS VALUES (1,'123 Boogie Woogie Ave',NULL,'Spooksville','CV',12345),
INTO ADDRESS VALUES (2,'456 Boogie Woogie Ave','Apt 3','Ghostburg','PG',67890),
SELECT * FROM DUAL;

INSERT ALL
INTO COMMENT VALUES (1,'Looking forward to the thing',0,1,1),
INTO COMMENT VALUES (2,'This is a flagged comment',1,2,2),
SELECT * FROM DUAL;

INSERT ALL
INTO EVENT VALUES (1,'Haunted House Party',NULL,'Spooky stuff going on in the graveyard, come on down.','October 31st, 2019',1,'13',0,1,1),
INTO EVENT VALUES (2,'Miner 49er',NULL,'Scooby-Doo type stuff.','May 3rd, 2019',2,'69',1,2,2),
SELECT * FROM DUAL;

INSERT ALL
INTO EVENT_CATEGORY VALUES (1,'Party'),
INTO EVENT_CATEGORY VALUES (2,'Other'),
SELECT * FROM DUAL;

INSERT ALL
INTO KROWD_USER VALUES (1,'email@email.com','firstname','lastname','username','picture',1234,0),
INTO KROWD_USER VALUES (2,'WWW@WWW.com','Bo','Peep','PeepBo',NULL,87,1),
SELECT * FROM DUAL;

INSERT ALL
INTO USER_EVENT VALUES (1,1,1,1),
INTO USER_EVENT VALUES (2,2,2,-1),
INTO USER_EVENT VALUES (3,2,1,0),
INTO USER_EVENT VALUES (4,2,1),
SELECT * FROM DUAL;

INSERT ALL
INTO USER_ROLE VALUES (1,'Admin'),
INTO USER_ROLE VALUES (2,'User'),
SELECT * FROM DUAL;