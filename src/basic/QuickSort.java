package basic;

import java.util.Arrays;

/**
 * Created by ghb on 2017/2/20.
 */
public class QuickSort {
    public static int partition(int[] data, int low, int high){
        if (data.length == 0)
            return -1;

        int key = data[low];
        while(low<high){
            while(low<high && data[high]>=key)//从右向左
                high--;
            data[low] = data[high];

            while(low<high && data[low]<=key)//从左向右
                low++;
            data[high] = data[low];
        }

        data[low] = key;//把轴元素放在轴所在地位置
        return low;//返回轴所在的位置
    }

    public static void quickSort(int[] date, int low, int high){
        if (low >= high)
            return;

        int index = partition(date ,low ,high);
        quickSort(date,low,index-1);
        quickSort(date, index+1, high);
    }

    public static void main(String[] args) {
        int[] data = {2,1,3,5,6,8,4,2};

        quickSort(data,0,data.length-1);

        System.out.println(Arrays.toString(data));
    }
}
