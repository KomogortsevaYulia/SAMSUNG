package com.company;

import java.util.Locale;

public class Vector2D {
    public static int count=0;
    double vX;
    double vY;
    public Vector2D(double v, double v1) {
        this.vX=v;
        this.vY=v1;
        count++;
    }

    public Vector2D() {
        this.vX=1;
        this.vY=1;
        count++;
    }

    public Vector2D(Vector2D v) {
        this(v.vX,v.vY);
    }

    public void print() {
        System.out.println(String.format(Locale.US, "(%.2f, %.2f)", this.vX,this.vY));
    }

    public void add(Vector2D vB) {
        this.vX=this.vX+vB.vX;
        this.vY=this.vY+vB.vY;
    }

    public void sub(Vector2D vC) {
        this.vX=this.vX-vC.vX;
        this.vY=this.vY-vC.vY;
    }

    public double length() {
        double x2=Math.pow(this.vX,2);
        double y2=Math.pow(this.vY,2);
        double ms=Math.sqrt(x2+y2);
        double res=Math.abs(ms);
        return res;
    }

    public void scale(double scaleFactor) {
        this.vX=this.vX*scaleFactor;
        this.vY=this.vY*scaleFactor;
    }

    public void normalized() {
        double inv_length = 1.0f / this.length();
        this.vX=this.vX*inv_length;
        this.vY=this.vY*inv_length;
    }

    public double dotProduct(Vector2D vB) {
        return (vB.vX*this.vX+vB.vY*this.vY);
    }
}
