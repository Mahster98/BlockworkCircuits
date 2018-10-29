package mahapps.blockworkcircuits;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;


import java.util.ArrayList;
import java.util.Vector;

import mahapps.blockworkcircuits.Gamelogic.GameplayManager;
import mahapps.blockworkcircuits.Objects.*;



public class TestZone {

    private BoxBase box;
    private PlayerBox playerBox;
    private TerminalBox terminalBox;
    private Vector<PlayerBox> playerBoxes;
    private ArrayList<GridBox> grid;
    private ArrayList<TerminalBox> terminals;
    private GameplayManager gm;


    TestZone(){

        int size = 150;

//        box = new BoxBase(90, 90, size, new Colour(100, 100, 100));
//        playerBox = new PlayerBox(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2, size);

//        gridBox = new GridBox(300, 300, size);
        grid = new ArrayList<>();
        gm = new GameplayManager();

        gm.setUpGrid(grid, Constants.SCREEN_WIDTH/8, Constants.SCREEN_HEIGHT/8, size, 2*Constants.SCREEN_WIDTH/3, 2*Constants.SCREEN_HEIGHT/3);
//        gm.setUpGrid(grid, size, size, size, size*3, size*3);

        playerBoxes = new Vector<PlayerBox>();
        playerBox = gm.spawnPlayer(grid);
        playerBoxes.add(playerBox);


//        terminals = gm.spawnTerminals(grid, 1, 6);
//        terminalBox = new TerminalBox(200, 200, size);

    }

    public void update(){


        playerBox.update(playerBoxes);
        for(GridBox i : grid){
            i.update();
        }

    }


    public void onTouchEvent( MotionEvent event){


        for(GridBox i : grid){

            i.onTouchEvent(event);
        }

        playerBox.onTouchEvent(event);
    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
//        box.display(canvas);
//        gridBox.display(canvas);
//        terminalBox.display(canvas);


        for(GridBox i: grid){
            i.display(canvas);
        }
//        for(TerminalBox i : terminals){
//            i.display(canvas);
//        }
        playerBox.display(canvas);
        for(PlayerBox i : playerBoxes){
            i.display(canvas);
        }
    }
}
