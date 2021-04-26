/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2_2;

/**
 *
 * @author ADMIN
 */
public class StatCalc {
    private int count;
    private double sum;
    private double sqareSum;
    private double max=Double.NEGATIVE_INFINITY;
    private double min=Double.POSITIVE_INFINITY;
    
    public void enter(double num){
        count++;
        sum+=num;
        sqareSum+=num*num;
        if (num>max)
            max=num;
        if(num<min)
            min=num;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
    
    public double getMean(){
        return sum/count;
    }
    
    public double getStandardDeviation(){
        double mean=getMean();
        return Math.sqrt(sqareSum/count-mean*mean);
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }
    
    
}
