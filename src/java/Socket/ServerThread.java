package java.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by ghb on 2017/4/21.
 */
public class ServerThread implements Runnable{

    Socket s=null;
    BufferedReader br=null;

    public ServerThread(Socket s) throws IOException{
        this.s = s;
        //初始化该sorket对应的输入流
        br=new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {

        try {
            String content=null;
            while ((content=readFromClient())!=null){
                for (Socket s : Myserver.socketList) {
                    PrintStream ps=new PrintStream(s.getOutputStream());
                    ps.print(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromClient(){
        try {
            return br.readLine();
        } catch (IOException e) {
            //若有异常说明对应客户端已经关闭
            Myserver.socketList.remove(s);
        }
        return null;
    }
}
