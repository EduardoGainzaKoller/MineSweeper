package software.ulpgc.minesweeper.architecture.control;

import software.ulpgc.minesweeper.app.MainFrame;
import software.ulpgc.minesweeper.architecture.io.MediumTableBuilder;
import software.ulpgc.minesweeper.architecture.io.interfaces.TableBuilder;
import software.ulpgc.minesweeper.architecture.model.Cell;
import software.ulpgc.minesweeper.architecture.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MediumOptionCommand implements Command {

    private final MainFrame mainFrame;
    private final TableBuilder tableBuilder;
    private TableManager tableManager;
    private boolean isFirstClick;
    private Table table;

    public MediumOptionCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.tableBuilder = new MediumTableBuilder();
    }

    @Override
    public void execute() {
        isFirstClick = true;
        mainFrame.setSize(new Dimension(750, 750));
        mainFrame.setLocationRelativeTo(null);
        table = tableBuilder.buildTable();
        mainFrame.getTableDisplay().display(table);
        addActionListeners(mainFrame.getTableDisplay().getButtons());
        mainFrame.getTableDisplay().revalidate();
        mainFrame.getTableDisplay().repaint();
        mainFrame.revalidate();
    }

    private void addActionListeners(List<List<JButton>> buttons) {
        for (int i = 0; i < buttons.size(); i++) {
            for (int j = 0; j < buttons.get(0).size(); j++) {
                final int row = i;
                final int col = j;
                JButton button = buttons.get(i).get(j);

                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Cell cell = table.getTableContent().get(row).get(col);
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (isFirstClick) {
                                table = tableBuilder.buildWithMines(cell);
                                tableManager = new TableManager(table);
                                handleCellClick(cell,button);
                                isFirstClick = false;
                            }
                            handleCellClick(cell, button);
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (button.getIcon() == null) {
                                button.setIcon(new ImageIcon("src/main/resources/RedFlag.jpg"));
                            } else {
                                button.setIcon(null);
                            }
                        }
                    }
                });
            }
        }
    }

    private void handleCellClick(Cell cell, JButton button) {
        if (cell.isMine()) {
            button.setText("Mine");
            button.setBackground(Color.RED);
            JOptionPane.showMessageDialog(mainFrame.getTableDisplay(), "You Lost! You hit a mine.", "Game Over", JOptionPane.ERROR_MESSAGE);
            mainFrame.getTableDisplay().disableAllButtons();
        } else {
            List<Cell> cellsToReveal = tableManager.revealAdjacentCells(cell);
            for (Cell adjacentCell : cellsToReveal) {

                JButton nextButton = mainFrame.getTableDisplay().getButtons().get(adjacentCell.row()).get(adjacentCell.column());

                int count = tableManager.countAdjacentMines(adjacentCell);
                if (count > 0) {
                    nextButton.setText("" + count);
                } else {
                    nextButton.setText("");
                }
                removeMouseListener(nextButton);
            }
        }
    }

    private static void removeMouseListener(JButton nextButton) {
        MouseListener[] mouseListeners = nextButton.getMouseListeners();
        for (MouseListener mouseListener : mouseListeners) {
            nextButton.removeMouseListener(mouseListener);
        }
        nextButton.setEnabled(false);
    }
}
