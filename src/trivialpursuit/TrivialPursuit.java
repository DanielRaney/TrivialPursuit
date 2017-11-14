package trivialpursuit;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class TrivialPursuit extends JFrame implements Runnable {
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
   

    public static void main(String[] args) {
        TrivialPursuit frame = new TrivialPursuit();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Star Wars Trivial Pursuit");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./trivial.png"));
    }

    public TrivialPursuit() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
                
                if (e.BUTTON1 == e.getButton() && Board.DrawingQuestion) {
                    if(e.getX() > Window.getX(4*50 - 10) && e.getY() > Window.getY(6*49 + 25) &&
                       e.getX() < (Window.getX(4*50 - 10)+ 8*49) && e.getY() < ( Window.getY(6*49 + 25) + 35) && Board.DrawingQuestion){
                       System.out.println("*Click* Noice");
                       Board.CheckCorrectAnswer(0);
//                       if(Board.CheckCorrectAnswer(0)){
//                           //Board.playerTurn.changeToken(Board.CurrentQuestion.getCategory());
//                       }
//                       else{
//                           //Board.switchNextPlayerTurn();
//                           //Board.RollDice();
//                       }
                    }
                    else if(e.getX() > Window.getX(4*50 - 10) && e.getY() > Window.getY(7*49 + 25) &&
                       e.getX() < (Window.getX(4*50 - 10)+ 8*49) && e.getY() < ( Window.getY(7*49 + 25) + 35) && Board.DrawingQuestion){
                       System.out.println("*Click* Noice 2");
                       Board.CheckCorrectAnswer(1);
//                       if(Board.CheckCorrectAnswer(1)) {
//                           //Board.playerTurn.changeToken(Board.CurrentQuestion.getCategory());
//                       }
//                       else{
//                           //Board.switchNextPlayerTurn();
//                           //Board.RollDice();
//                       }
                       
                    }
                    else if(e.getX() > Window.getX(4*50 - 10) && e.getY() > Window.getY(8*49 + 25) &&
                       e.getX() < (Window.getX(4*50 - 10)+ 8*49) && e.getY() < ( Window.getY(8*49 + 25) + 35) && Board.DrawingQuestion){
                       System.out.println("*Click* Noice 3");
                       Board.CheckCorrectAnswer(2);
//                       if(Board.CheckCorrectAnswer(2)){
//                           //Board.playerTurn.changeToken(Board.CurrentQuestion.getCategory());
//                       }
//                       else{
//                           //Board.switchNextPlayerTurn();
//                           //Board.RollDice();
//                       }
                       
                       
                    }
                    Board.switchNextPlayerTurn();
                    Board.DrawingQuestion = false;
                }
                if (e.BUTTON3 == e.getButton()) {
                    reset();
                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        //repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        //repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
//stop();
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                if(e.VK_K == e.getKeyCode()) {
                    Board.win();
                }
                if(e.VK_R == e.getKeyCode() && !Board.DrawingQuestion) {
                    Board.RollDice();
                }
//                if(e.VK_A == e.getKeyCode() ) {
//                    Board.CheckCorrectAnswer(0);
//                    System.out.println("A");
//                }
//                else if(e.VK_B == e.getKeyCode() ) {
//                    Board.CheckCorrectAnswer(1);
//                    System.out.println("B");
//                }
//                else if(e.VK_C == e.getKeyCode() ) {
//                    Board.CheckCorrectAnswer(2);
//                    System.out.println("C");
//                }
                
                
                
               // repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(new Color(53,78,102));
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()),Window.getY(Window.getHeight2()), Window.getY(0)};

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }   
//The Rest
        Board.Draw(g);
        
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        System.out.println("-------reset-------");
        
        Question.InstantiateQuestions();
        Board.reset();
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            reset();
        }
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
/////////////////////////////////////////////////////////////////////////
}
