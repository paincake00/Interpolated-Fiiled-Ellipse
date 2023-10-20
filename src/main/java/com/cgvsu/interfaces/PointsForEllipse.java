package com.cgvsu.interfaces;

import com.cgvsu.utils.Point;

import java.util.List;

public interface PointsForEllipse {
    List<Point> computePoint(int xPosCenter, int yPosCenter, int a, int b);

//    default void setParametersForSector(int xPosCenter, int yPosCenter, int angle, int radius) {};
//    List<Point> getPoints();
}
