package Chess.Pieces;

import Chess.Box;

public class Knight extends Piece {

    private static int ROWS[] = {1, 1, -1, -1, 2, 2, -2, -2};
    private static int COLS[] = {2, -2, 2, -2, 1, -1, 1, -1};

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    /** 1. Can move in L shapes, 2 and half step
     *  2. Can jump over other pieces
    * */
    public boolean canMove(Box start, Box end, Box[][] boxes) {
        if(this.isNotAllowedMove(start, end))
        return false;

        int sRow = start.getRow();
        int sCol = start.getCol();
        int eRow = end.getRow();
        int eCol = end.getCol();

        boolean isMovePossible = false;
        for(int i = 0; i < 8; i++) {
            int x = sRow + ROWS[i];
            int y = sCol + COLS[i];

            if(x == eRow && y == eCol) {
                isMovePossible = true;
                break;
            }
        }
        return isMovePossible;
    }
}
