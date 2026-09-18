package com.example.student.service;

import com.example.student.dao.ClassDao;
import com.example.student.model.Class;

import java.util.List;


public class ClassService {
    private final ClassDao classDao = new ClassDao();

    public void addClass(String className) {
        if(className == null|| className.trim().isEmpty()){
            throw new IllegalArgumentException("班级名称不能为空");
        }
        classDao.insert(new Class(className));

    }

    public void deleteClass(int id)  {
        classDao.deleteById(id);
    }

    public void update (int id,String className) {
        if(className  == null||className.trim().isEmpty()) {
            throw new IllegalArgumentException("班级名称不能为空");
        }
        classDao.update(new Class(id,className));
    }

    public List<Class> findAllClasses() {
        return classDao.findAll();
    }

    public Class findClassById(int id) {
        return classDao.findById(id);
    }
}
