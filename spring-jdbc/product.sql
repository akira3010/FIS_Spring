create database test;
use test;

create table product
( 
id int,
name varchar(25)
);
insert into product values(10,"pen");
insert into product values(20,"pencil");
select * from product;
drop table product;
create table product
(
id int,
name varchar(25)
);
insert into product values(10,"pen");
insert into product values(20,"pencil");
select * from product;
