package com.example.student.dao;

import com.example.student.model.Student;
import com.example.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentDao {

    /**
     * 插入学生
     */
    public void insert(Student student) {
        String sql = "INSERT INTO student (name, age, major, class_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getMajor());
            pstmt.setInt(4, student.getClassId());   // 新增

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
        String sql = "UPDATE student SET name = ?, age = ?, major = ?, class_id = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getMajor());
            pstmt.setInt(4, student.getClassId());   // 新增
            pstmt.setInt(5, student.getId());        // 原来的第 4 个问号变成第 5 个

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("更新学生信息失败", e);
        }
    }

    /**
     * 查询所有学生
     */
    public List<Student> findAll() {
        String sql = "SELECT id, name, age, major, class_id FROM student";   // 加上 class_id
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
        String sql = "SELECT id, name, age, major, class_id FROM student WHERE id = ?";   // 加上 class_id
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
                rs.getString("major"),
                rs.getInt("class_id")   // 新增
        );
    }

    /**
     * 按专业查询
     */
    public List<Student> findByMajor(String major) {

        String sql = "SELECT id, name, age, major, class_id FROM student WHERE major = ?";
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
        String sql = "SELECT id, name, age, major, class_id FROM student WHERE name LIKE ?";
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
    public List<Student> findStudentWithClass() {
        String sql = "SELECT s.id, s.name, s.age, s.major, s.class_id, c.class_name " +
                "FROM student s LEFT JOIN class c ON s.class_id = c.id";
        List<Student> students = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("major"),
                        rs.getInt("class_id"),
                        rs.getString("class_name")
                );
                // 可以把 class_name 也存到 Student 里，或者单独处理
                students.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询学生及班级失败", e);
        }
        return students;
    }

    public Map<String,Integer> countByMajor() {
        String sql = "SELECT major, COUNT(*) AS count FROM student GROUP BY major";
        Map<String,Integer> result = new LinkedHashMap<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()){

            while (rs.next()){
                result.put(rs.getString("major"),rs.getInt("count"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("按专业统计失败",e);
        }
        return result;
    }

    public Map<String,Integer> countByClass() {

        String sql = "SELECT c.class_name, COUNT(s.id) AS count " +
                "FROM class c LEFT JOIN student s ON c.id = s.class_id " +
                "GROUP BY c.id, c.class_name";
        Map<String,Integer> result = new LinkedHashMap<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()){

            while (rs.next()) {
                result.put(rs.getString("class"),rs.getInt("count") );
            }
        } catch (SQLException e) {
            throw new RuntimeException("按班级统计失败",e);
        }
        return result;
    }
}