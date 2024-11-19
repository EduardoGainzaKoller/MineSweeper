package software.ulpgc.minesweeper.model;

import software.ulpgc.minesweeper.model.interfaces.TableBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HardTableBuilder implements TableBuilder {
    private static final int ROW_SIZE = 20;
    private static final int COLUM_SIZE = 24;
    private static final int MINE_AMOUNT = 99;
    private final List<Integer> minePositions = new ArrayList<>();

    public HardTableBuilder() {
        initializeMinePositions();
    }

    @Override
    public Table build() {
        List<List<Cell>> table = new ArrayList<>();
        for (int row = 0; row < ROW_SIZE; row++) {
            table.add(createRow(row));
        }
        return new Table(table);
    }

    private void initializeMinePositions() {
        for (int i = 0; i < ROW_SIZE * COLUM_SIZE; i++) {
            minePositions.add(i);
        }
        Collections.shuffle(minePositions);
        minePositions.subList(MINE_AMOUNT, minePositions.size()).clear();
    }

    private List<Cell> createRow(int rowIndex) {
        List<Cell> row = new ArrayList<>();
        for (int colIndex = 0; colIndex < COLUM_SIZE; colIndex++) {
            row.add(createCell(rowIndex, colIndex));
        }
        return row;
    }

    private Cell createCell(int rowIndex, int colIndex) {
        int position = rowIndex * COLUM_SIZE + colIndex;
        boolean hasMine = minePositions.contains(position);
        return new Cell(rowIndex, colIndex, hasMine);
    }
}

