package mahapps.blockworkcircuits.Objects;


import android.graphics.Point;
import android.graphics.Rect;


public class PlayerBox extends BoxBase{

    int xPos;
    int yPos;
    int dx;
    int dy;
    int speed;
    boolean up, down, left, right;

    public PlayerBox(int xPos, int yPos){
        super(xPos, yPos, new Colour(0, 0, 0));
        this.xPos = xPos;
        this.yPos = yPos;
        dx = dy = 0;
        speed = 5;
        up = down = left = right = false;
    }


    public void update(){
        xPos += dx;
        yPos += dy;
        location = new Point(xPos, yPos);
        rect = new Rect(location.x, location.y, location.x  + size, location.y + size);

    }


    public void stopMoving(){
        dx = dy = 0;
        up = down = left = right = false;
    }

    public void moveUp(){
        stopMoving();
        dy = -speed;
        up = true;
    }

    public void moveDown(){
        stopMoving();
        dy = speed;
        down = true;
    }

    public void moveLeft(){
        stopMoving();
        dx = -speed;
        left = true;
    }

    public void moveRight(){
        stopMoving();
        dx = speed;
        right = true;

    }



}
