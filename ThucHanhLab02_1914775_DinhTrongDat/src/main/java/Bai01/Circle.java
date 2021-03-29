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
public class Circle extends Point{
    double radius;
    public Circle() {
    }

    public Circle(double radius, int x, int y) {
        super(x, y);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    @Override
    public double area()
    {
        return Math.PI * radius *radius;
    }
    @Override
    public String getName(){
        return ("Circle");
    }
    @Override
    public String toString(){
        return ("("+x+", "+y+", "+radius+"), area: "+ area());
    }
}
