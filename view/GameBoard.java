package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard {


    public static final int WIDTH =600;
    public static final int HEIGHT =300;

      
    private JFrame window;
    private MyCanvas canvas;

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

    }
    
}
