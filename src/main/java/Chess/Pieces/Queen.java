package Chess.Pieces;

import Chess.Box;

public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite);
    }

    /** 1. Can move Diagonally to any distance within board like Bishop
     *  2. Can move Horizontally and Vertically to any distance like Rook
     *  3. Cannot move over other pieces in between
    * */
    public boolean canMove(Box start, Box end, Box[][] boxes) {

        if(this.isNotAllowedMove(start, end))
        return false;

        int sRow = start.getRow();
        int sCol = start.getCol();
        int eRow = end.getRow();
        int eCol = end.getCol();

        int xDiff = Math.abs(sRow - eRow);
        int yDiff = Math.abs(sCol - eCol);

        // Diagonal move like Bishop
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

        //Horizontal and vertical moves like Rook
        if (xDiff == 0 || yDiff == 0) {
            if(xDiff != 0) {
                boolean sRowE = sRow < eRow;
                int x = sRowE ? sRow + 1 : sRow - 1;

                while((sRowE && x < eRow) || (!sRowE && x > eRow)){
                    if(boxes[x][sCol].getPiece() != null)
                        return false;
                    if(sRowE)
                        x++;
                    else x--;
                }
            }
            else {
                boolean sColE = sCol < eCol;
                int y = sCol + 1;
                while((sColE && y < eCol) || (!sColE && y > eCol)) {
                    if(boxes[sRow][y].getPiece() != null)
                        return false;

                    if(sColE)
                        y++;
                    else y--;
                }
            }

            return true;
        }

        return false;
    }
}
