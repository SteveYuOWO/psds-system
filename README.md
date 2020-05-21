# java EE大作业题目及要求

# Postgraduate Supervisor Dual Selection System

自己独立完成，任何人不得将自己的报告与别人共享（不得复制拷贝）

### ❤️1.题目

- 研究生导师双选系统 ，采用B/S架构

* 研究生入学时需要选择自己的导师，导师也需要选择学生；管理员（各个学院相应专业）也需要管理学生，导师数据，最终确定学生导师

* 每个研究生选导师有三个志愿；导师所带学生上限由管理员设定；

### 🧡2.系统用户

* 学生：
  * 学号、姓名、密码、所报考专业；
  * 选择导师（三个志愿必填），查看导师选择情况，最终导师；
  * 个人信息维护等；
* 导师：
  * 依据上限，选定学生（已经选择了该导师的学生）需要专业页面

* 管理员（学院级管理员）：
  * 学生基本信息批量导入（单个录入），维护；
  * 导师数据批量导入（单个录入），维护；
  * 专业，设定导师上限；
  * 查看学生选择导师情况，导师选择学生情况，最终确定学生导师；（只限于管理本院的招生专业）
  * 导出志愿表，选择导师最终结果（只限于管理本院的招生专业）
* 研究室院管理员：
  * 管理（增加，维护）学院管理员；
  * 查看学生选择导师情况，导师选择学生情况，最终确定学生导师；（只限于管理本院的招生专业）
  * 学生基本信息批量导入（单个录入），维护；
  * 导师数据批量导入（单个录入），维护；
  * 导出志愿表，选择导师最终结果

### 💛3.系统目标愿景

系统需求分析（最终使用者描述需求，功能性需求，非功能性（并发，安全，可靠，日志，事务））

* 自然语言描述及使用UML，用例图，。。。

系统设计（概要设计、详细设计）

* 数据库架构
* 技术架构设计MVC

系统测试、部署

* 功能



