import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int initialRoll = die1 + die2;

            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + initialRoll);


            if (initialRoll == 2 || initialRoll == 3 || initialRoll == 12) {
                System.out.println("You crapped out!");
            } else if (initialRoll == 7 || initialRoll == 11) {
                System.out.println("Natural! You win!");
            } else {

                int point = initialRoll;
                System.out.println("The point is now: " + point);


                boolean tryingForPoint = true;
                while (tryingForPoint) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    int roll = die1 + die2;

                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + roll);

                    if (roll == point) {
                        System.out.println("Made point and won!");
                        tryingForPoint = false;
                    } else if (roll == 7) {
                        System.out.println("Got a seven and lost.");
                        tryingForPoint = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }


            System.out.print("Do you want to play again? (Y/N): ");
            String response = scanner.next().trim().toUpperCase();
            playAgain = response.equals("Y");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}