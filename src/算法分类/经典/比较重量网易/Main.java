package 算法分类.经典.比较重量网易;

import java.util.LinkedList;

/**
 * 比较重量
 * 小明陪小红去看钻石，他们从一堆钻石中随机抽取两颗并比较她们的重量。这些钻石的重量各不相同。在他们们比较了一段时间后，它们看中了两颗钻石g1和g2。现在请你根据之前比较的信息判断这两颗钻石的哪颗更重。
 * 给定两颗钻石的编号g1,g2，编号从1开始，同时给定关系数组vector,其中元素为一些二元组，第一个元素为一次比较中较重的钻石的编号，第二个元素为较轻的钻石的编号。最后给定之前的比较次数n。请返回这两颗钻石的关系，若g1更重返回1，g2更重返回-1，无法判断返回0。输入数据保证合法，不会有矛盾情况出现。
 * 测试样例：
 */
public class Main {
    public int cmp(int g1, int g2, int[][] records, int n) {
        // write code here
        if(records == null||n == 0)
            return 0;
        if(levelOrder(records,g1,g2,n))
            return 1;
        else if(levelOrder(records,g2,g1,n))
            return -1;
        else
            return 0;
    }
    //判断g1下面是否有g2
    public boolean levelOrder(int[][] matrix,int g1,int g2,int n){
        LinkedList<Integer> list=new LinkedList();
        list.add(g1);
        boolean[] flag=new boolean[n];//用一个数组记录访问过的行，否则超时。
        while(list.size()!=0)
        {
            int temp=list.pollFirst();
            for(int i=0;i<n;i++)
            {
                if(flag[i] == true)
                    continue;
                if(matrix[i][0] == temp)
                {
                    flag[i]=true;
                    if(matrix[i][1] == g2)
                        return true;
                    list.add(matrix[i][1]);
                }
            }
        }
        return false;
    }
}
