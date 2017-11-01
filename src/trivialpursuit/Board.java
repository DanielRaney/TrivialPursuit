
package trivialpursuit;

import java.awt.*;
//Comment
//Hello World
public class Board {
    
    private final static int NUM_ROWS = 15;
    private final static int NUM_COLUMNS = 15; 
    int WALL = 1;
    int PATH = 0;
    int SECP = 3;
    int board1[][] = {
    {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
    {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL,WALL},
    {WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,PATH,WALL,WALL},
    {WALL,PATH,PATH,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,PATH,PATH,PATH},
    {WALL,PATH,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
    {WALL,PATH,WALL,PATH,WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH},
    {WALL,PATH,WALL,PATH,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,PATH},
    {WALL,PATH,WALL,PATH,WALL,WALL,WALL,WALL,WALL,PATH,PATH,PATH,PATH,PATH},
    {WALL,PATH,WALL,PATH,PATH,PATH,PATH,PATH,WALL,PATH,WALL,WALL,WALL,WALL},
    {WALL,PATH,WALL,PATH,WALL,PATH,WALL,PATH,WALL,PATH,WALL,WALL,WALL,WALL},
    {WALL,PATH,WALL,PATH,WALL,PATH,WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH},
    {WALL,PATH,WALL,PATH,WALL,PATH,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL},
    {WALL,PATH,WALL,PATH,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
    {WALL,PATH,WALL,PATH,WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH},
    {WALL,PATH,WALL,PATH,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},   
    };
    
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
        for(int zx = 0; zx<NUM_ROWS;zx++) {
            for(int zy = 0; zy<NUM_COLUMNS;zy++) {
                /*if(board[zx][zy] == WALL) {
                g.filloval()
                }*/
            }
        }
    }
}
