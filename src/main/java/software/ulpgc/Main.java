package software.ulpgc;

import software.ulpgc.Control.StartCommand;
import software.ulpgc.Model.EasyTableInitializer;
import software.ulpgc.Model.Table;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Table table = new EasyTableInitializer().initialize();
        MainFrame mainFrame = new MainFrame();
        mainFrame.put("START", new StartCommand(table, 8, mainFrame));
        mainFrame.setVisible(true);
    }
}