package com.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    // 数据库连接信息（提取为常量，方便复用）
    private static final String URL = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "Dcba20070202"; // 改成你自己的密码

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        // 1. 从控制台读取学生信息
        System.out.println("===== 当前所有学生 =====");
        List<Student> students = findAllStudents();
        for(Student s:students){
            System.out.println(s);
        }

        System.out.print("\n请输入要删除学生的id");
        int deleteid = scanner.nextInt();
        deleteStudent(deleteid);

        System.out.println("\n请输入要修改的学生的id：");
        int updateid = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n请输入新的年龄：");
        int newAge = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n请输入新的专业：");
        String newMajor = scanner.nextLine();

        updateStudent(updateid,newAge,newMajor);

        System.out.println("\n===== 操作后的所有学生 =====");
        List<Student> after = findAllStudents();
        for(Student s : after){
            System.out.println(s);
        }

        scanner.close();

    }

    public static void insertStudent(String name, int age, String major) {
        String sql = "INSERT INTO student (name, age, major) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 给三个占位符赋值
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, major);

            // 执行插入，返回受影响的行数
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }

        } catch (SQLException e) {
            System.err.println("插入数据时出错！");
            e.printStackTrace();
        }
    }
    /**
     * 查询所有学生，封装成 List<Student> 返回
     */
    public static List<Student> findAllStudents() {
        String sql = "SELECT id, name, age, major FROM student";
        List<Student> students = new ArrayList<>();

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String major = rs.getString("major");

                Student student = new Student(id, name, age, major);
                students.add(student);

            }
        }catch (SQLException e) {
            System.err.println("查询数据时出错");
            e.printStackTrace();
        }

        return students;
    }

    public static void deleteStudent(int id){
        String sql = "DELETE FROM student WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1,id);

            int rows = pstmt.executeUpdate();
            if(rows>0){
                System.out.println("删除成功！共删除 \" + rows + \" 条记录。");
            }else {
                System.out.println("删除失败，未找到 id = " + id + " 的学生。");
            }
        }catch (SQLException e) {
            System.err.println("删除出错！");
            e.printStackTrace();
        }
    }

    public static void updateStudent(int id, int age, String major) {
        String sql = "UPDATE student SET age = ?, major = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1,age);
            pstmt.setString(2,major);
            pstmt.setInt(3,id);

            int rows = pstmt.executeUpdate();
            if(rows>0){
                System.out.println("修改成功！共修改 " + rows + " 条记录。");
            }else{
                System.out.println("修改失败，未找到 id = " + id + " 的学生。");
            }
        } catch (SQLException e) {
            System.err.println("修改出错！");
            e.printStackTrace();
        }

    }
}
