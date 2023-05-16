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
        quiz1.put(1, new Question("Wat was het eerste populaire bouwspeelgoed dat in 1932 werd gemaakt?", "Lego"));
        quiz1.put(2, new Question("Welk speelgoed bestaat uit een cilindrische buis waarmee verschillende vormen en patronen kunnen worden gemaakt?", "Etch A Sketch"));
        quiz1.put(3, new Question("Welke iconische pop werd geïntroduceerd door Mattel in 1959?", "Barbie"));
        quiz1.put(4, new Question("Hoe heet het speelgoed dat bestaat uit kleurrijke plastic bouwstenen?", "Playmobil"));
        quiz1.put(5, new Question("Welk bordspel gaat over het navigeren door snoepthema-paden om het Candy Castle te bereiken?", "Candy Land"));
        quiz1.put(6, new Question("Hoe heet de populaire programmeerbare speelgoedrobot die verschillende taken kan uitvoeren?", "Cozmo"));
        quiz1.put(7, new Question("Welke pluchen speelgoed werd wereldwijd een fenomeen en had zijn eigen mobiele app-spel?", "Angry Birds"));
        quiz1.put(8, new Question("Hoe heet het draagbare elektronische spelapparaat dat in 1989 door Nintendo werd uitgebracht?", "Game Boy"));
        quiz1.put(9, new Question("Welk merk speelgoedauto staat bekend om zijn gegoten voertuigen en banen?", "Hot Wheels"));
        quiz1.put(10, new Question("Hoe heet de klassieke puzzelkubus met gekleurde vlakken?", "Rubik's Cube"));
        return quiz1;
    }

    public static HashMap<Integer, Question> setQuiz2(){
        HashMap<Integer, Question> quiz2 = new HashMap<>();
        quiz2.put(1, new Question("Welk speelgoed bestaat uit kleine verzamelbare figuurtjes verpakt in een verrassingsbal?", "L.O.L. Surprise!"));
        quiz2.put(2, new Question("Hoe heet het speelgoed dat bestaat uit dierenfiguren met grote ogen en zachte vacht?", "Ty Beanie Boo's"));
        quiz2.put(3, new Question("Welk speelgoed bestaat uit kleine plastic poppetjes die je kunt verzamelen en ruilen?", "Pokémon-kaarten"));
        quiz2.put(4, new Question("Welke speelgoedlijn bestaat uit verschillende kleine figuurtjes met voertuigen en speelsets?", "Paw Patrol"));
        quiz2.put(5, new Question("Hoe heet het speelgoed waarmee je kunt bouwen en ontwerpen met magnetische staafjes en bollen?", "Magformers"));
        quiz2.put(6, new Question("Wat is de naam van de populaire knuffelbeer die kinderen kunnen personaliseren met verschillende outfits en accessoires?", "Build-A-Bear"));
        quiz2.put(7, new Question("Welk speelgoed bestaat uit kleurrijke plastic ringen die op elkaar gestapeld kunnen worden?", "Stacking Rings"));
        quiz2.put(8, new Question("Welk speelgoed is een speelset met kleine plastic figuurtjes die je kunt verzamelen en ruilen?", "Shopkins"));
        quiz2.put(9, new Question("Hoe heet het speelgoed dat bestaat uit kleine diertjes die je kunt verzamelen en ze hebben magnetische voeten?", "Sylvanian Families"));
        quiz2.put(10, new Question("Welke speelgoedlijn bestaat uit kleine figuurtjes die je kunt verzamelen en ze hebben een geur?", "Num Noms"));
        return quiz2;
    }

    public static HashMap<Integer, Question> setQuiz3(){
        HashMap<Integer, Question> quiz3 = new HashMap<>();
        quiz3.put(1, new Question("Wat is de naam van het populaire speelgoed dat bestaat uit kleine plastic figuurtjes met grote ogen?", "Littlest Pet Shop"));
        quiz3.put(2, new Question("Welk speelgoed bestaat uit kleine voertuigen met verschillende thema's, zoals auto's, treinen en vliegtuigen?", "Matchbox"));
        quiz3.put(3, new Question("Hoe heet het speelgoed dat bestaat uit kleine plastic bouwstenen die je kunt stapelen en bouwen?", "Duplo"));
        quiz3.put(4, new Question("Welke speelgoedlijn bestaat uit verschillende verzamelbare figuren gebaseerd op een bekende filmserie?", "Star Wars Action Figures"));
        quiz3.put(5, new Question("Wat is de naam van de populaire speelgoedauto's met realistische details en verschillende modellen?", "Hot Wheels"));
        quiz3.put(6, new Question("Welk speelgoed bestaat uit kleine plastic dierenfiguren die je kunt verzamelen en ruilen?", "Schleich-dieren"));
        quiz3.put(7, new Question("Hoe heet het speelgoed waarmee je zandkastelen en sculpturen kunt maken?", "Zandbak en zandspeelgoed"));
        quiz3.put(8, new Question("Welke speelgoedlijn bestaat uit kleine figuurtjes met verschillende beroepen en accessoires?", "Playmobil"));
        quiz3.put(9, new Question("Wat is de naam van het speelgoed dat bestaat uit een interactieve knuffelbeer die kan praten en spelletjes kan spelen?", "FurReal Friends"));
        quiz3.put(10, new Question("Welk speelgoed bestaat uit kleine plastic bouwstenen die je kunt gebruiken om gedetailleerde modellen te bouwen?", "LEGO Technic"));
        return quiz3;
    }
    public static HashMap<Integer, Question> setQuiz4(){
        HashMap<Integer, Question> quiz4 = new HashMap<>();
        quiz4.put(1, new Question("Wat is de naam van het speelgoed dat bestaat uit kleine plastic figuurtjes met grote hoofden en lichamen?", "Bobbleheads"));
        quiz4.put(2, new Question("Welk speelgoed is een speelset met kleine plastic diertjes en accessoires?", "Littlest Pet Shop"));
        quiz4.put(3, new Question("Hoe heet het speelgoed dat bestaat uit kleine metalen autootjes met verschillende ontwerpen?", "Matchbox"));
        quiz4.put(4, new Question("Welke speelgoedlijn bestaat uit kleine figuurtjes gebaseerd op een bekende tekenfilmserie over ninja's?", "LEGO Ninjago"));
        quiz4.put(5, new Question("Wat is de naam van het speelgoed waarmee je verschillende geluiden kunt maken door op gekleurde knoppen te drukken?", "Bontempi Keyboard"));
        quiz4.put(6, new Question("Welk speelgoed is een speelset met kleine plastic poppetjes die je kunt verzamelen en ruilen?", "Shopkins"));
        quiz4.put(7, new Question("Hoe heet het speelgoed dat bestaat uit kleine plastic dierenfiguren met magnetische voeten?", "Sylvanian Families"));
        quiz4.put(8, new Question("Welke speelgoedlijn bestaat uit kleine figuurtjes met een geur en ze kunnen op elkaar gestapeld worden?", "Num Noms"));
        quiz4.put(9, new Question("Wat is de naam van het speelgoed dat bestaat uit kleine plastic figuurtjes met grote ogen en schattige outfits?", "Lalaloopsy"));
        quiz4.put(10, new Question("Welk speelgoed is een speelset met kleine plastic boerderijdieren en accessoires?", "Schleich Farm World"));
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