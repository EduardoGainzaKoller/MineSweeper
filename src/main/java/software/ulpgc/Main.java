package software.ulpgc;

public class Main {
    public static void main(String[] args) {
        Table table = new EasyTableInitializer().initialize();
        System.out.println(table.toString());
    }
}
