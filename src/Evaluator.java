import java.util.Scanner;

public class Evaluator {
    private int turnCnt = 1;
    private String personNumber;
    private int cows = 0;
    private int bulls = 0;

    public String getPersonNumber() {
        return personNumber;
    }

    public int getTurnCnt() {
        return turnCnt;
    }

    public int getCows() {
        return cows;
    }

    public int getBulls() {
        return bulls;
    }

    public void getPlayerNumber() {
        CheckForExceptions check = new CheckForExceptions();
        Scanner scan = new Scanner(System.in);
        System.out.printf("Turn %d:\n", turnCnt);
        this.personNumber = scan.nextLine();
        this.turnCnt++;
    }

    public void checker() {
        bulls = 0;
        cows = 0;
        String ourNumber = String.valueOf(RandomNumber.ourNumber);
        for (int i = 0; i < this.personNumber.length(); i++) {
            if (personNumber.charAt(i) == ourNumber.charAt(i)) {
                bulls++;
            } else if (ourNumber.contains(String.valueOf(personNumber.charAt(i)))) {
                cows++;
            }
        }
    }


    public void printer() {
        if (bulls == RandomNumber.ourNumber.length()) {
            System.out.printf("Grade: %d bulls\nCongratulations! You guessed the secret code.", bulls);
        } else if (cows == 1 & bulls == 1) {
            System.out.printf("Grade: %d bull and %d cow\n", bulls, cows);
        } else if (bulls > 1 & (cows > 1 || cows == 0)) {
            System.out.printf("Grade: %d bulls and %d cows.\n", bulls, cows);
        } else if (cows > 1 & (bulls > 1 || bulls == 0)) {
            System.out.printf("Grade: %d bulls and %d cow.\n", bulls, cows);
        } else if (bulls == 1 & (cows > 1 || cows == 0)) {
            System.out.printf("Grade: %d bull and %d cows.\n", bulls, cows);
        } else if (cows == 0 && bulls == 0) {
            System.out.println("Grade: 0 bulls and 0 cows.");
        } else if (cows == 1 & (bulls > 1 || bulls == 0)) {
            System.out.printf("Grade: %d bulls and %d cow.\n", bulls, cows);
        }
    }
}

