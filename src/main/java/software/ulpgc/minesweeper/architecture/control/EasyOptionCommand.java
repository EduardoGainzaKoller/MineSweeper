package software.ulpgc.minesweeper.architecture.control;

import software.ulpgc.minesweeper.app.MainFrame;
import software.ulpgc.minesweeper.architecture.io.EasyTableBuilder;
import software.ulpgc.minesweeper.architecture.io.interfaces.TableBuilder;
import software.ulpgc.minesweeper.architecture.model.Cell;
import software.ulpgc.minesweeper.architecture.model.Table;
import software.ulpgc.minesweeper.architecture.model.TableManager;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class EasyOptionCommand implements Command {

    private final MainFrame mainFrame;
    private final TableBuilder tableBuilder;
    private TableManager tableManager;
    private boolean isFirstClick;
    private Table table;

    public EasyOptionCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.tableBuilder = new EasyTableBuilder();
    }

    @Override
    public void execute() {
        isFirstClick = true;
        mainFrame.setSize(new Dimension(450, 450));
        mainFrame.setLocationRelativeTo(null);
        table = tableBuilder.buildTable();
        mainFrame.getTableDisplay().display(table);
        addActionListeners(mainFrame.getTableDisplay().getButtons());
        mainFrame.getTableDisplay().revalidate();
        mainFrame.getTableDisplay().repaint();
        mainFrame.revalidate();
    }

    private static boolean setImage = true;
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
                            if (setImage) {
                                button.setIcon(new ImageIcon("src/main/resources/RedFlag.jpg"));
                            } else {
                                button.setIcon(null);
                            }
                            setImage = !setImage;
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
                nextButton.setEnabled(false);
            }
        }
    }
}
