
package trivialpursuit;

import java.awt.Color;

public class Player {
    private Color color;
    
    private boolean inMiddle = true;
    
    public boolean hasOrange=false;
    public boolean hasRed=false;
    public boolean hasBlue=false;
    public boolean hasPurple=false;
    public boolean hasPink=false;
    public boolean hasGreen=false;
    public boolean hasAll=false;
    
    Player(Color _color){
        color = _color;

    }
    public Color getColor()
    {
        return (color);
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
        checkAll();
    }
    public void checkAll(){
        if(hasPurple && hasGreen && hasBlue && hasOrange && hasRed && hasPink)
            hasAll=true;
    }
    
    public boolean getInMiddle() {
        return(inMiddle);
    }
    public void setInMiddle(boolean newState) {
        inMiddle = newState;
    }
}
