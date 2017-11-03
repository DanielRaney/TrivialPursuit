
package trivialpursuit;

import java.awt.*;

public class Board {
    private final static int NUM_PIECES = 4;
    private final static int NUM_ROWS = 15;
    private final static int NUM_COLUMNS = 15; 
    private final static int WALL = 0;
    private final static int EPSI = 1;
    private final static int EPSII = 2;
    private final static int EPSIII = 3;
    private final static int EPSIV = 4;
    private final static int EPSV = 5;
    private final static int EPSVI = 6;
    private final static int ROLLAGAIN = 7;
    private static int RAND = (int)(Math.random()*7 + 1);
    
    private static Piece pieces[] = new Piece[NUM_PIECES];
    
    private static final Color I = new Color(215, 191, 100);
    private static final Color II = new Color(217, 98, 98);
    private static final Color III = new Color(112, 218, 97);
    private static final Color IV = new Color(96, 201, 219);
    private static final Color V = new Color(160, 95, 220);
    private static final Color VI = new Color(222, 92, 200);
            
    private static int board[][] = {

    {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
    {WALL,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,RAND,RAND,RAND,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,RAND,RAND,RAND,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,WALL},
    {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},   
    };
    
    
    public static void reset() {
        for(int i = 0; i<NUM_PIECES;i++) {
            int color = (int)(Math.random() * 3 +30);
            pieces[i] = new Piece(new Color(color,color,color),NUM_ROWS/2,NUM_COLUMNS/2);
        }
        for(int zx = 0; zx<NUM_ROWS;zx++) {
            for(int zy = 0; zy<NUM_COLUMNS;zy++) {
                if(board[zx][zy] != WALL) {
                    board[zx][zy] = (int)(Math.random() * 7 + 1);
                }
                if(zx > 0 && zy > 0 && zx < NUM_ROWS & zy < NUM_COLUMNS && board[zx][zy] != WALL) {
                    while(board[zx][zy] == board[zx-1][zy]) {
                        board[zx][zy] = (int)(Math.random() * 7 + 1);
                    }
                    while(board[zx][zy] == board[zx][zy-1]) {
                        board[zx][zy] = (int)(Math.random() * 7 + 1);
                    }
                }
            }
        }
        board[NUM_ROWS/2][NUM_COLUMNS/2] = ROLLAGAIN;
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
        for(int zx = 0; zx<NUM_ROWS;zx++) {
            for(int zy = 0; zy<NUM_COLUMNS;zy++) {  
                if(board[zx][zy] == WALL) { 
                    int color = (int)(Math.random() * 3 +30);
                    g.setColor(new Color(color,color,color));
                }
                else if(board[zx][zy] == EPSI) 
                    g.setColor(I);
                else if(board[zx][zy] == EPSII) 
                    g.setColor(II);
                else if(board[zx][zy] == EPSIII) 
                    g.setColor(III);
                else if(board[zx][zy] == EPSIV) 
                    g.setColor(IV);
                else if(board[zx][zy] == EPSV) 
                    g.setColor(V);
                else if(board[zx][zy] == EPSVI) 
                    g.setColor(VI);
                else if(board[zx][zy] == ROLLAGAIN) 
                    g.setColor(Color.WHITE);
                g.fillRect(Window.getX(zx * xdelta),Window.getY(zy * ydelta),xdelta,ydelta);
            }
        }
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta), Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        for(int zx = 0; zx<NUM_ROWS;zx++) {
            for(int zy = 0; zy<NUM_COLUMNS;zy++) {
                if(board[zx][zy] == WALL) 
                    g.setColor(Color.darkGray);
            }
        }
        for(int zp = 0; zp<NUM_PIECES; zp++) {
            pieces[zp].draw(g,xdelta,ydelta);
        }
        g.setColor(Color.black);
        g.drawRect(Window.getX(0), Window.getY(0), Window.getWidth2(), Window.getHeight2());
//Fill in below here
    }
}
