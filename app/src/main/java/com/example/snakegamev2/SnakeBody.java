package com.example.snakegamev2;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class SnakeBody extends Snake {
    /**
     * This snake's first coordinate.
     */
    private int my_curr_row;

    /**
     * This snake's second coordinate.
     */
    private int my_curr_col;

    /** This snake's body direction. */
    /**
     * up, down, left or right
     */
    private String direction;

    /** this snake's body position. */
    /**
     * Head, body and tail
     */
    private String bodyType;

    /**
     * Snake's appearance on the screen.
     */
    public String appearance;

    private Paint paintText = new Paint();


    /**
     * Constructors
     */
    public SnakeBody(int rowNum, int colNum, String direction, String bodyType) {
        my_curr_row = rowNum;
        my_curr_col = colNum;
        this.direction = direction;
        this.bodyType = bodyType;

        if (this.bodyType.equals("head")) {
            this.appearance = "⚉";
            paintText.setTextSize(60);
            paintText.setColor(Color.RED);
            paintText.setTypeface(Typeface.DEFAULT_BOLD);
        }
        else if (this.bodyType.equals("body") || this.bodyType.equals("tail")) {
            this.appearance = "●";
            paintText.setTextSize(40);
            paintText.setColor(Color.GREEN);
            paintText.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    /** Return the current row number of this snake body. */
    public int getMy_curr_row(){ return my_curr_row; }

    /** Return the current col number of this snake body. */
    public int getMy_curr_col() { return my_curr_col; }

    /** Set the current row number of this snake body.*/
    public void setMy_curr_row(int rowNum) {this.my_curr_row = rowNum;}

    /** Set the current col number of this snake body.*/
    public void setMy_curr_col(int colNum) {this.my_curr_col = colNum;}

    /** get the current type of this snake. */
    public String getBodyType(){return this.bodyType;}

    /** set the type of this snake. */
    public void setBodyType(String bodyType) {this.bodyType = bodyType;}

    /** get the current direction of this snake. */
    public String getDirection(){return this.direction;}

    /** set the direction of current snake. */
    public void setDirection(String direction){this.direction = direction;}


}


