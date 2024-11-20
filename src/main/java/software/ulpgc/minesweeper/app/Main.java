package software.ulpgc.minesweeper.app;

import software.ulpgc.minesweeper.architecture.control.EasyOptionCommand;
import software.ulpgc.minesweeper.architecture.control.HardOptionCommand;
import software.ulpgc.minesweeper.architecture.control.MediumOptionCommand;
import software.ulpgc.minesweeper.architecture.control.RestartCommand;
import software.ulpgc.minesweeper.architecture.io.MediumTableBuilder;
import software.ulpgc.minesweeper.architecture.model.Table;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.add("Easy",new EasyOptionCommand(mainFrame));
        mainFrame.add("Medium",new MediumOptionCommand(mainFrame));
        mainFrame.add("Hard",new HardOptionCommand(mainFrame));
        mainFrame.add("RESTART",new RestartCommand(mainFrame));
        new MediumOptionCommand(mainFrame).execute();
        mainFrame.setVisible(true);
    }
}
