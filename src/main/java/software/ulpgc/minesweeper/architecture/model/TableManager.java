package software.ulpgc.minesweeper.architecture.model;

import java.util.ArrayList;
import java.util.List;

public class TableManager {
    private final Table table;

    public TableManager(Table table) {
        this.table = table;
    }

    public boolean hasMine(Cell cell) {
        return cell.isMine();
    }

    public int countAdjacentMines(Cell cell) {
        int row = cell.row();
        int col = cell.column();
        int mineCount = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) continue;

                int adjRow = row + i;
                int adjCol = col + j;

                if (isWithinBounds(adjRow, adjCol)) {
                    Cell adjacentCell = table.getTableContent().get(adjRow).get(adjCol);
                    if (hasMine(adjacentCell)) {
                        mineCount++;
                    }
                }
            }
        }
        return mineCount;
    }

    public List<Cell> revealAdjacentCells(Cell cell) {
        List<Cell> cellsToReveal = new ArrayList<>();
        revealAdjacentCellsRecursive(cell, cellsToReveal, new ArrayList<>());
        return cellsToReveal;
    }

    private void revealAdjacentCellsRecursive(Cell cell, List<Cell> cellsToReveal, ArrayList<Cell> revealed) {
        if(hasMine(cell) || revealed.contains(cell) || ! isWithinBounds(cell.row(), cell.column())) {
            return;
        }

        revealed.add(cell);
        cellsToReveal.add(cell);

        if(countAdjacentMines(cell) > 0) {
            return;
        }

        int row = cell.row();
        int col = cell.column();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) continue;

                int adjRow = row + i;
                int adjCol = col + j;

                if (isWithinBounds(adjRow, adjCol)) {
                    Cell adjacentCell = table.getTableContent().get(adjRow).get(adjCol);
                    revealAdjacentCellsRecursive(adjacentCell, cellsToReveal, revealed);
                }
            }
        }

    }

    private boolean isWithinBounds(int row, int col) {
        return row >= 0 && row < table.getTableContent().size() && col >= 0 && col < table.getTableContent().get(0).size();
    }
}