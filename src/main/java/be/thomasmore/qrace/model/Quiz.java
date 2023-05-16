package be.thomasmore.qrace.model;

import org.hibernate.mapping.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quiz {

    private HashMap<Integer, Question> quizQuestions;

    public Quiz(HashMap<Integer, Question> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }
    public HashMap<Integer,Question> getQuestions() {
      return new  HashMap<>((Map) quizQuestions.values());
    }
    // Getters
    public HashMap<Integer, Question> getQuizQuestions() {
        return quizQuestions;
    }

    public Quiz getQuiz1() {
        return quiz1;
    }

    public Quiz getQuiz2() {
        return quiz2;
    }

    public Quiz getQuiz3() {
        return quiz3;
    }

    public Quiz getQuiz4() {
        return quiz4;
    }

    // Setters...
    public void setQuizQuestions(HashMap<Integer, Question> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    public void setQuiz1(Quiz quiz1) {
        this.quiz1 = quiz1;
    }

    public void setQuiz2(Quiz quiz2) {
        this.quiz2 = quiz2;
    }

    public void setQuiz3(Quiz quiz3) {
        this.quiz3 = quiz3;
    }

    public void setQuiz4(Quiz quiz4) {
        this.quiz4 = quiz4;
    }

    // heb liever dat de key van de hashmap de gallery is, maar weet niet hoe ik dat moet doen met de galleryID als een generated value
    public static HashMap<Integer, Question> setQuiz1(){
        HashMap<Integer, Question> quiz1 = new HashMap<>();
        quiz1.put(1, new Question("Wat is de naam van dit kunstwerk?", "De Schreeuw"));
        quiz1.put(2, new Question("Wat is de naam van dit kunstwerk?", "De Nachtwacht"));
        quiz1.put(3, new Question("Wat is de naam van dit kunstwerk?", "De Mona Lisa"));
        quiz1.put(4, new Question("Wat is de naam van dit kunstwerk?", "Het meisje met de parel"));
        quiz1.put(5, new Question("Wat is de naam van dit kunstwerk?", "De Sterrennacht"));
        quiz1.put(6, new Question("Wat is de naam van dit kunstwerk?", "Het Laatste Avondmaal"));
        quiz1.put(7, new Question("Wat is de naam van dit kunstwerk?", "Las Meninas"));
        quiz1.put(8, new Question("Wat is de naam van dit kunstwerk?", "Irissen"));
        quiz1.put(9, new Question("Wat is de naam van dit kunstwerk?", "De Kus"));
        quiz1.put(10, new Question("Wat is de naam van dit kunstwerk?", "De grote golf van Kanagawa"));
        return quiz1;
    }

    public static HashMap<Integer, Question> setQuiz2(){
        HashMap<Integer, Question> quiz2 = new HashMap<>();
        quiz2.put(1, new Question("Wat is de naam van dit kunstwerk?", "De Schreeuw"));
        quiz2.put(2, new Question("Wat is de naam van dit kunstwerk?", "De Nachtwacht"));
        quiz2.put(3, new Question("Wat is de naam van dit kunstwerk?", "De Mona Lisa"));
        quiz2.put(4, new Question("Wat is de naam van dit kunstwerk?", "Het meisje met de parel"));
        quiz2.put(5, new Question("Wat is de naam van dit kunstwerk?", "De Sterrennacht"));
        quiz2.put(6, new Question("Wat is de naam van dit kunstwerk?", "Het Laatste Avondmaal"));
        quiz2.put(7, new Question("Wat is de naam van dit kunstwerk?", "Las Meninas"));
        quiz2.put(8, new Question("Wat is de naam van dit kunstwerk?", "Irissen"));
        quiz2.put(9, new Question("Wat is de naam van dit kunstwerk?", "De Kus"));
        quiz2.put(10, new Question("Wat is de naam van dit kunstwerk?", "De grote golf van Kanagawa"));
        return quiz2;
    }

    public static HashMap<Integer, Question> setQuiz3(){
        HashMap<Integer, Question> quiz3 = new HashMap<>();
        quiz3.put(1, new Question("Wat is de naam van dit kunstwerk?", "De Schreeuw"));
        quiz3.put(2, new Question("Wat is de naam van dit kunstwerk?", "De Nachtwacht"));
        quiz3.put(3, new Question("Wat is de naam van dit kunstwerk?", "De Mona Lisa"));
        quiz3.put(4, new Question("Wat is de naam van dit kunstwerk?", "Het meisje met de parel"));
        quiz3.put(5, new Question("Wat is de naam van dit kunstwerk?", "De Sterrennacht"));
        quiz3.put(6, new Question("Wat is de naam van dit kunstwerk?", "Het Laatste Avondmaal"));
        quiz3.put(7, new Question("Wat is de naam van dit kunstwerk?", "Las Meninas"));
        quiz3.put(8, new Question("Wat is de naam van dit kunstwerk?", "Irissen"));
        quiz3.put(9, new Question("Wat is de naam van dit kunstwerk?", "De Kus"));
        quiz3.put(10, new Question("Wat is de naam van dit kunstwerk?", "De grote golf van Kanagawa"));
        return quiz3;
    }
    public static HashMap<Integer, Question> setQuiz4(){
        HashMap<Integer, Question> quiz4 = new HashMap<>();
        quiz4.put(1, new Question("Wat is de naam van dit kunstwerk?", "De Schreeuw"));
        quiz4.put(2, new Question("Wat is de naam van dit kunstwerk?", "De Nachtwacht"));
        quiz4.put(3, new Question("Wat is de naam van dit kunstwerk?", "De Mona Lisa"));
        quiz4.put(4, new Question("Wat is de naam van dit kunstwerk?", "Het meisje met de parel"));
        quiz4.put(5, new Question("Wat is de naam van dit kunstwerk?", "De Sterrennacht"));
        quiz4.put(6, new Question("Wat is de naam van dit kunstwerk?", "Het Laatste Avondmaal"));
        quiz4.put(7, new Question("Wat is de naam van dit kunstwerk?", "Las Meninas"));
        quiz4.put(8, new Question("Wat is de naam van dit kunstwerk?", "Irissen"));
        quiz4.put(9, new Question("Wat is de naam van dit kunstwerk?", "De Kus"));
        quiz4.put(10, new Question("Wat is de naam van dit kunstwerk?", "De grote golf van Kanagawa"));
        return quiz4;
    }

    Quiz quiz1 = new Quiz(setQuiz1());
    Quiz quiz2 = new Quiz(setQuiz2());
    Quiz quiz3 = new Quiz(setQuiz3());
    Quiz quiz4 = new Quiz(setQuiz4());


    /*

    zal implementeren als ik weet hoe ik de galleryID als key kan gebruiken

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

     */
}