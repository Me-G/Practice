
import java.io.*;
import java.net.*;

/**
 * @author ME 
 * 用Java SOCKET编程，实现简单的Echo功能 如：客户端从键盘输入 hi (当用户输出exit 退出程序)，服务端响应为
 * hi(服务器要求为多线程)
 *
 * 该文件为服务端
 */
public class ServerDemo extends Thread {

    private ServerSocket serverSocket;
    int port;

    public ServerDemo(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        System.out.println("等待客户端连接");
        Socket server = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        while (true) {
            try {
                server = serverSocket.accept();
                //服务端输入
                br = new BufferedReader(new InputStreamReader(server.getInputStream()));
                String message = br.readLine();
                System.out.println("Receive From Client:" + message);
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                //服务端输出
                pw = new PrintWriter(server.getOutputStream());
                pw.println(message);
                pw.flush();
                
            } catch (IOException e) {
            } finally {
                try {
                    if (pw != null) {
                        pw.close();
                    }
                    if (br != null) {
                        br.close();
                    }
                    if (server != null) {
                        server.close();
                    }
                } catch (IOException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error:请输入端口号");
        } else {
            int port = Integer.parseInt(args[0]);
            try {
                Thread th = new ServerDemo(port);
                th.start();
            } catch (IOException e) {
            }

        }

    }

}
