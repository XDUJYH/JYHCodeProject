package com.jyh.studyTest;

public class Student extends Teacher{
    public int age;
    public String name;


    public static final String s1 = "abc";
    public static final String s2 = "abc";
    public static final String abc = "abc";
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
//        Student s1 = new Student(22,"jyh");
//        System.out.println("age:" + s1.getAge());
//        System.out.println("name:" + s1.getName());

        int i = 0, j = 0;
        int k = 0;
        i ++;
        j = j + 1;
        k += 1;

    }
}
