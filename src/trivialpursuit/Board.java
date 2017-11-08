
package trivialpursuit;

import java.awt.*;
import static trivialpursuit.TrivialPursuit.*;
import static trivialpursuit.Category.*;
import static trivialpursuit.Question.*;

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
    

    public static Piece pieces[] = new Piece[NUM_PIECES];
    public static Piece playerTurn;
    
    
    public static boolean pressR = false;
    public static int timeCount = 0;
    public static int rollDice = 0;
    public static boolean notCurrently = true;
    
    //for randomized questions display
    public static int random = (int)(Math.random()*3);
    public static int previous = random;
     public static boolean stopCounting = false; //for randomized questions
    
    private static final Color I = new Color(215, 191, 100); //orange
    private static final Color II = new Color(217, 98, 98); //red
    private static final Color III = new Color(112, 218, 97); //green
    private static final Color IV = new Color(96, 201, 219); //blue
    private static final Color V = new Color(160, 95, 220); //purple
    private static final Color VI = new Color(222, 92, 200); //pink 
    
    public static void RollDice(){
        pressR = true;
        if(pressR && notCurrently) {
            rollDice = (int)(Math.random() * 6 + 1);
            movePiece(rollDice);
            notCurrently = false;
        }
    } 
            
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
        //for(int i = 0; i<NUM_PIECES;i++) {
        //    int color = (int)(Math.random() * 3 +30);
        //   pieces[i] = new Piece(new Color(color,color,color),NUM_ROWS/2,NUM_COLUMNS/2);
        //}
        pieces[0] = new Piece(Color.LIGHT_GRAY, NUM_ROWS/2,NUM_COLUMNS/2 + 1);
        pieces[1] = new Piece(Color.yellow, NUM_ROWS/2,NUM_COLUMNS/2 - 1);
        pieces[2] = new Piece(Color.DARK_GRAY, NUM_ROWS/2 + 1,NUM_COLUMNS/2);
        pieces[3] = new Piece(Color.BLUE, NUM_ROWS/2 - 1,NUM_COLUMNS/2);
        
        playerTurn = pieces[0];
        
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
        pressR = false;
        notCurrently = true;
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
    
        timeCount++;    
    /////////
        
        
        
//Fill in below here
/////////////////////////If R is pressed / RollDice code //////////////////////////////
        if(pressR){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.drawString("ROLLED A "+rollDice+"!", Window.getWidth2()/2-20,70); 
            if(timeCount % 25==24) {
                pressR = false;
                notCurrently = true;
            }
        }
        else{
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.drawString("PRESS [R] TO ROLL THE DICE", Window.getWidth2()/2-140,70); 
        }
