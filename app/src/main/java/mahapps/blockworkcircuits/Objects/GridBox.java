package mahapps.blockworkcircuits.Objects;

import android.graphics.Color;
import android.view.MotionEvent;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;


/**
 * Acts as the grid background of the game. Each instance of GridBox is a node of a graph
 */

public class GridBox extends BoxBase {


    private Hashtable <String, GridBox> adjacent;
    private String spawnLabel;
    private boolean on, availableMove, visited;



    public GridBox(int xPos, int yPos, int size){
        super(xPos, yPos, size, new Colour(255, 255, 255));

        adjacent = new Hashtable<>();

        spawnLabel = null;
        on = false;
        availableMove = false;
        visited = false;

    }

    public GridBox(int xPos, int yPos, int size, String spawnLabel){
        this(xPos,yPos,size);
        this.spawnLabel = spawnLabel;
    }


    public String getSpawnLabel() {
        return spawnLabel;
    }

    public boolean isAvailable(){
        if(availableMove){
            return true;
        }
        return false;
    }

    public void addAdjacent(String key, GridBox element){
        adjacent.put(key, element);
    }

    public void setAvailableMove(boolean availableMove) {
        this.availableMove = availableMove;
    }

    public void setSpawnLabel(String spawnLabel) {
        this.spawnLabel = spawnLabel;
    }

    public boolean isOn() {
        return on;
    }

    //Returns a string detailing where the other grid is relative to the current grid
    public String getAdjacentKey(GridBox other) {


        int left = getRect().left;
        int right = getRect().right;
        int top = getRect().top;
        int bottom = getRect().bottom;
        int otherLeft = other.getRect().left;
        int otherRight = other.getRect().right;
        int otherTop = other.getRect().top;
        int otherBottom = other.getRect().bottom;

        if (otherRight == left) {

            if (otherBottom == top) {
                return "Top Left";
            } else if (otherTop == bottom) {
                return "Bot Left";
            } else if (top == otherTop && bottom == otherBottom) {
                return "Left";
            }

        } else if (otherLeft == right) {

            if (otherBottom == top) {
                return "Top Right";
            } else if (otherTop == bottom) {
                return "Bot Right";
            } else if (top == otherTop && bottom == otherBottom) {
                return "Right";
            }
        } else if (right == otherRight && left == otherLeft) {

            if (otherBottom == top) {
                return "Top";
            } else if (otherTop == bottom) {
                return "Bot";
            }
        }

        return null;
    }



    public void on() {
        on = true;

        Iterator<String> it = adjacent.keySet().iterator();

        while(it.hasNext()){

           String key = it.next();

            if(key.equals("Top") || key.equals("Left") || key.equals("Bot") || key.equals("Right")) {

                GridBox other = adjacent.get(key);
                other.setAvailableMove(true);

            }


        }

    }

    public void off(){
        on = false;

        Iterator<String> it = adjacent.keySet().iterator();

        while(it.hasNext()){

            String key = it.next();

            if(key.equals("Top") || key.equals("Left") || key.equals("Bot") || key.equals("Right")) {

                GridBox other = adjacent.get(key);
                if(other.isAvailable() && !other.isOn()) {
                    other.setAvailableMove(false);
                }

            }


        }

    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public boolean isVisited(){
        return visited;
    }

    public HashSet<GridBox> getPaths(){

        HashSet<GridBox> paths = new HashSet<>();

        return paths;
    }

    public void onTouchEvent(MotionEvent event){

        switch(event.getActionMasked()) {

            case MotionEvent.ACTION_DOWN:

                if (availableMove) {
                    if (getRect().contains(Math.round(event.getX()), Math.round(event.getY()))) {
                        if (!on) {
                            on();
                        } else {
                            off();
                        }
                    }
                }


                break;

        }

    }

    public void update(){

        if(on){
            getFill().setColor(Color.BLUE);
        }
        else if(availableMove){
            getFill().setColor(Color.CYAN);
        }
        else{
            getFill().setColor(Color.WHITE);
        }

    }


}

