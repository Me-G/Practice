/**
 * @author ME
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。 
 * 但是要保证汉字不被截半个，如“我ABC”4，应该截为“我AB”，
 * 输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”
 */
public class StringDemo {
    public static void main(String[] args){
        String str="我ABC汉DEF";
        str=interceptString(str,6);
        System.out.println(str);
    }
    
    public static String interceptString(String string,int size){
        StringBuilder result=new StringBuilder();
        int sum=0;
        String temp=null;
        int len=0;
        for(int i=0;i<string.length();i++){
            temp=String.valueOf(string.charAt(i));
            if((len=temp.getBytes().length)>0){
                sum=sum+len;
            }
            if(sum<=size)
                result.append(temp);
            else
                break;
        }
        return result.toString();
    }
    
}
