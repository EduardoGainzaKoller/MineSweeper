package software.ulpgc.minesweeper.app;

import software.ulpgc.minesweeper.architecture.model.Table;
import software.ulpgc.minesweeper.architecture.view.TableDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingTableDisplay extends JPanel implements TableDisplay {
    private final List<List<JButton>> buttons;

    public SwingTableDisplay() {
        buttons = new ArrayList<>();
    }

    @Override
    public void display(Table table) {
        removeAll();
        buttons.clear();
        setLayout(new GridLayout(table.getRows(), table.getColums()));

        for (int i = 0; i < table.getRows(); i++) {
            List<JButton> rowButtons = new ArrayList<>();
            for (int j = 0; j < table.getColums(); j++) {
                JButton cellButton = new JButton();
                cellButton.setPreferredSize(new Dimension(10, 10));
                rowButtons.add(cellButton);
                add(cellButton);
            }
            buttons.add(rowButtons);
        }
        revalidate();
        repaint();
    }

    public List<List<JButton>> getButtons() {
        return buttons;
    }

    public void disableAllButtons() {
        for (Component component : getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(false);
            }
        }
    }
}
