
package trivialpursuit;

import java.awt.*;

public class Question {
    public static final int NUM_QUESTIONS = 10;
    public static final int NUM_ANSWERS = 3;
    private Category category;
    private Answer answers[] = new Answer[NUM_ANSWERS];  //change to answers
    private String name;
    private Color color; 
    
    Question(){
        name = "";
    }
    Question(String _name, Category _category){
        
    }

    
}
