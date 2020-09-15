package Chess.Pieces;

import Chess.Box;

public class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(isWhite);
    }
    /**
        1. Can move horizontally and vertically
        2. Cannot move over other piece
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

       if ((xDiff != 0 && yDiff == 0) || (xDiff == 0 && yDiff != 0)) {
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
       else return false;
    }
}
