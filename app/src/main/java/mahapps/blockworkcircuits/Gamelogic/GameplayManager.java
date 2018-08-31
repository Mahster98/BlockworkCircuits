package mahapps.blockworkcircuits.Gamelogic;

import java.util.ArrayList;

import mahapps.blockworkcircuits.Objects.GridBox;

public class GameplayManager {


    public void setUpGrid(ArrayList<GridBox> grid, int startX, int startY, int width, int height) {

//        int horizontal = width/size;
//        int vertical = height/size;

        for (int xPos = startX; xPos < width + startX; xPos += size) {
            for (int yPos = startY; yPos < height + startY; yPos += size) {

                grid.add(new GridBox(xPos, yPos));

            }
        }


        for (GridBox box : grid) {
            for (GridBox other : grid) {

                int left = box.rect.left;
                int right = box.rect.right;
                int top = box.rect.top;
                int bottom = box.rect.bottom;
                int otherLeft = other.rect.left;
                int otherRight = other.rect.right;
                int otherTop = other.rect.top;
                int otherBottom = other.rect.bottom;

                //Check left
                if (otherRight == left) {

                    if (otherBottom == top) {
                        box.setTopLeftGrid(other);
                    } else if (otherTop == bottom) {
                        box.setBotLeftGrid(other);
                    } else {
                        box.setLeftGrid(other);
                    }

                } else if (otherLeft == right) {

                    if (otherBottom == top) {
                        box.setTopRightGrid(other);
                    } else if (otherTop == bottom) {
                        box.setBotRightGrid(other);
                    } else {
                        box.setRightGrid(other);
                    }
                } else if (otherBottom == top) {
                    box.setUpperGrid(other);
                } else if (otherTop == bottom) {
                    box.setLowerGrid(other);
                }

            }

        }
    }
}
