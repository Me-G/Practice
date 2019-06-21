/**
 * @author ME
 * 满足Singleton模式的类
 */
public class SingletonDemo {

    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
        singleton.getMessage();
    }
    
}
class Singleton{
    private Singleton(){}
    private static Singleton instance=new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
    public void getMessage(){
        System.out.println("A SingletonDemo");
    }
}
