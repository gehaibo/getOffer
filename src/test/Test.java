package test;

/**
 * Created by ghb on 2017/4/5.
 */
public class Test {
    static int func()
    {
        int i,j,k=0;
        for(i=0,j=-1;j==0;i++,j++)
        {
            k++;
        }
        return k;
    }

    public int aaa() {
        int x = 1;

        try {
            return ++x;
        } catch (Exception e) {

        } finally {
            ++x;
        }
        return x;
    }

    public static void main(String[] args) {
//        int a= 0xEF;
//        System.out.println(Math.ceil(2.3));
//        System.out.println(Math.floor(2.3));
//        System.out.println(Math.round(2.3));
//        System.out.println(a);
//
//        String string="hello word";
//        string+="a";
//        int a1=string.length();
//        System.out.println(func());
//
//
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(1);
//        Iterator it= arrayList.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
//
//        Test t = new Test();
//        int y = t.aaa();
//        System.out.println("测试输出"+y);


    }

}
