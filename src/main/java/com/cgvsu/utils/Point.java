package com.cgvsu.utils;

public class Point {
    private final int x;
    private final int y;
    private final double distance;
    public Point(int x, int y, double distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public double getDistance() {
        return distance;
    }
}
