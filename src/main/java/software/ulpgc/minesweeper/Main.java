package software.ulpgc.minesweeper;

import software.ulpgc.minesweeper.control.EasyOptionCommand;
import software.ulpgc.minesweeper.control.HardOptionCommand;
import software.ulpgc.minesweeper.control.MediumOptionCommand;
import software.ulpgc.minesweeper.view.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.add("Easy",new EasyOptionCommand(mainFrame));
        mainFrame.add("Medium",new MediumOptionCommand(mainFrame));
        mainFrame.add("Hard",new HardOptionCommand(mainFrame));
        mainFrame.setVisible(true);
    }
}
