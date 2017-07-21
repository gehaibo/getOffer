package javaBase.异常.异常抛出后;

/**
 * Created by Jackson on 2017/7/14.
 */
class TestFinally {
    static void proc1() {
        try {
            System.out.println("inside proc1");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("proc1's finally");
        }
    }

    static void proc2() {
        try {
            System.out.println("inside proc2");
            return;
        } finally {
            System.out.println("proc2's finally");
        }
    }

    static void proc3() {
        try {
            System.out.println("inside proc3");
        } finally {
            System.out.println("proc3's finally");
        }
    }

    public static void main(String[] args) {
        try {
            proc1();
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
        proc2();
        proc3();
    }
}