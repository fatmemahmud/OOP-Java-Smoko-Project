package es.games.smoko;

public class Router {

	   public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1, DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
	    private Smoko smoko;
	    private Board board;
	    private int direction;
	    private boolean gameOver;

	    public Router(Smoko smoko, Board board) {
	        this.smoko = smoko;
	        this.board = board;
	    }

	    public void setDirection(int direction) {
	        this.direction = direction;
	    }

	    public void update() {
	        if (!gameOver) {
	            if (direction != DIRECTION_NONE) {
	                Cell nextCell = getNextCell(smoko.head);

	                if (smoko.checkCrash(nextCell)) {
	                    setDirection(DIRECTION_NONE);
	                    gameOver = true;
	                } else {
	                	smoko.move(nextCell);
	                    if (nextCell.type == Cell.CELL_TYPE_FOOD) {
	                    	smoko.grow();
	                        board.generateFood();
	                    }
	                }
	            }
	        }
	    }

	    private Cell getNextCell(Cell currentPosition) {
	        int row = currentPosition.row;
	        int col = currentPosition.col;

	        if (direction == DIRECTION_RIGHT) {
	            col++;
	        } else if (direction == DIRECTION_LEFT) {
	            col--;
	        } else if (direction == DIRECTION_UP) {
	            row--;
	        } else if (direction == DIRECTION_DOWN) {
	            row++;
	        }

	        Cell nextCell = board.cells[row][col];

	        return nextCell;
	    }
	}