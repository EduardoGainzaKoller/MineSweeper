package software.ulpgc.minesweeper.architecture.control;

import software.ulpgc.minesweeper.app.MainFrame;

import javax.swing.*;

public class RestartCommand implements Command{
    private final MainFrame mainFrame;

    public RestartCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void execute() {
        JPanel panel = mainFrame.getInfoMenu();
        JComboBox<String> difficulties = (JComboBox<String>) panel.getComponent(0);
        mainFrame.getCommands().get(difficulties.getSelectedItem()).execute();
    }
}
