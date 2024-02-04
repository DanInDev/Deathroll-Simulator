import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int amount;
    String player1 = "Starting Player";
    String player2 = "Second Player";
    String currentPlayer = player1;
    static int longestGame = 0;
    static int totalWinsPlayer1 = 0;
    static int totalWinsPlayer2 = 0;

    int roll() {
        return (int) (Math.random() * amount) + 1;
    }

    void swapPlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    void rollOff() {
        int rolls = 0; // Track the number of rolls in each game

        do {
            int result = roll();
            rolls++;
            System.out.println("[" + rolls + "] " + currentPlayer + " Rolled " + result);
            swapPlayer();
            amount = result; // Update the amount for the next roll

            // Update statistics
            if (rolls > longestGame) {
                longestGame = rolls;
            }

        } while (amount != 1);

        // Corrected condition to determine the winner
        if (currentPlayer.equals(player1)) {
            totalWinsPlayer1++;
        } else if (currentPlayer.equals(player2)) {
            totalWinsPlayer2++;
        }
        System.out.println(currentPlayer + " Won!" + "\n \n" + "--------GameOver---------");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the total number of games: ");
        int totalGames = Integer.parseInt(reader.readLine());

        int wins500To1000Player1 = 0;
        int wins2000To5000Player1 = 0;
        int wins100000To200000Player1 = 0;

        int wins500To1000Player2 = 0;
        int wins2000To5000Player2 = 0;
        int wins100000To200000Player2 = 0;

        for (int i = 0; i < totalGames; i++) {
            Main game = new Main();
            game.amount = (int) (Math.random() * 300000) + 500; // Random number between 500 and 300,000
            System.out.println("Game " + (i + 1) + ": Starting with amount " + game.amount);
            game.rollOff();

            // Check and update wins in specified ranges for player 1
            if (game.amount >= 500 && game.amount <= 1000) {
                wins500To1000Player1 += (game.currentPlayer.equals(game.player1)) ? 1 : 0;
            } else if (game.amount >= 2000 && game.amount <= 5000) {
                wins2000To5000Player1 += (game.currentPlayer.equals(game.player1)) ? 1 : 0;
            } else if (game.amount >= 100000 && game.amount <= 200000) {
                wins100000To200000Player1 += (game.currentPlayer.equals(game.player1)) ? 1 : 0;
            }

            // Check and update wins in specified ranges for player 2
            if (game.amount >= 500 && game.amount <= 1000) {
                wins500To1000Player2 += (game.currentPlayer.equals(game.player2)) ? 1 : 0;
            } else if (game.amount >= 2000 && game.amount <= 5000) {
                wins2000To5000Player2 += (game.currentPlayer.equals(game.player2)) ? 1 : 0;
            } else if (game.amount >= 100000 && game.amount <= 200000) {
                wins100000To200000Player2 += (game.currentPlayer.equals(game.player2)) ? 1 : 0;
            }

            System.out.println();
        }

        System.out.println("Longest Game: " + longestGame + " rolls");
        System.out.println("Total Wins for Starting Player: " + totalWinsPlayer1);
        System.out.println("Total Wins for Second Player: " + totalWinsPlayer2);

        System.out.println("Wins for Starting Player in the range 500-1000: " + wins500To1000Player1);
        System.out.println("Wins for Starting Player in the range 2000-5000: " + wins2000To5000Player1);
        System.out.println("Wins for Starting Player in the range 100000-200000: " + wins100000To200000Player1);

        System.out.println("Wins for Second Player in the range 500-1000: " + wins500To1000Player2);
        System.out.println("Wins for Second Player in the range 2000-5000: " + wins2000To5000Player2);
        System.out.println("Wins for Second Player in the range 100000-200000: " + wins100000To200000Player2);

        // Close the reader
        reader.close();
    }
}
