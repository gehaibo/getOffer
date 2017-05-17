package javaBase.java8;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ghb on 2017/4/9.
 */
public class NioTest {
    /**
     * 写入数据到Buffer
     * 调用flip()方法,将Buffer从写模式切换到读模式
     * 从Buffer中读取数据
     * 调用clear()方法或者compact()方法,clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        RandomAccessFile afile=new RandomAccessFile("/Users/ghb/Documents/nioTest.txt","rw");
        FileChannel inChannel= afile.getChannel();

        ByteBuffer buf=ByteBuffer.allocate(48);//create buffer with capacity of 48 bytes

        int bytesRead=inChannel.read(buf);//read into buffer.

        while (bytesRead!=-1){
            System.out.println("Read " + bytesRead);
            buf.flip();//make buffer ready for read

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());// read 1 byte at a time
            }

            buf.clear();//make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        afile.close();
    }
}
