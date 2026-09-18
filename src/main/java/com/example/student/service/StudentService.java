package com.example.student.service;

import com.example.student.dao.StudentDao;
import com.example.student.model.Student;

import java.util.List;

public class StudentService {

    private final StudentDao studentDao = new StudentDao();

    /**
     * 添加学生，带业务校验
     */
    public void addStudent(String name, int age, String major,int classId) {
        if (name == null || name.trim().length() < 2) {
            throw new IllegalArgumentException("姓名不合法");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("年龄不合法");
        }
        Student student = new Student(name, age, major,classId);
        studentDao.insert(student);
    }

    /**
     * 删除学生
     */
    public void deleteStudent(int id) {
        studentDao.deleteById(id);
    }

    /**
     * 修改学生
     */
    public void updateStudent(int id, String name, int age, String major,int classId) {
        if (name == null || name.trim().length() < 2) {
            throw new IllegalArgumentException("姓名不合法");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("年龄不合法");
        }
        Student student = new Student(id, name, age, major,classId);
        studentDao.update(student);
    }

    /**
     * 查询所有
     */
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    /**
     * 根据 id 查询
     */
    public Student findStudentById(int id) {
        return studentDao.findById(id);
    }

    public List<Student> findStudentsByMajor(String major) {
        return studentDao.findByMajor(major);
    }

    public List<Student> findStudentsByNameLike(String keyword) {
        return studentDao.findByNameLike(keyword);
    }
}