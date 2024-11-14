import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static String[] questions = {
            "What is the capital of France?",
            "Which language is known as the 'language of the web'?",
            "Who invented Java Programming Language?",
    };

    private static String[][] options = {
            {"1. London", "2. Paris", "3. Rome", "4. Berlin"},
            {"1. C++", "2. Java", "3. JavaScript", "4. Python"},
            {"1. Dennis Ritchie", "2. James Gosling", "3. Guido van Rossum", "4. Linus Torvalds"}
    };

    private static int[] answers = {2, 3, 2};  // Correct answers: Paris, JavaScript, James Gosling

    private static int score = 0;
    private static int timeLimit = 10; // time limit in seconds for each question
    private static Timer timer = new Timer();
    private static boolean answered = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Quiz! You have " + timeLimit + " seconds for each question.");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            answered = false;
            startTimer();

            int userAnswer = getUserAnswer(scanner);
            if (userAnswer == answers[i] && answered) {
                System.out.println("Correct!");
                score++;
            } else if (answered) {
                System.out.println("Wrong answer.");
            }

            timer.cancel();  // stop the timer for the current question
            timer = new Timer();  // reset the timer for the next question
        }

        System.out.println("\nQuiz Over! Your score is: " + score + "/" + questions.length);
        scanner.close();
    }

    private static int getUserAnswer(Scanner scanner) {
        while (!answered) {
            try {
                if (scanner.hasNextInt()) {
                    int answer = scanner.nextInt();
                    answered = true;
                    return answer;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next();  // clear invalid input
            }
        }
        return -1;  // Return -1 if the time runs out before answering
    }

    private static void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("\nTime's up!");
                    answered = true;
                }
            }
        }, timeLimit * 1000);
    }
}