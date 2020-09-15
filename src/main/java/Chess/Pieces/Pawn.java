package Chess.Pieces;

import Chess.Box;

public class Pawn extends Piece {
    private boolean isFirstMove;

    public Pawn(boolean isWhite) {
        super(isWhite);
        this.isFirstMove = true;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    /** This one is special!!
     *  1. Can move 1 step towards other team.
     *  2. For 1st move, it can take either 1 or 2 steps
     *  3. Cannot move backward
     *  4. Cannot move horizontally
     *  5. While capturing, it can move 1 step diagonally
     * */
    @Override
    public boolean canMove(Box start, Box end, Box[][] boxes) {

        if(this.isNotAllowedMove(start, end))
        return false;

        int sRow = start.getRow();
        int sCol = start.getCol();
        int eRow = end.getRow();
        int eCol = end.getCol();

        int xDiff = sRow - eRow;
        int yDiff = sCol - eCol;

        /* Check if it is not a backward move
               Blacks will have positive diff row-wise and whites will have negative diff. */
        if((xDiff > 0 && this.isWhite()) || (xDiff < 0 && !this.isWhite()))
            return false;

        //Checking for 1 step row-wise
        if(Math.abs(xDiff) == 1) {
            if(yDiff == 0)
                return true;
            // Trying to capture another piece
            return Math.abs(yDiff) == 1 && boxes[eRow][eCol].getPiece() != null;
        }

        return Math.abs(xDiff) == 2 && yDiff == 0 && this.isFirstMove;
    }
}
