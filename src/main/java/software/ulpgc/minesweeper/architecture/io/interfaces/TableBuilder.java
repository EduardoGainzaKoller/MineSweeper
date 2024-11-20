package software.ulpgc.minesweeper.architecture.io.interfaces;

import software.ulpgc.minesweeper.architecture.model.Cell;
import software.ulpgc.minesweeper.architecture.model.Table;

public interface TableBuilder {
    Table buildTable();
    Table buildWithMines(Cell cell);
}
