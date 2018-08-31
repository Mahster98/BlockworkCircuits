package mahapps.blockworkcircuits.Objects;

import android.graphics.Color;
import android.view.MotionEvent;

import java.util.ArrayList;

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

    public GridBox(int xPos, int yPos){
        super(xPos, yPos, new Colour(255, 255, 255));

        upperGrid = null;
        lowerGrid = null;
        leftGrid = null;
        rightGrid = null;
        topLeftGrid = null;
        topRightGrid = null;
        botLeftGrid = null;
        botRightGrid = null;



    }


    public void onTouchEvent(MotionEvent event){



        if(rect.contains(Math.round(event.getX()), Math.round(event.getY()))){

            System.out.println("touch");

            if(upperGrid != null) {
                upperGrid.fill.setColor(Color.BLUE);
            }
            if(lowerGrid != null) {
                lowerGrid.fill.setColor(Color.BLACK);
            }
            if(leftGrid != null) {
                leftGrid.fill.setColor(Color.GRAY);
            }
            if(rightGrid != null) {
                rightGrid.fill.setColor(Color.GREEN);
            }
            if(topLeftGrid != null) {
                topLeftGrid.fill.setColor(Color.MAGENTA);
            }
            if(topRightGrid != null) {
                topRightGrid.fill.setColor(Color.CYAN);
            }
            if(botLeftGrid != null) {
                botLeftGrid.fill.setColor(Color.RED);
            }
            if(botRightGrid != null) {
                botRightGrid.fill.setColor(Color.YELLOW);
            }

//
        }

    }

public void setUpGrid(ArrayList<GridBox> grid, int startX, int startY, int width, int height){

//        int horizontal = width/size;
//        int vertical = height/size;

        for(int xPos = startX; xPos < width + startX; xPos += size){
            for (int yPos = startY; yPos < height + startY; yPos += size){

                grid.add(new GridBox(xPos, yPos));

            }
        }


        for(GridBox box : grid){
            for (GridBox other : grid){

                int left = box.rect.left;
                int right = box.rect.right;
                int top = box.rect.top;
                int bottom = box.rect.bottom;
                int otherLeft = other.rect.left;
                int otherRight = other.rect.right;
                int otherTop = other.rect.top;
                int otherBottom = other.rect.bottom;

                //Check left
                if (otherRight == left){

                    if(otherBottom == top){
                        box.setTopLeftGrid(other);
                    }

                    else if (otherTop == bottom){
                        box.setBotLeftGrid(other);
                    }

                    else {
                        box.setLeftGrid(other);
                    }

                }

                else if (otherLeft == right){

                    if(otherBottom == top){
                        box.setTopRightGrid(other);
                    }

                    else if (otherTop == bottom){
                        box.setBotRightGrid(other);
                    }

                    else {
                        box.setRightGrid(other);
                    }
                }

                else if (otherBottom == top){
                    box.setUpperGrid(other);
                }

                else if (otherTop == bottom) {
                    box.setLowerGrid(other);
                }

                int set = top + bottom;
            }

        }


}

}
