package software.ulpgc.minesweeper.view;

import software.ulpgc.minesweeper.control.Command;
import software.ulpgc.minesweeper.model.MediumTableBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private final Map<String, Command> commands;

    public MainFrame() {
        this.setTitle("MineSweeper");
        this.setSize(new Dimension(650, 650));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(infoMenu(), BorderLayout.NORTH);
        commands = new HashMap<>();
    }

    public void add(String key, Command value){
        commands.put(key,value);
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
        return restart;
    }
}
