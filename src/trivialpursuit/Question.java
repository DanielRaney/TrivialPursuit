
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
    private String theCorrectAnswer;
    
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
        theCorrectAnswer = correctAnswer;
    }
    public static ArrayList<Question> getQuestions(){
        return questions;
    }
    public String getName(){
        return name;
    }
    public String getCorrectAnswer(){
        return theCorrectAnswer;
    }
    public String getAnswers(int k){
        return answers[k];
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
        
        Question ep1Q2 = new Question("Who is Obi-Wan's master?", "Qui Gon Jinn", "Lando Calrissian","Mace Windu", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q2);
        
        Question ep1Q3 = new Question("The jedi discovered what on the confederate ship?", "A droid army", "A clone army","Plans to build a super weapon", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q3);
        
        Question ep1Q4 = new Question("What planet does Queen Amidala live on?", "Naboo", "Tatooine","Hoth", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q4);
        
        Question ep1Q5 = new Question("How did Anakin pay for the Queen's ship's broken machinery?", "Pod race", "Shooting contest","Selling his belongings", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q5);
        
        Question ep1Q6 = new Question("Why didn't the jedi counsil let Anakin be trained to become a jedi?", "Too old", "He was too dumb","Wasn't rich", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q6);
        
        Question ep1Q7 = new Question("Which actress played Padme?", "Natalie Portman", "Charlize Theron","Daisy Ridley", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q7);
        
        Question ep1Q8 = new Question("In the final fight, who got cut in half?", "Darth Maul", "Obi-Wan Kenobi","Qui Gon Jinn", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q8);
        
        Question ep1Q9 = new Question("When was Episode I: The Phantom Menace released?", "1999", "1998","2002", Category.EPISODEI, Difficulty.HARD);
        questions.add(ep1Q9);
        
        Question ep1Q10 = new Question("How did the planet of Naboo celebrate their victory?", "A parade", "There was no celebration","A big ball in the palace", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q10);
        ////////////////////////////////////////////////////EPISODE II///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep2Q1 = new Question("How did the bounty hunter first try to kill Padme?", "A bomb on her ship", "A blaster shot","A blade", Category.EPISODEII, Difficulty.HARD);
        questions.add(ep2Q1);
        
        Question ep2Q2 = new Question("How did the bounty hunter try to kill Padme again?", "Poisonous creature", "Speeder crash","A rocket", Category.EPISODEII, Difficulty.MEDIUM);
        questions.add(ep2Q2);
        
        Question ep2Q3 = new Question("What planet did Obi-Wan visit to investigate the bounty hunter?", "Kamino", "Geonosis","Mustafar", Category.EPISODEII, Difficulty.HARD);
        questions.add(ep2Q3);
        
        Question ep2Q4 = new Question("What did Obi-Wan Kenobi find on Kamino?", "A secret clone army", "A droid factory","A hideout for smugglers", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q4);
        
        Question ep2Q5 = new Question("Who created the clone army?", "Sifo Dyas", "Plo Koon","Yoda", Category.EPISODEII, Difficulty.HARD);
        questions.add(ep2Q5);
        
        Question ep2Q6 = new Question("Who are the clones cloned after?", "Jango Fett", "Count Dooku","Poe Dameron", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q6);
        
        Question ep2Q7 = new Question("Who does Obi-Wan fight when leaving Kamino?", "Jengo Fett", "General Grevious","Count Dooku", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q7);
        
        Question ep2Q8 = new Question("Where was the first battle of the Clone Wars?", "Geonosis", "Coruscant","Kashyyk", Category.EPISODEII, Difficulty.MEDIUM);
        questions.add(ep2Q8);
        
        Question ep2Q9 = new Question("Who isn't chained up in the arena on Geonosis?", "Yoda", "Obi-wan","Padme", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q9);
        
        Question ep2Q10 = new Question("What happens to Anakin in the fight against Count Dooku?", "Looses his arm", "He switches to the dark side","Looses his leg", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q10);
        ////////////////////////////////////////////////////EPISODE III///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep3Q1 = new Question("Who are the Republic fighting?", "CIS", "Galactic Empire","The New Order", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q1);
        
        Question ep3Q2 = new Question("Who is captured by a CIS ship?", "Senator Palpatine", "Mace Windu","Padme", Category.EPISODEIII, Difficulty.MEDIUM);
        questions.add(ep3Q2);
        
        Question ep3Q3 = new Question("What does Anakin do to Count Dooku?", "Beheads him", "Lets him escape","Inprison him", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q3);
        
        Question ep3Q4 = new Question("How many light sabers does General Grievous have?", "4", "2","1", Category.EPISODEIII, Difficulty.MEDIUM);
        questions.add(ep3Q4);
       
        Question ep3Q5 = new Question("Palpatine tells the story of Darth Plagus at...?", "An Opera", "A ship","A senate meeting", Category.EPISODEIII, Difficulty.HARD);
        questions.add(ep3Q5);
        
        Question ep3Q6 = new Question("Why is Anakin angry at the jedi counsil?", "They won't grant him the rank of master", "They won't let him join the counsil","They won't let him fight in the war", Category.EPISODEIII, Difficulty.MEDIUM);
        questions.add(ep3Q6);
        
        Question ep3Q7 = new Question("What does Anakin find out about Palpatine?", "He is the sith lord", "He is sick","He plans on quiting his job as senator", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q7);
        
        Question ep3Q8 = new Question("Who stops Mace Windu from killing the sith lord?", "Anakin", "Yoda","The droid army", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q8);
        
        Question ep3Q9 = new Question("What order does the sith lord execute to turn the clones against the jedi?", "Order 66", "Order 556","Order 25", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q9);
        
        Question ep3Q10 = new Question("Where do Anakin and Obi-Wan fight?", "Mustafar", "Geonosis","Tatooine ", Category.EPISODEIII, Difficulty.HARD);
        questions.add(ep3Q10);
        

        ////////////////////////////////////////////////////EPISODE IV///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep4Q1 = new Question("What droid does Princess Leia record her message?", "R2D2", "R2D4","C3PO", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q1);
        
        Question ep4Q2 = new Question("What planet does Luke live on?", "Tatooine", "Kashykk","Naboo", Category.EPISODEIV, Difficulty.EASY);
        questions.add(ep4Q2);
        
        Question ep4Q3 = new Question("Who is Princess Leia's 'only hope'?", "Obi-Wan Kenobi", "Luke Skywalker","Yoda", Category.EPISODEIV, Difficulty.EASY);
        questions.add(ep4Q3);
        
        Question ep4Q4 = new Question("What does Obi-Wan Kenobi give Luke?", "His lightsaber", "His droid","His land", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q4);
        
        Question ep4Q5 = new Question("Who kills Luke's aunt and uncle?", "Stormtroopers", "Sand people","Bounty hunters", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q5);
        
        Question ep4Q6 = new Question("Who does Obi-Wan hire to take them to Alderon?", "Han Solo", "Boba Fett","Princess Leia", Category.EPISODEIV, Difficulty.EASY);
        questions.add(ep4Q6);
        
        Question ep4Q7 = new Question("Who dies from Darth Vader in the death star?", "Obi-Wan", "Chewbaca","Boba Fett", Category.EPISODEIV, Difficulty.EASY);
        questions.add(ep4Q7);
        
        Question ep4Q8 = new Question("What is the name of Han Solo's ship", "The Millennium Falcon", "Slave I","The Inercepter", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q8);
        
        Question ep4Q9 = new Question("What planet is the secret rebel base located?", "Yavin-4", "Dantooine","Alderan", Category.EPISODEIV, Difficulty.HARD);
        questions.add(ep4Q9);
        
        Question ep4Q10 = new Question("Who destroys the death star?", "Luke SkyWalker", "Poe Dameron","Han Solo", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q10);
        ////////////////////////////////////////////////////EPISODE V ///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep5Q1 = new Question("What planet is the new rebel base on?", "Hoth", "Scarif","Tatooine", Category.EPISODEV, Difficulty.EASY);
        questions.add(ep5Q1);
        
        Question ep5Q2 = new Question("What Imperial machines are present in the Battle of Hoth", "AT-AT", "AD-ST","ST-AA", Category.EPISODEV, Difficulty.HARD);
        questions.add(ep5Q2);
        
        Question ep5Q3 = new Question("Who does ghost Obi-Wan tell Luke to visit?", "Yoda", "Mace Windu","Lando Calrissian", Category.EPISODEV, Difficulty.MEDIUM);
        questions.add(ep5Q3);
        
        Question ep5Q4 = new Question("Where is Yoda?", "Dagobah", "Coruscant","Mustafar", Category.EPISODEV, Difficulty.HARD);
        questions.add(ep5Q4);
        
        Question ep5Q5 = new Question("Where do Han Solo, Chewy, and the rest of the group go?", "Cloud City", "Naboo","Mos Eisley", Category.EPISODEV, Difficulty.HARD);
        questions.add(ep5Q5);
       
        Question ep5Q6 = new Question("Why does Luke go to Yoda?", "To be trained", "To claim a reward","To be told important information", Category.EPISODEV, Difficulty.MEDIUM);
        questions.add(ep5Q6);
        
        Question ep5Q7 = new Question("What information is told to Darth Vader by the Emperor?", "He has living offspring", "The rebels escaped","There is a traitor", Category.EPISODEV, Difficulty.MEDIUM);
        questions.add(ep5Q7);
        
        Question ep5Q8 = new Question("Who is captured by Boba Fett", "Han Solo", "Chewbaca","Luke", Category.EPISODEV, Difficulty.EASY);
        questions.add(ep5Q8);
        
        Question ep5Q9 = new Question("What limb is lost by luke", "Right hand", "Left hand","Right foot", Category.EPISODEV, Difficulty.HARD);
        questions.add(ep5Q9);
        
        Question ep5Q10 = new Question("Who voiced Darth Vader", "James Earl Jones", "Tommy Lee Jones","Liam Nesson", Category.EPISODEV, Difficulty.HARD);
        questions.add(ep5Q10);
 
        
        ////////////////////////////////////////////////////EPISODE VI ///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep6Q1 = new Question("What planet does Jabba the Hut live on?", "Tatooine", "Naboo","Endor", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q1);
        
        Question ep6Q2 = new Question("What color is Luke's lightsaber?", "Green", "Blue","Yellow", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q2);
        
        Question ep6Q3 = new Question("Who kills Jabba the Hut?", "Leia", "Luke","Lando", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q3);
        
        Question ep6Q4 = new Question("How old is Yoda when he dies?", "900", "110","500", Category.EPISODEVI, Difficulty.HARD);
        questions.add(ep6Q4);
        
        Question ep6Q5 = new Question("Where is the shield generator for the new death star?", "Endor", "Kashyyk","Mustafar", Category.EPISODEVI, Difficulty.HARD);
        questions.add(ep6Q5);
        
        Question ep6Q6 = new Question("What creatures help the rebels on Endor?", "Ewoks", "Wookies","Gungans", Category.EPISODEVI, Difficulty.HARD);
        questions.add(ep6Q6);
        
        Question ep6Q7 = new Question("Who does Luke fight on the new death star?", "Darth Vader", "The Emperor","Boba Fett", Category.EPISODEVI, Difficulty.MEDIUM);
        questions.add(ep6Q7);
        
        Question ep6Q8 = new Question("Who destroys the new death star?", "Lando", "Luke","Han", Category.EPISODEVI, Difficulty.MEDIUM);
        questions.add(ep6Q8);
        
        Question ep6Q9 = new Question("Who does Darth Vader kill on the death star?", "The Emperor", "Luke","Leia", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q9);
        
        Question ep6Q10 = new Question("How is Darth Vader's body disposed?", "By fire", "buried","Released in space", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q10);


    }
  
    }
