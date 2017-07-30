package java基础.异常.异常抛出后;

/**
 * Created by Jackson on 2017/7/14.
 */
public class TestThrow {
    static int proc(){
        try{
            throw new NullPointerException("demo");
        }catch(NullPointerException e){
            System.out.println("Caught inside proc");
            throw e;

        }
    }

    public static void main(String [] args){
        try{
            proc();
        }catch(NullPointerException e){
            System.out.println("Recaught: "+e);
        }
    }
}
