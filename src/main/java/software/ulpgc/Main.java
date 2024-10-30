package software.ulpgc;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Table table = new EasyTableInitializer().initialize();
        SwingUtilities.invokeLater(() -> new MockGameFrame(8, table));
    }
}