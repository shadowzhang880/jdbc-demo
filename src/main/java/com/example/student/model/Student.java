package com.example.student.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String major;
    private int classId;
    private String className;

    public Student() {
    }
    public Student(String name, int age, String major, int classId) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.classId = classId;
    }

    // 查询用（有 id）
    public Student(int id, String name, int age, String major, int classId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        this.classId = classId;
    }

    public Student(int id, String name, int age, String major, int classId, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        this.classId = classId;
        this.className = className;
    }

    public int getId() { return id;}
    public void setId(int id) { this.id = id;}

    public  String getName() { return name;}
    public  void setName() { this.name = name;}

    public int getAge() { return age;}
    public void setAge(int age) {this.age = age;}

    public  String getMajor() {return major;}
    public  void setMajor(String major) {this.major = major;}

    public int getClassId() { return classId; }
    public void setClassId(int classId) { this.classId = classId; }

    public String getClassName() {return className;}
    public void setClassName(String className) {this.className = className;}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}