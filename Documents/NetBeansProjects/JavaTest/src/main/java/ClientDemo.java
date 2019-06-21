
import java.io.*;
import java.net.*;

/**
 * @author ME 
 * ��Java SOCKET��̣�ʵ�ּ򵥵�Echo���� �磺�ͻ��˴Ӽ������� hi (���û����exit �˳�����)���������ӦΪ
 * hi(������Ҫ��Ϊ���߳�)
 *
 * ���ļ�Ϊ�ͻ���
 */
public class ClientDemo {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error:�������������Ͷ˿ں�");
        } else {
            String host = args[0];
            int port = Integer.parseInt(args[1]);
            Socket client = null;
            PrintWriter pw = null;     //�ͻ������
            BufferedReader br = null;  //�ͻ�������
            try {
                System.out.println("���ӵ������");
                //�û�����
                BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    client = new Socket(host, port);
                    //�ͻ������롢���
                    pw = new PrintWriter(client.getOutputStream());
                    br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    //�����˷�����Ϣ
                    String message = enter.readLine();
                    pw.println(message);
                    pw.flush();
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                    //���շ������Ӧ
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
