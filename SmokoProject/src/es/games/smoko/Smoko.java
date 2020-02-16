package es.games.smoko;

import java.util.LinkedList;

public class Smoko {
	LinkedList<Cell> smokoPartList = new LinkedList<>();
    Cell head;

    public Smoko(Cell initPos) {
        head = initPos;
        smokoPartList.add(head);
    }

    public void grow() {
    	smokoPartList.add(head);
    }

    public void move(Cell nextCell) {
        Cell tail = smokoPartList.removeLast();
        tail.type = Cell.CELL_TYPE_EMPTY;

        head = nextCell;
        smokoPartList.addFirst(head);
    }

    public boolean checkCrash(Cell nextCell) {
        for (Cell cell : smokoPartList) {
            if (cell == nextCell) {
                return true;
            }
        }

        return false;
    }
}
