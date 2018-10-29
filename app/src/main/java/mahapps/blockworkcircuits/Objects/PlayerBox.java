package mahapps.blockworkcircuits.Objects;


import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;


public class PlayerBox extends BoxBase{

    int xPos;
    int yPos;
    int dx;
    int dy;
    int speed;
    boolean up, down, left, right, playing;
    GridBox grid;
    Point targetLocation;


    public PlayerBox(int xPos, int yPos, int size, GridBox grid){
        super(xPos, yPos, size, new Colour(0, 0, 0));
        this.xPos = xPos;
        this.yPos = yPos;
        dx = dy = 0;
        speed = 5;
        up = down = left = right = false;
        this.grid = grid;
        targetLocation = new Point(xPos, yPos);
    }


    public void update(Vector<PlayerBox> playerBoxes){

        if(playing) {
            xPos += dx;
            yPos += dy;
            setLocation(new Point(xPos, yPos));
            setRect(new Rect(getLocation().x, getLocation().y, getLocation().x + getSize(), getLocation().y + getSize()));

            if (getLocation().x == targetLocation.x && getLocation().y == targetLocation.y) {
                assignDirection(playerBoxes);
            }
        }

    }

    public void setGrid(GridBox grid) {
        this.grid = grid;
    }

    public GridBox getGrid() {
        return grid;
    }

    public void startPlaying() {
        playing = true;
    }

    public void stopPlaying(){
        playing = false;
    }

    private void stopMoving(){
        dx = dy = 0;
        up = down = left = right = false;
    }

    private void moveUp(){
        stopMoving();
        dy = -speed;
        up = true;
    }

    private void moveDown(){
        stopMoving();
        dy = speed;
        down = true;
    }

    private void moveLeft(){
        stopMoving();
        dx = -speed;
        left = true;
    }

    private void moveRight(){
        stopMoving();
        dx = speed;
        right = true;

    }

    public void move(String move){
        if(move.equals("Top")){
            moveUp();
        }
        else if( move.equals("Bot")){
            moveDown();
        }

        else if (move.equals("Right")){
            moveRight();
        }
        else if (move.equals("Left")){
            moveLeft();
        }
    }

//When location = gridBox location
    public void assignDirection(Vector<PlayerBox> playerBoxes) {


            HashSet<GridBox> paths = grid.getPaths();
            Iterator<GridBox> it = paths.iterator();

            for (int i = 1; i <= paths.size(); i++) {

                GridBox path = it.next();

                if (paths.size() == i) {
                    move(grid.getAdjacentKey(path));
                    grid = path;
                    targetLocation = grid.getLocation();
                }
                else{

                    PlayerBox newPlayer = new PlayerBox(grid.getLocation().x, grid.getLocation().y,  grid.getSize(), path);
                    newPlayer.move(grid.getAdjacentKey(path));
                    newPlayer.targetLocation = path.getLocation();
                    playerBoxes.add(newPlayer);

                }

                grid.setVisited(true);

            }

        }


    public void onTouchEvent(MotionEvent event){
        if (getRect().contains(Math.round(event.getX()), Math.round(event.getY()))){
            startPlaying();
        }
    }

}
