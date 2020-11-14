package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Shooter;
import model.ShooterElement;

public class GameBoard {


    public static final int WIDTH =600;
    public static final int HEIGHT =300;

      
    private JFrame window;
    private MyCanvas canvas;
    private Shooter shooter;

    public GameBoard(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        canvas =new MyCanvas(this,WIDTH,HEIGHT);
        cp.add(BorderLayout.CENTER, canvas);

        JButton startButton =new JButton("Start");
        JButton quitButton =new JButton("Quit");

        JPanel southPanel =new JPanel();
        southPanel.add(startButton);
        southPanel.add(quitButton);
        cp.add(BorderLayout.SOUTH,southPanel);
        canvas.getGameElements().add(new TextDraw("Click <start> to play", 100, 100, Color.yellow, 30));
        shooter =new Shooter(GameBoard.WIDTH/2,GameBoard.HEIGHT-ShooterElement.SIZE );
        canvas.getGameElements().add(shooter);
    }
    
}
