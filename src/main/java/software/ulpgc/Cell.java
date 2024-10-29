package software.ulpgc;

import java.util.Objects;

public class Cell {
    private final int posX;
    private final int posY;

    public Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return posX == cell.posX && posY == cell.posY;
    }

    @Override
    public String toString() {
        return "(" + posX + ", " + posY + ")";
    }
}
