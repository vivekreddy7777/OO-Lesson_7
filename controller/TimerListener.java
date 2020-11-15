package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.LinkedList;

import view.GameBoard;

public class TimerListener implements ActionListener {

    private GameBoard gameBoard;
    private LinkedList<EventType> eventQueue;
    

    public enum EventType{
        KEY_RIGHT,KEY_LEFT,KEY_SPACE
    }

    public TimerListener(GameBoard gameBoard){

        this.gameBoard=gameBoard;
        eventQueue =new LinkedList<>(); 
    

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        processEventQueue();
        processCollision();
        gameBoard.getCanvas().repaint();
    }

    private void processEventQueue(){

    }
    
    private void processCollision(){
        
    }

    private void update(){

    }

    public LinkedList<EventType> getEventQueue() {
        return eventQueue;
    }

    
}
