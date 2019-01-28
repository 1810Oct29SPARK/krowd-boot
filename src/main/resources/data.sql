
INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (1,'123 Boogie Woogie Ave',NULL,'Spooksville','CV',12345);
INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (2,'456 Boogie Woogie Ave','Apt 3','Ghostburg','PG',67890);

INSERT INTO EVENT_CATEGORY (id,name) VALUES (1,'Party');
INSERT INTO EVENT_CATEGORY (id,name) VALUES (2,'Other');

INSERT INTO USER_ROLE (id,name) VALUES (1,'Admin');
INSERT INTO USER_ROLE (id,name) VALUES (2,'User');

INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) VALUES (1,'email@email.com','firstname','lastname','username','picture',1234,2,1);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) VALUES (2,'WWW@WWW.com','Bo','Peep','PeepBo',NULL,87,1,1);

INSERT INTO EVENT (id,name,picture,description,date,address_id,flag,event_category_id,user_id) VALUES (1,'Haunted House Party',NULL,'Spooky stuff going on in the graveyard, come on down.','October 31st, 2019',1,0,1,1);
INSERT INTO EVENT (id,name,picture,description,date,address_id,flag,event_category_id,user_id) VALUES (2,'Miner 49er',NULL,'Scooby-Doo type stuff.','May 3rd, 2019',2,1,2,2);

INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,1,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,2,-1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,2,0);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (2,1);

INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (1,'Looking forward to the thing',0,1,1,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (2,'This is a flagged comment',1,2,2,null);

INSERT INTO KROWD_USER (EMAIL,FIRSTNAME,LASTNAME,USERNAME,REPUTATION,ACCOUNT_STATUS) VALUES ('JAKEY@JAKEY.COM','JAKE','MAN','RUNESCAPER1337',1,1);
