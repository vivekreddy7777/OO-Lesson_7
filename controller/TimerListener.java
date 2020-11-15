package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.LinkedList;

import model.Shooter;
import view.GameBoard;

public class TimerListener implements ActionListener {

    public enum EventType{
        KEY_RIGHT,KEY_LEFT,KEY_SPACE
    }

    private GameBoard gameBoard;
    private LinkedList<EventType> eventQueue;
    

   

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

        while(!eventQueue.isEmpty()){
            var e =eventQueue.getFirst();
            eventQueue.removeFirst();
            Shooter shooter =gameBoard.getShooter();
            if(shooter==null) return;

            switch(e){
                case KEY_LEFT:
                shooter.moveLeft();
                break;
                case KEY_RIGHT:
                shooter.moveRight();
                break;
                case KEY_SPACE:

            }
        }

    }
    
    private void processCollision(){
        
    }

    private void update(){

    }

    public LinkedList<EventType> getEventQueue() {
        return eventQueue;
    }

    
}
