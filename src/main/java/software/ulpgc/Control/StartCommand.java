package software.ulpgc.Control;

import software.ulpgc.MainFrame;
import software.ulpgc.Dirty.MockGamePanel;
import software.ulpgc.Model.Table;

import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StartCommand implements Command{
    private final Table table;
    private final MainFrame mainFrame;

    public StartCommand(Table table, MainFrame mainFrame) {
        this.table = table;
        this.mainFrame = mainFrame;
    }

    @Override
    public void execute() {
        mainFrame.dispose();

        JFrame gameFrame = new JFrame("MINESWEEPER");
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        gameFrame.add(new MockGamePanel(table));

        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }
}
