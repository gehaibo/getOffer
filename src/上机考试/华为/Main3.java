package 上机考试.华为;

import java.util.Scanner;

/**
 * Created by ghb on 2017/3/23.
 */
public class Main3 {


    public static void main(String[] args) {
        //	System.out.println("请输入学生数量和操作数");
        Scanner console=new Scanner(System.in);
        while (console.hasNext()){

            String[] nm=console.nextLine().split(" ");
            int Student_count=Integer.valueOf(nm[0]);
            int Play_count=Integer.valueOf(nm[1]);

            //		System.out.println("请输入学生成绩");
            String[] Student_score=console.nextLine().split(" ");
            int score[]=new int[Student_count];
            for(int i=0;i<Student_count;i++){
                score[i]=Integer.valueOf(Student_score[i]);
            }

            //	System.out.println("请输入操作");
            String[] Play=new String[Play_count];
            for(int i=0;i<Play_count;i++){
                Play[i]=console.nextLine();
            }

            for(int i=0;i<Play_count;i++){
                String play[]=Play[i].split(" ");
                int a=Integer.valueOf(play[1]);
                int b=Integer.valueOf(play[2]);
                if (play[0].equals("U")){
                    score[a-1]=b;
                }
                if(play[0].equals("Q")){
                    int	max_score=getMaxScore(score,a-1,b-1);
                    System.out.println(max_score);
                }

            }
        }

        console.close();
    }


    private static int getMaxScore(int[] score, int i, int j) {

        int max_score=score[i];
        for(int xx=Math.min(i, j);xx<=Math.max(i, j);xx++){
            max_score=Math.max(max_score, score[xx]);
        }
        return max_score;
    }
}
