package mahapps.blockworkcircuits.Objects;

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



}
