public class Cell {
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getNeightbors() {
        return neightbors;
    }

    public void setNeightbors(int neightbors) {
        this.neightbors = neightbors;
    }

    private int row;
    private int col;
    private int neightbors;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.neightbors=0;
    }
}
