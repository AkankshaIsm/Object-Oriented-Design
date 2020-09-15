package Chess;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Player p1, p2;
    Board board;
    List<Move> moves;
    boolean playerOne;

    Game(String player1, String player2) {
        p1 = new Player(1, player1);
        p2 = new Player(2, player2);
        board = new Board();
        moves = new ArrayList<>();
        playerOne = true;
    }

    public String playerTurn() {
        return playerOne ?  p1.getName() : p2.getName();
    }

    public void makeMove(int sr, int sc, int er, int ec) {

    }
}
