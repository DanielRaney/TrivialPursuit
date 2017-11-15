
package trivialpursuit;

import java.awt.*;
import static trivialpursuit.TrivialPursuit.*;
import static trivialpursuit.Category.*;
import static trivialpursuit.Question.*;
import static trivialpursuit.Board.*;


public class Piece extends Player{
    private int x;
    private int y; 
    Piece(Color _color, int _x, int _y){
        super(_color);
        x = _x;
        y = _y;
    }
    public int getX() {
        return(x);
    }
    public int getY() {
        return(y);
    }
    public void moveX(int increment) {
        x += increment;
    }
    public void moveY(int increment) {
        y += increment;
    }
    public boolean getHasAll() {
        return(hasAll);
    }
    public void giveAll() {
        hasAll=true;
        hasOrange=true;
        hasRed=true;
        hasBlue=true;
        hasPurple=true;
        hasPink=true;
        hasGreen=true;
        hasAll=true;
    }

    
    public void draw(Graphics2D g,int xdelta,int ydelta) {
        g.setColor(getColor()); 
        g.fillOval(Window.getX(x*xdelta),Window.getY(y*ydelta),xdelta,ydelta);
        g.setColor(Color.BLACK);
        g.drawOval(Window.getX(x*xdelta),Window.getY(y*ydelta),xdelta,ydelta);
        

//        g.setColor(Color.white);
//        g.setFont(new Font("Arial",Font.PLAIN,30));
//        g.drawString("",Window.getX(column*xdelta)+30,Window.getY(row*ydelta)+40);       
        int angle = (360/6);
        g.setColor(Board.getI());
        if(hasOrange)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90, angle-10);
        g.setColor(Board.getII());
        if(hasRed)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90+angle*1, angle-10);
        g.setColor(Board.getIII());
        if(hasGreen)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10,90+angle*2, angle-10);
        g.setColor(Board.getIV());
        if( hasBlue)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90+angle*3, angle-10);
        g.setColor(Board.getV());
        if(hasPurple)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90+angle*4, angle-10);
        g.setColor(Board.getVI());
        if(hasPink)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90+angle*5, angle-10); 
    }
    
}