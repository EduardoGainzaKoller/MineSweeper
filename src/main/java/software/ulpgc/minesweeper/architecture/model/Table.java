package software.ulpgc.minesweeper.architecture.model;

import java.util.List;

public class Table {
    private final List<List<Cell>> tableContent;

    public Table(List<List<Cell>> table) {
        this.tableContent = table;
    }

    public List<List<Cell>> getTableContent() {
        return tableContent;
    }

    public int getRows() {
        return tableContent.size();
    }

    public int getColums() {
        return tableContent.get(0).size();
    }
}
