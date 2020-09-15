package Chess;

import Chess.Pieces.*;

public class Board {

    Box boxes[][];

    Board() {
        boxes = new Box[8][8];
        this.initialize();
    }

    private void initialize() {

        /* Initializing blacks */
        /* First Row */
        boxes[0][0] = new Box(0, 0, new Rook(false));
        boxes[0][1] = new Box(0, 1, new Knight(false));
        boxes[0][2] = new Box(0, 2, new Bishop(false));
        boxes[0][3] = new Box(0, 3, new Queen(false));
        boxes[0][4] = new Box(0, 4, new King(false));
        boxes[0][5] = new Box(0, 5, new Bishop(false));
        boxes[0][6] = new Box(0, 6, new Knight(false));
        boxes[0][7] = new Box(0, 7, new Rook(false));
        /* Pawns */
        boxes[1][0] = new Box(1, 0, new Pawn(false));
        boxes[1][1] = new Box(1, 1, new Pawn(false));
        boxes[1][2] = new Box(1, 2, new Pawn(false));
        boxes[1][3] = new Box(1, 3, new Pawn(false));
        boxes[1][4] = new Box(1, 4, new Pawn(false));
        boxes[1][5] = new Box(1, 5, new Pawn(false));
        boxes[1][6] = new Box(1, 6, new Pawn(false));
        boxes[1][7] = new Box(1, 7, new Pawn(false));

        /* Initializing whites */
        /* First Row */
        boxes[7][0] = new Box(7, 0, new Rook(true));
        boxes[7][1] = new Box(7, 1, new Knight(true));
        boxes[7][2] = new Box(7, 2, new Bishop(true));
        boxes[7][3] = new Box(7, 3, new Queen(true));
        boxes[7][4] = new Box(7, 4, new King(true));
        boxes[7][5] = new Box(7, 5, new Bishop(true));
        boxes[7][6] = new Box(7, 6, new Knight(true));
        boxes[7][7] = new Box(7, 7, new Rook(true));
        /* Pawns */
        boxes[6][0] = new Box(6, 0, new Pawn(true));
        boxes[6][1] = new Box(6, 1, new Pawn(true));
        boxes[6][2] = new Box(6, 2, new Pawn(true));
        boxes[6][3] = new Box(6, 3, new Pawn(true));
        boxes[6][4] = new Box(6, 4, new Pawn(true));
        boxes[6][5] = new Box(6, 5, new Pawn(true));
        boxes[6][6] = new Box(6, 6, new Pawn(true));
        boxes[6][7] = new Box(6, 7, new Pawn(true));

        /* Initializing empty cells */
        for(int i = 2; i <= 5; i++) {
            for(int j = 0; j <= 7; j++)
                boxes[i][j] = new Box(i, j, null);
        }
    }

    void makeMove(Box start, Box end, Piece piece) {
        int sRow = start.getRow();
        int sCol = start.getCol();
        int eRow = end.getRow();
        int eCol = end.getCol();

        boxes[sRow][sCol].setPiece(null);
        boxes[eRow][eCol].setPiece(piece);
    }

}
