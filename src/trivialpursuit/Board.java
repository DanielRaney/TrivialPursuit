
package trivialpursuit;

import java.awt.*;
//Comment
//Hello World
public class Board {
    
    private final static int NUM_ROWS = 19;
    private final static int NUM_COLUMNS = 19; 
    
    public static void Reset() {
        
    }
    
    public static void addPiece(int x, int y) {
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        int zx = (x - Window.getX(0))/xdelta;
        int zy = (y-Window.getY(0))/ydelta;
    }
    
    
    public static void Draw(Graphics2D g) {
        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.darkGray);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.white);
        g.drawPolyline(x, y, 5);
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
//draw grid
        g.setColor(Color.white);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta), Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
//Fill in below here
        
        
    }
}
