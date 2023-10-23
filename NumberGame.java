//Task1 #codsoft internship project #1
//programming in java to create NumberGame
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + (rounds + 1));
            System.out.println("I have selected a number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (" + (maxAttempts - attempts) + " attempts left): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Your guess is out of the allowed range.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number (" + targetNumber + ") in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    break;
                }
            }

            if (hasGuessedCorrectly) {
                score += 1;
            } else {
                System.out.println("You've run out of attempts. The correct number was " + targetNumber);
            }

            rounds++;
            System.out.println("Your score: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Total rounds played: " + rounds + " Total score: " + score);
                break;
            }
        }
    }
}




















































//using Message dialog box 
/* 
import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            JOptionPane.showMessageDialog(null, "Round " + (rounds + 1));
            JOptionPane.showMessageDialog(null, "I have selected a number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog("Enter your guess (" + (maxAttempts - attempts) + " attempts left):");
                int userGuess = Integer.parseInt(input);
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    JOptionPane.showMessageDialog(null, "Your guess is out of the allowed range.");
                } else if (userGuess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Congratulations! You've guessed the correct number (" + targetNumber + ") in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    break;
                }
            }

            if (hasGuessedCorrectly) {
                score += 1;
            } else {
                JOptionPane.showMessageDialog(null, "You've run out of attempts. The correct number was " + targetNumber);
            }

            rounds++;
            JOptionPane.showMessageDialog(null, "Your score: " + score);

            String playAgain = JOptionPane.showInputDialog("Do you want to play another round? (yes/no):");

            if (!playAgain.equalsIgnoreCase("yes")) {
                JOptionPane.showMessageDialog(null, "Thanks for playing! Total rounds played: " + rounds + " Total score: " + score);
                break;
            }
        }
    }
}
*/