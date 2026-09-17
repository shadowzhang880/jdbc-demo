package com.example.jdbc;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/school?" +
            "useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "Dcba20070202";

    // 静态代码块：类加载时执行一次，用于加载驱动
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            System.out.println("MySQL 驱动加载失败");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    /**
     * 关闭资源：Connection、Statement、ResultSet
     * 顺序：先关 ResultSet，再关 Statement，最后关 Connection
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();;
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null) {
            try {
                stmt.close();;
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 重载：只关闭 Connection 和 Statement
     */
    public static void close(Connection conn, Statement stmt) {
        close(conn,stmt,null);
    }
}
