package mahapps.blockworkcircuits;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by xelah on 2018-08-30.
 *
 * Utilises the SurfaceView class of Android to add Touchscreen and Canvas functionality
 *
 */

public class PlayZone extends SurfaceView implements SurfaceHolder.Callback  {

    /**
     * Custom Thread to run game loop
     */
    private GameThread thread;


    public PlayZone(Context context) {
        super(context);

        getHolder().addCallback(this);

        setup();

        setFocusable(true);
        //Changes
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }



    @Override
    public void surfaceCreated(SurfaceHolder holder){

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try{
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {e.printStackTrace();}
            retry = false;
        }
    }

    /**
     * Touchscreen event listener
     *
     * @param event Touch event
     * @return true if screen has been touched
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        return true;

    }


    /**
     * Updates the game everytime it is called
     */
    public void update(){

    }

    /**
     * Draws onto the Canvas
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {

        super.draw(canvas);
        canvas.drawRect(new Rect(), new Paint());



    }

    /**
     * Sets up the game
     */
    public void setup() {


        Constants.ACTIVE_SCENE = 0;

        thread = new GameThread(getHolder(), this);


    }


}
