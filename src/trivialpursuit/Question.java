
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
    Question(String _name, String answer1, String answer2, String answer3, Category _category, Difficulty _difficulty){
        name = _name;
        category = _category;
        difficulty = _difficulty;
        answers[0] = answer1;
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
        Question ep1Q1 = new Question("How many blades does Darth Maul's lightsaber have?", "1", "2","3", Category.EPISODEI, Difficulty.EASY);
        questions.add(ep1Q1);
    }
    
    
}
