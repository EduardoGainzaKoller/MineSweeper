package software.ulpgc;

public class TableManager {
    private final Table table;

    public TableManager(Table table) {
        this.table = table;
    }

    public boolean hasMine(Cell cell) {
        for (Cell mine : table.getMines()) {
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

    private boolean isWithinBounds(int row, int col) {
        return row >= 0 && row < table.getTable().size() && col >= 0 && col < table.getTable().get(0).size();
    }
}
