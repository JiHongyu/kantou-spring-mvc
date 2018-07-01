package chapter4;

/**
 * Description:
 * User: jihy
 * Date: 2018-07-01
 * Time: 21:07
 */

import java.io.*;
import java.net.Socket;

import static common.Constant.DEDAULT_PORT;
import static common.Constant.LOCAL_IP;

public class Client {
    public static void main(String args[]) {
        String msg = "Client Data";
        try {
            //创建一个Socket，跟本机的8080端口连接
            Socket socket = new Socket(LOCAL_IP, DEDAULT_PORT);
            //使用Socket创建PrintWriter和BufferedReader进行读写数据
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //发送数据
            pw.println(msg);
            pw.flush();
            //接收数据
            String line = is.readLine();
            System.out.println("received from server: " + line);
            //关闭资源
            pw.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
