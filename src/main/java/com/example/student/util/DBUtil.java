package com.example.student.util;

import jdk.dynalink.beans.StaticClass;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "Dcba20070202"; // 改成你自己的密码

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            System.err.println("MySQL 驱动加载失败！");
            e.printStackTrace();
        }
    }

    private DBUtil() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
