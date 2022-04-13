package com.example.snakegamev2;

import android.graphics.Canvas;

import java.util.List;

public class SnakeGameManager {

    public List<SnakeGame.SnakeGame> snakes;
    /** The width of myLittleFishes. */
    private int gridWidth;
    /** The height of myLittleFishes. */
    private int gridHeight;

    /**
     * Return the width of a row of locations.
     *
     * @return the width of a column of locations.
     */
    public int getGridWidth() {return gridWidth;}

    /**
     * Return the height of a column of locations.
     *
     * @return the height of a column of locations.
     */
    public int getGridHeight() {return gridHeight;}

    public SnakeGameManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
    }

    public void draw(Canvas canvas){
        for(int i = 0; i < snakes.size(); i++){
            if (snakes.get(i) != null) snakes.get(i).draw(canvas);
        }
    }

    public void update(){
        for (int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i) != null) snakes.get(i).action();
        }
    }

    public void createSnake(){

        snakes.add(new SnakeGame.SnakeBody(2, 0, "down", "head"));
        snakes.add(new SnakeGame.SnakeBody(1, 0, "down", "body"));
        snakes.add(new SnakeGame.SnakeBody(0, 0, "down", "tail"));
    }

}
