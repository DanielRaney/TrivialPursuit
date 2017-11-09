
package trivialpursuit;

import java.awt.*;


public class Piece {
    private Color color;
    
    private int x;
    private int y;
    private boolean hasOrange=false;
    private boolean hasRed=false;
    private boolean hasBlue=false;
    private boolean hasPurple=false;
    private boolean hasPink=false;
    private boolean hasGreen=false;
    

    Piece(Color _color, int _x, int _y){
        color = _color;
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
    public Color getColor()
    {
        return (color);
    }
    public void setLocation() {
        
    }
    public void setOrange(){
        hasOrange=!hasOrange;
    }
    
    public void setRed(){
        hasRed=!hasRed;
    }
    public void setGreen(){
        hasGreen=!hasGreen;
    }
    public void setBlue(){
        hasBlue=!hasBlue;
    }
    public void setPurple(){
        hasPurple=!hasPurple;
    }
    public void setPink(){
        hasPink=!hasPink;
    }
    
    
    public void draw(Graphics2D g,int xdelta,int ydelta) {
        g.setColor(color); 
        g.fillOval(Window.getX(x*xdelta),Window.getY(y*ydelta),xdelta,ydelta);
        g.setColor(Color.BLACK);
        g.drawOval(Window.getX(x*xdelta),Window.getY(y*ydelta),xdelta,ydelta);
        

//        g.setColor(Color.white);
//        g.setFont(new Font("Arial",Font.PLAIN,30));
//        g.drawString("",Window.getX(column*xdelta)+30,Window.getY(row*ydelta)+40);       
        int angle = (360/6);
        g.setColor(Color.red);
        if(hasRed)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90, angle-10);
        g.setColor(Color.ORANGE);
        if(hasOrange)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90+angle*1, angle-10);
        g.setColor(Color.magenta);
        if(hasPurple)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10,90+angle*2, angle-10);
        g.setColor(Color.GREEN);
        if(hasGreen)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90+angle*3, angle-10);
        g.setColor(new Color(255,0,128));
        if(hasPink)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90+angle*4, angle-10);
        g.setColor(Color.CYAN);
        if(hasBlue)
        g.fillArc(Window.getX(x*xdelta)+5,  Window.getY(y*ydelta)+4, xdelta-10, ydelta-10, 90+angle*5, angle-10); 


    }
    
}