package mahapps.blockworkcircuits.Objects;

import android.graphics.Color;
import android.view.MotionEvent;


/**
 * Acts as the grid background of the game. Each instance of GridBox is a node of a graph
 */

public class GridBox extends BoxBase {

    private GridBox upperGrid;
    private GridBox lowerGrid;
    private GridBox leftGrid;
    private GridBox rightGrid;
    private GridBox topLeftGrid;
    private GridBox topRightGrid;
    private GridBox botLeftGrid;
    private GridBox botRightGrid;
    private String spawnLabel;
    private boolean on, availableMove;



    public GridBox(int xPos, int yPos, int size){
        super(xPos, yPos, size, new Colour(255, 255, 255));

        upperGrid = null;
        lowerGrid = null;
        leftGrid = null;
        rightGrid = null;
        topLeftGrid = null;
        topRightGrid = null;
        botLeftGrid = null;
        botRightGrid = null;
        spawnLabel = null;
        on = false;
        availableMove = false;

    }

    public GridBox(int xPos, int yPos, int size, String spawnLabel){
        this(xPos,yPos,size);
        this.spawnLabel = spawnLabel;
    }

    public GridBox getUpperGrid() {
        return upperGrid;
    }

    public void setUpperGrid(GridBox upperGrid) {
        this.upperGrid = upperGrid;
    }

    public GridBox getLowerGrid() {
        return lowerGrid;
    }

    public void setLowerGrid(GridBox lowerGrid) {
        this.lowerGrid = lowerGrid;
    }

    public GridBox getLeftGrid() {
        return leftGrid;
    }

    public void setLeftGrid(GridBox leftGrid) {
        this.leftGrid = leftGrid;
    }

    public GridBox getRightGrid() {
        return rightGrid;
    }

    public void setRightGrid(GridBox rightGrid) {
        this.rightGrid = rightGrid;
    }

    public GridBox getTopLeftGrid() {
        return topLeftGrid;
    }

    public void setTopLeftGrid(GridBox topLeftGrid) {
        this.topLeftGrid = topLeftGrid;
    }

    public GridBox getTopRightGrid() {
        return topRightGrid;
    }

    public void setTopRightGrid(GridBox topRightGrid) {
        this.topRightGrid = topRightGrid;
    }

    public GridBox getBotLeftGrid() {
        return botLeftGrid;
    }

    public void setBotLeftGrid(GridBox botLeftGrid) {
        this.botLeftGrid = botLeftGrid;
    }

    public GridBox getBotRightGrid() {
        return botRightGrid;
    }

    public void setBotRightGrid(GridBox botRightGrid) {
        this.botRightGrid = botRightGrid;
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

    public void setAvailableMove(boolean availableMove) {
        this.availableMove = availableMove;
    }

    public void setSpawnLabel(String spawnLabel) {
        this.spawnLabel = spawnLabel;
    }

    public boolean isOn() {
        return on;
    }

    public void on() {
        on = true;

        if (leftGrid != null) {
            leftGrid.setAvailableMove(true);
        }
        if (rightGrid != null) {
            rightGrid.setAvailableMove(true);
        }
        if (upperGrid != null) {
            upperGrid.setAvailableMove(true);
        }
        if (lowerGrid != null) {
            lowerGrid.setAvailableMove(true);
        }
    }

    public void off(){
        on = false;
        if (leftGrid != null) {
            if(leftGrid.isAvailable() && !leftGrid.isOn()) {
                leftGrid.setAvailableMove(false);
            }
        }
        if (rightGrid != null) {
            if(rightGrid.isAvailable()&& !rightGrid.isOn()) {
                rightGrid.setAvailableMove(false);
            }
        }
        if (upperGrid != null) {
            if(upperGrid.isAvailable()&& !upperGrid.isOn()) {
                upperGrid.setAvailableMove(false);
            }
        }
        if (lowerGrid != null) {
            if(lowerGrid.isAvailable() && !lowerGrid.isOn()) {
                lowerGrid.setAvailableMove(false);
            }
        }
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

