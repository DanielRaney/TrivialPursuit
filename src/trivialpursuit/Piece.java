
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
    }
    
}