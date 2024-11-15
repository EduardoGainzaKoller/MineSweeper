package software.ulpgc;

import software.ulpgc.Model.Table;

import javax.swing.*;
import java.awt.*;

public class MockGameFrame extends JFrame {

    public MockGameFrame(int size, Table table) {
        setTitle("Buscaminas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        MockGamePanel gamePanel = new MockGamePanel(size, table);
        add(gamePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}