package com.z_vladislav;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public enum Messages {
        INTRO("Please guess the number between 1 and 1000."),
        TOO_HIGH("Too high"),
        TOO_LOW("Too low"),
        OUT_OF_BOUND("Only numbers between 1 and 1000"),
        CONGRATULATION("Congratulations! Number is "),
        NUMBER_OF_GUESSES("Number of guesses: ");

        private String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomInt = random.nextInt(1000) + 1;
        int numberOfGuesses = 0;
        int playersGuess;

        System.out.println(Messages.INTRO.getMessage());

        do {
            playersGuess = scanner.nextInt();
            numberOfGuesses++;
            if (playersGuess > 1000 || playersGuess < 1) {
                System.out.println(Messages.OUT_OF_BOUND.getMessage());
            } else if (playersGuess > randomInt) {
                System.out.println(Messages.TOO_HIGH.getMessage());
            } else if (playersGuess < randomInt) {
                System.out.println(Messages.TOO_LOW.getMessage());
            }
        } while (playersGuess != randomInt);

        System.out.println(Messages.CONGRATULATION.getMessage() + randomInt);
        System.out.println(Messages.NUMBER_OF_GUESSES.getMessage() + numberOfGuesses);
    }
}