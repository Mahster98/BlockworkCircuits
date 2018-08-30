package mahapps.blockworkcircuits.Objects;

import android.graphics.Color;

/**
 * Custom class for storing colour data
 * Also uses Canadian spelling of colour so HA
 */

public class Colour {

    private int red;
    private int blue;
    private int green;

    Colour(int r, int b, int g){
        red = r;
        blue = b;
        green = g;
    }

    //TODO Create hex converter

//    Colour(int value){
//
//        Integer hex = new Integer(value);
//
//
//
//
//    }
    public int getColour(){
       return Color.rgb(red, green, blue);
    }
}
