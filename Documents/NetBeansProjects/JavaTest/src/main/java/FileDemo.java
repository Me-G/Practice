import java.io.*;

/**
 * @author ME
 * ����ĳ�ļ����µ������ļ�Ŀ¼���ļ� (�ļ��д�����������)
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {
        if (args.length <= 0) {
            System.out.println("Error:No Input Path.");
        } else {
            for (String s : args) {
                traverseFolder(s);
            }
        }
    }

    //�����ļ���
    public static void traverseFolder(String path) {
        File file = new File(path);
        //������ļ��У������ļ����е�����
        if (file.isDirectory()) {
            System.out.println("Directory " + file + " " + file.getAbsolutePath());
            String[] list = file.list();
            for (String str : list) {
                str=path+"\\"+str;
                File subFile = new File(str);
                if (subFile.isDirectory()) {  //�������ļ���
                    traverseFolder(str);
                } else {                     //���ļ�
                    System.out.println("File " + subFile + " " + subFile.getAbsolutePath());
                }
            }
        } else {   //������ļ�������ļ���Ϣ
            System.out.println("File " + file + " " + file.getAbsolutePath());
        }
    }

}
