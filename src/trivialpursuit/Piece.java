
package trivialpursuit;

import java.awt.*;
import static trivialpursuit.TrivialPursuit.*;
import static trivialpursuit.Category.*;
import static trivialpursuit.Question.*;
import static trivialpursuit.Board.*;


public class Piece {
    private Color color;
    
    private int x;
    private int y;
    private boolean inMiddle = true;
    
    private boolean hasOrange=false;
    private boolean hasRed=false;
    private boolean hasBlue=false;
    private boolean hasPurple=false;
    private boolean hasPink=false;
    private boolean hasGreen=false;
    private boolean hasAll=false;
    

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
        hasOrange=true;
    }
    
    public void setRed(){
        hasRed=true;
    }
    public void setGreen(){
        hasGreen=true;
    }
    public void setBlue(){
        hasBlue=true;
    }
    public void setPurple(){
        hasPurple=true;
    }
    public void setPink(){
        hasPink=true;
    }
    public void checkAll(){
        if(hasPurple && hasGreen && hasBlue && hasOrange && hasRed && hasPink)
            hasAll=true;
    }
    public void changeToken(Category _token){
        if(_token==Category.EPISODEI)
            setOrange();
        if(_token==Category.EPISODEII)
            setRed();
        if(_token==Category.EPISODEIII)
            setGreen();
        if(_token==Category.EPISODEIV)
            setBlue();
        if(_token==Category.EPISODEV)
            setPurple();
        if(_token==Category.EPISODEVI)
            setPink();
    }
    public boolean getInMiddle() {
        return(inMiddle);
    }
    public void setInMiddle(boolean newState) {
        inMiddle = newState;
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