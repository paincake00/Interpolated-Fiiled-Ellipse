package com.cgvsu.rasterizationfxapp;

import com.cgvsu.algorithms.FilledEllipse;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        Rasterization rasterization = new Rasterization();

        rasterization.draw(canvas.getGraphicsContext2D(), new FilledEllipse((int)(canvas.getWidth() / 2),
                (int)(canvas.getHeight() / 2), 200, 100, Color.BLACK, Color.GREEN).fillEllipse());

    }
}