package atest;

/**
 * Created by Jackson on 2017/8/30.
 */
public class test {
    public static void main(String[] args) {
        int n = 6;
        cal(n);
        cal(28);
    }

    public static void cal(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        if (sum > n) {
            System.out.println(n + "是盈数");
        } else if (sum == n) {
            System.out.println(n + "是完全数");
        } else {
            System.out.println(n + "是亏数");
        }
    }
}

