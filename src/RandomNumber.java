import java.util.*;

public class RandomNumber {

    static StringBuilder ourNumber;
    private int numberLength;
    private int amountLetters;


    public int getNumberLength() {
        return numberLength;
    }

    public RandomNumber(int numberLength, int amountLetters) {
        this.numberLength = numberLength;
        this.amountLetters = amountLetters;
    }

    public void randomNumber() {
        System.out.println("Okay, let's start a game!");
        String star = "*".repeat(this.numberLength);
        if (this.amountLetters < 11) {
            ourNumber = generateRandomLine(this.numberLength, this.amountLetters);
            System.out.printf("The secret is prepared: %s (0-%d).\n", star, amountLetters - 1);
        } else {
            ourNumber = generateRandomLine(this.numberLength, this.amountLetters);
            if (this.amountLetters >= 11) {
                System.out.printf("The secret is prepared: %s (0-9, a-%s).\n", star, String.valueOf((char) (amountLetters + 86)));
            }
        }
        System.out.println(ourNumber);
    }

    private StringBuilder generateRandomLine(int length, int amountLetters) {
        Random random = new Random();
        String possibleSymbols = "0123456789abcdefghijklmnopqestuvwxyz";
        StringBuilder finalString = new StringBuilder();
        do {
            int randomPosition = random.nextInt(amountLetters);
            if (finalString.toString().contains(String.valueOf(possibleSymbols.charAt(randomPosition)))) {
                continue;
            } else {
                finalString.append(possibleSymbols.charAt(randomPosition));
            }
        } while (finalString.length() < length);
        return finalString;
    }
}



