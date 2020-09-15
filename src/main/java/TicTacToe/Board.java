package TicTacToe;

public class Board {
    private BoxStatus box[][];
    private boolean isFilled;
    private int n;

    Board(final int n) {
        this.n = n;
        box = new BoxStatus[n][n];
        this.isFilled = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                box[i][j] = BoxStatus.EMPTY;
        }
    }

    public void getBoard() {
        for(int i = 0; i < n ;i++) {
            for(int j = 0; j < n; j++)
                System.out.print(box[i][j].toString() + " ");
            System.out.println();
        }
    }

    private boolean moveInsideBoard(int row, int col) {
        return (row >= 0 && row < n && col >= 0 && col < n);
    }

    private boolean isBoardFilled() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(box[i][j] == BoxStatus.EMPTY)
                    return false;
            }
        }
        return true;
    }

    public GameStatus makeMove(Move move) throws IllegalStateException {

        if(this.isFilled)
            return GameStatus.DRAW;

        int row = move.row;
        int col = move.col;

        if(!moveInsideBoard(row, col)) {
            throw new IllegalStateException("TicTacToe.Move is out of TicTacToe.Board!");
        }

        if(box[row][col] != BoxStatus.EMPTY) {
            throw new IllegalStateException("Box is not Empty");
        }

        BoxStatus boxStatus = move.player.getId() == 1 ? BoxStatus.PLAYER_1 : BoxStatus.PLAYER_2;
        box[row][col] = boxStatus;

        boolean rowWinner = true, colWinner = true, diagWinner = true, revdiagWinner = true;
        for(int i = 0; i < n; i++) {
            if(box[i][col] != boxStatus)
                colWinner = false;

            if(box[row][i] != boxStatus)
                rowWinner = false;

            if(box[i][i] != boxStatus)
                diagWinner = false;

            if(box[i][n-i-1] != boxStatus)
                revdiagWinner = false;
        }
        if(colWinner || rowWinner || diagWinner || revdiagWinner)
            return boxStatus == BoxStatus.PLAYER_1 ? GameStatus.PLAYER_1 : GameStatus.PLAYER_2;

        this.isFilled = isBoardFilled();
        if(this.isFilled) {
            return GameStatus.DRAW;
        }

        return GameStatus.UNDECIDED;
    }

}
