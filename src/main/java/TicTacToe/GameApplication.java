package TicTacToe;

import java.util.Scanner;

public class GameApplication {

    public static void main(String[] args) {
        Game game = new Game("Ashish", "Akanksha", 3);
        boolean ashish = true;
        do {
            if(ashish) {
                System.out.println("Ashish's TicTacToe.Move...");
            }
            else {
                System.out.println("Akanksha's TicTacToe.Move...");
            }

            ashish = !ashish;

            System.out.println("Enter move : ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            GameStatus status = game.makeMove(row, col);
            if(status != GameStatus.UNDECIDED) {
                System.out.println("TicTacToe.Game winner is : " + status.toString());
                break;
            }
        }
        while(true);

    }
}
