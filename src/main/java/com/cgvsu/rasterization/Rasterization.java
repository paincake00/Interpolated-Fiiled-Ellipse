package com.cgvsu.rasterization;

import com.cgvsu.utils.Pixel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;

import java.util.Set;

public class Rasterization implements Drawable {

    @Override
    public void draw(GraphicsContext gc, Set<Pixel> data) {
        final PixelWriter pixelWriter = gc.getPixelWriter();

        for (Pixel pixel : data) {
            pixelWriter.setColor(pixel.getX(), pixel.getY(), pixel.getColor());
        }
    }

}
