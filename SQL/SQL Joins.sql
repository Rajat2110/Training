create database student;

use student;

create table Student
 ( id int,
   sname varchar(30),
   course_id int
 );
 
 insert into Student (id, sname) values (101, "James");
 insert into Student values (102, "Alex", 101);
 insert into Student values (104, "Luke", 102);
 
 select * from Student;
 
 create table Course
 ( course_id int,
   course_name varchar(40)
 );
 
 insert into Course values (101, "Physics");
 insert into Course values (102, "Chemistry");
 insert into Course values (104, "Economics");
 
 select * from Course;
 
 select * from Student s inner join Course c on s.course_id = c.course_id;
 select * from Student s left join Course c on s.course_id = c.course_id;
 
 select * from Student s left join Course c on s.course_id = c.course_id
 union
 select * from Student s right join Course c on s.course_id = c.course_id;