package mahapps.blockworkcircuits.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class BoxBase {

    private Point location;
    private Paint fill;
    private Rect rect;
    private int size;

    public BoxBase(int xPos, int yPos, Colour colour) {

        size = 90;
        location = new Point(xPos, yPos);
        fill = new Paint();
        fill.setColor(colour.getColour());
        rect = new Rect(xPos, yPos, xPos + size, yPos + size);
    }



    public void display(Canvas canvas){
        canvas.drawRect(rect, fill);
    }


}
