package offer;

/**
 * Created by ghb on 2017/2/20.
 */
public class Item30 {

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
        int[] data = new int[]{4, 5, 2, 6, 1, 0, 8};
        quickSort(data, 0, data.length-1);
        for(int n : data)
        {
            System.out.print(n+" ");
        }
    }
}
