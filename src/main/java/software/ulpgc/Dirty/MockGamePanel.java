package software.ulpgc.Dirty;

import software.ulpgc.Model.Cell;
import software.ulpgc.Model.Table;
import software.ulpgc.Model.TableManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MockGamePanel extends JPanel {
    private final Table table;
    private final TableManager tableManager;

    public MockGamePanel(Table table) {
        this.table = table;
        this.tableManager = new TableManager(table);
        setLayout(new GridLayout(table.getRows(), table.getRows()));


        for (int i = 0; i < table.getRows(); i++) {
            for (int j = 0; j < table.getColums(); j++) {
                JButton cellButton = new JButton();
                cellButton.setPreferredSize(new Dimension(10, 10));

                Cell cell = table.getTable().get(i).get(j);
                cellButton.addActionListener(e -> handleCellClick(cell, cellButton));

                add(cellButton);
            }
        }
    }

    private void handleCellClick(Cell cell, JButton cellButton) {
        if (tableManager.hasMine(cell)) {
            // Show game over message in English
            cellButton.setText("Mine");
            cellButton.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "You Lost! You hit a mine.", "Game Over", JOptionPane.ERROR_MESSAGE);

            // Disable all buttons
            disableAllButtons();
        } else {
            List<Cell> cellsToReveal = tableManager.revealAdjacentCells(cell);
            for (Cell adjacentCell : cellsToReveal) {
                int x = adjacentCell.getPosX();
                int y = adjacentCell.getPosY();
                JButton button = (JButton) getComponent(x * table.getColums() + y);

                int count = tableManager.countAdjacentMines(adjacentCell);

                if (count > 0) {
                    button.setText("" + count);
                } else {
                    button.setText("");
                }
                button.setEnabled(false);
            }
        }
    }

    private void disableAllButtons() {
        for (Component component : getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(false);
            }
        }
    }
}
