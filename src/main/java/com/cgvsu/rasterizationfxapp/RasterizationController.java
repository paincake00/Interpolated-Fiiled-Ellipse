package com.cgvsu.rasterizationfxapp;

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

        Rasterization.fillEllipse(canvas.getGraphicsContext2D(), (int)(canvas.getWidth() / 2),
                (int)(canvas.getHeight() / 2), 200, 100, Color.BLUE, Color.RED);



//        Rasterization.drawFilledEllipse(canvas.getGraphicsContext2D(),
//                200,
//                100,
//                (int)(canvas.getWidth() / 2),
//                (int)(canvas.getHeight() / 2),
//                Color.RED, Color.BLUE);

    }
}