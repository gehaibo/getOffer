package leetCode;

/**
 * Created by Jackson on 2017/5/6.
 */
public class Candy {
    public static int candy(int[] ratings) {
        if (ratings.length==0) return -1;
        if (ratings.length==1) return 1;
        int count=0;
        int[] temp=new int[ratings.length];
        temp[0]=1;
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i]>ratings[i-1]) temp[i]=temp[i-1]+1;
            else temp[i]=1;
        }
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i]>ratings[i+1]&&temp[i]<=temp[i+1]) temp[i]=temp[i+1]+1;
        }
        for (int i = 0; i < temp.length; i++) {
            count+=temp[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a={1,3,5};
        System.out.println(candy(a));
    }
}
