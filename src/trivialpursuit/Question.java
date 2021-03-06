
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
    private int randomIndex0;
    private int randomIndex1;
    private int randomIndex2; 
    
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
        while(randomIndex0 == randomIndex1 || randomIndex0 == randomIndex2 || randomIndex1 == randomIndex2){
            randomIndex0= (int)(Math.random() * 3);
            randomIndex1= (int)(Math.random() * 3);
            randomIndex2= (int)(Math.random() * 3);
            answers[randomIndex0] = correctAnswer;
            answers[randomIndex1] = answer2;
            answers[randomIndex2] = answer3;
        }
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
        
        Question ep1Q5 = new Question("How did Anakin pay for the ship's broken machinery?", "Pod race", "Shooting contest","Selling his belongings", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q5);
        
        Question ep1Q6 = new Question("Why didn't the jedi let Anakin become a jedi?", "Too old", "He was too dumb","Wasn't rich", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q6);
        
        Question ep1Q7 = new Question("Which actress played Padme?", "Natalie Portman", "Charlize Theron","Daisy Ridley", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q7);
        
        Question ep1Q8 = new Question("In the final fight, who got cut in half?", "Darth Maul", "Obi-Wan Kenobi","Qui Gon Jinn", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q8);
        
        Question ep1Q9 = new Question("When was Episode I: The Phantom Menace released?", "1999", "1987","2006", Category.EPISODEI, Difficulty.HARD);
        questions.add(ep1Q9);
        
        Question ep1Q10 = new Question("How did the planet of Naboo celebrate their victory?", "A parade", "There was no celebration","A big ball in the palace", Category.EPISODEI, Difficulty.MEDIUM);
        questions.add(ep1Q10);
        
//        Question ep1Q11 = new Question("How many lines did Darth Maul speak?", "3", "2","1", Category.EPISODEI, Difficulty.HARD);
//        questions.add(ep1Q11);
//        
//        Question ep1Q12 = new Question("What was the budget for The Phantom menace?", "$115,000,000", "112,000,000","100,000,000", Category.EPISODEI, Difficulty.HARD);
//        questions.add(ep1Q12);
        ////////////////////////////////////////////////////EPISODE II///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep2Q1 = new Question("How did the bounty hunter first try to kill Padme?", "A bomb on her ship", "A blaster shot","A blade", Category.EPISODEII, Difficulty.HARD);
        questions.add(ep2Q1);
        
        Question ep2Q2 = new Question("How did the bounty hunter try to kill Padme again?", "Poisonous creature", "Speeder crash","A rocket", Category.EPISODEII, Difficulty.MEDIUM);
        questions.add(ep2Q2);
        
        Question ep2Q3 = new Question("Where did Obi-Wan visit to investigate the bounty hunter?", "Kamino", "Geonosis","Mustafar", Category.EPISODEII, Difficulty.HARD);
        questions.add(ep2Q3);
        
        Question ep2Q4 = new Question("What did Obi-Wan Kenobi find on Kamino?", "A secret clone army", "A droid factory","A hideout for smugglers", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q4);
        
        Question ep2Q5 = new Question("Who created the clone army?", "Sifo Dyas", "Plo Koon","Yoda", Category.EPISODEII, Difficulty.HARD);
        questions.add(ep2Q5);
        
        Question ep2Q6 = new Question("Who is Mr. Yee's favorite character?", "Yoda", "Himself","Darth Vader", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q6);
        
        Question ep2Q7 = new Question("Who does Obi-Wan fight when leaving Kamino?", "Jengo Fett", "General Grevious","Count Dooku", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q7);
        
        Question ep2Q8 = new Question("Where was the first battle of the Clone Wars?", "Geonosis", "Coruscant","Kashyyk", Category.EPISODEII, Difficulty.MEDIUM);
        questions.add(ep2Q8);
        
        Question ep2Q9 = new Question("Who isn't chained up in the arena on Geonosis?", "Yoda", "Obi-wan","Padme", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q9);
        
        Question ep2Q10 = new Question("What happens to Anakin in the fight against Count Dooku?", "Looses his arm", "He switches to the dark side","Looses his leg", Category.EPISODEII, Difficulty.EASY);
        questions.add(ep2Q10);
        
