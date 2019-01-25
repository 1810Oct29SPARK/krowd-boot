INSERT INTO EVENT_CATEGORY VALUES (1, 'Sports');
INSERT INTO EVENT_CATEGORY VALUES (2, 'METEOROLOGY');
INSERT INTO EVENT_CATEGORY VALUES (3, 'LITERATURE');

Insert into USER (id,email,firstname,lastname,username,picture,reputation,account_status) values (1,'what','Jon','Snider','Bubsy',null,12,1);
Insert into USER (id,email,firstname,lastname,username,picture,reputation,account_status) values (2,'what','Stew','Gardner','Anger',null,9,1);
Insert into USER (id,email,firstname,lastname,username,picture,reputation,account_status) values (3,'what','Ed','Soma','Punk',null,2,1);

Insert into EVENT(id,address,date,description,flag,name,event_category_id,user_id) values(1,'123q street','12 jan','kickball',0,'kickball',1,1);
COMMIT;