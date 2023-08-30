package com.epam.rd.autotasks.segments;

import static java.lang.Math.*;
import static java.lang.StrictMath.pow;

class Segment {
    Double x1;
    Double x2;
    Double y1;
    Double y2;
    public Segment(Point start, Point end) {
        if (start == end) {
            throw new RuntimeException();
        }
        if ((start.getX() == end.getX()) & (start.getY() == end.getY())) {
            throw new RuntimeException();
        }
    x1 = start.getX();
    x2 = end.getX();
    y1 = start.getY();
    y2 = end.getY();
    }

    double length() {
        Double len = sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        return len;
    }

    Point middle() {
        Point mid = new Point((x1+x2)/2, (y1+y2)/2);
        return mid;
    }

    Point intersection(Segment another) {
        Double x3 = another.x1;
        Double x4 = another.x2;
        Double y3 = another.y1;
        Double y4 = another.y2;
        if ((y2-y1)/(x2-x1) == (y4-y3)/(x4-x3)) {
            return null;
        }
        // точки по порядку
        if (x2 < x1) {
            x1 = x1 + x2;
            x2 = x1 - x2;
            x1 = x1 - x2;
            y1 = y1 + y2;
            y2 = y1 - y2;
            y1 = y1 - y2;
        }
        if (x4 < x3) {
            x3 = x3 + x4;
            x4 = x3 - x4;
            x3 = x3 - x4;
            y3 = y3 + y4;
            y4 = y3 - y4;
            y3 = y3 - y4;
        }
        // никогда не пересекутся
        if (x2 < x3) {
            return null;
        }
        // исключаем вертикальную парралель
        if ((x1 == x2) && (x3 == x4)) {
            return null;
        }
        // исключаем случаи с вертикальными
        if ((x1 == x2)) {
            Double a2 = (y3 - y4)/(x3 - x4);
            Double b2 = y3 - a2*x3;
            Double ya = a2 * x1 + b2;
            if ((x3 <= x1) && (x4 >= x1) && (Math.min(y1, y2) <= ya) && (Math.max(y1, y2)>=ya)) {
                Point inter = new Point(x1, ya);
                return inter;
            } else {
                return null;
            }
        }
         if ((x3 == x4)) {
            Double a1 = (y1 - y2)/(x1 - x2);
            Double b1 = y1 - a1*x1;
            Double ya = a1 * x3 + b1;
            if ((x1 <= x3) && (x2>=x3) && (Math.min(y3, y4) <= ya) && (Math.max(y3, y4)>=ya)) {
                Point inter = new Point(x3, ya);
                return inter;
            } else {
                return null;
            }
        }
        Double a1 = (y1 - y2)/(x1 - x2);
        Double a2 = (y3 - y4)/(x3 - x4);
        Double b1 = y1 - a1 * x1;
        Double b2 = y3 - a2 * x3;
        if (a1 == a2) {
            return null;
        }
        Double xa = (b2 - b1) / (a1 - a2);
        Double ya = a2 * xa + b2;
        if ((xa<Math.max(x1, x3)) || (xa > Math.min(x2, x4))) {
            return null;
        }
        else {
            Point inter = new Point(xa, ya);
            return inter;
        }
    }

}
