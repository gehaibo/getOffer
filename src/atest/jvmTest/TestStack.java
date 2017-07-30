package atest.jvmTest;

import org.junit.Test;

/**
 * Created by Jackson on 2017/7/25.
 */
public class TestStack {
    private int count=0;
    public void recursion(){
        count++;
        recursion();
    }
    @Test
    public void testStack(){
        try {
            recursion();
        } catch (Exception e) {
            System.out.println("deep of stack is"+count);
            e.printStackTrace();
        }
    }


}
