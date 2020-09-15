package Chess.Pieces;

import Chess.Box;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    /**
        1. Can move diagonally to any distance within the board
        2. Cannot move over other pieces in between
    **/
    public boolean canMove(Box start, Box end, Box[][] boxes) {

        if(this.isNotAllowedMove(start, end))
        return false;

        int sRow = start.getRow();
        int sCol = start.getCol();
        int eRow = end.getRow();
        int eCol = end.getCol();

        int xDiff = Math.abs(sRow - eRow);
        int yDiff = Math.abs(sCol - eCol);

        if(xDiff == yDiff) {

            if(sRow < eRow && sCol < eCol) {
                int x = sRow + 1;
                int y = sCol + 1;

                while( x < eRow && y < eCol) {
                    if(boxes[x][y].getPiece() != null)
                        return false;
                    x++;
                    y++;
                }

                return true;
            }
            else if(sRow < eRow && sCol > eCol) {
                int x = sRow + 1;
                int y = sCol - 1;

                while( x < eRow && y > eCol) {
                    if(boxes[x][y].getPiece() != null)
                        return false;
                    x++;
                    y--;
                }

                return true;
            }
            else if(sRow > eRow && sCol < eCol) {
                int x = sRow - 1;
                int y = sCol + 1;

                while( x > eRow && y < eCol) {
                    if(boxes[x][y].getPiece() != null)
                        return false;
                    x--;
                    y++;
                }

                return true;
            }
            else { //(sRow > eRow && sCol > eCol)
                int x = sRow - 1;
                int y = sCol + 1;

                while( x > eRow && y > eCol) {
                    if(boxes[x][y].getPiece() != null)
                        return false;
                    x--;
                    y--;
                }

                return true;
            }

        }
        else return false;
    }
}
