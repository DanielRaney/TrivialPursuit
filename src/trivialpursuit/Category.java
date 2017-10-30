
package trivialpursuit;

import java.awt.Color;

public class Category {
    public static int useless = 1000000000;
    public static final int NUM_CATEGORIES = 6;
    public static Category categories[] = new Category[NUM_CATEGORIES];
    private String name;
    private Color color;
    public static enum Categories{
        STARWARS, INDIANA
    }
}
