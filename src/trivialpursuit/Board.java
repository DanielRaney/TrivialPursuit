
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
    private final static int CENT = 8;
    
    private static int RAND = (int)(Math.random()*7 + 1);
    

    public static Piece pieces[] = new Piece[NUM_PIECES];
    public static Piece playerTurn;
    
    private static int currentPlayer = 0;
    private static boolean pressR = false;
    private static int timeCount = 0;
    private static int rollDice = 0;
    private static boolean notCurrently = true;
    
    //for randomized questions display
    private static int random = (int)(Math.random()*3);
    private static int previous = random;
    private static int answerIndex[] = new int[NUM_QUESTIONS];
    
    private static boolean stopCounting = false; //for randomized questions
    
    //for random question generater drawquestion
    private static boolean stopLooping = false;
    private static Question question = Question.getQuestions().get((int)(Math.random()*60));
    
    public static boolean DrawingQuestion = false;
    
    private static ArrayList<Question> UsedQuestions = new ArrayList<Question>();
    
    private static Question CurrentQuestion;
    private static int CurrentQuestionAnswerIndex[]=new int [NUM_ANSWERS];
    
    private static int QuestionTimer = 20;
    private static boolean stopTimer = false;
    
    private static final Color I = new Color(215, 191, 100); //orange
    private static final Color II = new Color(217, 98, 98); //red
    private static final Color III = new Color(112, 218, 97); //green
    private static final Color IV = new Color(96, 201, 219); //blue
    private static final Color V = new Color(160, 95, 220); //purple
    private static final Color VI = new Color(222, 92, 200); //pink 
    
    private static boolean correctAnswer=false;
    private static int randomCorrectAnswerDisplay=(int)(Math.random()*5); 
    
    private static int beginningTimer=25;
    
    private static int numEI = 0;
    private static int numEII = 0;
    private static int numEIII = 0;
    private static int numEIV = 0;
    private static int numEV = 0;
    private static int numEVI = 0;
    
    private static boolean APlayerHasAll;
    
    private static boolean DrawWin;
       
    private static int board[][] = {
    {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
    {WALL,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,RAND,RAND,RAND,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,RAND,RAND,RAND,RAND,RAND,CENT,RAND,RAND,RAND,RAND,RAND,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,RAND,RAND,RAND,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL,WALL,WALL,WALL,WALL,RAND,WALL},
    {WALL,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,RAND,WALL},
    {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},   
    };
    
    public static void resetBeginningTimer(){
        beginningTimer = 0;
    }
    public static Color getI(){
        return(I);
    }
    public static Color getII(){
        return(II);
    }
    public static Color getIII(){
        return(III);
    }
    public static Color getIV(){
        return(IV);
    }
    public static Color getV(){
        return(V);
    }
    public static Color getVI(){
        return(VI);
    }
    public static ArrayList<Question> getUsedQuestions(){
        return(UsedQuestions);
    }
    public static boolean getDrawWin(){
        return(DrawWin);
    }
    
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
        board[NUM_ROWS/2][NUM_COLUMNS/2] = CENT;
        pressR = false;
        notCurrently = true;
        UsedQuestions.clear();
        beginningTimer=25;
        DrawingQuestion = false;
        numEI = 0;
        numEII = 0;
        numEIII = 0;
        numEIV = 0;
        numEV = 0;
        numEVI = 0;
        APlayerHasAll = false;
        DrawWin=false;
    }
    
    public static void addPiece(int x, int y) {
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        int zx = (x - Window.getX(0))/xdelta;
        int zy = (y-Window.getY(0))/ydelta;
    }
    public static void RollDice(){
//        if(playerTurn.getX() == NUM_COLUMNS/2 && playerTurn.getY() == NUM_ROWS/2) {
//            switchNextPlayerTurn();
//            return;
//        }
        pressR = true;
        if(pressR && notCurrently) {
            rollDice = (int)(Math.random() * 6 + 1);
            movePiece(rollDice);
            notCurrently = false;
            QuestionTimer=20;
            if(!playerTurn.getHasAll())
                DrawingQuestion = true;
            else if(playerTurn.getHasAll() && board[playerTurn.getX()][playerTurn.getY()]!=ROLLAGN){
                if(board[playerTurn.getX()][playerTurn.getY()] == CENT) {
                    DrawWin = true;
                    return;
                }
                switchNextPlayerTurn();
            }
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

        if(playerTurn.getHasAll()){
            APlayerHasAll = true;
        }
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
                else if(board[zx][zy] == CENT) {
                    if(APlayerHasAll){
                        int color = (int)(Math.random() * 6) + 1;
                        switch (color) {
                            case 1:
                                g.setColor(I);
                                break;
                            case 2:
                                g.setColor(II);
                                break;
                            case 3:
                                g.setColor(III);
                                break;
                            case 4:
                                g.setColor(IV);
                                break;
                            case 5:
                                g.setColor(V);
                                break;
                            case 6:
                                g.setColor(VI);
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        g.setColor(Color.white);        }
                }
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

        //DrawingQuestion=false;
        if(board[playerTurn.getX()][playerTurn.getY()]==EPSI){
            //System.out.println("EPI");
            if(QuestionTimer>0 && !playerTurn.getHasAll())
                DrawQuestion(g, EPISODEI);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
                DrawingQuestion = false;
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSII){
            //System.out.println("EPSII");
            if(QuestionTimer>0 && !playerTurn.getHasAll())
                DrawQuestion(g, EPISODEII);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
                DrawingQuestion = false;
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSIII){
            //System.out.println("EPSIII");
            if(QuestionTimer>0 && !playerTurn.getHasAll())
                DrawQuestion(g, EPISODEIII);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
                DrawingQuestion = false;
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSIV){
            //System.out.println("EPSIV");
            if(QuestionTimer>0 && !playerTurn.getHasAll())
                DrawQuestion(g, EPISODEIV);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
                DrawingQuestion = false;
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSV){
            //System.out.println("EPSV");
            if(QuestionTimer>0 && !playerTurn.getHasAll())
                DrawQuestion(g, EPISODEV);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
                DrawingQuestion = false;
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==EPSVI){
            //System.out.println("EPSVI");
            if(QuestionTimer>0 && !playerTurn.getHasAll())
                DrawQuestion(g, EPISODEVI);
            else if(QuestionTimer==0){
                QuestionTimer=-1;
                switchNextPlayerTurn();
                DrawingQuestion = false;
            }
        }
        else if(board[playerTurn.getX()][playerTurn.getY()]==ROLLAGN){
            //System.out.println("RollAgain");
            DrawingQuestion=false;
            //RollDice();
            //switchNextPlayerTurn();
        }
        
        int turnXThing = Window.getHeight2() - 135;
        int turnYThing = Window.getHeight2()+125;
        g.setColor(playerTurn.getColor());
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("This", turnXThing,turnYThing); 
        g.setColor(Color.white);
        g.drawString("player's", turnXThing+60,turnYThing); 
        g.setColor(Color.white);
        g.drawString("turn", turnXThing+162,turnYThing); 
        
        if(beginningTimer >0)
            DrawInstructions(g);
        
        timeCount++;    
//Fill in below here
/////////////////////////If R is pressed / RollDice code //////////////////////////////
        if(pressR){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.drawString("ROLLED A "+rollDice+"!", Window.getWidth2()/2-20,70); 
            if(timeCount % 5==4) {
                pressR = false;
                notCurrently = true;
            }
        }
        else{
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.drawString("PRESS [R] TO ROLL THE DICE", Window.getWidth2()/2-140,70); 
        }
        if(correctAnswer){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,25));
            if(randomCorrectAnswerDisplay==0)
                g.drawString("Correct!", Window.getX(0),130+Window.getHeight2());
            else if(randomCorrectAnswerDisplay==1)
                g.drawString("You didn't fail!", Window.getX(0),130+Window.getHeight2());
            else if(randomCorrectAnswerDisplay==2)
                g.drawString("Got 'eem", Window.getX(0),130+Window.getHeight2());
            else if(randomCorrectAnswerDisplay==3)
                g.drawString("Plus one participation point",Window.getX(0),130+Window.getHeight2());
            else if(randomCorrectAnswerDisplay==4)
                g.drawString("One point to Griffindor", Window.getX(0),130+Window.getHeight2());
            if(timeCount % 50==49) {
                correctAnswer = false;
                randomCorrectAnswerDisplay= (int)(Math.random()*5);
            }
        }
        if(DrawWin)
            DrawWin(g);
            
//        else if(!correctAnswer){
//            g.setColor(Color.WHITE);
//            g.setFont(new Font("Arial",Font.BOLD,25));
//            if(randomCorrectAnswerDisplay==0)
//                g.drawString("Wrong", Window.getX(0),130+Window.getHeight2());
//            else if(randomCorrectAnswerDisplay==1)
//                g.drawString("You failed!", Window.getX(0),130+Window.getHeight2());
//            else if(randomCorrectAnswerDisplay==2)
//                g.drawString("Incorrect", Window.getX(0),130+Window.getHeight2());
//            else if(randomCorrectAnswerDisplay==3)
//                g.drawString("Minus one participation point",Window.getX(0),130+Window.getHeight2());
//            else if(randomCorrectAnswerDisplay==4)
//                g.drawString("Nope", Window.getX(0),130+Window.getHeight2());
//            if(timeCount % 50==49) {
//                correctAnswer = false;
//                randomCorrectAnswerDisplay= (int)(Math.random()*5);
//            }
//        }

////////////////////////////////////////////////////////////////////////////////////////////
    }
    
    public static void DrawQuestion(Graphics2D g, Category _category){
        if(!DrawingQuestion)
            return;
        int color = (int)(Math.random() * 8 +30);
        //int color =34;
        g.setColor(new Color(color,color,color));
        //DrawingQuestion=true;
        if(timeCount %12 ==11){
            QuestionTimer--;
        }
//        for(Question  obj:  getUsedQuestions()){
//            System.out.println(""+ obj.getName()+" "+obj.getCategory());    
//        }
        System.out.println(""+ UsedQuestions.size());  
        if(UsedQuestions.isEmpty()){
            while(question.getCategory() != _category){
                question = Question.getQuestions().get((int)(Math.random()*60));
            }
        }
        else{
            while(question.getCategory() != _category || UsedQuestions.contains(question)){
                question = Question.getQuestions().get((int)(Math.random()*60));
            }
        }
        
        CurrentQuestion = question;
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

        while(answerIndex[0] == answerIndex[1] || answerIndex[0] == answerIndex[2] || answerIndex[1] == answerIndex[2]){
            answerIndex[0]=(int)(Math.random()*3);
            answerIndex[1]=(int)(Math.random()*3);
            answerIndex[2]=(int)(Math.random()*3);
        }
        CurrentQuestionAnswerIndex[0]= answerIndex[0];
        CurrentQuestionAnswerIndex[1]= answerIndex[1];
        CurrentQuestionAnswerIndex[2]= answerIndex[2];
        System.out.println("answerIndex[0] is "+answerIndex[0]+" answerIndex[1] is "+answerIndex[1]+" answerIndex[2] is "+answerIndex[2]);
        
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
    public static void DrawInstructions(Graphics2D g){
        int color =150;
        g.setColor(new Color(color,color,color));
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        g.fillRect(Window.getX(2*xdelta - xdelta/4), Window.getY(3*ydelta - ydelta/4), 11*xdelta + xdelta/2, 8*ydelta + ydelta/2);
        g.setColor(Color.black);
        g.drawRect(Window.getX(2*xdelta - xdelta/4), Window.getY(3*ydelta - ydelta/4), 11*xdelta + xdelta/2, 8*ydelta + ydelta/2);
        
        int lineSpace = 18;
        if(timeCount %15 ==14)
            beginningTimer--;
        
        g.setColor(Color.white); 
        g.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
        g.drawString("WELCOME TO", Window.getX(Window.getHeight2()/2 - xdelta),Window.getY(4*ydelta - ydelta/2 -6) );
        g.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,60));
        g.setColor(Board.getII()); 
        g.drawString("TRIVIAL PURSUIT", Window.getX(2*xdelta + xdelta/2 - 10),Window.getY(5*ydelta - ydelta/2 +4) ); 
        g.setColor(Board.getVI()); 
        g.drawString("TRIVIAL PURSUIT", Window.getX(2*xdelta + xdelta/2 - 5),Window.getY(5*ydelta - ydelta/2 +2) ); 
        g.setColor(Board.getV()); 
        g.drawString("TRIVIAL PURSUIT", Window.getX(2*xdelta + xdelta/2),Window.getY(5*ydelta - ydelta/2) ); 
        g.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,22));
        g.setColor(Board.getII()); 
        g.drawString("STAR WARS EDITION", Window.getX(Window.getHeight2()/2 - (2*xdelta +15)),Window.getY(5*ydelta + 7) );
        g.setColor(Color.white); 
        g.drawString("STAR WARS EDITION", Window.getX(Window.getHeight2()/2 - (2*xdelta +15) + 2),Window.getY(5*ydelta + 7) );
        
        g.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,17));
        g.drawString("Basic instructions:", Window.getX(Window.getHeight2()/2 - xdelta - xdelta/2),Window.getY(6*ydelta - 10) );
        //g.drawString("Answer a Star Wars based trivia question correct to ear", Window.getX(3*xdelta),Window.getY(7*ydelta - ydelta/2 +lineSpace) );                  reference
        g.drawString("Answer a Star Wars based trivia question correct to", Window.getX(3*xdelta),Window.getY(6*ydelta +lineSpace) );
        g.drawString("earn 1 out of the 6 total tokens. Once you have obtained", Window.getX(3*xdelta),Window.getY(6*ydelta +2*lineSpace) );
        g.drawString("all 6 tokens, you'll have the ability to travel back to the", Window.getX(3*xdelta),Window.getY(6*ydelta  +3*lineSpace) );
        g.drawString("center where you'll have to answer 1 final trivia question", Window.getX(3*xdelta),Window.getY(6*ydelta  +4*lineSpace) );
        g.drawString("correct to win. First player to do so wins. By default,", Window.getX(3*xdelta),Window.getY(6*ydelta  +5*lineSpace) );
        g.drawString("the game requires 4 people to play, or 1 lonely person", Window.getX(3*xdelta),Window.getY(6*ydelta  +6*lineSpace) );
        g.drawString("who desires to play against themselves. Each colored square", Window.getX(3*xdelta),Window.getY(6*ydelta +7*lineSpace) );
        g.drawString("has a categorized set of questions, and if you land on a ", Window.getX(3*xdelta),Window.getY(6*ydelta  +8*lineSpace) );
        g.drawString("white piece, you get to roll again.", Window.getX(3*xdelta),Window.getY(6*ydelta +9*lineSpace) );
        
        g.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,23));
        g.setColor(Board.getV()); 
        g.drawString("Good luck, and may the force be with you", Window.getX(3*xdelta -4),Window.getY(7*ydelta+ ydelta/2+7*lineSpace +2) );
        g.setColor(Board.getVI());
        g.drawString("Good luck, and may the force be with you", Window.getX(3*xdelta -2),Window.getY(7*ydelta+ ydelta/2+7*lineSpace +1) );
        g.setColor(Color.white);
        g.drawString("Good luck, and may the force be with you", Window.getX(3*xdelta),Window.getY(7*ydelta+ ydelta/2+7*lineSpace) );
        g.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
        g.drawString("This message will disappear in "+beginningTimer+" seconds", Window.getX(5*xdelta -xdelta/2 -xdelta/4),Window.getY(8*ydelta+15+7*lineSpace) );
    }
    
    public static void DrawWin(Graphics2D g){
        int offset = 2;
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        g.setFont(new Font("Arial",Font.BOLD,34));
        g.setColor(I);
        g.drawString("This", Window.getX(5*xdelta -5)+offset/2,Window.getY(4*ydelta)); 
        g.setColor(VI);
        g.drawString("This", Window.getX(5*xdelta -5)-offset,Window.getY(4*ydelta)+offset); 
        g.setColor(playerTurn.getColor());
        g.drawString("This", Window.getX(5*xdelta -5),Window.getY(4*ydelta)); 
        g.setColor(I);
        g.drawString("player's won!", Window.getX(5*xdelta +15)+60 +offset/2,Window.getY(4*ydelta)); 
        g.setColor(VI);
        g.drawString("player's won!", Window.getX(5*xdelta +15)+60 -offset,Window.getY(4*ydelta)+offset);
        g.setColor(Color.white);
        g.drawString("player's won!", Window.getX(5*xdelta +15)+60,Window.getY(4*ydelta));
    }
    public static void movePiece(int ran) {
        int amountMovePossible = 0;
        if(playerTurn.getHasAll() && playerTurn.getInMiddle() == false) {
            //Horizontal Left
            if(playerTurn.getY() == NUM_ROWS/2 && playerTurn.getX() > NUM_COLUMNS/2 && playerTurn.getX() < NUM_COLUMNS-1) {
                for(int i = 0; i< ran; i++) {
                    if(playerTurn.getX() - i > (1) && board[playerTurn.getX() - i][playerTurn.getY()] != WALL) {
                        amountMovePossible += 1;
                        
                    }
                    
                }
                playerTurn.moveX(-amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;
                if(playerTurn.getX() < NUM_COLUMNS/2) {
                    playerTurn.setInMiddle(true);
                }
            }
            //Horizontal Right
            if(playerTurn.getY() == NUM_ROWS/2 && playerTurn.getX() > 0 && playerTurn.getX() < NUM_COLUMNS/2) {
                for(int i = 0; i< ran; i++) {
                    if(playerTurn.getY() != 1 && playerTurn.getX() + i < (NUM_COLUMNS - 2) && board[playerTurn.getX() + i][playerTurn.getY()] != WALL) {
                        amountMovePossible +=1;
                    }
                }
                playerTurn.moveX(amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;
                if(playerTurn.getX() > NUM_COLUMNS/2) {
                    playerTurn.setInMiddle(true);
                }
            }    
            //Vertical Up
            if(playerTurn.getX() == NUM_COLUMNS/2 && playerTurn.getY() > NUM_ROWS/2 && playerTurn.getY() < (NUM_ROWS - 1) ) {
                for(int i = 0; i < ran;i++) {
                    if(playerTurn.getX() != 1 && playerTurn.getY() - i > 1 && board[playerTurn.getX()][playerTurn.getY() - i] != WALL) {
                        amountMovePossible += 1;
                    }
                }
                playerTurn.moveY(-amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0;
                if(playerTurn.getY() < NUM_ROWS/2) {
                    playerTurn.setInMiddle(true);
                }
            }    
            //Vertical Down
            if(playerTurn.getX() == NUM_COLUMNS/2 && playerTurn.getY() < NUM_ROWS/2) {
                for(int i = 0; i < ran; i++) {
                    if ((playerTurn.getY() + i) < (NUM_ROWS-2) && board[playerTurn.getX()][playerTurn.getY() + i] != WALL) {
                        amountMovePossible += 1;
                    }
                }
                playerTurn.moveY(amountMovePossible);
                ran -= amountMovePossible;
                amountMovePossible = 0; 
                if(playerTurn.getY() > NUM_ROWS/2) {
                    playerTurn.setInMiddle(true);
                }
            }     
        }
        //
        if(playerTurn.getX() == NUM_COLUMNS/2 && playerTurn.getY() > NUM_ROWS/2) {
            for(int i = 0; i < ran; i++) {
                if (playerTurn.getInMiddle() && (playerTurn.getY() + i) < (NUM_ROWS-2) && board[playerTurn.getX()][playerTurn.getY() + i] != WALL) {
                    amountMovePossible += 1;
                }
            }
            playerTurn.moveY(amountMovePossible);
            ran -= amountMovePossible;
            amountMovePossible = 0;
        }
        else if(playerTurn.getY() == NUM_COLUMNS/2 && playerTurn.getX() > NUM_COLUMNS/2) {
            for(int i = 0; i< ran; i++) {
                if(playerTurn.getInMiddle()&&playerTurn.getY() != 1 && playerTurn.getX() + i < (NUM_COLUMNS - 2) && board[playerTurn.getX() + i][playerTurn.getY()] != WALL) {
                    amountMovePossible +=1;
                }
            }
            playerTurn.moveX(amountMovePossible);
            ran -= amountMovePossible;
            amountMovePossible = 0;

        }
        else if(playerTurn.getX() == NUM_ROWS/2 && playerTurn.getY() < NUM_ROWS) {
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
        else if (playerTurn.getY() == NUM_ROWS/2 && playerTurn.getX() < NUM_COLUMNS/2) {
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
        for(int l = 0; l < 10 && ran!=0; l++) {
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
        }
    }
    
    public static boolean CheckCorrectAnswer(int i, Graphics2D g){
        if(CurrentQuestion.getAnswers(CurrentQuestionAnswerIndex[i])== CurrentQuestion.getCorrectAnswer()){
            playerTurn.changeToken(CurrentQuestion.getCategory());
            correctAnswer = true;
            //RollDice();
            if(!UsedQuestions.contains(question)){
                UsedQuestions.add(question);
                if(question.getCategory()==Category.EPISODEI)
                    numEI++;
                else if(question.getCategory()==Category.EPISODEII)
                    numEII++;
                else if(question.getCategory()==Category.EPISODEIII)
                    numEIII++;
                else if(question.getCategory()==Category.EPISODEIV)
                    numEIV++;
                else if(question.getCategory()==Category.EPISODEV)
                    numEV++;
                else if(question.getCategory()==Category.EPISODEVI)
                    numEVI++;
                System.out.println("numEI "+numEI+" numEII "+numEII+" numEIII "+numEIII+" numEIV "+numEIV+" numEV "+numEV+" numEVI "+numEVI);
                if(numEI==10||numEII==10||numEIII==10||numEIV==10||numEV==10||numEVI==10){
                    UsedQuestions.clear();
                    numEI = 0;numEII = 0;numEIII = 0;numEIV = 0;numEV = 0;numEVI = 0;
                }
                
            }
            return true;
        }
        return false;
    }
    public static void CheckAndRemoveUsedQuestions(){
        if(numEI==10){
            for(Question obj : UsedQuestions){
                if(obj.getCategory() == Category.EPISODEI)
                    UsedQuestions.remove(obj);
            }
        }
        else if(numEII==10){
            for(Question obj : UsedQuestions){
                if(obj.getCategory() == Category.EPISODEII)
                    UsedQuestions.remove(obj);
            }
        }
        else if(numEIII==10){
            for(Question obj : UsedQuestions){
                if(obj.getCategory() == Category.EPISODEIII)
                    UsedQuestions.remove(obj);
            }
        }
        else if(numEIV==10){
            for(Question obj : UsedQuestions){
                if(obj.getCategory() == Category.EPISODEIV)
                    UsedQuestions.remove(obj);
            }
        }
        else if(numEV==10){
            for(Question obj : UsedQuestions){
                if(obj.getCategory() == Category.EPISODEV)
                    UsedQuestions.remove(obj);
            }
        }
        else if(numEVI==10){
            for(Question obj : UsedQuestions){
                if(obj.getCategory() == Category.EPISODEVI)
                    UsedQuestions.remove(obj);
            }
        }
    }
    public static void switchNextPlayerTurn(){
        if(currentPlayer >= NUM_PIECES-1) {
            currentPlayer = -1;
        }
        currentPlayer++;
        playerTurn = pieces[currentPlayer];

    }  
    //for test remove
    public static void win() {
        playerTurn.giveAll();
    }
}   

   
    

    