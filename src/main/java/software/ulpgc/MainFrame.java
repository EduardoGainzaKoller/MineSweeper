package software.ulpgc;

import software.ulpgc.Control.Command;

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
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(menu());
        commands = new HashMap<>();
    }

    private JPanel menu() {
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        menu.add(Box.createVerticalGlue());
        menu.add(startButton(), BorderLayout.CENTER);
        menu.add(Box.createRigidArea(new Dimension(0, 20)));
        menu.add(difficultyComboBox(), BorderLayout.CENTER);
        menu.add(Box.createVerticalGlue());
        return menu;
    }

    private JComboBox<String> difficultyComboBox() {
        String[] difficulties = {"Easy", "Medium", "Hard"};
        JComboBox<String> difficultyComboBox = new JComboBox<>(difficulties);

        difficultyComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        difficultyComboBox.setMaximumSize(new Dimension(120, 40));
        difficultyComboBox.setMinimumSize(new Dimension(120, 40));

        difficultyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDifficulty = (String) difficultyComboBox.getSelectedItem();
                if (commands.containsKey("DIFFICULTY")) {
                    commands.get("DIFFICULTY").execute();
                }
            }
        });

        return difficultyComboBox;
    }

    private JButton startButton() {
        JButton start = new JButton("START");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("START").execute();
            }
        });

        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        return start;
    }

    public Command put(String key, Command value) {
        return commands.put(key, value);
    }
}
