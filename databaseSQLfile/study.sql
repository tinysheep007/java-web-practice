create DATABASE study;
use study;
Create table student (ID int not null, Name varchar(30), Gender varchar(10), primary key (ID));
create table teacher(Tid  int not null, Name varchar(30), Gender varchar(10), primary key(Tid));
create table teach(ID int not null, Tid int not null, primary key(ID, Tid));
show tables;
insert into student values (102851, "Beater Pan", "M");
ALTER TABLE student RENAME COLUMN ID TO Sid;
select * from student;
