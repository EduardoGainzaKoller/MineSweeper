package software.ulpgc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyTableInitializer implements TableInitializer {
    private static final int size = 8;
    private int mineAmount = 10;
    private final Table table;

    public EasyTableInitializer() {
        this.table = new Table();
    }

    @Override
    public Table initialize() {
        for (int i = 0; i < size; i++) {
            table.getTable().add(createRow(i));
        }

        addMines();
        return table;
    }

    private List<Cell> createRow(int rowIndex) {
        List<Cell> row = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            row.add(createCell(rowIndex, j));
        }
        return row;
    }

    private Cell createCell(int rowIndex, int columnIndex) {
        return new Cell(rowIndex, columnIndex);
    }

    private void addMines() {
        Random random = new Random();
        while(mineAmount>0) {
            Cell mine = new Cell(random.nextInt(0, 7), random.nextInt(0, 7));
            if (!table.getMines().contains(mine)) {
                table.getMines().add(mine);
                mineAmount--;
            }
        }

    }

}
