package 上机考试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/6/21.
 */
public class 百度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        int[] b= Arrays.copyOf(a,n);
        Arrays.sort(b);
        int count=0;
        int temp=b[0];
        int i = 0;
        for (; i < n; i++) {
            if (a[i]==temp){
                count++;
                break;
            }


            }
        for (int j = i+1; j <n ; j++) {
            if (a[j]>temp){
                count++;
                temp=a[j];
            }
        }
        if (n==count){
            System.out.println(0);
        }else if ((n-count)==1){
            if (b[n-1]==a[n-1]){
                System.out.println(2);
            }else if (b[n-1]==a[0]){
                System.out.println(1);
            }else {
                System.out.println(n-count+1);
            }
        }else{
            System.out.println(n-count+1);
        }

    }
}
