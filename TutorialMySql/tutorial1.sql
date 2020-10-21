set default_storage_engine=INNODB;
show table status;
 
create table test(id int) engine=INNODB;
show tables;

select @@GLOBAL.SQL_MODE;
select @@GLOBAL.SQL_MODE, @@SESSION.SQL_MODE;

create table test1(id int) engine=INNODB;
drop table test;
desc users;

insert into users (id) values (9);
select * from users;

set @@SESSION.sql_mode = '' ;
set sql_mode = 'NO_ENGINE_SUBSTITUTION';
select @@GLOBAL.SQL_MODE, @@SESSION.SQL_MODE LIMIT 0, 1000;
insert into users (id) values (10);
