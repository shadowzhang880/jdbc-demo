package com.example.student.model;

public class Class {
    private int id;
    private String className;
    public Class() {
    }

    public Class(String className) {
        this.className = className;
    }

    public Class(int id,String classname) {
        this.id = id;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", className='" + className + '\'' +
                '}';
    }
}
