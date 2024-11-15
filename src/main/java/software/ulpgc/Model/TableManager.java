package software.ulpgc.Model;

import java.util.ArrayList;
import java.util.List;

public class TableManager {
    private final Table table;

    public TableManager(Table table) {
        this.table = table;
    }

    public boolean hasMine(Cell cell) {
        for (Cell mine : table.getMinesCoordinates()) {
            if(mine.equals(cell)) {
                return true;
            }
        }
        return false;
    }

    public int countAdjacentMines(Cell cell) {
        int row = cell.getPosX();
        int col = cell.getPosY();
        int mineCount = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) continue;

                int adjRow = row + i;
                int adjCol = col + j;

                if (isWithinBounds(adjRow, adjCol)) {
                    Cell adjacentCell = table.getTable().get(adjRow).get(adjCol);
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
        if(hasMine(cell) || revealed.contains(cell) || ! isWithinBounds(cell.getPosX(), cell.getPosY())) {
            return;
        }

        revealed.add(cell);
        cellsToReveal.add(cell);

        if(countAdjacentMines(cell) > 0) {
            return;
        }

        int row = cell.getPosX();
        int col = cell.getPosY();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) continue;

                int adjRow = row + i;
                int adjCol = col + j;

                if (isWithinBounds(adjRow, adjCol)) {
                    Cell adjacentCell = table.get(adjRow).get(adjCol);
                    revealAdjacentCellsRecursive(adjacentCell, cellsToReveal, revealed);
                }
            }
        }

    }

    private boolean isWithinBounds(int row, int col) {
        return row >= 0 && row < table.getTable().size() && col >= 0 && col < table.getTable().get(0).size();
    }
}
