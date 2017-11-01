
package trivialpursuit;

import java.awt.*;

public class Question {
    public static final int NUM_QUESTIONS = 10;
    public static final int NUM_ANSWERS = 3;
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
    Question(String _name, Category _category){
        name = _name;
        category = _category;
        for(int i=0; i<NUM_ANSWERS;i++){
            answers[i]="";
        }
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
    
    
}
