package software.ulpgc.Model;

import software.ulpgc.Model.Interfaces.TableInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumTableInitializer implements TableInitializer {
    private static final int size = 16;
    private final int mineAmount = 40;
    private final Table table;

    public MediumTableInitializer() {
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
        int minesCreated = 0;
        while (mineAmount > minesCreated) {
            Cell mine = new Cell(random.nextInt(0, size), random.nextInt(0, size));
            if (!table.getMinesCoordinates().contains(mine)) {
                table.getMinesCoordinates().add(mine);
                minesCreated++;
            }
        }
    }
}
