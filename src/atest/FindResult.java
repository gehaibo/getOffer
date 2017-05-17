package atest;

import java.util.Arrays;

/**
 * Created by ghb on 2017/3/6.
 */

/**
 * //输入一组数据并输出
 Scanner sc = new Scanner(System.in);
 StringAbout str=sc.nextLine();
 System.out.printf("%s\n",str);

 //输入多组数据并输出
 Scanner sc = new Scanner(System.in);
 StringAbout str;
 while(sc.hasNextLine()){
 str = sc.nextLine();
 System.out.printf("%s\n",str);
 }

 */
public class FindResult {

    /*返回均分值，与要去除的第一个和第三个位置*/
    static int[] findCut(int[] A) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0, j = A.length - 1; i < j; ) {

            if (sum1 < sum2) {
                sum1 = sum1 + A[i];
                ++i;
            } else if (sum1 > sum2) {
                sum2 = sum2 + A[j];
                --j;
            } else {
                /*验证：2<=N-3-n<=2v*/
                int m = A.length - 3 - (i + 1 + A.length - j);
                if (m >= 2 && m <= 2 * sum1) {

                    int re[] = {sum1, i+1, 0, j-1};
                    return re;
                } else {
                    sum1 = sum1 + A[i];
                    ++i;
                }

            }
        }
        return null;
    }
    //返回{第一个切点，第三个，和}
    static boolean resolve2(int[] array) {
        int[] result=findCut(array);
        System.out.println("寻找完毕，开始检查: "+ Arrays.toString(result));
        result[2]=checkingFind(array,result[0],result[1],result[3]); //减1是由于有4部分，最后一部分至少占用1个位置。
        if (result[2]<0)
            return false;
        int v3=checkingFind(array,result[0],result[2]+1,result[3]+1);//检查第四部分，的分割点是否为re[3]
        if(v3==result[3]){
            return true;
        }
        return false;
    }
    static int checkingFind(int[] A ,int val,int begin,int end){
        int s=0;
        for(int i=begin;i<end;++i){
            s=s+A[i];
            if(s==val){
                //返回要去除那个点。
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        int[] A={1,1,1,1,7,1,3,1,1,2,1,5,2,2};
        Boolean res = resolve2(A);

        System.out.println(String.valueOf(res));
    }
}
