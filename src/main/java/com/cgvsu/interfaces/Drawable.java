package com.cgvsu.interfaces;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Drawable {
    void draw(GraphicsContext gc);
    void interpolate(Color colorCenter, Color colorBorder);
    void changeAlgorithm(DataReturner algorithm);
}
