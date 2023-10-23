//Task4 CODSOFT Intern project #4
//programming in java to create QUIZ APPLICATION WITH TIMER 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static List<Question> questions;
    private static int currentQuestionIndex;
    private static int score;
    private static Timer timer;

    public static void main(String[] args) {
        initializeQuestions();
        currentQuestionIndex = 0;
        score = 0;

        startQuiz();
    }

    private static void initializeQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                new String[]{"A) London", "B) Berlin", "C) Paris", "D) Madrid"}, "C"));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"A) Earth", "B) Mars", "C) Venus", "D) Jupiter"}, "B"));
        questions.add(new Question("What is the largest mammal in the world?",
                new String[]{"A) Elephant", "B) Blue Whale", "C) Giraffe", "D) Dolphin"}, "B"));
        questions.add(new Question("Which gas is most abundant in Earth's atmosphere?",
                new String[]{"A) Oxygen", "B) Nitrogen", "C) Carbon Dioxide", "D) Hydrogen"}, "B"));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?",
                new String[]{"A) Charles Dickens", "B) William Shakespeare", "C) Jane Austen", "D) Leo Tolstoy"}, "B"));
        // Add more questions here
    }

    private static void startQuiz() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            System.out.println(currentQuestion.getQuestion());
            for (String option : currentQuestion.getOptions()) {
                System.out.println(option);
            }

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    displayResult();
                }
            }, 15000); // 15 seconds per question, you can adjust this

            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.nextLine().toUpperCase();

            if (userAnswer.equals(currentQuestion.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + currentQuestion.getCorrectAnswer());
            }

            currentQuestionIndex++;
            timer.cancel();

            startQuiz(); // Move to the next question
        } else {
            displayResult();
        }
    }

    private static void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (questions.size() - score));
    }
}

class Question {
    private String question;
    private String[] options;
    private String correctAnswer;

    public Question(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
