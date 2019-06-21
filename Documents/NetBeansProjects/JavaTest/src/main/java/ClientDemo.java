
import java.io.*;
import java.net.*;

/**
 * @author ME 
 * 用Java SOCKET编程，实现简单的Echo功能 如：客户端从键盘输入 hi (当用户输出exit 退出程序)，服务端响应为
 * hi(服务器要求为多线程)
 *
 * 该文件为客户端
 */
public class ClientDemo {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error:请输入主机名和端口号");
        } else {
            String host = args[0];
            int port = Integer.parseInt(args[1]);
            Socket client = null;
            PrintWriter pw = null;     //客户端输出
            BufferedReader br = null;  //客户端输入
            try {
                System.out.println("连接到服务端");
                //用户输入
                BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    client = new Socket(host, port);
                    //客户端输入、输出
                    pw = new PrintWriter(client.getOutputStream());
                    br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    //向服务端发送消息
                    String message = enter.readLine();
                    pw.println(message);
                    pw.flush();
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                    //接收服务端响应
                    System.out.println("Receive From Server:" + br.readLine());
                }

            } catch (IOException e) {
            } finally {
                try {
                    if (pw != null) {
                        pw.close();
                    }
                    if (br != null) {
                        br.close();
                    }
                    if (client != null) {
                        client.close();
                    }
                } catch (IOException e) {
                }
            }
        }
    }
}
