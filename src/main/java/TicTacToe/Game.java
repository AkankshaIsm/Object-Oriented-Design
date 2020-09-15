package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Player p1, p2;
    private List<Move> moves;
    boolean playerOne;
    private GameStatus status;

    Game(String player1, String player2, final int n) {
        this.board = new Board(n);
        p1 = new Player(1, player1);
        p2 = new Player(2, player2);
        playerOne = true;
        status = GameStatus.UNDECIDED;
        this.moves = new ArrayList<>();
    }

    public GameStatus makeMove(int row, int col) {
        Move move;

        if(playerOne) {
            move = new Move(p1, row, col);
        }
        else {
            move = new Move(p2, row, col);
        }

        this.status = board.makeMove(move);
        this.moves.add(move);

        playerOne = !playerOne;
        return this.status;
    }

    public String getGameStatus() {
        return this.status.toString();
    }

    private void printAllMovesTillNow() {
        for(Move move : this.moves) {
            System.out.println(move.player.getName() + " " + move.row + " " + move.col);
        }

        System.out.println("TicTacToe.Game Status is : " + this.getGameStatus());
    }
}
