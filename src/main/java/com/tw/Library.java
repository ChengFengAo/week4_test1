package com.tw;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Library {
   // private  Test_Class add=new Test_Class();
    public boolean someLibraryMethod() {
        return true;
    }

    private List<StudentInfo> members = new ArrayList<>();//保存学生信息

    public void mainPrint() {   //主界面输出
        System.out.println("1.添加学生");
        System.out.println("2.生成成绩单");
        System.out.println("3.退出");
        System.out.println("请输入你的选择（1～3）：");
    }

    public int getGrade(String str) {   //获得字符串中的学生成绩
        int result=-1;
        String[] tmp;
        if(str.contains(":")){
        tmp = str.split(":");
       result =Integer.parseInt(tmp[1]);}
       return result;
    }

    public Boolean addStudent(String tmp) {          //添加学生信息
        Boolean result;
        //String regx = "[\\u4e00-\\u9fa5]+,[0-9]+(,[\\u4e00-\\u9fa5]+:[1-9][0-9]){4}"; //正则
        String regx = "[\\u4e00-\\u9fa5]+,[0-9]+,数学:[1-9][0-9],语文:[1-9][0-9],英语:[1-9][0-9],编程:[1-9][0-9]"; //正则
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(tmp);
        if (m.matches()) {           //输入匹配则提取信息，创建学生类，保存数据
            String name;
            int id = 0, math, chinese, english, coding;
            String[] pname = tmp.split(",");
            name = pname[0];
            id = Integer.parseInt(pname[1]);
            math = getGrade(pname[2]);
            chinese = getGrade(pname[3]);
            english = getGrade(pname[4]);
            coding = getGrade(pname[5]);
            StudentInfo addStudent = new StudentInfo(name, id, math, chinese, english, coding);
            members.add(addStudent);      //保存学生信息
            result=true;
            System.out.println("学生" + pname[0] + "的成绩被添加");

        } else {
            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
            result=false;
         //   add.addStudents();
        }
        return result;
    }

    public Boolean printGrade(String id) {          //打印学生成绩
        Boolean result=false;
        String rgx = "[0-9]+(,([0-9]+))?";
        Pattern p = Pattern.compile(rgx);
        Matcher m = p.matcher(id);
        if (m.matches()) {
            int all_sum = 0, count = 1, sum;
            List<Integer> middle = new ArrayList<>();
            String[] tmpv;
            tmpv = id.split(",");
            System.out.println("成绩单\n" + "姓名|数学|语文|英语|编程|平均分|总分");
            System.out.println("========================");
            for (int i = 0; i < tmpv.length; i++) {                                     //过滤学生成绩
                for (int j = 0; j < members.size(); j++) {
                    if (Integer.parseInt(tmpv[i]) == members.get(j).getId()) {
                        count += 1;
                        sum = members.get(j).getMath() + members.get(j).getChinese() + members.get(j).getEnglish() + members.get(j).getCoding();
                        middle.add(sum);
                        all_sum += sum;
                        System.out.println(members.get(j).getName() + "|" + members.get(j).getMath() + "|" + members.get(j).getChinese() + "|" + members.get(j).getEnglish() + "|" + members.get(j).getCoding() + "|" + sum / 4 + "|" + sum);
                    }
                }

            }
            System.out.println("========================");
            if(middle.size()!=0){
                System.out.println("全班总分平均数：" + all_sum / count);
                System.out.println("全班总分中位数：" + calculate(middle));

            }
            result =true;
        } else {
            System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
            result=false;
        }
        return  result;
    }

    public int calculate(List<Integer> sum) {   //计算中位数
        int result=0;
        if(sum.size()%2==0)
        {
            int tmp;
           tmp= sum.stream().sorted(Comparator.naturalOrder())
                    .skip(sum.size()/2-1)
                    .limit(2)
                    .reduce(Integer::sum).get();
           result=tmp/2;
        }
        else {
            if (sum.size()>1){
            result=sum.stream()
                    .sorted(Comparator.naturalOrder())
                    .skip(sum.size()/2+1)
                    .limit(1)
                    .findFirst()
                    .get();
        }
        else
            {
                result=sum.get(0);
            }
        }
        return result;
    }
}




