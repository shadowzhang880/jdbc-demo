package com.example.student.dao;

import com.example.student.model.Student;
import com.example.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    /**
     * 插入学生
     */
    public void insert(Student student) {
        String sql = "INSERT INTO student (name, age, major) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getMajor());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("插入学生失败", e);
        }
    }

    /**
     * 根据 id 删除
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("删除学生失败", e);
        }
    }

    /**
     * 更新学生
     */
    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, age = ?, major = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getMajor());
            pstmt.setInt(4, student.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("更新学生失败", e);
        }
    }

    /**
     * 查询所有学生
     */
    public List<Student> findAll() {
        String sql = "SELECT id, name, age, major FROM student";
        List<Student> students = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                students.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询所有学生失败", e);
        }

        return students;
    }

    /**
     * 根据 id 查询
     */
    public Student findById(int id) {
        String sql = "SELECT id, name, age, major FROM student WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询学生失败", e);
        }
        return null;
    }

    /**
     * 把 ResultSet 的一行映射成 Student 对象
     */
    private Student mapRow(ResultSet rs) throws SQLException {
        return new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("major")
        );
    }

    /**
     * 按专业查询
     */
    public List<Student> findByMajor(String major) {

        String sql = "SELECT id,name,age,major FROM student WHERE major = ?";
        List<Student> students = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){

            pstmt.setString(1,major);
            try (ResultSet rs = pstmt.executeQuery()){
                while(rs.next()) {
                    students.add(mapRow(rs));
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException("按专业查询失败",e);
        }
        return students;


    }

    /**
     * 按姓名模糊查询
     */
    public List<Student> findByNameLike(String keyword) {
        String sql = "SELECT id, name, age, major FROM student WHERE name LIKE ?";
        List<Student> students = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + keyword + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    students.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("按姓名查询失败", e);
        }
        return students;
    }

}