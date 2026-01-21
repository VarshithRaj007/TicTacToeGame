import java.util.Scanner;

public class TicTacToe {

    // 3x3 board
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("      TIC TAC TOE (2 Players)");
        System.out.println("===================================");
        System.out.println("How to play:");
        System.out.println("- Player 1 = X");
        System.out.println("- Player 2 = O");
        System.out.println("- Enter row and column (1 to 3)");
        System.out.println("Example: row=1 col=3 means top-right cell");
        System.out.println("===================================\n");

        boolean playAgain = true;

        while (playAgain) {
            initializeBoard();
            char currentPlayer = 'X';
            boolean gameOver = false;

            while (!gameOver) {
                printBoard();

                // Take input
                int row, col;
                while (true) {
                    System.out.println("Player " + currentPlayer + " turn.");
                    System.out.print("Enter row (1-3): ");
                    row = sc.nextInt();
                    System.out.print("Enter column (1-3): ");
                    col = sc.nextInt();

                    // Convert to 0-based index
                    row--;
                    col--;

                    // Validate
                    if (isValidMove(row, col)) {
                        break;
                    } else {
                        System.out.println("Invalid move! Try again.\n");
                    }
                }

                // Place move
                board[row][col] = currentPlayer;

                // Check winner
                if (checkWinner(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                }
                // Check draw
                else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                }
                // Switch player
                else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            // Play again option
            System.out.print("\nDo you want to play again? (yes/no): ");
            String ans = sc.next().toLowerCase();
            playAgain = ans.equals("yes");
            System.out.println();
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }

    // Initialize board with empty spaces
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print board after each move
    static void printBoard() {
        System.out.println("\nCurrent Board:");
        System.out.println("   1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  ---+---+---");
        }
        System.out.println();
    }

    // Validate: inside board and empty cell
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    // Check winner for current player
    static boolean checkWinner(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    // Check if board is full
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
