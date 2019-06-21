
import java.io.*;
import java.net.*;

/**
 * @author ME 
 * ��Java SOCKET��̣�ʵ�ּ򵥵�Echo���� �磺�ͻ��˴Ӽ������� hi (���û����exit �˳�����)���������ӦΪ
 * hi(������Ҫ��Ϊ���߳�)
 *
 * ���ļ�Ϊ�����
 */
public class ServerDemo extends Thread {

    private ServerSocket serverSocket;
    int port;

    public ServerDemo(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        System.out.println("�ȴ��ͻ�������");
        Socket server = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        while (true) {
            try {
                server = serverSocket.accept();
                //���������
                br = new BufferedReader(new InputStreamReader(server.getInputStream()));
                String message = br.readLine();
                System.out.println("Receive From Client:" + message);
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                //��������
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
            System.out.println("Error:������˿ں�");
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
