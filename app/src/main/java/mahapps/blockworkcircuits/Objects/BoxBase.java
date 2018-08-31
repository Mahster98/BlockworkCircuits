package mahapps.blockworkcircuits.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class BoxBase {

    private Point location;
    private Paint fill, stroke;
    private Rect rect;
    private int size;

    public BoxBase(int xPos, int yPos, int size, Colour colour) {

        this.size = size;
        location = new Point(xPos, yPos);
        fill = new Paint();
        fill.setColor(colour.getColour());
        stroke = new Paint();
        stroke.setStyle(Paint.Style.STROKE);
        stroke.setStrokeWidth(5);
        stroke.setColor(Color.BLACK);


        rect = new Rect(xPos, yPos, xPos + size, yPos + size);
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Paint getFill() {
        return fill;
    }

    public void setFill(Paint fill) {
        this.fill = fill;
    }

    public Paint getStroke() {
        return stroke;
    }

    public void setStroke(Paint stroke) {
        this.stroke = stroke;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void display(Canvas canvas){
        canvas.drawRect(rect, fill);
        canvas.drawRect(rect, stroke);
    }


}
