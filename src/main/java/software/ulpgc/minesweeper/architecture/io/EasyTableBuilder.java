package software.ulpgc.minesweeper.architecture.io;

import software.ulpgc.minesweeper.architecture.model.Cell;
import software.ulpgc.minesweeper.architecture.model.Table;
import software.ulpgc.minesweeper.architecture.io.interfaces.TableBuilder;

import java.util.*;

public class EasyTableBuilder implements TableBuilder {

    private static final int SIZE = 8;
    private static final int MINES_AMOUNT = 10;

    public EasyTableBuilder() {
    }

    @Override
    public Table buildTable() {
        return new Table(initializeContentTable());
    }

    @Override
    public Table buildWithMines(Cell cell) {
        List<List<Cell>> table = initializeContentTable();
        return new Table(initializeContentTableWithMines(table, cell));
    }


    private List<List<Cell>> initializeContentTable(){
        List<List<Cell>> contentTable = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            contentTable.add(createRow(i));
        }
        return contentTable;
    }

    private List<List<Cell>> initializeContentTableWithMines(List<List<Cell>> contentTable, Cell cell) {
        Random random = new Random();
        Set<Cell> usedPositions = new HashSet<>();
        int minesPlaced = 0;

        Set<Cell> protectedCells = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = cell.row() + i;
                int newCol = cell.column() + j;
                if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE) {
                    protectedCells.add(contentTable.get(newRow).get(newCol));
                }
            }
        }

        while (minesPlaced < MINES_AMOUNT) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            Cell cellToAdd = contentTable.get(row).get(col);

            if (!protectedCells.contains(cellToAdd) && !usedPositions.contains(cellToAdd)) {
                contentTable.get(row).set(col, createCell(row, col, true));
                usedPositions.add(cellToAdd);
                minesPlaced++;
            }
        }

        return contentTable;
    }

    private List<Cell> createRow(int rowIndex) {
        List<Cell> row = new ArrayList<>();
        for (int j = 0; j < SIZE; j++) {
            row.add(createCell(rowIndex, j,false));
        }
        return row;
    }

    private Cell createCell(int rowIndex, int columnIndex, boolean isMine) {
        return new Cell(rowIndex, columnIndex,isMine);
    }

}