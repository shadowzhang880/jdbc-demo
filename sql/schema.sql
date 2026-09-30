CREATE DATABASE IF NOT EXISTS school DEFAULT CHARACTER SET utf8mb4;
USE school;

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS class;

CREATE TABLE class (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       class_name VARCHAR(50) NOT NULL
);

CREATE TABLE student (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(50) NOT NULL,
                         age INT,
                         major VARCHAR(50),
                         class_id INT
);

INSERT INTO class (class_name) VALUES
                                   ('软件1班'),
                                   ('软件2班'),
                                   ('网络1班');

INSERT INTO student (name, age, major, class_id) VALUES
                                                     ('张三', 20, '软件技术', 1),
                                                     ('李四', 21, '计算机应用', 1),
                                                     ('王五', 19, '软件技术', 1),
                                                     ('赵六', 22, '网络工程', 2),
                                                     ('孙七', 20, '软件技术', 2),
                                                     ('周八', 23, '网络工程', 3),
                                                     ('吴九', 18, '软件技术', 3),
                                                     ('郑十', 24, '计算机应用', 3),
                                                     ('张十一', 20, '网络工程', 1),
                                                     ('王十二', 22, '软件技术', 2);