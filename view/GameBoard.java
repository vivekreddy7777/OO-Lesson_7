package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.KeyController;
import controller.TimerListener;
import model.Shooter;
import model.ShooterElement;

public class GameBoard {


    public static final int WIDTH =600;
    public static final int HEIGHT =300;
        
    public static final int FPS=20; 

    public static final int DELAY =1000/FPS;

      
    private JFrame window;
    private MyCanvas canvas;
    private Shooter shooter;
    private Timer timer;
    private TimerListener timerListener;

    public GameBoard(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        canvas =new MyCanvas(this,WIDTH,HEIGHT);
        cp.add(BorderLayout.CENTER, canvas);
        canvas.addKeyListener(new KeyController(this));
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);


        JButton startButton =new JButton("Start");
        JButton quitButton =new JButton("Quit");
        startButton.setFocusable(false);
        quitButton.setFocusable(false);

        JPanel southPanel =new JPanel();
        southPanel.add(startButton);
        southPanel.add(quitButton);
        cp.add(BorderLayout.SOUTH,southPanel);
        canvas.getGameElements().add(new TextDraw("Click <start> to play", 100, 100, Color.yellow, 30));
        
        timerListener=new TimerListener(this);
        timer =new Timer (DELAY,timerListener);


        timer =new Timer(DELAY, new TimerListener(this)); 
       
        startButton.addActionListener(event ->{
            shooter =new Shooter(GameBoard.WIDTH/2,GameBoard.HEIGHT-ShooterElement.SIZE );
            canvas.getGameElements().clear();
            canvas.getGameElements().add(shooter);
            timer.start();


        });
    }

    public MyCanvas getCanvas() {
        return canvas;
    }

    public Timer getTimer() {
        return timer;
    }

    public TimerListener getTimerListener() {
        return timerListener;
    }
    
}
