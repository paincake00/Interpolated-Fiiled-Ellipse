package com.cgvsu.algorithms;

import com.cgvsu.interfaces.PointsForEllipse;
import com.cgvsu.utils.Point;

import java.util.ArrayList;
import java.util.List;

public class FilledEllipseAlgorithm implements PointsForEllipse {
    private int centerX;
    private int centerY;
    private int a;
    private int b;
    @Override
    public List<Point> computePoint(int centerX, int centerY, int a, int b) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.a = a;
        this.b = b;
        return fillEllipse();
    }
    private List<Point> fillEllipse() {
        List<Point> data = new ArrayList<>();

        for (int x = -a; x <= a; x++) {
            for (int y = -b; y <= b; y++) {
                double distance = Math.sqrt(Math.pow((double)x / a, 2) + Math.pow((double)y / b, 2));

                if (distance <= 1) {
                    data.add(new Point(x + centerX, y + centerY));
                }
            }
        }
        return data;
    }
}
