package Chess.Pieces;

import Chess.Box;

public abstract class Piece {
    private boolean isWhite;
    private boolean isKilled;

    Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isKilled() {
        return isKilled;
    }

    /**
     * Basic checks here :
       1. A move is not allowed out of the board itself
       2. Move is not allowed at same place, i.e, start and end position must be different
       3. Move is not allowed if end box has a piece from same team
    * */
    public boolean isNotAllowedMove(Box start, Box end) {
        int sRow = start.getRow();
        int sCol = start.getCol();
        int eRow = end.getRow();
        int eCol = end.getCol();

        return (eRow < 0 || eRow >= 8 || eCol < 0 || eCol >= 8
                || (sRow == eRow && sCol == eCol)
                || (end.getPiece() != null && (end.getPiece().isWhite == start.getPiece().isWhite)));
    }

    public abstract boolean canMove(Box start, Box end, Box[][] boxes);
}
