create DATABASE study;
use study;
Create table student (ID int not null, Name varchar(30), Gender varchar(10), primary key (ID));
create table teacher(Tid  int not null, Name varchar(30), Gender varchar(10), primary key(Tid));
create table teach(ID int not null, Tid int not null, primary key(ID, Tid));
show tables;
insert into student values (102851, "Beater Pan", "M");
insert into student values (1, "Jin", "M");
insert into student values (2, "Jasper", "M");
ALTER TABLE student RENAME COLUMN ID TO Sid;
insert into teacher values ();
select * from student;
select * from teacher;
create table user (Userid varchar(30) not null primary key, Password varchar(50));
insert into user values("a","a");
insert into user values("tinysheep007","Zcl48484848!");
select * from user;