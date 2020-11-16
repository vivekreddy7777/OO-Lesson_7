package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class EnemyComposite extends GameElement {

    public static final int NROWS =2;
    public static final int NCOLS =10;
    public static final int ENEMY_SIZE =20;
    public static final int UNIT_MOVE =5;

    private ArrayList<ArrayList<GameElement>> rows;



    public EnemyComposite(){

        rows=new ArrayList<>();
        for(int r=0;r<NROWS;r++){
            var oneRow=new ArrayList<GameElement>();
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
        // TODO Auto-generated method stub

    }
    
}
