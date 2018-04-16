package com.tw;

public class StudentInfo {

    private String name;
    private int id, chinese, math, english, coding;

    public StudentInfo(String name,int id, int math, int chinese, int english, int coding) {
        this.name = name;
        this.id=id;
        this.math=math;
        this.chinese = chinese;
        this.english = english;
        this.coding = coding;
    }

    public int getId() {
        return id;
    }

    public int getMath() {
        return math;
    }

    public int getChinese() {
        return chinese;
    }

    public int getEnglish() {
        return english;
    }

    public int getCoding() {
        return coding;
    }

    public String getName() {
        return name;
    }
}
