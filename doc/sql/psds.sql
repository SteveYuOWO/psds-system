create table t_admin
(
    id     int auto_increment
        primary key,
    name   varchar(50)  null,
    sex    char(2)      null,
    passwd varchar(200) null
);

create table t_dual_choose
(
    teacherId int not null,
    studentId int not null,
    status    int null,
    primary key (teacherId, studentId)
);

create table t_major
(
    id   int auto_increment
        primary key,
    name varchar(50)   null,
    max  int           null,
    info varchar(2000) null
);

create table t_root
(
    id     int auto_increment
        primary key,
    name   varchar(50)  null,
    sex    char(2)      null,
    passwd varchar(200) null
);

create table t_student
(
    id     int auto_increment
        primary key,
    name   varchar(50)   null,
    sex    char(2)       null,
    stuNum varchar(50)   null,
    email  varchar(50)   null,
    major  varchar(50)   null,
    info   varchar(2000) null,
    passwd varchar(200)  null
);

create table t_teacher
(
    id     int auto_increment
        primary key,
    name   varchar(50)   null,
    sex    char(2)       null,
    teaNum varchar(50)   null,
    email  varchar(50)   null,
    major  varchar(50)   null,
    info   varchar(2000) null,
    passwd varchar(200)  null
);

