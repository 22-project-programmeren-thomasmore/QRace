package be.thomasmore.qrace.model;

import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        Question[] quiz01 = {
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", "")
        };
        Question[] quiz02 = {
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", "")
        };
        Question[] quiz03 = {
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
        };
        Question[] quiz04 = {
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
                new Question("", Player.builder().build(), "", "", ""),
        };
    }

    public static void takeQuiz01(Question[] quiz01) {
        int score = 0;
        Scanner keyboardInput = new Scanner(System.in);

        for (Question question : quiz01) {
            System.out.println(question.prompt);
            String firstAnswer = keyboardInput.nextLine();
            String secondAnswer = keyboardInput.nextLine();
            if (firstAnswer.equals(question.firstAnswer)) {
                score += 3;
                System.out.println("You've earned 3 points.");
            } else if (secondAnswer.equals(question.secondAnswer)) {
                score++;
                System.out.println("You've earned 1 point.");
            } else {
                System.out.println("You've earned 0 points.");
            }
        }
        System.out.println("You got " + score + "/" + quiz01.length);
    }
}