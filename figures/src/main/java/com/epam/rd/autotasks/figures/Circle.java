package com.epam.rd.autotasks.figures;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

class Circle extends Figure{
    Double r2;
    Double x1;
    Double y1;
    Double leftX1;
    public Circle(Point c1, Number d) {
        r2 = d.doubleValue();
        x1 = c1.getX();
        y1 = c1.getY();
        leftX1 = c1.getX() - d.doubleValue();
    }

    @Override
    public double area() {
        Double s;
        s = Math.PI * r2 * r2;
        return s;
    }

    @Override
    public String pointsToString() {
        String sf = String.format(Locale.US, "(%.1f,%.1f)", x1, y1);
        return sf;
    }


    @Override
    public String toString() {
        String sf = String.format(Locale.US, "(%.1f,%.1f)", x1, y1);
        DecimalFormatSymbols US = new DecimalFormatSymbols(Locale.US);
        NumberFormat nf = new DecimalFormat("##0.0####", US);
        String rad = nf.format(r2);
        sf +=rad;
        sf = this.getClass().getSimpleName() + "[" + sf + "]";
        return sf;
    }

    @Override
    public Point leftmostPoint() {
        Point leftest = new Point(leftX1,y1);
        return leftest;
    }
}
