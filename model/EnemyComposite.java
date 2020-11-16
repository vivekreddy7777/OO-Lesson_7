package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import view.GameBoard;

public class EnemyComposite extends GameElement {

    public static final int NROWS =2;
    public static final int NCOLS =10;
    public static final int ENEMY_SIZE =20;
    public static final int UNIT_MOVE =5;


    private ArrayList<ArrayList<GameElement>> rows;
    private boolean movingToRight=true;



    public EnemyComposite(){

        rows=new ArrayList<>();
        for(int r=0;r<NROWS;r++){
            var oneRow=new ArrayList<GameElement>();
            rows.add(oneRow);
            for(int c=0;c<NCOLS;c++){
                oneRow.add(new Enemy(
                    c*ENEMY_SIZE*2, r*ENEMY_SIZE*2, ENEMY_SIZE, Color.yellow, true));
            }
        }

    }

    @Override
    public void render(Graphics2D g2) {
        for(var r:rows){
            for(var c:r){
                c.render(g2);
            }
        }
    }

    @Override
    public void animate() {
        int dx = UNIT_MOVE;
        if(movingToRight){
            if(rightEnd()>=GameBoard.WIDTH){
                dx=-dx;
                movingToRight=false;
            }

        }else{
            dx=-dx;
            if(leftEnd()<=0){
                dx=-dx;
                movingToRight=true;

            }

        }
        for(var row :rows){
            for(var e:row){
                e.x+=dx;
            }
        }
    }

    private int rightEnd(){
        int xEnd=-100;
        for(var row :rows){
            if(row.size()==0) continue;
            int x =row.get(row.size()-1).x+ ENEMY_SIZE;
            if(x>xEnd) xEnd =x;
        }
        return xEnd;
    }    

    private int leftEnd(){
        int xEnd=9000;
        for(var row :rows){
            if(row.size()==0) continue;
            int x =row.get(0).x;
            if(x<xEnd) xEnd =x;
            if(x<xEnd) xEnd =x;
        }
        return xEnd;


    }
}
