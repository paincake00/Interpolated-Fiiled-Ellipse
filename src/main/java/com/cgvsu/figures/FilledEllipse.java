package com.cgvsu.figures;

import com.cgvsu.interfaces.DataReturner;
import com.cgvsu.algorithms.FilledEllipseAlgorithm;
import com.cgvsu.interfaces.Drawable;
import com.cgvsu.utils.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.util.List;

public class FilledEllipse implements Drawable {
    private final int xCenter;
    private final int yCenter;
    private final int a;
    private final int b;
    private final Color color;
    private Color colorCenter = null;
    private Color colorBorder = null;
    private boolean interpolation = false;
    private DataReturner algorithm = null;
    public FilledEllipse(int xCenter, int yCenter, int a, int b, Color color) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.a = a;
        this.b = b;
        this.color = color;
    }
    @Override
    public void interpolate(Color colorCenter, Color colorBorder) {
        interpolation = true;
        this.colorCenter = colorCenter;
        this.colorBorder = colorBorder;
    }
    @Override
    public void changeAlgorithm(DataReturner algorithm) {
        this.algorithm = algorithm;
    }
    private List<Point> useAlgorithm() {
        if (algorithm == null) {
            algorithm = new FilledEllipseAlgorithm();
        }
        algorithm.setParametersForEllipse(xCenter, yCenter, a, b);
        return algorithm.getPoints();
    }
    @Override
    public void draw(GraphicsContext gc) {
        final PixelWriter pixelWriter = gc.getPixelWriter();

        for (Point point : useAlgorithm()) {
            pixelWriter.setColor(
                    point.getX(),
                    point.getY(),
                    interpolation ? colorCenter.interpolate(colorBorder, point.getDistance()) : color
            );
        }
    }
}
