package Chess;

import Chess.Pieces.Piece;

public class Move {
    private Box start;
    private Box end;
    private Piece piece;

    Move(Box start, Box end, Piece piece) {
        this.start = start;
        this.end = end;
        this.piece = piece;
    }

    public Box getStart() {
        return start;
    }

    public Box getEnd() {
        return end;
    }

    public Piece getPiece() {
        return piece;
    }
}
