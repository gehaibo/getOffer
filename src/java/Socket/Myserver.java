package java.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ghb on 2017/4/21.
 */
public class Myserver {
    //保存所有socket的list
    public static List<Socket> socketList= Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException{
        ServerSocket ss=new ServerSocket(30000);
        while (true){
            Socket s=ss.accept();
            socketList.add(s);
            new Thread(new ServerThread(s)).start();
        }
    }
}
