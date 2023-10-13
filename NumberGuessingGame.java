import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int totalScore = 0;

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound) + lowerBound;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

            int attempts = 0;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                    totalScore += attempts;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playMore = scanner.next().toLowerCase();
            if (!playMore.equals("yes")) {
                playAgain = false;
                System.out.println("Your total score is " + totalScore + ".");
            }
        }
    }
}