//        Question ep2Q11 = new Question("When was this movie released?", "2002", "2004","2001", Category.EPISODEII, Difficulty.MEDIUM);
//        questions.add(ep2Q11);
//        
//        Question ep2Q12 = new Question("How much did the movie make on opening weekend in the US?", "$80,027,814 ", "$125,068,815","$85,251,265", Category.EPISODEII, Difficulty.MEDIUM);
//        questions.add(ep2Q12);
        ////////////////////////////////////////////////////EPISODE III///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep3Q1 = new Question("Who does Mr. Yee dress as for Halloween?", "Yoda", "Noone","His daughter", Category.EPISODEIII, Difficulty.EASY);
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
        
        Question ep3Q9 = new Question("What order turns the clones against the jedi?", "Order 66", "Order 556","Order 25", Category.EPISODEIII, Difficulty.EASY);
        questions.add(ep3Q9);
        
        Question ep3Q10 = new Question("Where do Anakin and Obi-Wan fight each other?", "Mustafar", "Geonosis","Tatooine ", Category.EPISODEIII, Difficulty.HARD);
        questions.add(ep3Q10);
        
//        Question ep3Q11 = new Question("How many costumes were created for the clone troopers?", "0", "200","350 ", Category.EPISODEIII, Difficulty.HARD);
//        questions.add(ep3Q11);
//        
//        Question ep3Q12 = new Question("How many lines did Count Dooku speak in Episode III?", "4", "27","31 ", Category.EPISODEIII, Difficulty.HARD);
//        questions.add(ep3Q12);
//        
//        Question ep3Q13 = new Question("How many minuets is General Grievous on screen?", "6", "8","13 ", Category.EPISODEIII, Difficulty.HARD);
//        questions.add(ep3Q13);
//        
//        Question ep3Q14 = new Question("How many minuets is General Grievous on screen?", "6", "8","13 ", Category.EPISODEIII, Difficulty.HARD);
//        questions.add(ep3Q14);
        ////////////////////////////////////////////////////EPISODE IV///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep4Q1 = new Question("What droid does Princess Leia record her message?", "R2D2", "R2D4","C3PO", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q1);
        
        Question ep4Q2 = new Question("What planet does Luke live on?", "Tatooine", "Kashykk","Naboo", Category.EPISODEIV, Difficulty.EASY);
        questions.add(ep4Q2);
        
        Question ep4Q3 = new Question("Who is Princess Leia's 'only hope'?", "Obi-Wan Kenobi", "Luke Skywalker","Yoda", Category.EPISODEIV, Difficulty.EASY);
        questions.add(ep4Q3);
        
        Question ep4Q4 = new Question("What does Obi-Wan Kenobi give Luke?", "A lightsaber", "His droid","His land", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q4);
        
        Question ep4Q5 = new Question("Who kills Luke's aunt and uncle?", "Stormtroopers", "Sand people","Bounty hunters", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q5);
        
        Question ep4Q6 = new Question("Who does Obi-Wan hire to take them to Alderon?", "Han Solo", "Boba Fett","Princess Leia", Category.EPISODEIV, Difficulty.EASY);
        questions.add(ep4Q6);
        
        Question ep4Q7 = new Question("Who dies from Darth Vader in the death star?", "Obi-Wan", "Chewbaca","Boba Fett", Category.EPISODEIV, Difficulty.EASY);
        questions.add(ep4Q7);
        
        Question ep4Q8 = new Question("What is the name of Han Solo's ship?", "The Millennium Falcon", "Slave I","The Inercepter", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q8);
        
        Question ep4Q9 = new Question("What planet is the secret rebel base located?", "Yavin-4", "Dantooine","Alderan", Category.EPISODEIV, Difficulty.HARD);
        questions.add(ep4Q9);
        
        Question ep4Q10 = new Question("Who destroys the Death Star?", "Luke SkyWalker", "Poe Dameron","Han Solo", Category.EPISODEIV, Difficulty.MEDIUM);
        questions.add(ep4Q10);
        
