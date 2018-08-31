package mahapps.blockworkcircuits;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;


import java.util.ArrayList;

import mahapps.blockworkcircuits.Objects.*;



public class TestZone {

    private BoxBase box;
    private PlayerBox playerBox;
    private TerminalBox terminalBox;
    private GridBox gridBox;
    private ArrayList<GridBox> grid;

    TestZone(){

        box = new BoxBase(90, 90, new Colour(100, 100, 100));
        playerBox = new PlayerBox(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2);

        gridBox = new GridBox(300, 300);
        grid = new ArrayList<>();
        gridBox.setUpGrid(grid,500, 500, 150*3, 150*3);

        terminalBox = new TerminalBox(200, 200);
    }

    public void update(){

    }


    public void onTouchEvent( MotionEvent event){

        for(GridBox i : grid){
            i.onTouchEvent(event);
        }
    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        box.display(canvas);
        playerBox.display(canvas);
        gridBox.display(canvas);
        terminalBox.display(canvas);
        for(GridBox i: grid){
            i.display(canvas);
        }
    }
}
