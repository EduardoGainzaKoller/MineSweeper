package software.ulpgc;

import software.ulpgc.Control.EasyCommand;
import software.ulpgc.Control.HardCommand;
import software.ulpgc.Control.MediumCommand;
import software.ulpgc.Control.StartCommand;
import software.ulpgc.Model.EasyTableInitializer;
import software.ulpgc.Model.Table;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Table table = new EasyTableInitializer().initialize();
        MainFrame mainFrame = new MainFrame();
        mainFrame.put("START", new StartCommand(table, mainFrame));
        mainFrame.put("Easy", new EasyCommand(mainFrame));
        mainFrame.put("Medium", new MediumCommand(mainFrame));
        mainFrame.put("Hard", new HardCommand(mainFrame));
        mainFrame.setVisible(true);
    }
}