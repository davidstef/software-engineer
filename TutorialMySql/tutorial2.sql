select * from users;

insert into users (id, username) values (1, "Bob");
insert into users (id, username) values (1, "Vicky");

delete from users;
select @@SESSION.SQL_SAFE_UPDATES;
set sql_safe_updates = 0;

drop table users;
create table users (id int primary key, name text, email text);
desc users;

insert into users (id, name, email) values (0, "Bob", "bobdaffdat.com");
insert into users (id, name, email) values (1, "Vicky", "vickydaffdat.com");
select * from users;

drop table users;
create table users (id int primary key auto_increment, name text);
insert into users (name) values ('Bob');
insert into users (name) values ('Vicky');
insert into users (id, name) values (5, 'Vicky');
insert into users (id, name) values (7, 'Vicky');
