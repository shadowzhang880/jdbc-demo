# 学生信息管理系统

## 项目简介
基于 Java + JDBC + MySQL 的控制台学生信息管理系统，采用分层架构。

## 技术栈
- Java 21
- MySQL 8
- JDBC
- Maven
- Logback（可选）

## 功能列表
- [x] 学生增删改查
- [x] 按专业查询
- [x] 按姓名模糊查询
- [x] 班级增删改查
- [x] 查询学生及班级（多表查询）
- [x] 按专业统计人数
- [x] 按班级统计人数
- [x] 菜单循环
- [x] 输入校验

## 项目结构
com.example.student
├── model      实体类（Student、Class）
├── dao        数据访问层（StudentDao、ClassDao）
├── service    业务逻辑层（StudentService、ClassService）
├── util       工具类（DBUtil）
└── Main       入口

## 数据库设计

### student 表
| 字段 | 类型 | 说明 |
|------|------|------|
| id | INT | 主键，自增 |
| name | VARCHAR(50) | 姓名 |
| age | INT | 年龄 |
| major | VARCHAR(50) | 专业 |
| class_id | INT | 班级 id |

### class 表
| 字段 | 类型 | 说明 |
|------|------|------|
| id | INT | 主键，自增 |
| class_name | VARCHAR(50) | 班级名称 |

## 运行方式
1. 创建数据库 school
2. 执行建表 SQL（见 sql/schema.sql）
3. 修改 DBUtil 中的数据库密码
4. 运行 Main 类的 main 方法

## 开发进度
- [x] 第一阶段：学生 CRUD + 班级管理 + 多表查询 + 统计
- [ ] 第二阶段：Spring Boot + MyBatis
- [ ] 第三阶段：微服务

## 作者
你的名字