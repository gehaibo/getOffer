package offer;

/**
 * Created by ghb on 2017/2/20.
 */
public class Item29 {
    //题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    // 例如输入一个长度为9的数组｛1，2，3，2，2，2，5，4，2｝。
    // 由于数字2在数组中出现5次，超过数组长度的一半，因此输出2.

    static int moreThanHalfNum(int[] number){
        if (number.length ==0)
            return -1;
        int result = number[0];//记录数字出现的次数
        int times = 1;
        for (int i = 1 ; i<number.length;i++){
            if (times ==0){
                result = number[i];
                times = 1;
            }else if (number[i] == result){
                times++;
            }else{
                times--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] number = {1,2,3,4,5,2,2,2,2,2,2};
        System.out.println(moreThanHalfNum(number));
    }
}
