package java基础.Io流;

import java.io.*;

/**
 * Created by Jackson on 2017/7/9.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //
        // File file = new File("/Users/ghb/Desktop/a2Test.txt");
        //File file=File.
//        OutputStream out = new FileOutputStream("/Users/ghb/Desktop/a2Test.txt", true);
//        //String str="Hello World!";
//        String str = "add one word~";
//        byte[] bytes = str.getBytes();
//        out.write(bytes);
//        out.close();

//        InputStream in = new FileInputStream("/Users/ghb/Desktop/a2Test.txt");
//        byte[] bytes1 = new byte[1024];
//
//        int hasRead;
//        int length = 0;
//        while ((hasRead = in.read()) != -1) {
//            bytes1[length] = (byte) hasRead;
//            length++;
//        }
//        in.close();
//        System.out.println(new String(bytes1, 0, length));
        insert("",12,"我试插入的内容~ ");

    }

    public static void insert(String file, long pos, String insertContent) throws IOException {
        File tmp = File.createTempFile("temp", null);
        tmp.deleteOnExit();

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        //使用临时文件来保存插入后的数据
        FileOutputStream tmpOut = new FileOutputStream(tmp);
        FileInputStream tmpIn = new FileInputStream(tmp);

        //找到插入的地方
        raf.seek(pos);

        //存储插入后的节点内容
        byte[] bbuf = new byte[64];

        int hasRead = 0;

        while ((hasRead = raf.read(bbuf)) > 0) {
            tmpOut.write(bbuf, 0, hasRead);
        }

        //重新定位指针
        raf.seek(pos);

        raf.write(insertContent.getBytes());

        while ((hasRead = tmpIn.read(bbuf)) > 0) {
            raf.write(bbuf, 0, hasRead);
        }


    }
}
