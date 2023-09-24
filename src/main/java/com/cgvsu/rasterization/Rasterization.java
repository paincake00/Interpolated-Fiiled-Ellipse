package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void fillEllipse(GraphicsContext gc, int centerX, int centerY, int a, int b, Color colorBorder, Color colorCenter) {

        final PixelWriter pixelWriter = gc.getPixelWriter();

        for (int x = -a; x <= 0; x++) {
            for (int y = -b; y <= 0; y++) {
                double distance = Math.sqrt(Math.pow((double)x / a, 2) + Math.pow((double)y / b, 2));

                if (distance <= 1) {
                    // color interpolation
                    Color color = colorCenter.interpolate(colorBorder, distance);

                    pixelWriter.setColor(x + centerX, y + centerY, color);
                    pixelWriter.setColor(-x + centerX, y + centerY, color);
                    pixelWriter.setColor(x + centerX, -y + centerY, color);
                    pixelWriter.setColor(-x + centerX, -y + centerY, color);
                }
            }
        }
    }




//    public static void drawFilledEllipse(
//                final GraphicsContext graphicsContext,
//                final int a, final int b,
//                final int xCenter, final int yCenter,
//                final Color colorBorder, final Color colorCenter)
//    {
//        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
//
//        for (int y = -b; y <= 0; ++y) {
//            for (int x = -a; x <= 0; ++x) {
//                double equation = (double)(x * x * b * b + y * y * a * a) / (a * a * b * b);
//                if (equation <= 1) {
//
//                    double A = (double)(b*b) / (a*a) + (double) ((y-yCenter) * (y-yCenter)) / ((x-xCenter) * (x-xCenter));
//                    double B = (double)(2*(y-yCenter)*(x*yCenter-xCenter*y)) / ((x-xCenter)*(x-xCenter));
//                    double D = B*B - 4 * A * (((double)((x*yCenter - xCenter*y) * (x*yCenter - xCenter*y)) / ((x-xCenter) * (x-xCenter))) - b*b);
//
//                    double xCross;
//                    double xRes = (-B + Math.sqrt(D)) / (2 * A);
//                    if ( xRes >= xCenter ) {
//                        xCross = xRes;
//                    } else {
//                        xCross = (-B - Math.sqrt(D)) / (2 * A);
//                    }
//                    double yCross = ((xCross-xCenter) * (y-yCenter)) / (double)(x-xCenter) + yCenter;
//
//                    double k = (Math.sqrt((x-xCross) * (x-xCross) + (y-yCross) * (y-yCross)))
//                            / (Math.sqrt((xCenter-xCross) * (xCenter-xCross) + (yCenter-yCross) * (yCenter-yCross)));
//
//
//                    Color colorPoint = Color.rgb(
//                            (int) (255*colorBorder.getRed() + k * (255*colorCenter.getRed() - 255*colorBorder.getRed())),
//                            (int) (255*colorBorder.getGreen() + k * (255*colorCenter.getGreen() - 255*colorBorder.getGreen())),
//                            (int) (255*colorBorder.getBlue() + k * (255*colorCenter.getBlue() - 255*colorBorder.getBlue()))
//                    );
//
//                    pixelWriter.setColor(x + xCenter, y + yCenter, colorPoint);
//                    pixelWriter.setColor(-x + xCenter, y + yCenter, colorPoint);
//                    pixelWriter.setColor(x + xCenter, -y + yCenter, colorPoint);
//                    pixelWriter.setColor(-x + xCenter, -y + yCenter, colorPoint);
//                }
//
//            }
//        }
//    }

}
