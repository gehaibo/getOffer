package 算法分类.常见排序.高级排序;

/**
 * Created by ghb on 2017/4/10.
 */
public class 堆排序 {



    /**
     * 2.堆排序
     * 不稳定排序
     * 全是nlog2n，空间复杂度1
     */
    public static void heapSort(int[] a) {
        int lastIndex = a.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            // 建堆
            buildMaxHeap(a, lastIndex - i);
            // 交换堆顶和最后一个元素
            swap(a, 0, lastIndex - i);
            // System.out.println(Arrays.toString(a));
        }
    }

    private static void buildMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1, 12, 4, 6};

        //heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
