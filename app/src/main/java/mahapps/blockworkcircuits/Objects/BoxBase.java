package mahapps.blockworkcircuits.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class BoxBase {

    private Point location;
    Paint fill, stroke;
    Rect rect;
    private int size;

    public BoxBase(int xPos, int yPos, Colour colour) {

        size = 100;
        location = new Point(xPos, yPos);
        fill = new Paint();
        fill.setColor(colour.getColour());
        stroke = new Paint();
        stroke.setStyle(Paint.Style.STROKE);
        stroke.setStrokeWidth(5);
        stroke.setColor(Color.BLACK);


        rect = new Rect(xPos, yPos, xPos + size, yPos + size);
    }



    public void display(Canvas canvas){
        canvas.drawRect(rect, fill);
        canvas.drawRect(rect, stroke);
    }


}
