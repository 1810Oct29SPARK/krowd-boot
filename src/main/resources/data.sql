
INSERT INTO EVENT_CATEGORY VALUES (1, 'Sports');
INSERT INTO EVENT_CATEGORY VALUES (2, 'METEOROLOGY');
INSERT INTO EVENT_CATEGORY VALUES (3, 'LITERATURE');

Insert into KROWD_USER (id,email,firstname,lastname,username,picture,reputation,account_status) values (1,'what','Jon','Snider','Bubsy',null,12,1);
Insert into KROWD_USER (id,email,firstname,lastname,username,picture,reputation,account_status) values (2,'wshat','Stew','Gardner','Anger',null,9,1);
Insert into KROWD_USER (id,email,firstname,lastname,username,picture,reputation,account_status) values (3,'wfhat','Ed','Soma','Punk',null,2,1);

Insert into ADDRESS(id,street_Address,apartment,city,state,zip) values(1,'123qwea','2','asder','CA',12345);

Insert into EVENT(id,address_id,date,description,flag,name,event_category_id,user_id) values(1,1,'12 jan','kickball',0,'kickball',1,1);