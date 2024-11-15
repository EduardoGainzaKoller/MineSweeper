package software.ulpgc.Model;


import java.util.ArrayList;
import java.util.List;

public class Table {
    private final List<List<Cell>> table;
    private final List<Cell> minesCoordinates;

    public Table() {
        this.minesCoordinates = new ArrayList<>();
        table = new ArrayList<>();
    }

    public List<List<Cell>> getTable() {
        return table;
    }

    public List<Cell> getMinesCoordinates() {
        return minesCoordinates;
    }

    public List<Cell> get(int index) {
        return table.get(index);
    }

    @Override
    public String toString() {
        String result = "";
        for (List<Cell> cells : table) {
            String s = cells.toString() + "\n";
            result+=s;
        }

        result+= "\n";
        for (Cell mine : minesCoordinates) {
            result+= mine.toString() + "\n";
        }
        return result;
    }
}
