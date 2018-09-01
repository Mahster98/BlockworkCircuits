package mahapps.blockworkcircuits.Gamelogic;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Random;

import mahapps.blockworkcircuits.Objects.*;

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

    public PlayerBox spawnPlayer(ArrayList<GridBox> grid){

        Point pos = null;

        while(true){

            int loc = generateRandomNumberInRange(0, grid.size());

            GridBox gridBox = grid.get(loc);


            if(gridBox.getSpawnLabel() == null) {
                gridBox.setSpawnLabel("Player");
                pos = new Point(gridBox.getLocation());
                break;
            }
        }

        if(pos == null){
            System.err.println("Position has not been correctly calculated. ERR!");
            return new PlayerBox(0,0, grid.get(0).getSize());
        }


        return new PlayerBox(pos.x, pos.y, grid.get(0).getSize());
    }

    public ArrayList<TerminalBox> spawnTerminals(ArrayList<GridBox> grid, int lower, int upper){

        ArrayList<TerminalBox> terminals = new ArrayList<>();

        int numSpawn = generateRandomNumberInRange(lower, upper);

        for (int i = 0; i <= numSpawn; i++) {

            while (true) {

                int index = generateRandomNumberInRange(0, grid.size());
                GridBox gridBox = grid.get(index);

                if(gridBox.getSpawnLabel() == null){
                    gridBox.setSpawnLabel("Terminal");
                    terminals.add(new TerminalBox(gridBox.getLocation().x, gridBox.getLocation().y, gridBox.getSize()));
                    break;
                }

            }

        }
        return terminals;
    }



    private int generateRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}
