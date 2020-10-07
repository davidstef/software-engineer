
public class MainClass {
    public static void main(String ...args) {
        Singleton client1 = Singleton.getInstance();
        Singleton client2 = Singleton.getInstance();
        System.out.println("Are these objects equals? " + (client1 == client2));
    }
}
