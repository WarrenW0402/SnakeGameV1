package com.example.snakegamev2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class Snake extends SnakeGame.SnakeGame {


    private int my_curr_row;

    private int my_curr_col;

    private SnakeGame.SnakeGameManager manager;
//    for (int i = 0; i < this.manager.snakes.size(); i++){
//
//    }
//    SnakeBody head = new SnakeBody(2, 0, "down", "head");
//    SnakeBody body = new SnakeBody(1, 0, "down", "body");
//    SnakeBody tail = new SnakeBody(0, 0, "down", "tail");


    /**
     * all the snakebodies that construct this snake
     */
    public ArrayList<SnakeGame.SnakeBody> snakebodies = new ArrayList(Arrays.asList(manager.snakes.get(0), manager.snakes.get(1), manager.snakes.get(2)));


    public ArrayList<Integer> turningpointsX = new ArrayList<>();
    public ArrayList<Integer> turningpointsY = new ArrayList<>();

    private Paint paintText = new Paint();


    @Override
    int getMy_curr_row() {
        return 0;
    }

    @Override
    int getMy_curr_col() {
        return 0;
    }

    @Override
    void action() {
        /** turn the snake's body and tail when encounter a turning point.
         *  delete the turning point after tail passes. */
        for (int i = 1; i < snakebodies.size(); i++) {
            if (snakebodies.get(i) == body || snakebodies.get(i) == tail) {
                if (snakebodies.get(i).getMy_curr_col() == turningpointsY.get(0) && snakebodies.get(i).getMy_curr_row() == turningpointsX.get(0)) {
                    snakebodies.get(i).setDirection(snakebodies.get(0).getDirection());
                    if (snakebodies.get(i) == tail) {
                        turningpointsY.remove(0);
                        turningpointsX.remove(0);
                    }
                }
            }
        }
        switch (head.getDirection()) {
            case "up":
                my_curr_row += 1;
                break;
            case "down":
                my_curr_row -= 1;
                break;
            case "left":
                my_curr_col -= 1;
                break;
            case "right":
                my_curr_col += 1;
                break;
        }
        switch (body.getDirection()) {
            case "up":
                my_curr_row += 1;
                break;
            case "down":
                my_curr_row -= 1;
                break;
            case "left":
                my_curr_col -= 1;
                break;
            case "right":
                my_curr_col += 1;
                break;
        }
        switch (tail.getDirection()) {
            case "up":
                my_curr_row += 1;
                break;
            case "down":
                my_curr_row -= 1;
                break;
            case "left":
                my_curr_col -= 1;
                break;
            case "right":
                my_curr_col += 1;
                break;
        }


    }

    /**
     * change the direction on each movement key pressed
     */
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_W:
                snakebodies.get(0).setDirection("up");
                turningpointsY.add(head.getMy_curr_col());
                turningpointsX.add(head.getMy_curr_row());
                return true;

            case KeyEvent.KEYCODE_A:
                snakebodies.get(0).setDirection("left");
                turningpointsY.add(head.getMy_curr_col());
                turningpointsX.add(head.getMy_curr_row());
                return true;

            case KeyEvent.KEYCODE_D:
                snakebodies.get(0).setDirection("right");
                turningpointsY.add(head.getMy_curr_col());
                turningpointsX.add(head.getMy_curr_row());
                return true;

            case KeyEvent.KEYCODE_S:
                snakebodies.get(0).setDirection("down");
                turningpointsY.add(head.getMy_curr_col());
                turningpointsX.add(head.getMy_curr_row());
                return true;
            default:
                return false;
        }

    }

    private void drawString(Canvas canvas, String s, int x, int y) {
        canvas.drawText(s, y * SnakeGame.SnakeGameView.charWidth, x * SnakeGame.SnakeGameView.charHeight, paintText);
    }

    @Override
    void draw(Canvas canvas) {
        for (int i = 0; i < snakebodies.size(); i++) {
            if (snakebodies.get(i) == head) {
                drawString(canvas, head.appearance, my_curr_row, my_curr_col);
            }
            else {
                drawString(canvas, body.appearance, my_curr_row, my_curr_col);

            }
        }
    }
}






