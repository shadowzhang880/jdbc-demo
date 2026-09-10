package com.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo {
    public static void main(String[] args) {
        // 1. 数据库连接信息
        String url = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
        String user = "root";
        String password = "Dcba20070202"; // 改成你自己的密码

        // 2. SQL 语句
        String sql = "SELECT id, name, age, major FROM student";

        // 3. 准备一个 List 存放 Student 对象
        List<Student> students = new ArrayList<>();

        // 4. 连接数据库、执行查询、封装结果
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // 5. 遍历结果集，每行封装成一个 Student 对象
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String major = rs.getString("major");

                // 用全参构造创建 Student
                Student student = new Student(id, name, age, major);

                // 加入 List
                students.add(student);
            }

        } catch (SQLException e) {
            System.err.println("数据库操作失败！");
            e.printStackTrace();
        }

        // 6. 遍历 List，打印所有学生
        System.out.println("共查询到 " + students.size() + " 名学生：");
        for (Student s : students) {
            System.out.println(s);
        }

        // 7. 也可以根据条件筛选，比如打印所有软件技术专业的学生
        System.out.println("\n软件技术专业的学生：");
        for (Student s : students) {
            if ("软件技术".equals(s.getMajor())) {
                System.out.println(s.getName() + " - " + s.getAge());
            }
        }
    }
}