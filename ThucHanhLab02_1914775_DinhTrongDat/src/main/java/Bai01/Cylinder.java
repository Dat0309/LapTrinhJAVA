/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai01;

/**
 *
 * @author ADMIN
 */
public class Cylinder extends Circle{
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height, double radius, int x, int y) {
        super(radius, x, y);
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double area() {
        return (super.area()*2 + 2*Math.PI*radius*height);
    }

    @Override
    public double volume() {
        return Math.PI*radius*radius*height;
    }
    
    @Override
    public String toString(){
        return ("("+radius+", "+height+", "+x+", "+ y+")"+" area: "+area()+", volume: "+ volume());
    }

    @Override
    public String getName() {
        return "Cylinder";
    }
}
