package atest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jackson on 2017/6/24.
 */
public class Test1 {
    public static void main(String[] args) {
//        String s="abc789ABC";
//        char[] a=s.toCharArray();
//        Arrays.sort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]+"lala");
//
//        }
//
//        int result=a[0];
//        System.out.println(a[0]-'0');
        //String s="asc   df g";
        //String[] a=s.split("  ");
        String s1 = "nihao a a , wo shi ge ge d.I love milk";
//        String s2="abc";
//        String s3=new String("abc");
//        System.out.println(s1==s2);//true
//        System.out.println(s1==s3);//false
//        s3=s1.intern();
//        System.out.println(s1==s3);//true
        String[] strings = s1.split("\\s|,|\\.");
        Set<String> sets = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            sets.add(strings[i]);
        }

        //Set<String> set = sets.stream().filter(param -> !param.equals(",") && !param.equals(".")).collect(Collectors.toSet());

        String[] strArray = new String[sets.size()];      //定义长度为6的字符串数组
        String[] result = sets.toArray(strArray);  //将集合转换为字符串数组形式

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }


    }

}
