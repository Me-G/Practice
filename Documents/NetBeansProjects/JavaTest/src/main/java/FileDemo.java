import java.io.*;

/**
 * @author ME
 * 遍历某文件夹下的所有文件目录及文件 (文件夹从命令行输入)
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

    //遍历文件夹
    public static void traverseFolder(String path) {
        File file = new File(path);
        //如果是文件夹，遍历文件夹中的内容
        if (file.isDirectory()) {
            System.out.println("Directory " + file + " " + file.getAbsolutePath());
            String[] list = file.list();
            for (String str : list) {
                str=path+"\\"+str;
                File subFile = new File(str);
                if (subFile.isDirectory()) {  //遍历子文件夹
                    traverseFolder(str);
                } else {                     //子文件
                    System.out.println("File " + subFile + " " + subFile.getAbsolutePath());
                }
            }
        } else {   //如果是文件，输出文件信息
            System.out.println("File " + file + " " + file.getAbsolutePath());
        }
    }

}
