package mahapps.blockworkcircuits;

import android.graphics.Canvas;
import android.graphics.Color;


import mahapps.blockworkcircuits.Objects.*;



public class TestZone {

    private BoxBase box;
    private PlayerBox playerBox;
    private TerminalBox terminalBox;
    private GridBox gridBox;

    TestZone(){

        box = new BoxBase(90, 90, new Colour(100, 100, 100));
        playerBox = new PlayerBox(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2);
        terminalBox = new TerminalBox(200, 200);
        gridBox = new GridBox(300, 300);

    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        box.display(canvas);
        playerBox.display(canvas);
        gridBox.display(canvas);
        terminalBox.display(canvas);
    }
}
