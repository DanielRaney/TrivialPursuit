
package trivialpursuit;

import java.awt.Color;

public class Category {
    public static final int NUM_CATEGORIES = 6;
    public static final int NUM_QUESTIONS = 6;
    public static Category categories[] = new Category[NUM_CATEGORIES];
    private Question questions[] = new Question[NUM_QUESTIONS];
    private String name;
    private Color color;
    public static enum Categories{
        
    }
}
