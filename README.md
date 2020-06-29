# 研究生导师双选系统🍓

### 1.课程设计清单

- [课程设计题目](doc/大作业题目.md)

- [课程设计软件工程设计及报告](doc/研究生导师双选系统文档.docx)
- [SQL文件](doc/sql/psds.sql)

### 2.部署文档

- 环境：`jdk1.8`、`Tomcat 9`、`maven3.7`、`mysql 8`
- 数据库部署：`source doc/sql/psds.sql`

- 打包：`mvn clean package`
- 移动war包到tomcat的webapps目录下，执行`startup.sh`启动`tomcat`即可

