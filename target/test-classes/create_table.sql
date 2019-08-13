use studentSys;

drop table if exists student;
/*学生信息表*/
create table student
(
    `id`    int auto_increment,
    `name` varchar(10),
    `status` varchar(10),
    primary key (`id`)
);

drop table if exists course;

/*课程信息表*/
create table course
(
    `id` int   not null auto_increment,
    `name`      varchar(10) not null,
    primary key (`id`)
);

drop table if exists score;

create table score
(
    `course_id`  int ,
    `student_id` int ,
    `goal` int,
    `year` int
);


