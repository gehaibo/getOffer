package test;

/**
 * Created by ghb on 2017/3/6.
 */
public class Find {

    static boolean find(int[] A) {

        int[] result=findCut(A);

        result[2]=checkSum(A,result[0],result[1]+1,result[3]-1);

        int sum3=checkSum(A,result[0],result[2]+1,result[3]);

        if(sum3==result[3]){
            return true;
        }
        return false;
    }

    static int[] findCut(int[] array) {
        int sum1 = 0, sum2 = 0;
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (sum1 < sum2) {
                sum1 += array[i];
                ++i;
            } else if (sum1 > sum2) {
                sum2 += array[j];
                --j;
            } else {
                int m = j - i - 5;
                if (m >= 0 && m <= array.length-1) {
                    int result[] = {sum1, i, 0, j};
                    return result;
                }
            }
        }
        return null;
    }
    static int checkSum(int[] array ,int s,int low,int high){
        int sum=0;
        for(int i=low;i<high;++i){
            sum +=array[i];
            if(sum == s){
                //返回要去除那个点。
                return i+1;
            }
        }
        return -1;
    }


    public static void main(String[] args){

        int[] A={1,1,1,1,7,1,3,1,1,2,1,5,2,2};
        Boolean res = find(A);

        System.out.println(String.valueOf(res));
    }
}
