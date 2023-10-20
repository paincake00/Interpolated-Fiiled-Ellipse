package com.cgvsu.figures;

import com.cgvsu.interfaces.PointsForEllipse;
import com.cgvsu.algorithms.FilledEllipseAlgorithm;
import com.cgvsu.interfaces.Drawable;
import com.cgvsu.interfaces.PointsForEllipse;
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
    private PointsForEllipse algorithm = null;
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
    public void changeAlgorithm(PointsForEllipse algorithm) {
        this.algorithm = algorithm;
    }
    private List<Point> useAlgorithm() {
        if (algorithm == null) {
            algorithm = new FilledEllipseAlgorithm();
        }
        return algorithm.computePoint(xCenter, yCenter, a, b);
    }
    @Override
    public void draw(GraphicsContext gc) {
        final PixelWriter pixelWriter = gc.getPixelWriter();

        for (Point point : useAlgorithm()) {
            pixelWriter.setColor(
                    point.getX(),
                    point.getY(),
                    interpolation ? colorCenter.interpolate(colorBorder,
                            Math.sqrt(Math.pow((double)(point.getX() - xCenter) / a, 2) + Math.pow((double)(point.getY() - yCenter) / b, 2))) : color
            );
        }
    }
}
