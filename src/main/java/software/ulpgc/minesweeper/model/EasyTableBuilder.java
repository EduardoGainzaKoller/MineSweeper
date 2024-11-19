package software.ulpgc.minesweeper.model;

import software.ulpgc.minesweeper.model.interfaces.TableBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EasyTableBuilder implements TableBuilder {
    private static final int SIZE = 8;
    private static final int MINE_AMOUNT = 10;
    private final List<Integer> minePositions = new ArrayList<>();

    public EasyTableBuilder() {
        initializeMinePositions();
    }

    @Override
    public Table build() {
        List<List<Cell>> table = new ArrayList<>();
        for (int row = 0; row < SIZE; row++) {
            table.add(createRow(row));
        }
        return new Table(table);
    }

    private void initializeMinePositions() {
        for (int i = 0; i < SIZE * SIZE; i++) {
            minePositions.add(i);
        }
        Collections.shuffle(minePositions);
        minePositions.subList(MINE_AMOUNT, minePositions.size()).clear();
    }

    private List<Cell> createRow(int rowIndex) {
        List<Cell> row = new ArrayList<>();
        for (int colIndex = 0; colIndex < SIZE; colIndex++) {
            row.add(createCell(rowIndex, colIndex));
        }
        return row;
    }

    private Cell createCell(int rowIndex, int colIndex) {
        int position = rowIndex * SIZE + colIndex;
        boolean hasMine = minePositions.contains(position);
        return new Cell(rowIndex, colIndex, hasMine);
    }
}


