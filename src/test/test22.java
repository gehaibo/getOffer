package test;

import java.util.*;

/**
 * Created by ghb on 2017/4/18.
 */
public class test22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String[]> input = new HashMap();
        List<String> result = new ArrayList();
        int m, k;
        while (sc.hasNext()) {
            String aa=sc.nextLine();
            String[] aaa=aa.split(" ");
            m = Integer.parseInt(aaa[0]);
            k = Integer.parseInt(aaa[1]);

            for (int i = 0; i < m; i++) {
                String[] a = sc.nextLine().split(" ");
                input.put(i, a);
            }

            for (int i = 0; i < m - 1; i++) {
                String[] a1 = input.get(i);
                String[] a2 = input.get(i + 1);
                for (int j = 0; j < a1.length; j++) {
                    if (j + 1 <= a2.length) {
                        result.add(a1[j]);
                    }
                }

            }
            String[] a3 = input.get(m - 1);
            for (int j = 0; j < a3.length; j++) {
                result.add(a3[j]);
            }
            int[] outPut=new int[result.size()];
            //result.sort();
            for (int i = 0; i < result.size(); i++) {
                outPut[i]= Integer.parseInt(result.get(i));
            }
            Arrays.sort(outPut);
            int sum=0;
            for (int i = outPut.length-1; i >outPut.length-k-1; i--) {
                sum+=outPut[i];
            }
            System.out.print(sum);
        }

    }
}
