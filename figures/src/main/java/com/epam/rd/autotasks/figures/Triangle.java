package com.epam.rd.autotasks.figures;

import java.util.Locale;

class Triangle extends Figure {
    Double x1;
    Double y1;
    Double x2;
    Double y2;
    Double x3;
    Double y3;
    Point t1;
    Point t2;
    Point t3;
    public Triangle(Point a1, Point a2, Point a3){
        x1 = a1.getX();
        x2 = a2.getX();
        x3 = a3.getX();
        y1 = a1.getY();
        y2 = a2.getY();
        y3 = a3.getY();
        t1 = a1;
        t2 = a2;
        t3 = a3;
    }

    @Override
    public double area() {
        Double s = 0.0;
        s = 0.5*Math.abs((x2 - x1)*(y3-y1)-(x3 - x1)*(y2 - y1));
        return s;
    }

    @Override
    public String pointsToString() {
        String sf = String.format(Locale.US, "(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)", x1,y1,x2,y2,x3,y3);
        return sf;
    }


    @Override
    public Point leftmostPoint() {
        if (x1 < x2) {
            if (x1 < x3) {
                return t1;
            } else {
                return t3;
            }
        } else if (x2 < x3) {
            return t2;
        } else {
            return t3;
        }
    }
}