//        Question ep4Q11 = new Question("When was the first star wars released?", "1977", "1979","1976", Category.EPISODEIV, Difficulty.MEDIUM);
//        questions.add(ep4Q11);
//        
//        Question ep4Q12 = new Question("Who shot first?", "Han", "Greedo","They shot at the same time", Category.EPISODEIV, Difficulty.HARD);
//        questions.add(ep4Q12);
//        
//        Question ep4Q13 = new Question("Which friend of George Lucas inspired the character Han Solo?", "Francis Ford Coppola", "Steven Spielberg","Stanley Kubrick", Category.EPISODEIV, Difficulty.HARD);
//        questions.add(ep4Q13);
//        
//        Question ep4Q14 = new Question("How much was Harrison Ford paid a week?", "$1,000", "$500","$1,200", Category.EPISODEIV, Difficulty.HARD);
//        questions.add(ep4Q14);
//        
//        Question ep4Q15 = new Question("How many minutes of screen time does Darth Vader have?", "12", "31","$26", Category.EPISODEIV, Difficulty.HARD);
//        questions.add(ep4Q15);
        ////////////////////////////////////////////////////EPISODE V ///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep5Q1 = new Question("What planet is the new rebel base on?", "Hoth", "Scarif","Tatooine", Category.EPISODEV, Difficulty.EASY);
        questions.add(ep5Q1);
        
        Question ep5Q2 = new Question("What Imperial machines are present in the Battle of Hoth", "AT-AT", "AD-ST","ST-AA", Category.EPISODEV, Difficulty.HARD);
        questions.add(ep5Q2);
        
        Question ep5Q3 = new Question("Who does ghost Obi-Wan tell Luke to visit?", "Yoda", "Mace Windu","Lando Calrissian", Category.EPISODEV, Difficulty.MEDIUM);
        questions.add(ep5Q3);
        
        Question ep5Q4 = new Question("Where is Yoda living?", "Dagobah", "Coruscant","Mustafar", Category.EPISODEV, Difficulty.HARD);
        questions.add(ep5Q4);
        
        Question ep5Q5 = new Question("Where do Han Solo, Chewy, and the rest of the group go?", "Cloud City", "Naboo","Mos Eisley", Category.EPISODEV, Difficulty.HARD);
        questions.add(ep5Q5);
       
        Question ep5Q6 = new Question("Why does Luke go to Yoda?", "To be trained", "To claim a reward","To be told important information", Category.EPISODEV, Difficulty.MEDIUM);
        questions.add(ep5Q6);
        
        Question ep5Q7 = new Question("What information is told to Darth Vader by the Emperor?", "He has living offspring", "The rebels escaped","There is a traitor", Category.EPISODEV, Difficulty.MEDIUM);
        questions.add(ep5Q7);
        
        Question ep5Q8 = new Question("Who is captured by Boba Fett?", "Han Solo", "Chewbaca","Luke", Category.EPISODEV, Difficulty.EASY);
        questions.add(ep5Q8);
        
        Question ep5Q9 = new Question("What limb is lost by Luke?", "Right hand", "Left hand","Right foot", Category.EPISODEV, Difficulty.MEDIUM);
        questions.add(ep5Q9);
        
        Question ep5Q10 = new Question("Who voiced Darth Vader?", "James Earl Jones", "Tommy Lee Jones","Liam Nesson", Category.EPISODEV, Difficulty.MEDIUM);
        questions.add(ep5Q10);
 
