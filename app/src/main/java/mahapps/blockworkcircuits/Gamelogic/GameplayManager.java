package mahapps.blockworkcircuits.Gamelogic;

import java.util.ArrayList;

import mahapps.blockworkcircuits.Objects.GridBox;

public class GameplayManager {


    public void setUpGrid(ArrayList<GridBox> grid, int startX, int startY, int size, int width, int height) {


        for (int xPos = startX; xPos < width + startX; xPos += size) {
            for (int yPos = startY; yPos < height + startY; yPos += size) {

                grid.add(new GridBox(xPos, yPos, size));

            }
        }


        for (GridBox box : grid) {
            for (GridBox other : grid) {

                int left = box.getRect().left;
                int right = box.getRect().right;
                int top = box.getRect().top;
                int bottom = box.getRect().bottom;
                int otherLeft = other.getRect().left;
                int otherRight = other.getRect().right;
                int otherTop = other.getRect().top;
                int otherBottom = other.getRect().bottom;

                if (otherRight == left) {

                    if (otherBottom == top) {
                        box.setTopLeftGrid(other);
                    } else if (otherTop == bottom) {
                        box.setBotLeftGrid(other);
                    } else if (top == otherTop && bottom == otherBottom) {
                        box.setLeftGrid(other);
                    }

                } else if (otherLeft == right) {

                    if (otherBottom == top) {
                        box.setTopRightGrid(other);
                    } else if (otherTop == bottom) {
                        box.setBotRightGrid(other);
                    } else if (top == otherTop && bottom == otherBottom) {
                        box.setRightGrid(other);
                    }
                }
                else if(right == otherRight && left == otherLeft) {

                    if (otherBottom == top) {
                        box.setUpperGrid(other);
                    } else if (otherTop == bottom) {
                        box.setLowerGrid(other);
                    }
                }

            }

        }
    }
}
