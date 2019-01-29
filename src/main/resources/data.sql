INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (1,'123 Boogie Woogie Ave',NULL,'St. Petersburg','FL',33705);
INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (2,'456 Boogie Woogie Ave','Apt 3','St. Petersburg','FL',33708);
INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (3,'1 St. Pete Beach',NULL,'St. Petersburg','FL',33706);
INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (4,'1109 Bruce B. Downs Ave','Apartment 1203','Tampa','FL',33647);
INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (5,'1109 Bruce B. Downs Ave','Apartment 1204','Tampa','FL',33647);
INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (6,'1200 E. Fletcher Ave','Apt 65','Tampa','FL',33625);
INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (7,'308 Bullet Blvd',NULL,'Tampa','FL',33625);
INSERT INTO ADDRESS (id,street_Address,apartment,city,state,zip) VALUES (8,'42 Answer Way',NULL,'Tampa','FL',33619);

INSERT INTO EVENT_CATEGORY (id,name) VALUES (1,'Art');
INSERT INTO EVENT_CATEGORY (id,name) VALUES (2,'Food & Drink');
INSERT INTO EVENT_CATEGORY (id,name) VALUES (3,'Music');
INSERT INTO EVENT_CATEGORY (id,name) VALUES (4,'Outdoors');
INSERT INTO EVENT_CATEGORY (id,name) VALUES (5,'Sports');
INSERT INTO EVENT_CATEGORY (id,name) VALUES (6,'Volunteering');
INSERT INTO EVENT_CATEGORY (id,name) VALUES (7,'Other');

INSERT INTO USER_ROLE (id,name) VALUES (1,'Admin');
INSERT INTO USER_ROLE (id,name) VALUES (2,'User');

INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (1,'Grandma@art.com','Grandmother','Moses','ArtForAll','https://mholloway63.files.wordpress.com/2013/12/grandma-moses-9416251-1-402.jpg?w=560',1234,2,1);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (2,'shepherd@lamb.com','Bo','Peep','BoPeep','https://upload.wikimedia.org/wikipedia/commons/6/66/Hambledon_Hill_Sheep.jpg',87,1,0);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (3,'DevilCurseTheKing@USA.gov','John Paul','Jones','Madman','https://www.thefamouspeople.com/profiles/images/john-paul-jones-4.jpg',12,2,1);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (4,'I''llDieWithThisHammerInMyHand@CCC.gov','John','Henry','HammerMan','https://upload.wikimedia.org/wikipedia/commons/0/00/John_Henry-27527.jpg',870,1,1);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (5,'JaneDoe@generic.com','Jane','Doe','Generic',NULL,34,1,1);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (6,'Computer@NASA.gov','Katherine','Johnson','MathWiz','https://img.apmcdn.org/2e2ceb4fdbd8ac017b85b242fe098cb3b466cf5a/square/44315c-20161208-katherine-johnson.jpg',8,1,1);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (7,'Apollo1@NASA.gov','Niel','Armstrong','MoonBird',NULL,23,1,0);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (8,'Apollo2@NASA.gov','Buzz','Aldrin','SpaceEagle',NULL,7,1,0);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (9,'Apollo3@NASA.gov','Michael','Collins','OrbitWatcher',NULL,14,1,1);
INSERT INTO KROWD_USER (id,email,firstname,lastname,username,picture,reputation,role_id,account_status) 
VALUES (10,'Burt@CONELRAD.gov','Burt','Turtle','DuckAndCover',NULL,56,1,0);

INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (1,'First Meet Up!','January 27th, 2019',1,0,7,1,'Krowd Tampa has it''s first meeting today! I''d love to see you there.','https://images.unsplash.com/photo-1517457373958-b7bdd4587205?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=600&q=60');
INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (2,'Arts and Crafts with Grandma','January 27th, 2019',1,0,1,1,'I''d love to share my knowledge of art with all my friends.','https://images.unsplash.com/photo-1460661419201-fd4cecdf8a8b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=80');
INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (3,'Learn to Bake','January 28th, 2019',1,0,2,1,'For those of you who''d like to learn how to bake, my home will be open. I''ll have all the ingredients so don''t worry.','https://images.unsplash.com/photo-1483695028939-5bb13f8648b0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80');
INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (4,'Toy Drive','January 29th, 2019',8,0,6,1,'St Jude''s Children''s Hospital would love to have some donations of toys for the upcoming season. Any help is appreciated.','https://images.unsplash.com/photo-1516981879613-9f5da904015f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=967&q=80');
INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (5,'Hike near Hillsborough','February 2nd, 2019',2,0,4,2,'Let''s go for a nice Hike near Morris Bridge, I''ll meet you guys there.',null);
INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (6,'Swamp Orienteering','February 9th, 2019',3,0,4,2,'Want to learn how to find your way out of the swamp? I can teach you how.','https://images.unsplash.com/photo-1501155971883-5eea9f469c10?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80');
INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (7,'Trees of Tampa','February 16th, 2019',4,0,4,2,'The flora of Tampa are quite diverse. I''ll show you what''s what.','https://images.unsplash.com/photo-1541638127853-301f4ac81bbc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80');
INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (8,'Sailor''s Serenade','February 2nd, 2019',5,0,3,3,'Come to the riverfront to sing sea shanties long into the night.','https://images.unsplash.com/photo-1521616210349-dbec8efd13b4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80');
INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (9,'Spoils of the Sea','February 9th, 2019',6,0,2,3,'I''ll be cooking up all the sea has to offer, BYOB.','https://images.unsplash.com/photo-1530435525778-78f9b82b5115?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80');
INSERT INTO EVENT (id,name,date,address_id,flag,event_category_id,user_id,description,picture) 
VALUES (10,'Let''s clean up Tampa','February 10th, 2019',7,0,6,4,'Tampa could use some cleaning. Let''s pick up as much litter as possible.','https://images.unsplash.com/photo-1530587191325-3db32d826c18?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=600&q=60');

INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,1,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,2,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,3,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,4,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,5,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,6,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,7,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,8,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (2,9,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,1,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,2,0);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,3,0);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,4,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,5,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,6,-1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,7,-1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,8,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,9,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (1,10,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (3,1,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (3,2,-1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (3,3,-1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (3,4,-1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (3,5,0);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (3,6,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (3,7,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (3,8,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (4,1,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (4,2,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (4,3,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (4,4,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (4,5,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (4,6,1);
INSERT INTO USER_EVENT (event_id,user_id,rating) VALUES (4,7,1);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (5,1);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (5,2);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (5,3);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (5,4);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (5,5);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (5,6);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (6,1);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (6,2);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (6,3);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (6,4);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (6,5);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (7,1);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (7,2);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (7,3);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (7,4);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (8,1);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (8,2);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (8,3);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (9,1);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (9,2);
INSERT INTO USER_EVENT (event_id,user_id) VALUES (10,1);

INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (1,'Looking forward to seeing all you.',0,1,1,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (2,'I hated this event. The host should just die in a hole.',1,2,2,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (3,'Why is every event bad. I don''t like Krowd.',1,2,1,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (4,'You are all jerks. I hate this stuff.',1,2,2,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (5,'I actually liked this event. Good job.',0,2,1,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (6,'Nice. I love seafood.',0,4,8,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (7,'I''m looking forward to learning about all the nature around here.',0,3,7,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (8,'I love hiking.',0,5,5,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (9,'Loved the first event. Krowd is cool.',0,6,1,null);
INSERT INTO COMMENT (id,comment,flag,user_id,event_id,timestamp) VALUES (10,'I liked the cookies.',0,7,2,null);