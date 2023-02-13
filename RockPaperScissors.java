import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String player1, player2;
        int score1 = 0, score2 = 0;
        int highestScore = 0;

        System.out.println("Rock, Paper, Scissors Game");
        System.out.println("Enter Player 1 Name: ");
        player1 = sc.nextLine();
        System.out.println("Enter Player 2 Name: ");
        player2 = sc.nextLine();
        System.out.println("Current highest score: " + highestScore);

        while (true) {
            System.out.println("\n" + player1 + " choose (R)ock, (P)aper, (S)cissors or (Q)uit: ");
            String player1Choice = sc.nextLine();
            if (player1Choice.equals("Q")) {
                break;
            }

            System.out.println("\n" + player2 + " choose (R)ock, (P)aper, (S)cissors or (Q)uit: ");
            String player2Choice = sc.nextLine();
            if (player2Choice.equals("Q")) {
                break;
            }

            if (player1Choice.equals("R")) {
                if (player2Choice.equals("S")) {
                    System.out.println(player1 + " wins!");
                    score1++;
                } else if (player2Choice.equals("P")) {
                    System.out.println(player2 + " wins!");
                    score2++;
                } else {
                    System.out.println("Draw!");
                }
            } else if (player1Choice.equals("P")) {
                if (player2Choice.equals("R")) {
                    System.out.println(player1 + " wins!");
                    score1++;
                } else if (player2Choice.equals("S")) {
                    System.out.println(player2 + " wins!");
                    score2++;
                } else {
                    System.out.println("Draw!");
                }
            } else if (player1Choice.equals("S")) {
                if (player2Choice.equals("P")) {
                    System.out.println(player1 + " wins!");
                    score1++;
                } else if (player2Choice.equals("R")) {
                    System.out.println(player2 + " wins!");
                    score2++;
                } else {
                    System.out.println("Draw!");
                }
            }

            if (score1 > highestScore) {
                highestScore = score1;
            }
            if (score2 > highestScore) {
                highestScore = score2;
            }

            System.out.println("\nCurrent scores - " + player1 + ": " + score1 + ",\n" + player2 + ": " + score2);
            System.out.println("Highest score: " + highestScore);
        }

        System.out.println("\nThanks for playing!");
        sc.close();
    }
}

