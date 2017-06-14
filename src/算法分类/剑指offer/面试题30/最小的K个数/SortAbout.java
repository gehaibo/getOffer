package 算法分类.剑指offer.面试题30.最小的K个数;

/**
 * 排序相关
 */
public class SortAbout {
    /**
     * offer-30:快排
     * @param data
     * @param low
     * @param hight
     */
    private static void quickSort(int data[], int low, int hight)
    {
        int i=low,j=hight;
        int mid=data[(low+hight)/2];
        while(i <= j)
        {
            while(data[i]<mid) i++;
            while(data[j]>mid) j--;
            if(i<=j)
            {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        if(i<hight) quickSort(data, i, hight);
        if(j>low) quickSort(data, low, j);
    }


    public static void main(String[] args)
    {

        /**
         * offer-30:快排
         */
        int[] data = new int[]{4, 5, 2, 6, 1, 0, 8};
        quickSort(data, 0, data.length-1);
        for(int n : data)
        {
            System.out.print(n+" ");
        }
    }
}
