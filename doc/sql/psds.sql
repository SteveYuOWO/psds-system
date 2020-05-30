create table t_admin
(
    id     int auto_increment primary key,
    name   varchar(50) ,
    sex    char(2)     ,
    passwd varchar(200),
    major  varchar(30)
);

create table t_dual_choose
(
    teacherId int not null,
    studentId int not null,
    primary key (teacherId, studentId)
);

create table t_major
(
    id   int auto_increment
        primary key,
    name varchar(50)  ,
    max  int          ,
    info varchar(2000)
);

create table t_root_admin
(
    id     int auto_increment
        primary key,
    name   varchar(50) ,
    sex    char(2)     ,
    passwd varchar(200)
);

create table t_student
(
    id             int auto_increment
        primary key,
    name           varchar(50)  ,
    sex            char(2)      ,
    stuNum         varchar(50)  ,
    email          varchar(50)  ,
    major          varchar(50)  ,
    info           varchar(2000),
    chooseTeacher1 int          ,
    chooseTeacher2 int          ,
    chooseTeacher3 int          ,
    passwd         varchar(200)
);

create table t_teacher
(
    id     int auto_increment
        primary key,
    name   varchar(50)  ,
    sex    char(2)      ,
    teaNum varchar(50)  ,
    email  varchar(50)  ,
    major  varchar(50)  ,
    info   varchar(2000),
    passwd varchar(200)
);