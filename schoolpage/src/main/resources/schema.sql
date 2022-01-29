create table admissions(
id Long not null primary key AUTO_INCREMENT,
departments varchar(50) not null,
faculty varchar(50) not null,
start_date date not null,
end_date date not null,
alloted int not null,
filled int not null,
remaining int not null);

create table courses(
id Long not null primary key auto_increment,
course_name varchar(100) not null,
course_duration int not null,
department_id Long not null,
department_name varchar(50) not null,
tutors varchar(50) not null,
resources LONGTEXT not null
);

create table schoolUsers(
id Long not null primary key auto_increment,
firstname varchar(255) not null,
lastname varchar(255) not null,
email varchar(255) not null,
phonenumber varchar(255) not null,
userid varchar(255) not null,
designation varchar(255) not null,
password varchar(255) not null,
checkterms tinyint not null);

create table roles(
id Long not null primary key auto_increment,
role varchar(45) not null unique);

insert into roles(role) values('ADMIN');