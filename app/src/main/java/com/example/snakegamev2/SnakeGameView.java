package com.example.snakegamev2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/** The snake game view. */
public class SnakeGameView extends SurfaceView implements SurfaceHolder.Callback {

    /** Screen width. */
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    /** Screen height. */
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    /** The width of a character. */
    public static float charWidth;
    /** The height of a character. */
    public static float charHeight;

    /** The fish tank contents. */
    public SnakeGameManager snakeGameManager;
    /** The part of the program that manages time. */
    private MainThread thread;

    /**
     * Create a new fish tank in the context environment.
     *
     * @param context the environment.
     */
    public SnakeGameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        // Figure out the size of a letter.
        Paint paintText = new Paint();
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        charWidth = paintText.measureText("W");
        charHeight = -paintText.ascent() + paintText.descent();

        // Use the letter size and screen height to determine the size of the fish tank.
        snakeGameManager = new SnakeGameManager((int) (screenHeight / charHeight), (int) (screenWidth / charWidth));
        snakeGameManager.createSnake();

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    /** Update the fish tank. */
    public void update() {
        snakeGameManager.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            snakeGameManager.draw(canvas);
        }
    }
}