////////////////////////////////////////////////////////////////////////////////////////////
    }
    
    public static void DrawQuestion(Graphics2D g){
        //boolean pickOnce = true;
        //int randomQuestion =(int)(Math.random()*30);
        //if(pickOnce){
            //randomQuestion =(int)(Math.random()*30);
            //pickOnce = false;
        //}
        Question question = Question.getQuestions().get(10);
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        g.fillRect(Window.getX(2*xdelta - xdelta/4), Window.getY(5*ydelta - ydelta/4), 11*xdelta + xdelta/2, 5*ydelta + ydelta/2);
        if(question.getCategory() == EPISODEI) 
            g.setColor(I);
        else if(question.getCategory() == EPISODEII) 
            g.setColor(II);
        else if(question.getCategory() == EPISODEIII) 
            g.setColor(III);
        else if(question.getCategory() == EPISODEIV) 
            g.setColor(IV);
        else if(question.getCategory() == EPISODEV) 
            g.setColor(V);
        else if(question.getCategory() == EPISODEVI) 
            g.setColor(VI);
        g.drawRect(Window.getX(2*xdelta - xdelta/4), Window.getY(5*ydelta - ydelta/4), 11*xdelta + xdelta/2, 5*ydelta + ydelta/2);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString(""+question.getName(), Window.getX(2*xdelta + 10),Window.getY(6*ydelta - ydelta/2) ); 
        g.setFont(new Font("Arial",Font.PLAIN,20));
        
        
        int answerIndex[] = new int[NUM_QUESTIONS];
        if(!stopCounting){
            int countQNum = -1;
            int countLineNum = 6;
            while(countQNum<2){
                if(previous == 0){
                    random = (int)(Math.random()*2 +1);
                }
                if(previous == 1){
                    random = (int)(Math.random()*2);
                    if(random == 1)
                        random=0;
                    else if(random == 2)
                        random=2;
                }
                if(previous == 2){
                    random = (int)(Math.random()*2);
                }
                previous = random;
                countQNum++;
                if(countLineNum<9){countLineNum++;}
                answerIndex[countQNum] = random;
                System.out.println("countLineNum="+countLineNum+" countQNum="+countQNum+" answerIndex["+countQNum+"] is "+random);
            }
            if(countQNum == 2){
                stopCounting = true;
                System.out.println("working");
            }
        }
        g.drawString(""+question.getAnswers(answerIndex[0]), Window.getX(3*xdelta),Window.getY(7*ydelta));
        g.drawString(""+question.getAnswers(answerIndex[1]), Window.getX(3*xdelta),Window.getY(8*ydelta));
        g.drawString(""+question.getAnswers(answerIndex[2]), Window.getX(3*xdelta),Window.getY(9*ydelta));
        System.out.println("answerIndex[0] is "+answerIndex[0]+" answerIndex[1] is "+answerIndex[1]+" answerIndex[2] is "+answerIndex[2]);
    }
    public static void movePiece(int ran) {
        
        //Second iteration (Very Hardcode)
    //    int ran = (int)(Math.random() * 6 + 1);
    //    int X = 1;
    //    int Y = 1;
    //    if(playerTurn.getX() != (NUM_ROWS-2) &&(playerTurn.getY()+ran) < NUM_ROWS && board[playerTurn.getX()][playerTurn.getY() + ran] != WALL) {
    //        playerTurn.moveY(ran);
    //    }
    //    else if(playerTurn.getX() != (NUM_COLUMNS-2) &&(playerTurn.getX()+ran) < NUM_COLUMNS && board[playerTurn.getX() + ran][playerTurn.getY()] != WALL){
    //        playerTurn.moveX(ran);
    //    }
    //    else if (playerTurn.getX() < NUM_COLUMNS && (playerTurn.getY() - ran) > 0 && board[playerTurn.getX()][playerTurn.getY() - ran] != WALL) {
    //        playerTurn.moveY(-ran);
    //    }
    
        int amountMovePossible = 0;
        //STARTING MOVE DEPENDENT ON STARTING LOCATION
            for(int i = 0; i < ran; i++) {
                System.out.println("oof");
                if (playerTurn.getX() != (NUM_COLUMNS-2) && playerTurn.getY() != 1 && (playerTurn.getY() + i) < (NUM_ROWS-2) && board[playerTurn.getX()][playerTurn.getY() + i] != WALL) {
                    amountMovePossible += 1;
                }
            }
            System.out.println(amountMovePossible + " is the possible move " + ran + " was the amount total");
            playerTurn.moveY(amountMovePossible);
            ran -= amountMovePossible;
            amountMovePossible = 0;
            //WIP
            
            for(int i = 0; i< ran; i++) {
                if(playerTurn.getY() != 1 && playerTurn.getX() + i < (NUM_COLUMNS - 2) && board[playerTurn.getX() + i][playerTurn.getY()] != WALL) {
                    amountMovePossible +=1;
                }
            }
            System.out.println(amountMovePossible + "");
            playerTurn.moveX(amountMovePossible);
            ran -= amountMovePossible;
            amountMovePossible = 0;
            for(int i = 0; i < ran;i++) {
                if(playerTurn.getY() - i > 1 && board[playerTurn.getX()][playerTurn.getY() - i] != WALL && playerTurn.getX() == NUM_COLUMNS-2) {
                    amountMovePossible += 1;
                }
            }
            System.out.println(amountMovePossible + "");
            playerTurn.moveY(-amountMovePossible);
            ran -= amountMovePossible;
            amountMovePossible = 0;
            
            for(int i = 0; i< ran; i++) {
                if(playerTurn.getX() - i > (1) && board[playerTurn.getX() - i][playerTurn.getY()] != WALL) {
                    amountMovePossible += 1;
                }
            }
            
            System.out.println(amountMovePossible + "");
            playerTurn.moveX(-amountMovePossible);
            ran -= amountMovePossible;
            amountMovePossible = 0;
            
            for(int i = 0; i < ran; i++) {
                System.out.println("oof");
                if (playerTurn.getX() != (NUM_COLUMNS-2) && (playerTurn.getY() + i) < (NUM_ROWS-2) && board[playerTurn.getX()][playerTurn.getY() + i] != WALL) {
                    amountMovePossible += 1;
                }
            }
            System.out.println(amountMovePossible + " is the possible move " + ran + " was the amount total");
            playerTurn.moveY(amountMovePossible);
            ran -= amountMovePossible;
    }
}