package com.example.student;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final StudentService service = new StudentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("请选择操作：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 吃掉回车

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    findAllStudents();
                    break;
                case 3:
                    findStudentById();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    findByMajor();
                    break;
                case 7:
                    findByNameLike();
                    break;
                case 0:
                    System.out.println("退出系统，再见！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效选择，请重新输入。");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== 学生信息管理系统 =====");
        System.out.println("1. 添加学生");
        System.out.println("2. 查询所有学生");
        System.out.println("3. 根据 id 查询");
        System.out.println("4. 修改学生");
        System.out.println("5. 删除学生");
        System.out.println("6. 按专业查询");
        System.out.println("7. 按姓名模糊查询");
        System.out.println("0. 退出");
        System.out.println("============================");
    }

    private static void addStudent() {
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入专业：");
        String major = scanner.nextLine();

        try {
            service.addStudent(name,age,major);
            System.out.println("添加成功");

        }catch (Exception e) {
            System.out.println("添加失败"+e.getMessage());
        }
    }

    private static void findAllStudents() {
        List<Student> students = service.findAllStudents();
        if(students.isEmpty()){
            System.out.println("暂无学生数据");
        }else {
            for (Student s:students) {
                System.out.println(s);
            }
        }
    }

    private static void findStudentById() {
        System.out.println("请输入学生id：");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student s = service.findStudentById(id);
        if (s == null) {
            System.out.println("未找到id为"+id+"的学生");
        }else {
            System.out.println(s);
        }
    }

    private static void updateStudent() {
        System.out.print("请输入要修改的学生 id：");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("请输入新姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入新年龄：");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("请输入新专业：");
        String major = scanner.nextLine();

        try {
            service.updateStudent(id, name, age, major);
            System.out.println("修改成功！");
        } catch (Exception e) {
            System.out.println("修改失败：" + e.getMessage());
        }
    }

    private static void deleteStudent() {
        System.out.print("请输入要删除的学生 id：");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            service.deleteStudent(id);
            System.out.println("删除成功！");
        } catch (Exception e) {
            System.out.println("删除失败：" + e.getMessage());
        }
    }

    private static void findByMajor() {
        System.out.print("请输入专业：");
        String major = scanner.nextLine();

        List<Student> students = service.findStudentsByMajor(major);
        if (students.isEmpty()) {
            System.out.println("该专业暂无学生。");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void findByNameLike() {
        System.out.print("请输入姓名关键词：");
        String keyword = scanner.nextLine();

        List<Student> students = service.findStudentsByNameLike(keyword);
        if (students.isEmpty()) {
            System.out.println("未找到匹配的学生。");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}