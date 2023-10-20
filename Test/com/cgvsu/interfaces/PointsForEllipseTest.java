package com.cgvsu.interfaces;

import com.cgvsu.algorithms.FilledEllipseAlgorithm;
import com.cgvsu.utils.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointsForEllipseTest {

    Point[] testPoints;
    int width = 400;
    int height = 300;

    @Test
    public void test() {
        List<Point> points = new FilledEllipseAlgorithm().computePoint(width, height, 2, 1);

        testPoints = new Point[]{
                new Point( -2, 0),
                new Point( -1, 0),
                new Point( 0, -1),
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 0),
                new Point(2, 0)
        };

//        for (Point p : points) {
//            System.out.println((p.getX() - width) + ";" + (p.getY() - height));
//        }

        int index = 0;
        for (Point p : points) {
            System.out.println((testPoints[index].getX() == (p.getX() - width))
                    && (testPoints[index].getY() == (p.getY() - height)));
            index++;
        }
    }
}