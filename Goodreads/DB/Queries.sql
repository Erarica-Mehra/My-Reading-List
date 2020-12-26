create table my_shelf(
   id INT NOT NULL AUTO_INCREMENT,
   bookid int(11) NOT NULL,
   title VARCHAR(100) NOT NULL,
   author VARCHAR(100),
   PRIMARY KEY (id)
);

alter table my_shelf add column status varchar(50) NOT NULL;
alter table my_shelf add column image_url varchar(200) NOT NULL;
alter table my_shelf add column rating double NOT NULL;