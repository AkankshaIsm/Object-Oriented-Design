package TicTacToe;

public class Move {
    Player player;
    int row;
    int col;

    Move(Player player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }
}
