package software.ulpgc.Control;

import software.ulpgc.MainFrame;
import software.ulpgc.MockGamePanel;
import software.ulpgc.Model.Interfaces.TableInitializer;
import software.ulpgc.Model.Table;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StartCommand implements Command{
    private final Table table;
    private final int size;
    private final MainFrame mainFrame;

    public StartCommand(Table table, int size, MainFrame mainFrame) {
        this.table = table;
        this.size = size;
        this.mainFrame = mainFrame;
    }

    @Override
    public void execute() {
        mainFrame.dispose();

        JFrame gameFrame = new JFrame("MINESWEEPER");
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        gameFrame.add(new MockGamePanel(size, table));

        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }
}
