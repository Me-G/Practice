/**
 * @author ME
 * ��дһ����ȡ�ַ����ĺ���������Ϊһ���ַ������ֽ��������Ϊ���ֽڽ�ȡ���ַ����� 
 * ����Ҫ��֤���ֲ����ذ�����硰��ABC��4��Ӧ�ý�Ϊ����AB����
 * ���롰��ABC��DEF����6��Ӧ�����Ϊ����ABC�������ǡ���ABC+���İ����
 */
public class StringDemo {
    public static void main(String[] args){
        String str="��ABC��DEF";
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
