package mahapps.blockworkcircuits;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;


import java.util.ArrayList;

import mahapps.blockworkcircuits.Gamelogic.GameplayManager;
import mahapps.blockworkcircuits.Objects.*;



public class TestZone {

    private BoxBase box;
    private PlayerBox playerBox;
    private TerminalBox terminalBox;
    private GridBox gridBox;
    private ArrayList<GridBox> grid;
    private GameplayManager gm;
    int counter;

    TestZone(){

        int size = 150;

//        box = new BoxBase(90, 90, size, new Colour(100, 100, 100));
        playerBox = new PlayerBox(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2, size);

//        gridBox = new GridBox(300, 300, size);
        grid = new ArrayList<>();
        gm = new GameplayManager();

        gm.setUpGrid(grid, Constants.SCREEN_WIDTH/8, Constants.SCREEN_HEIGHT/8, size, 2*Constants.SCREEN_WIDTH/3, 2*Constants.SCREEN_HEIGHT/3);

//        terminalBox = new TerminalBox(200, 200, size);

        counter = 0;
    }

    public void update(){

        counter++;
        if (counter > 300){
            counter = 0;
        }

        if(counter >= 0 && counter < 60){
            playerBox.moveUp();
        }

        if(counter >= 60 && counter < 120){
            playerBox.moveRight();
        }

        if(counter >= 120 && counter < 180){
            playerBox.moveDown();
        }

        if(counter >= 180 && counter < 240){
            playerBox.moveLeft();
        }

        if(counter >= 240 && counter < 300){
            playerBox.stopMoving();
        }

        System.out.println(counter);

        playerBox.update();

    }


    public void onTouchEvent( MotionEvent event){

        for(GridBox i : grid){
            i.onTouchEvent(event);
        }
    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
//        box.display(canvas);
//        gridBox.display(canvas);
//        terminalBox.display(canvas);
        for(GridBox i: grid){
            i.display(canvas);
        }
        playerBox.display(canvas);
    }
}
