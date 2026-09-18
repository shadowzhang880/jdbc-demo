package com.example.student.dao;

import com.example.student.model.Class;
import com.example.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClassDao {

    public void insert(Class c) {
        String sql = "INSERT INTO class (class_name) VALUES (?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,c.getClassName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("插入班级失败",e);
        }

    }public void deleteById(int id) {
        String sql = "DELETE FROM class WHERE id = ?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("删除班级失败",e);
        }
    }

    public void update(Class c) {
        String sql = "UPDATE class SET class_name = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,c.getClassName());
            pstmt.setInt(2,c.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("更新班级失败",e);
        }
    }

    public List<Class> findAll() {
        String sql = "SELECT id,class_name FROM class";
        List<Class> classes = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.getResultSet()){

            while (rs.next()) {
                classes.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询所有班级失败",e);
        }
        return classes;
    }

    public Class findById(int id) {

        String sql = "SELECT id,class_name FROM class WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1,id);
            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {return mapRow(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("查询班级失败",e);
        }
        return null;
    }

    private Class mapRow(ResultSet rs) throws SQLException{
        return new Class(
                rs.getInt("id"),
                rs.getString("class_name")
        );
    }
}
