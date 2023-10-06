package com.cgvsu.rasterization;

import com.cgvsu.utils.Pixel;
import javafx.scene.canvas.GraphicsContext;

import java.util.Set;

public interface Drawable {
    void draw(GraphicsContext gc, Set<Pixel> data);
}
