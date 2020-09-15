package Chess.Pieces;

import Chess.Box;

public class King extends Piece{

    public King(boolean isWhite) {
        super(isWhite);
    }

    /** 1. Can move 1 step diagonally
     *  2. Can move 1 step horizontally
     *  3. Can move 1 step vertically
     * */
    @Override
    public boolean canMove(Box start, Box end, Box[][] boxes) {
        if(this.isNotAllowedMove(start, end))
        return false;

        int sRow = start.getRow();
        int sCol = start.getCol();
        int eRow = end.getRow();
        int eCol = end.getCol();

        int xDiff = Math.abs(sRow - eRow);
        int yDiff = Math.abs(sCol - eCol);

        return (xDiff + yDiff == 1 || (xDiff == yDiff && xDiff == 1));
    }
}
