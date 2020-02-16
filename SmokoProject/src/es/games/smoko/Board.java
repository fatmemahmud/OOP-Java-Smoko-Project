package es.games.smoko;

public class Board {

    final int ROW_COUNT, COL_COUNT;
    Cell[][] cells;

    public Board(int rowCount, int columnCount) {
        ROW_COUNT = rowCount;
        COL_COUNT = columnCount;

        cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COL_COUNT; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }

    public void generateFood() {
        int row = (int) (Math.random() * ROW_COUNT);
        int column = (int) (Math.random() * COL_COUNT);

        cells[row][column].type = Cell.CELL_TYPE_FOOD;
    }
}