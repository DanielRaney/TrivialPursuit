
package trivialpursuit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Piece {
    private Color color;
    
    Piece(Color _color)
    {
        color = _color;
        
    }
    public Color getColor()
    {
        return (color);
    }

    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {
        g.setColor(color); 
        g.fillOval(Window.getX(column*xdelta),Window.getY(row*ydelta),xdelta,ydelta);
        
//        g.setColor(Color.white);
//        g.setFont(new Font("Arial",Font.PLAIN,30));
//        g.drawString("",Window.getX(column*xdelta)+30,Window.getY(row*ydelta)+40);       
        int angle = (360/6);
        g.setColor(Color.GREEN);
        g.fillArc(Window.getX(column*xdelta)+5,  Window.getY(row*ydelta)+4, xdelta-10, ydelta-10, 90, angle-10);
        g.setColor(Color.yellow);
        g.fillArc(Window.getX(column*xdelta)+5,  Window.getY(row*ydelta)+4, xdelta-10, ydelta-10, 90+angle*1, angle-10);
        g.setColor(Color.magenta);
        g.fillArc(Window.getX(column*xdelta)+5,  Window.getY(row*ydelta)+4, xdelta-10, ydelta-10,90+angle*2, angle-10);
        g.setColor(Color.white);
        g.fillArc(Window.getX(column*xdelta)+5,  Window.getY(row*ydelta)+4, xdelta-10, ydelta-10, 90+angle*3, angle-10);
        g.setColor(Color.GRAY);
        g.fillArc(Window.getX(column*xdelta)+5,  Window.getY(row*ydelta)+4, xdelta-10, ydelta-10, 90+angle*4, angle-10);
        g.setColor(Color.CYAN);
        g.fillArc(Window.getX(column*xdelta)+5,  Window.getY(row*ydelta)+4, xdelta-10, ydelta-10, 90+angle*5, angle-10);


    }
    
}