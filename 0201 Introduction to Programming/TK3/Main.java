import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] level1Characters = {"d", "e", "t", "t", "l", "i"};
    private static final String[] level2Characters = {"s", "e", "c", "a", "e", "n"};
    private static final String[] level3Characters = {"h", "k", "r", "n", "e", "o"};
    private static String Answer;
    private static ArrayList<String> Answers = new ArrayList<>();
    private static boolean isCanProceed = false;
    private static int OverallScore = 0;
    private static boolean isRunning = true;

    public static void main(String[] args) {
        System.out.println("Coepoe Word Puzzle");
        System.out.println("==================\n");

        System.out.println("Rules : ");
        System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters");
        System.out.println("2. Each level, you have 10 chances to answer correctly");
        System.out.println("3. To get through to next level you have to score 70 point each level\n\n");

        while (isRunning) {
            OverallScore = 0;
            Level(1, level1Characters);

            if (isCanProceed) {
                Level(2, level2Characters);
            } else {
                GameOver();
            }

            if (isCanProceed) {
                Level(3, level3Characters);
            } else {
                GameOver();
            }

            if (isCanProceed) {
                System.out.println("\nOverall score: " + OverallScore);
                System.out.println("You Win!!");
                System.out.println("Press ENTER to exit..");
            } else {
                GameOver();
            }
        }
    }

    public static void Level(int levelNumber, String[] levelCharacters) {
        isCanProceed = false;
        Answers.clear();

        System.out.println("Level " + levelNumber);
        System.out.println("-------");
        System.out.print("         ");
        for (String character : levelCharacters) {
            System.out.printf("%-10s", character);
        }
        System.out.println();

        int currentScore = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + ") Your Answer: ");
            Answer = scanner.nextLine();

            if (ValidateAnswer(Answer)) {
                currentScore += 10;
                System.out.println("#Right. Score: " + currentScore);
            }
        }

        System.out.printf("You had answered 10 times with %d right answers..", currentScore / 10);

        if (currentScore >= 70) {
            isCanProceed = true;
        }

        OverallScore += currentScore;
    }

    private static boolean ValidateAnswer(String s) {
        if (s.length() < 3 || s.length() > 6) {
            System.out.println("Your answer should be min 3 characters & max 6 characters");
            return false;
        } else if (Answers.contains(s)) {
            System.out.println("You had already type this word before");
            return false;
        } else {
            Answers.add(Answer);
            return true;
        }
    }

    static void GameOver() {
        String userSelection;

        System.out.println("You Lose!! Try Again..");
        System.out.print("Do you want to retry? (y/n) : ");
        userSelection = scanner.nextLine();

        switch (userSelection.toLowerCase()) {
            case "y":
                isRunning = true;
                break;
            case "n":
                isRunning = false;
                break;
            default:
                System.out.println("You can only select either 'y' or 't'");
                GameOver();
                break;
        }
    }
}