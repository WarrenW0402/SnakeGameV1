package com.example.snakegamev2;

import android.graphics.Canvas;

abstract class SnakeGame {

    abstract int getMy_curr_row();

    abstract int getMy_curr_col();

    abstract void action();

    abstract void draw(Canvas canvas);
}
