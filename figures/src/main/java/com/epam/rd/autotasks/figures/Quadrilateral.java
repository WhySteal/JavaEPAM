package com.epam.rd.autotasks.figures;

import java.util.Locale;

class Quadrilateral extends Figure {
    Double x1;
    Double y1;
    Double x2;
    Double y2;
    Double x3;
    Double y3;
    Double x4;
    Double y4;
    Point t1;
    Point t2;
    Point t3;
    Point t4;
    public Quadrilateral(Point b1, Point b2, Point b3, Point b4) {
        x1 = b1.getX();
        x2 = b2.getX();
        x3 = b3.getX();
        y1 = b1.getY();
        y2 = b2.getY();
        y3 = b3.getY();
        x4 = b4.getX();
        y4 = b4.getY();
        t1 = b1;
        t2 = b2;
        t3 = b3;
        t4 = b4;
    }

    @Override
    public double area() {
        Double s = 0.0;
        s = (0.5*Math.abs((x2 - x1)*(y3-y1)-(x3 - x1)*(y2 - y1))) + (0.5*Math.abs((x3 - x1)*(y4-y1)-(x4 - x1)*(y3 - y1)));
        return s;
    }

    @Override
    public String pointsToString() {
        String sf = String.format(Locale.US, "(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)", x1, y1, x2, y2, x3, y3, x4, y4);
        return sf;
    }


    @Override
    public Point leftmostPoint() {
        if (x1 < x2) {
            if (x1 < x3) {
                if (x1 < x4) {
                    return t1;
                } else {
                    return t4;
                }
            }
            if (x3 < x4) {
                return t3;
            } else {
                return t4;
            }
        } else if (x2 < x3) {
            if (x2 < x4) {
                return t2;
            } else {
                return t4;
            }
        } else if (x3 < x4) {
            return t3;
        } else {
            return t4;
        }
    }
}
