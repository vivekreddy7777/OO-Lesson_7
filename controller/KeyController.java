package controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.GameBoard;


public class KeyController implements KeyListener {

    private GameBoard gameBoard;

    public KeyController(GameBoard gameBoard){
        this.gameBoard=gameBoard;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode =e.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_LEFT:
            System.out.println("left");
            break;
            case KeyEvent.VK_RIGHT:
            System.out.println("r");
            break;
            case KeyEvent.VK_SPACE:
            System.out.println("s");

            break;
            
        }
    }


    @Override
    public void keyTyped(KeyEvent e) { }

  

    @Override
    public void keyReleased(KeyEvent e) {  }
    
}
