
package trivialpursuit;

import java.awt.*;
import java.util.ArrayList;
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
    private final static int ROLLAGN = 7;
    
    private static int RAND = (int)(Math.random()*7 + 1);
    

    public static Piece pieces[] = new Piece[NUM_PIECES];
    public static Piece playerTurn;
    
    private static int currentPlayer = 0;
    public static boolean pressR = false;
    public static int timeCount = 0;
    public static int rollDice = 0;
    public static boolean notCurrently = true;
    
    //for randomized questions display
    public static int random = (int)(Math.random()*3);
    public static int previous = random;
    public static int answerIndex[] = new int[NUM_QUESTIONS];
    public static boolean stopCounting = false; //for randomized questions
    
    //for random question generater drawquestion
    public static boolean stopLooping = false;
    public static Question question = Question.getQuestions().get((int)(Math.random()*60));
    
    public static boolean DrawingQuestion = false;
    
    public static ArrayList<Question> UsedQuestions = new ArrayList<Question>();
    
    public static Question CurrentQuestion;
    public static int CurrentQuestionAnswerIndex[]=new int [NUM_ANSWERS];
    
    public static int QuestionTimer = 10;
    public static boolean stopTimer = false;
    
    public static final Color I = new Color(215, 191, 100); //orange
    public static final Color II = new Color(217, 98, 98); //red
    public static final Color III = new Color(112, 218, 97); //green
    public static final Color IV = new Color(96, 201, 219); //blue
    public static final Color V = new Color(160, 95, 220); //purple
    public static final Color VI = new Color(222, 92, 200); //pink 
    
       
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
        if(NUM_PIECES>0)
            pieces[0] = new Piece(Color.LIGHT_GRAY, NUM_ROWS/2,NUM_COLUMNS/2 + 1);
        if(NUM_PIECES>1)
            pieces[1] = new Piece(Color.DARK_GRAY, NUM_ROWS/2 + 1,NUM_COLUMNS/2);
        if(NUM_PIECES>2)
            pieces[2] = new Piece(Color.yellow, NUM_ROWS/2,NUM_COLUMNS/2 - 1);
        if(NUM_PIECES>3)
            pieces[3] = new Piece(Color.BLUE, NUM_ROWS/2 - 1,NUM_COLUMNS/2);
        
        currentPlayer = 0;
        playerTurn = pieces[currentPlayer];
        
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
        board[NUM_ROWS/2][NUM_COLUMNS/2] = ROLLAGN;
        pressR = false;
        notCurrently = true;
        UsedQuestions.clear();
    }
    
    public static void addPiece(int x, int y) {
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        int zx = (x - Window.getX(0))/xdelta;
        int zy = (y-Window.getY(0))/ydelta;
    }
    public static void RollDice(){
        pressR = true;
        if(pressR && notCurrently) {
            rollDice = (int)(Math.random() * 6 + 1);
            movePiece(rollDice);
            notCurrently = false;
            QuestionTimer=10;
        }
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
                    //int color = (int)(Math.random() * 3 +30);
                    int color = 32;
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
                else if(board[zx][zy] == ROLLAGN) 
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

        DrawingQuestion=false;
        if(board[playerTurn.getX()][playerTurn.getY()]==EPSI){
            //System.out.println("EPI");
            if(QuestionTimer>0)
                DrawQuestion(g, EPISODEI);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSII){
            //System.out.println("EPSII");
            if(QuestionTimer>0)
                DrawQuestion(g, EPISODEII);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSIII){
            //System.out.println("EPSIII");
            if(QuestionTimer>0)
                DrawQuestion(g, EPISODEIII);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSIV){
            //System.out.println("EPSIV");
            if(QuestionTimer>0)
                DrawQuestion(g, EPISODEIV);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSV){
            //System.out.println("EPSV");
            if(QuestionTimer>0)
                DrawQuestion(g, EPISODEV);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSVI){
            //System.out.println("EPSVI");
            if(QuestionTimer>0)
                DrawQuestion(g, EPISODEVI);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==ROLLAGN){
            //System.out.println("RollAgain");
            DrawingQuestion=false;
            RollDice();
            switchNextPlayerTurn();
        }
        g.setColor(playerTurn.getColor());
        g.setFont(new Font("Arial",Font.BOLD,15));
        g.drawString("Turn", 100,50); 
        timeCount++;    
//Fill in below here
/////////////////////////If R is pressed / RollDice code //////////////////////////////
        if(pressR){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.drawString("ROLLED A "+rollDice+"!", Window.getWidth2()/2-20,70); 
            //if(timeCount % 25==24) {
                pressR = false;
                notCurrently = true;
            //}
        }
        else{
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.drawString("PRESS [R] TO ROLL THE DICE", Window.getWidth2()/2-140,70); 
        }
////////////////////////////////////////////////////////////////////////////////////////////
    }
    
    public static void DrawQuestion(Graphics2D g, Category _category){
        //int color = (int)(Math.random() * 8 +30);
        int color =34;
        g.setColor(new Color(color,color,color));
        DrawingQuestion=true;
        if(timeCount %12 ==11){
            QuestionTimer--;
        }
        if(UsedQuestions.isEmpty()){
            while(question.getCategory() != _category){
                question = Question.getQuestions().get((int)(Math.random()*60));
            }
        }
        else{
            while(question.getCategory() != _category && !UsedQuestions.contains(questions)){
                question = Question.getQuestions().get((int)(Math.random()*60));
            }
        }
        CurrentQuestion = question;
        UsedQuestions.add(question);
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


        if(!stopCounting){
            int countQNum = -1;
            int countLineNum = 6;
            for(int i=0; i<3; i++){
                countQNum++;
                if(countLineNum<9){countLineNum++;}
                answerIndex[i] = random;

                System.out.println("countLineNum="+countLineNum+" countQNum="+countQNum+" answerIndex["+countQNum+"] is "+random);
                if(i == 2){
                    stopCounting = true;
                    System.out.println("working");
                }
            }
            while(answerIndex[0] == answerIndex[1] || answerIndex[0] == answerIndex[2] || answerIndex[1] == answerIndex[2]){
                answerIndex[0]=(int)(Math.random()*3);
                answerIndex[1]=(int)(Math.random()*3);
                answerIndex[2]=(int)(Math.random()*3);
            }
            CurrentQuestionAnswerIndex[0]= answerIndex[0];
            CurrentQuestionAnswerIndex[1]= answerIndex[1];
            CurrentQuestionAnswerIndex[2]= answerIndex[2];
            System.out.println("answerIndex[0] is "+answerIndex[0]+" answerIndex[1] is "+answerIndex[1]+" answerIndex[2] is "+answerIndex[2]);
        }
        g.drawRect(Window.getX(4*xdelta - 10), Window.getY(6*ydelta + 25), 8*xdelta, 35);
        g.drawRect(Window.getX(4*xdelta - 10), Window.getY(6*ydelta + 25 + ydelta), 8*xdelta, 35);
        g.drawRect(Window.getX(4*xdelta - 10), Window.getY(6*ydelta + 25 + 2*ydelta), 8*xdelta, 35);
        g.drawString(""+question.getAnswers(answerIndex[0]), Window.getX(4*xdelta),Window.getY(7*ydelta));
        g.drawString(""+question.getAnswers(answerIndex[1]), Window.getX(4*xdelta),Window.getY(8*ydelta));
        g.drawString(""+question.getAnswers(answerIndex[2]), Window.getX(4*xdelta),Window.getY(9*ydelta));
        g.drawString("A. ", Window.getX(3*xdelta),Window.getY(7*ydelta));
        g.drawString("B. ", Window.getX(3*xdelta),Window.getY(8*ydelta));
        g.drawString("C. ", Window.getX(3*xdelta),Window.getY(9*ydelta));
        g.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
        g.drawString(""+question.getCategory(), Window.getX(10*xdelta),Window.getY(10*ydelta - 8));
        g.drawString("Difficulty "+question.getDifficulty(), Window.getX(2*xdelta + xdelta/2),Window.getY(10*ydelta - 8));
        g.drawString(""+QuestionTimer, Window.getX(12*xdelta),Window.getY(10*ydelta - 8));
        //then call some switch turn method
    // for ==> if(QuestionTimer>=0){
    //System.out.println("xdelta "+xdelta+" ydelta "+ydelta);
    }
    public static void movePiece(int ran) {
        int amountMovePossible = 0;
//////////////////// Starting Point Hard Code Hype
            if(playerTurn == pieces[0]) {
                for(int i = 0; i < ran; i++) {
                    if (playerTurn.getInMiddle() && (playerTurn.getY() + i) < (NUM_ROWS-2) && board[playerTurn.getX()][playerTurn.getY() + i] != WALL) {
                        amountMovePossible += 1;
                    }
                }
                playerTurn.moveY(amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;
            }
            else if(playerTurn == pieces[1] && NUM_PIECES > 1) {
                for(int i = 0; i< ran; i++) {
                    if(playerTurn.getInMiddle()&&playerTurn.getY() != 1 && playerTurn.getX() + i < (NUM_COLUMNS - 2) && board[playerTurn.getX() + i][playerTurn.getY()] != WALL) {
                        amountMovePossible +=1;
                    }
                }
                playerTurn.moveX(amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;
                
            }
            else if(playerTurn == pieces[2] && NUM_PIECES > 2) {
                amountMovePossible = 0;
                for(int i = 0; i < ran;i++) {
                    if(playerTurn.getInMiddle() && playerTurn.getX() != 1 && playerTurn.getY() - i > 1 && board[playerTurn.getX()][playerTurn.getY() - i] != WALL) {
                        amountMovePossible += 1;
                    }
                }
                playerTurn.moveY(-amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;
            }
            else if (playerTurn == pieces [3] &&  NUM_PIECES > 3) {
                for(int i = 0; i< ran; i++) {
                    if(playerTurn.getInMiddle() &&playerTurn.getX() - i > (1) && board[playerTurn.getX() - i][playerTurn.getY()] != WALL) {
                        amountMovePossible += 1;
                    }
                }
                playerTurn.moveX(-amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;
            }
            
//////////////////// WIP
            //WIP
            int loopCount = 0;
            while(ran != 0 && loopCount < 10) {
                for(int i = 0; i< ran; i++) {
                    if(playerTurn.getY() == (NUM_ROWS-2)&&playerTurn.getY() != 1 && playerTurn.getX() + i < (NUM_COLUMNS - 2) && board[playerTurn.getX() + i][playerTurn.getY()] != WALL) {
                        amountMovePossible +=1;
                        playerTurn.setInMiddle(false);
                    }
                }
                playerTurn.moveX(amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;

                for(int i = 0; i < ran;i++) {
                    if(playerTurn.getX() == (NUM_COLUMNS-2)&&playerTurn.getY() - i > 1 && board[playerTurn.getX()][playerTurn.getY() - i] != WALL && playerTurn.getX() == NUM_COLUMNS-2) {
                        amountMovePossible += 1;
                        playerTurn.setInMiddle(false);
                    }
                }
                playerTurn.moveY(-amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;

                for(int i = 0; i< ran; i++) {
                    if(playerTurn.getY() == 1 &&playerTurn.getX() - i > (1) && board[playerTurn.getX() - i][playerTurn.getY()] != WALL) {
                        amountMovePossible += 1;
                        playerTurn.setInMiddle(false);
                    }
                }
                playerTurn.moveX(-amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;

                for(int i = 0; i < ran; i++) {
                    if (playerTurn.getX() == 1 && playerTurn.getX() != (NUM_COLUMNS-2) && (playerTurn.getY() + i) < (NUM_ROWS-2) && board[playerTurn.getX()][playerTurn.getY() + i] != WALL) {
                        amountMovePossible += 1;
                        playerTurn.setInMiddle(false);
                    }
                }
                playerTurn.moveY(amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;
                loopCount++;
            }
    }
    
    public static boolean CheckCorrectAnswer(int i){
        if(CurrentQuestion.getAnswers(CurrentQuestionAnswerIndex[i])== CurrentQuestion.getCorrectAnswer()){
            System.out.println("Correct!");
            RollDice();
            return true;
        }
        return false;
    }
    public static void switchNextPlayerTurn(){
        if(currentPlayer >= NUM_PIECES-1) {
            currentPlayer = -1;
        }
        currentPlayer++;
        playerTurn = pieces[currentPlayer];
    }
    
}
    