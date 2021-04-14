/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise4_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*

/**
 *
 * @author Administrator
 */
public class StatCalcGUI extends JPanel implements ActionListener {
/**
* A main routine allows this class to be run as an application.
*/
public static void main(String[] args) {

JFrame window = new JFrame("Stat Calc");
StatCalcGUI content = new StatCalcGUI();
window.setContentPane(content);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setLocation(120,70);
window.setSize(350,200);
window.setVisible(true);
}

final static Color labelBG = new Color(240,225,200); 

final static Color labelFG = new Color(180,0,0);
final static Font labelFont = new Font("Monospaced", Font.PLAIN, 12);
private JLabel countLabel; 
private JLabel sumLabel; 
private JLabel meanLabel; 
private JLabel standevLabel; 
private JLabel message; 
private JButton enterButton; 
private JButton clearButton; 
private JTextField numberInput; 
private StatCalc stats;

public StatCalcGUI() {

stats = new StatCalc();
numberInput = new JTextField();
numberInput.setBackground(Color.WHITE);
numberInput.addActionListener(this);
enterButton = new JButton("Enter");
enterButton.addActionListener(this);
clearButton = new JButton("Clear");
clearButton.addActionListener(this);
JPanel inputPanel = new JPanel(); 
inputPanel.setLayout( new GridLayout(1,3) );
inputPanel.add(numberInput);
inputPanel.add(enterButton);
inputPanel.add(clearButton);
countLabel = makeLabel(" Number of Entries: 0");
sumLabel = makeLabel(" Sum: 0.0");
meanLabel = makeLabel(" Average: undefined");
standevLabel = makeLabel(" Standard Deviation: undefined");
message = new JLabel("Enter a number, press return:",JLabel.CENTER);
message.setBackground(labelBG);
message.setForeground(Color.BLUE);
message.setOpaque(true);
message.setFont(new Font("SansSerif", Font.BOLD, 12));
setBackground(Color.BLUE);
setLayout( new GridLayout(6,1,2,2) );
add(message);
add(inputPanel);
add(countLabel);
add(sumLabel);
add(meanLabel);
add(standevLabel);
setBorder( BorderFactory.createLineBorder(Color.BLUE, 2) );
}
private JLabel makeLabel(String text) {
JLabel label = new JLabel(text);
label.setBackground(labelBG);
label.setForeground(labelFG);

label.setFont(labelFont);
label.setOpaque(true);
return label;
}

public void actionPerformed(ActionEvent evt) {
Object source = evt.getSource(); 
if (source == clearButton) {

stats = new StatCalc();
countLabel.setText(" Number of Entries: 0");
sumLabel.setText(" Sum: 0.0");
meanLabel.setText(" Average: undefined");
standevLabel.setText(" Standard Deviation: undefined");
numberInput.setText("");
}
else if (source == enterButton || source == numberInput) {

double num; 
try {
num = Double.parseDouble(numberInput.getText());
}
catch (NumberFormatException e) {

message.setText("\"" + numberInput.getText() +
"\" is not a legal number.");
numberInput.selectAll();
numberInput.requestFocus();
return;
}
stats.enter(num);
countLabel.setText(" Number of Entries: " + stats.getCount());
sumLabel.setText(" Sum: " + stats.getSum());
meanLabel.setText(" Average: " + stats.getMean());
standevLabel.setText(" Standard Deviation: "
+
stats.getStandardDeviation());
}

message.setText("Enter a number, press return:");
numberInput.selectAll();
numberInput.requestFocus();
} 



public class StatCalc {
private int count; 
private double sum; 
private double squareSum; 

public void enter(double num) {
count++;
sum += num;
squareSum += num*num;
}

public int getCount() {
return count;
}

public double getSum() {
return sum;
}

public double getMean() {
return sum / count;
}

public double getStandardDeviation() {
double mean = getMean();
return Math.sqrt( squareSum/count - mean*mean );
}
} 
}
