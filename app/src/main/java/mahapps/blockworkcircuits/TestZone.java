package mahapps.blockworkcircuits;

import android.graphics.Canvas;
import android.graphics.Color;


import mahapps.blockworkcircuits.Objects.*;


public class TestZone {

    private BoxBase box;

    TestZone(){

        box = new BoxBase(90, 90, new Colour(100, 100, 100));

    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        box.display(canvas);
    }
}
