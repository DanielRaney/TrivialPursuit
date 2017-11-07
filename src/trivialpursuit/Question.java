
package trivialpursuit;

import java.awt.*;
import java.util.ArrayList;

public class Question {
    public static final int NUM_QUESTIONS = 10;
    public static final int NUM_ANSWERS = 3;
    public static ArrayList<Question> questions = new ArrayList<Question>();
    private Category category;
    private Difficulty difficulty;
    private String answers[] = new String[NUM_ANSWERS];  
    private String name;
    private Color color; 
    
    Question(){
        name = "";
        for(int i=0; i<NUM_ANSWERS;i++){
            answers[i]="";
        }
    }
    Question(String _name, String correctAnswer, String answer2, String answer3, Category _category, Difficulty _difficulty){
        name = _name;
        category = _category;
        difficulty = _difficulty;
        answers[0] = correctAnswer;
        answers[1] = answer2;
        answers[2] = answer3;
    }
    public static ArrayList<Question> getQuestions(){
        return questions;
    }
    public String getName(){
        return name;
    }
    public String[] getAnswers(){
        return answers;
    }
    public Category getCategory(){
        return category;
    }
    public Difficulty getDifficulty(){
        return difficulty;
    }
    public static void InstantiateQuestions(){
        Question ep1Q1 = new Question("How many blades does Darth Maul's lightsaber have?", "2", "1","3", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q1);
        
        Question ep1Q2 = new Question("Whos was the jedi that accompanied obi-wan at the meeting with the trade confederation?", "Qui Gon Jinn", "Lando Calrissian","Mace Windu", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q2);
        
        Question ep1Q3 = new Question("What did the jedi discover on the trade confederation ship?", "A droid army", "A clone army","plans to build a super weapon", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q3);
        
        Question ep1Q4 = new Question(" What planet did Obi-Wan and Qui-Gon Jinn land on after leaving the trade confederation ship?", "Naboo", "Tatooine","Hoth", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q4);
        
        Question ep1Q5 = new Question("How did Anakin pay for the Queen's ship's broken machinery?", "Pod race", "Shooting contest","Selling his belongings", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q5);
        
        Question ep1Q6 = new Question("Why didn't the jedi counsil let Anakin be trained to become a jedi?", "Too old", "He was too dumb","Wasn't rich", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q6);
        
        Question ep1Q7 = new Question("Which actress played Padme?", "Natalie Portman", "Charlize Theron","Daisy Ridley", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q7);
        
        Question ep1Q8 = new Question("In the final fight between the Jedi and the one sith, who get cut in half?", "Darth Maul", "Obi-Wan Kenobi","Qui Gon Jinn", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q8);
        
        Question ep1Q9 = new Question("When was Episode I: The Phantom Menace released?", "1999", "1998","2002", Category.EPISODEI, Difficulty.HARD);
        questions.add(ep1Q9);
        
        Question ep1Q10 = new Question("How did the planet of Naboo celebrate victory against the trade confederation?", "A parade", "There was no celebration","A big ball in the palace", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q10);
        ////////////////////////////////////////////////////EPISODE II///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep2Q1 = new Question("How did the bounty hunter first try to kill Padme?", "A bomb on her ship", "A blaster shot","a blade", Category.EPISODEII, Difficulty.HARD);
        questions.add(ep2Q1);
        
        Question ep2Q2 = new Question(" What was the bounty hunter's second attempt on Padme's life?", "Poisonous creature", "speeder crash","A rocket", Category.EPISODEII, Difficulty.MEDIUM);
        questions.add(ep2Q2);
        
        Question ep2Q3 = new Question("What planet did Obi-Wan visit to investigate the bounty hunter?", "Kamino", "Geonosis","Mustafar", Category.EPISODEII, Difficulty.HARD);
        questions.add(ep2Q3);
        
        Question ep2Q4 = new Question("What did Obi-Wan Kenobi find on Kamino?", "A secret clone army", "A droid factory","A hideout for smugglers", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q4);
        
        Question ep2Q5 = new Question("Which old jedi did Obi-Wan Kenobi discover created the clone army?", "Sifo Dyas", "Plo Koon","Yoda", Category.EPISODEII, Difficulty.HARD);
        questions.add(ep2Q5);
        
        Question ep2Q6 = new Question("Who are the clones cloned after?", "Jango Fett", "Count Dooku","Poe Dameron", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q6);
        
        Question ep2Q7 = new Question("Who does Obi-Wan fight when leaving Kamino?", "Jengo Fett", "General Grevious","Count Dooku", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q7);
        
        Question ep2Q8 = new Question("Where was the first battle of the Clone Wars?", "Geonosis", "Coruscant","Kashyyk", Category.EPISODEII, Difficulty.MEDIUM);
        questions.add(ep2Q8);
        
        Question ep2Q9 = new Question(" Who isn't chained up in the arena on Geonosis?", "Yoda", "Obi-wan","Padme", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q9);
        
        Question ep2Q10 = new Question("What happens to Anakin in the fight against Count Dooku?", "looses his arm", "switches to the dark side","Looses his leg", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q10);
        ////////////////////////////////////////////////////EPISODE III///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep3Q1 = new Question("Who are the Republic fighting?", "CIS", "Galactic Empire","The New Order", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q1);
        
        Question ep3Q2 = new Question("Who are Obi-Wan Kenobi and Anakin trying to save during the space battle?", "Senator Palpatine", "Mace Windu","Padme", Category.EPISODEIII, Difficulty.MEDIUM);
        questions.add(ep3Q2);
        
        Question ep3Q3 = new Question("What does Anakin do to Count Dooku?", "Beheads him", "lets him escape","Inprison him", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q3);
        
        Question ep3Q4 = new Question("How many light sabers does General Grievous have?", "4", "2","1", Category.EPISODEIII, Difficulty.MEDIUM);
        questions.add(ep3Q4);
       
        Question ep3Q5 = new Question("Where does Senator Palpatine tell the story of Darth Plagus to Anakin?", "an Opera", "while on a ship","a senate meeting", Category.EPISODEIII, Difficulty.HARD);
        questions.add(ep3Q5);
        
        Question ep3Q6 = new Question("Why is Anakin angry at the jedi counsil?", "They won't grant him the rank of master", "They won't let him join the counsil","They won't let him fight in the war", Category.EPISODEIII, Difficulty.MEDIUM);
        questions.add(ep3Q6);
        
        Question ep3Q7 = new Question("What does Anakin find out about Palpatine?", "He is the sith lord", "He is sick","He plans on quiting his job as senator", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q7);
        
        Question ep3Q8 = new Question("Who stops Mace Windu from killing the sith lord?", "Anakin", "Yoda","The droid army", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q8);
        
        Question ep3Q9 = new Question("What order does the sith lord execute to turn the clones against the jedi?", "order 66", "order 556","order 25", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q9);
        
        Question ep3Q10 = new Question("What planet does the final fight between Anakin and Obi-Wan take place?", "Mustafar", "Geonosis","Tatooine ", Category.EPISODEIII, Difficulty.HARD);
        questions.add(ep3Q10);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
  
    }
