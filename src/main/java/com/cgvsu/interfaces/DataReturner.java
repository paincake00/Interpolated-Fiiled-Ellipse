package com.cgvsu.interfaces;

import com.cgvsu.utils.Point;

import java.util.List;

public interface DataReturner {
    void setParametersForEllipse(int xPosCenter, int yPosCenter, int a, int b);
    List<Point> getPoints();
}
