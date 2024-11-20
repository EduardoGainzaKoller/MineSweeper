package software.ulpgc.minesweeper.app;

import software.ulpgc.minesweeper.architecture.control.Command;
import software.ulpgc.minesweeper.architecture.view.TableDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private final Map<String, Command> commands;
    private final SwingTableDisplay tableDisplay;
    private final JPanel infoMenu;

    public MainFrame() {
        this.setTitle("MineSweeper");
        this.setSize(new Dimension(750, 750));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(infoMenu = infoMenu(), BorderLayout.NORTH);
        this.add(tableDisplay = (SwingTableDisplay) tableDisplay(),BorderLayout.CENTER);
        commands = new HashMap<>();
    }

    public void add(String key, Command value){
        commands.put(key,value);
    }

    private JPanel tableDisplay(){
        SwingTableDisplay display = new SwingTableDisplay();
        return display;
    }

    public SwingTableDisplay getTableDisplay(){
        return tableDisplay;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public JPanel getInfoMenu() {
        return infoMenu;
    }

    private JPanel infoMenu() {
        JPanel infoMenu = new JPanel(new FlowLayout());
        infoMenu.add(difficultyComboBox());
        infoMenu.add(restartButton());
        return infoMenu;
    }

    private JComboBox<String> difficultyComboBox() {
        String[] difficulties = {"Easy", "Medium", "Hard"};
        JComboBox<String> difficultyComboBox = new JComboBox<>(difficulties);
        difficultyComboBox.setSelectedItem("Medium");
        difficultyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get((String) difficultyComboBox.getSelectedItem()).execute();
            }
        });
        return difficultyComboBox;
    }

    private JButton restartButton() {
        JButton restart = new JButton("RESTART");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("RESTART").execute();
            }
        });
        return restart;
    }
}
