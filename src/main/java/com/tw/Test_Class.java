package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_Class {
    Library l = new Library();
    public void logical ()
    {
        int c = -1;
        l.mainPrint();
        Scanner ms = new Scanner(System.in);
        do {
            if (ms.hasNextInt()) {
                c = ms.nextInt();
            }
            switch ((char) c) {
                case 1: {
                    System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
                    Scanner addStudentIdWrong = new Scanner(System.in);
                    while (l.addStudent(addStudentIdWrong.nextLine()).equals(false))
                    {
                        addStudentIdWrong = new Scanner(System.in);
                        l.addStudent(addStudentIdWrong.nextLine());
                    }
                    this.logical();

                }
                case 2: {
                    System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                    Scanner getStudentIdWrong = new Scanner(System.in);
                    while (l.printGrade(getStudentIdWrong.nextLine()).equals(false))
                    {
                        getStudentIdWrong = new Scanner(System.in);
                        l.getGrade(getStudentIdWrong.nextLine());
                    }
                    this.logical();
                }
            }
        }
        while (c != 3);
    }



    public static void main(String[] args) {
     Test_Class mains=new Test_Class();
     mains.logical();

    }

}
