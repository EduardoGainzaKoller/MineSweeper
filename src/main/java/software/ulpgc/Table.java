package software.ulpgc;


import java.util.ArrayList;
import java.util.List;

public class Table {
    private final List<List<Cell>> table;
    private final List<Cell> mines;

    public Table() {
        this.mines = new ArrayList<>();
        table = new ArrayList<>();
    }

    public List<List<Cell>> getTable() {
        return table;
    }

    public List<Cell> getMines() {
        return mines;
    }


    @Override
    public String toString() {
        String result = "";
        for (List<Cell> cells : table) {
            String s = cells.toString() + "\n";
            result+=s;
        }

        result+= "\n";
        for (Cell mine : mines) {
            result+= mine.toString() + "\n";
        }
        return result;
    }
}