//        Question ep5Q11 = new Question("Who voiced Yoda", "Frank Oz", "Jim Henson","Peter Mayhew", Category.EPISODEV, Difficulty.MEDIUM);
//        questions.add(ep5Q11);
//        
//        Question ep5Q12 = new Question("How many sets were constructed for this film?", "64", "54","87", Category.EPISODEV, Difficulty.HARD);
//        questions.add(ep5Q12);
//        
//        Question ep5Q13 = new Question("Who got bitten by a snake on set?", "Mark Hamill", "George Lucas","Billy-Dee Williams", Category.EPISODEV, Difficulty.HARD);
//        questions.add(ep5Q13);
//        
//        Question ep5Q14 = new Question("Which actor wanted to have their character killed?", "Harrison Ford", "Carrie Fisher","Billy Dee Williams", Category.EPISODEV, Difficulty.EASY);
//        questions.add(ep5Q14);
//        
//        Question ep5Q15 = new Question("How many lines does Boba Fett have?", "5", "8","14", Category.EPISODEV, Difficulty.HARD);
//        questions.add(ep5Q15);
        ////////////////////////////////////////////////////EPISODE VI ///////////////////////////////////////////////////////////////////////////////////////
        
        Question ep6Q1 = new Question("What planet does Jabba the Hut live on?", "Tatooine", "Naboo","Endor", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q1);
        
        Question ep6Q2 = new Question("What color is Luke's lightsaber?", "Green", "Blue","Yellow", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q2);
        
        Question ep6Q3 = new Question("Who kills Jabba the Hut?", "Leia", "Luke","Lando", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q3);
        
        Question ep6Q4 = new Question("How old is Yoda when he dies?", "900", "110","500", Category.EPISODEVI, Difficulty.HARD);
        questions.add(ep6Q4);
        
        Question ep6Q5 = new Question("Where is the shield generator for the new Death Star?", "Endor", "Kashyyk","Mustafar", Category.EPISODEVI, Difficulty.HARD);
        questions.add(ep6Q5);
        
        Question ep6Q6 = new Question("What creatures help the rebels on Endor?", "Ewoks", "Wookies","Gungans", Category.EPISODEVI, Difficulty.HARD);
        questions.add(ep6Q6);
        
        Question ep6Q7 = new Question("Who does Luke fight on the new Death Star?", "Darth Vader", "The Emperor","Boba Fett", Category.EPISODEVI, Difficulty.MEDIUM);
        questions.add(ep6Q7);
        
        Question ep6Q8 = new Question("Who destroys the new death star?", "Lando", "Luke","Han", Category.EPISODEVI, Difficulty.MEDIUM);
        questions.add(ep6Q8);
        
        Question ep6Q9 = new Question("Who does Darth Vader kill on the Death Star?", "The Emperor", "Luke","Leia", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q9);
        
        Question ep6Q10 = new Question("How is Darth Vader's body disposed?", "By fire", "Buried","Released in space", Category.EPISODEVI, Difficulty.EASY);
        questions.add(ep6Q10);
        
//        Question ep6Q11 = new Question("Only Star Wars to not have...", "A blue lightsaber", "Obi-Wan","Space battle", Category.EPISODEVI, Difficulty.HARD);
//        questions.add(ep6Q11);
//        
//        Question ep6Q12 = new Question("What brand new lightsaber color was introduced?", "Green", "Yellow","Purple", Category.EPISODEVI, Difficulty.EASY);
//        questions.add(ep6Q12);
//
//        Question ep6Q13 = new Question("What is revealed to be Darth Vader's name?", "Anakin", "Rex","Ric", Category.EPISODEVI, Difficulty.EASY);
//        questions.add(ep6Q13);
//        
//        Question ep6Q14 = new Question("What is th MPAA rating for this film?", "PG", "G","PG-13", Category.EPISODEVI, Difficulty.EASY);
//        questions.add(ep6Q14);
//        
//        Question ep6Q15 = new Question("Who composed the score for the movie?", "John Williams", "Hans Zimmer","Howard Shore", Category.EPISODEVI, Difficulty.EASY);
//        questions.add(ep6Q15);
    }
  
    }
