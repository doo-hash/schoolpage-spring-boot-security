create table admissions(
id Long not null primary key AUTO_INCREMENT,
departments varchar(50) not null,
faculty varchar(50) not null,
start_date date not null,
end_date date not null,
alloted int not null,
filled int not null,
remaining int not null);

insert into 
admissions(departments, faculty, start_date, end_date, alloted, filled, remaining) 
values('Languages','John','2022-01-05','2023-01-03',200,100,100);
insert into 
admissions(departments, faculty, start_date, end_date, alloted, filled, remaining) 
values('Science','Meera','2022-01-05','2023-01-03',200,100,100);
insert into 
admissions(departments, faculty, start_date, end_date, alloted, filled, remaining) 
values('Mathematics','John','2022-01-05','2023-01-03',200,100,100);
insert into 
admissions(departments, faculty, start_date, end_date, alloted, filled, remaining) 
values('Arts','Meera','2022-01-05','2023-01-03',200,100,100);
insert into 
admissions(departments, faculty, start_date, end_date, alloted, filled, remaining) 
values('Chemistry','Hari','2022-01-05','2023-01-03',200,100,100);
insert into 
admissions(departments, faculty, start_date, end_date, alloted, filled, remaining) 
values('Social','Harish','2022-01-05','2023-01-03',200,100,100);
insert into 
admissions(departments, faculty, start_date, end_date, alloted, filled, remaining) 
values('English','David','2022-01-05','2023-01-03',200,100,100);
insert into 
admissions(departments, faculty, start_date, end_date, alloted, filled, remaining) 
values('Physics','Jackson','2022-01-05','2023-01-03',200,100,100);
insert into 
admissions(departments, faculty, start_date, end_date, alloted, filled, remaining) 
values('Biology','Salma','2022-01-05','2023-01-03',200,100,100);

create table courses(
id Long not null primary key auto_increment,
course_name varchar(100) not null,
course_duration int not null,
department_id Long not null,
department_name varchar(50) not null,
tutors varchar(50) not null,
resources LONGTEXT not null
);
insert into 
courses(course_name, course_duration,department_id,department_name, tutors, resources) 
values('course-1','10','1','Languages','Jackson','Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS.');
insert into 
courses(course_name, course_duration,department_id,department_name, tutors, resources) 
values('course-1','10','2','Science','Jackson','Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS.');
insert into 
courses(course_name, course_duration,department_id,department_name, tutors, resources) 
values('course-1','10','3','Mathematics','Jackson','Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS.');
insert into 
courses(course_name, course_duration,department_id,department_name, tutors, resources) 
values('course-1','10','4','Arts','Jackson','Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS.');
insert into 
courses(course_name, course_duration,department_id,department_name, tutors, resources) 
values('course-1','10','5','Chemistry','Jackson','Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS.');
insert into 
courses(course_name, course_duration,department_id,department_name, tutors, resources) 
values('course-1','10','6','Social','Jackson','Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS.');
insert into 
courses(course_name, course_duration,department_id,department_name, tutors, resources) 
values('course-1','10','7','English','Jackson','Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS.');
insert into 
courses(course_name, course_duration,department_id,department_name, tutors, resources) 
values('course-1','10','8','Physics','Jackson','Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS.');
insert into 
courses(course_name, course_duration,department_id,department_name, tutors, resources) 
values('course-1','10','9','Biology','Jackson','Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS.');
