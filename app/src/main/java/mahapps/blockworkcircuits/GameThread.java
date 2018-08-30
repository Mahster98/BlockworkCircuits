package mahapps.blockworkcircuits;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by xelah on 2018-08-30.
 * Custom Thread class - extra Failsafes to prevent thread errors.
 */

public class GameThread extends Thread {

    private final int MAX_FPS = 30;
    private SurfaceHolder surfaceHolder;
    private PlayZone game;
    private boolean running;
    Canvas canvas;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public GameThread(SurfaceHolder surfaceholder, PlayZone game){
        super();
        this.surfaceHolder = surfaceholder;
        this.game = game;
        canvas = Constants.canvas;
    }

    @Override
    public void run() {
        long startTime;
        long timeMillis = 100/MAX_FPS;
        long waitTime;
        long targetTime = 1000/MAX_FPS;

        while (running) {
            startTime = System.nanoTime();
            canvas = null;

            //Main game loop
            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    this.game.update();
                    this.game.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch(Exception e) { e.printStackTrace();}
                }
            }

            timeMillis = (System.nanoTime() - startTime)/1000000;
            waitTime = targetTime - timeMillis;

            //Sleeps thread if needed
            try{
                if (waitTime > 0) {
                    this.sleep(waitTime);
                }

            }catch(Exception e) { e.printStackTrace();}

        }
    }
}
