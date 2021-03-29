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
public class Point extends Shape{
    int x,y;
    public Point(){}
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return("("+ x +", "+y+")");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
