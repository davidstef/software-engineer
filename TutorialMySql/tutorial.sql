create database tutorial1;
show databases;
use tutorial1;
create database tutorial1;
create table users(username text);
show tables;
desc users;

insert into users (username) values ("Bob");
insert into users (username) values ("Vicky");
select * from users;
desc users;
drop table users;
show tables;
create table users(id int, username text );
desc users;

insert into users (id, username) values (1, "Bob");
insert into users (id, username) values (1, "Vicky");
insert into users (id, username) values (null,null);

create table users(id int not null, username text not null);
insert into users (usename) values ("Someone");

show engines;
show table status;
  