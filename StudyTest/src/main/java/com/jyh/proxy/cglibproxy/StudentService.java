package com.jyh.proxy.cglibproxy;

public class StudentService {
    private String name;

    public StudentService() {
    }

    public StudentService(String name) {
        this.name = name;
    }

    public String sing(String songName) {
        System.out.println(this.name + "正在唱：" + songName);
        return this.name + "：谢谢大家！";
    }

    public String dance() {
        System.out.println(this.name + "正在跳舞");
        return this.name + "：谢谢大家！";
    }
}
