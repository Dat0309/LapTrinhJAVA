/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai02;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author ADMIN
 */
public class DisplayClock extends Applet{
     GregorianCalendar cal;
    Timer clockTimer = new Timer();
    TimeZone clockTimeZone = TimeZone.getDefault();
 
    public DisplayClock() {
        clockTimer.schedule(new TickTimerTask(), 0, 1000);
    }
 
    @Override
    public void init() {}
 
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(50, 50, 205, 205);
        g.setColor(Color.WHITE);
        g.fillOval(50, 50, 200, 200);
        //g.setColor(Color.ORANGE);
        // g.fillOval(80, 80, 140, 140);
        //g.drawOval(45,45, 210, 210);
        double second = cal.get(Calendar.SECOND);
        double minute = cal.get(Calendar.MINUTE);
        double hours = cal.get(Calendar.HOUR);
        //double milis = cal.get(Calendar.MILLISECOND);
        //Vẽ mặt đồng hồ
        for (int i = 0; i < 60; i++) {
            int length = 90;
            double rad = (i * 6) * (Math.PI) / 180;
            if (i % 5 == 0) {
                length = 82;
                g.setColor(Color.black);
            } else {
                g.setColor(Color.GRAY);
            }
            int x = 150 + (int)(95 * Math.cos(rad - (Math.PI / 2)));
            int y = 150 + (int)(95 * Math.sin(rad - (Math.PI / 2)));
            int x1 = 150 + (int)(length * Math.cos(rad - (Math.PI / 2)));
            int y1 = 150 + (int)(length * Math.sin(rad - (Math.PI / 2)));
            g.drawLine(x, y, x1, y1);
        }
        //vẽ kim đồng hồ
            drawHands(g, second, minute, hours);
        //g.fillOval(50, 50, 200, 200);
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            g.setColor(Color.red);
            g.setFont(new Font("Tahoma", Font.BOLD, 16));
            g.drawString(sdf.format(cal.getTime()), 120, 20);
            g.setFont(new Font("Arial", Font.BOLD, 10));
            g.drawString("DISPLAY CLOCK", 110, 140);
    }

        public void drawHands(Graphics g, double second, double minute, double hours) {
            double rSecond = (second * 6) * (Math.PI) / 180;
            double rMinute = ((minute + (second / 60)) * 6) * (Math.PI) / 180;
            double rHours = ((hours + (minute / 60)) * 30) * (Math.PI) / 180;
            g.setColor(Color.RED);
            g.drawLine(150, 150, 150 + (int)(100 * Math.cos(rSecond - (Math.PI / 2))), 150 + (int)(100 * Math.sin(rSecond - (Math.PI / 2))));
            g.setColor(Color.green);    
            g.drawLine(150, 150, 150 + (int)(70 * Math.cos(rMinute - (Math.PI / 2))), 150 + (int)(70 * Math.sin((rMinute - (Math.PI / 2)))));
            g.setColor(Color.blue);
            g.drawLine(150, 150, 150 + (int)(50 * Math.cos(rHours - (Math.PI / 2))), 150 + (int)(50 * Math.sin(rHours - (Math.PI / 2))));
        //g.drawLine(150, 150, 150+(int)(100*Math.sin(2*Math.PI)),150+(int)(100*Math.cos(2*Math.PI)));
    }
        public class TickTimerTask extends TimerTask{

    @Override
    public void run() {
        cal=(GregorianCalendar) GregorianCalendar.getInstance(clockTimeZone);
        repaint();
        }
    
    }
}
