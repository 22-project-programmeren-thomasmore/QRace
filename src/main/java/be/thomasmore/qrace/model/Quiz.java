package be.thomasmore.qrace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Quiz {

    public static void setQuiz1(){
        HashMap<Gallery, Question> quiz1 = new HashMap<Gallery, Question>();
        quiz1.put(new Gallery(1), new Question("Wat is de naam van dit kunstwerk?", "De Schreeuw"));
        quiz1.put(new Gallery(2), new Question("Wat is de naam van dit kunstwerk?", "De Nachtwacht"));
        quiz1.put(new Gallery(3), new Question("Wat is de naam van dit kunstwerk?", "De Mona Lisa"));
        quiz1.put(new Gallery(4), new Question("Wat is de naam van dit kunstwerk?", "Het meisje met de parel"));
        quiz1.put(new Gallery(5), new Question("Wat is de naam van dit kunstwerk?", "De Sterrennacht"));
        quiz1.put(new Gallery(6), new Question("Wat is de naam van dit kunstwerk?", "Het Laatste Avondmaal"));
        quiz1.put(new Gallery(7), new Question("Wat is de naam van dit kunstwerk?", "Las Meninas"));
        quiz1.put(new Gallery(8), new Question("Wat is de naam van dit kunstwerk?", "Irissen"));
        quiz1.put(new Gallery(9), new Question("Wat is de naam van dit kunstwerk?", "De Kus"));
        quiz1.put(new Gallery(10), new Question("Wat is de naam van dit kunstwerk?", "De grote golf van Kanagawa"));
    }

    public static void setQuiz2(){
        HashMap<Gallery, Question> quiz2 = new HashMap<Gallery, Question>();
        quiz2.put(new Gallery(1), new Question("Wat is de naam van dit kunstwerk?", "De Schreeuw"));
        quiz2.put(new Gallery(2), new Question("Wat is de naam van dit kunstwerk?", "De Nachtwacht"));
        quiz2.put(new Gallery(3), new Question("Wat is de naam van dit kunstwerk?", "De Mona Lisa"));
        quiz2.put(new Gallery(4), new Question("Wat is de naam van dit kunstwerk?", "Het meisje met de parel"));
        quiz2.put(new Gallery(5), new Question("Wat is de naam van dit kunstwerk?", "De Sterrennacht"));
        quiz2.put(new Gallery(6), new Question("Wat is de naam van dit kunstwerk?", "Het Laatste Avondmaal"));
        quiz2.put(new Gallery(7), new Question("Wat is de naam van dit kunstwerk?", "Las Meninas"));
        quiz2.put(new Gallery(8), new Question("Wat is de naam van dit kunstwerk?", "Irissen"));
        quiz2.put(new Gallery(9), new Question("Wat is de naam van dit kunstwerk?", "De Kus"));
        quiz2.put(new Gallery(10), new Question("Wat is de naam van dit kunstwerk?", "De grote golf van Kanagawa"));
    }

    public static void setQuiz3(){
        HashMap<Gallery, Question> quiz3 = new HashMap<Gallery, Question>();
        quiz3.put(new Gallery(1), new Question("Wat is de naam van dit kunstwerk?", "De Schreeuw"));
        quiz3.put(new Gallery(2), new Question("Wat is de naam van dit kunstwerk?", "De Nachtwacht"));
        quiz3.put(new Gallery(3), new Question("Wat is de naam van dit kunstwerk?", "De Mona Lisa"));
        quiz3.put(new Gallery(4), new Question("Wat is de naam van dit kunstwerk?", "Het meisje met de parel"));
        quiz3.put(new Gallery(5), new Question("Wat is de naam van dit kunstwerk?", "De Sterrennacht"));
        quiz3.put(new Gallery(6), new Question("Wat is de naam van dit kunstwerk?", "Het Laatste Avondmaal"));
        quiz3.put(new Gallery(7), new Question("Wat is de naam van dit kunstwerk?", "Las Meninas"));
        quiz3.put(new Gallery(8), new Question("Wat is de naam van dit kunstwerk?", "Irissen"));
        quiz3.put(new Gallery(9), new Question("Wat is de naam van dit kunstwerk?", "De Kus"));
        quiz3.put(new Gallery(10), new Question("Wat is de naam van dit kunstwerk?", "De grote golf van Kanagawa"));
    }
    public static void setQuiz4(){
        HashMap<Gallery, Question> quiz4 = new HashMap<Gallery, Question>();
        quiz4.put(new Gallery(1), new Question("Wat is de naam van dit kunstwerk?", "De Schreeuw"));
        quiz4.put(new Gallery(2), new Question("Wat is de naam van dit kunstwerk?", "De Nachtwacht"));
        quiz4.put(new Gallery(3), new Question("Wat is de naam van dit kunstwerk?", "De Mona Lisa"));
        quiz4.put(new Gallery(4), new Question("Wat is de naam van dit kunstwerk?", "Het meisje met de parel"));
        quiz4.put(new Gallery(5), new Question("Wat is de naam van dit kunstwerk?", "De Sterrennacht"));
        quiz4.put(new Gallery(6), new Question("Wat is de naam van dit kunstwerk?", "Het Laatste Avondmaal"));
        quiz4.put(new Gallery(7), new Question("Wat is de naam van dit kunstwerk?", "Las Meninas"));
        quiz4.put(new Gallery(8), new Question("Wat is de naam van dit kunstwerk?", "Irissen"));
        quiz4.put(new Gallery(9), new Question("Wat is de naam van dit kunstwerk?", "De Kus"));
        quiz4.put(new Gallery(10), new Question("Wat is de naam van dit kunstwerk?", "De grote golf van Kanagawa"));
    }
    public static void takeQuiz(Question[] quiz) {
        int score = 0;
        Scanner keyboardInput = new Scanner(System.in);

        for (Question question : quiz) {
            System.out.println(question.prompt);
            String answer = keyboardInput.nextLine();
            if (answer.equals(question.answer)) {
                score += 3;
                System.out.println("You've earned 3 points.");
            } else if (answer.equals(question.answer)) {
                score++;
                System.out.println("You've earned 1 point.");
            } else {
                System.out.println("You've earned 0 points.");
            }
        }
        System.out.println("You got " + score + "/" + quiz.length);
    }
}