create database psds;

use psds;

create table t_student(
                          id int primary key auto_increment,
                          name varchar(50),
                          sex char(2),
                          stuNum varchar(50),
                          identityNum varchar(30),
                          email varchar(50),
                          headPic varchar(50),
                          major varchar(50),
                          info varchar(2000),
                          chooseTeacher int,
                          passwd varchar(200)
);

create table t_teacher(
                          id int primary key auto_increment,
                          name varchar(50),
                          sex char(2),
                          teaNum varchar(50),
                          identityNum varchar(30),
                          email varchar(50),
                          headPic varchar(50),
                          major varchar(50),
                          info varchar(2000),
                          chooseStudent int,
                          passwd varchar(200)
);

create table t_admin(
                        id int primary key auto_increment,
                        name varchar(50),
                        sex char(2),
                        role varchar(50), # 是学院管理员还是root管理员，权限不一样
                        passwd varchar(200)
);

create table t_major(
                      id int primary key auto_increment,
                      name varchar(50),
                      max int,
                      info varchar(2000)
);