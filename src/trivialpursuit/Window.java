
package trivialpursuit;
public class Window {
    public static int xsize = -1;
    public static int ysize = -1;
    
    static final int XBORDER = 65;
    static final int YBORDER = 65;
    static final int YTITLE = 25;
    static final int WINDOW_WIDTH = 881;
    static final int WINDOW_HEIGHT = 891;    
    public static int getX(int x) {
        return (x + XBORDER);
    }

    public static int getY(int y) {
        return (y + YBORDER + YTITLE);
    }
    public static int getYNormal(int y) {
        return (-y + YBORDER + YTITLE+getHeight2());
    }

    public static int getWidth2() {
        return (xsize - getX(0) - XBORDER);
    }

    public static int getHeight2() {
        return (ysize - getY(0) - YBORDER);
    }
}
