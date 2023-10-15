package com.cgvsu.algorithms;

import com.cgvsu.interfaces.DataReturner;
import com.cgvsu.utils.Point;

import java.util.ArrayList;
import java.util.List;

public class FilledEllipseAlgorithm implements DataReturner {
    private int centerX;
    private int centerY;
    private int a;
    private int b;
    @Override
    public void setParametersForEllipse(int centerX, int centerY, int a, int b) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.a = a;
        this.b = b;
    }
    @Override
    public List<Point> getPoints() {
        return fillEllipse();
    }
    private List<Point> fillEllipse() {
        List<Point> data = new ArrayList<>();

        for (int x = -a; x <= 0; x++) {
            for (int y = -b; y <= 0; y++) {
                double distance = Math.sqrt(Math.pow((double)x / a, 2) + Math.pow((double)y / b, 2));

                if (distance <= 1) {
                    data.add(new Point(x + centerX, y + centerY, distance));
                    data.add(new Point(-x + centerX, y + centerY, distance));
                    data.add(new Point(x + centerX, -y + centerY, distance));
                    data.add(new Point(-x + centerX, -y + centerY, distance));
                }
            }
        }
        return data;
    }
}
