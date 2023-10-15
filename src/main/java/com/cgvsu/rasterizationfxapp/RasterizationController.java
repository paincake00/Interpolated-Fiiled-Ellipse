package com.cgvsu.rasterizationfxapp;

import com.cgvsu.interfaces.Drawable;
import com.cgvsu.figures.FilledEllipse;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        ArrayList<Drawable> figures = new ArrayList<>();
        Drawable figure = new FilledEllipse(
                (int)(canvas.getWidth() / 2),
                (int)(canvas.getHeight() / 2),
                200,
                100,
                Color.BLACK);
        figure.interpolate(Color.AQUA, Color.BLACK);
        figures.add(figure);

        for (Drawable f : figures) {
            f.draw(canvas.getGraphicsContext2D());
        }
    }
}