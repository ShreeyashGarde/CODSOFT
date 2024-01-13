import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAtmpt = 5; 
        int score = 0; 

        System.out.println("Welcome to the Number Game!");

        boolean playAgain = true;
        while (playAgain) {
            int ranNum = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I've generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAtmpt + " attempts to guess the number.");

            while (attempts < maxAtmpt && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                System.out.println(); 

                attempts++;

                if (guess == ranNum) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    score++; 
                } else if (guess < ranNum) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Oops! You've run out of attempts. The number was: " + ranNum);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.nextLine();
            playChoice = playChoice.toLowerCase();
            playAgain = playChoice.equals("yes") || playChoice.equals("y");
        }

        System.out.println("Thanks for playing! Your total score is: " + score);
        scanner.close();
    }
}
