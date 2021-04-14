/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise4_2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Administrator
 */
public class TextCounter extends JPanel {
/**
* A main routine allows this class to be run as an application.
*/
public static void main(String[] args) {
JFrame window = new JFrame("Text Counter");
TextCounter content = new TextCounter();
window.setContentPane(content);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setLocation(120,70);
window.setSize(300,350);
window.setVisible(true);
}

private JTextArea textInput; 
private JLabel lineCountLabel; 
private JLabel wordCountLabel; 
private JLabel charCountLabel; 

public TextCounter() {
setBackground(Color.DARK_GRAY);
textInput = new JTextArea();
textInput.setBackground(Color.WHITE);


JPanel south = new JPanel();
south.setBackground(Color.DARK_GRAY);
south.setLayout( new GridLayout(4,1,2,2) );

JButton countButton = new JButton("Process the Text");
countButton.addActionListener( new ActionListener() {
public void actionPerformed(ActionEvent evt) {
processInput();
}
});
south.add(countButton);


lineCountLabel = new JLabel(" Number of lines:");
lineCountLabel.setBackground(Color.WHITE);
lineCountLabel.setForeground(Color.BLUE);
lineCountLabel.setOpaque(true);
south.add(lineCountLabel);
wordCountLabel = new JLabel(" Number of words:");
wordCountLabel.setBackground(Color.WHITE);
wordCountLabel.setForeground(Color.BLUE);
wordCountLabel.setOpaque(true);
south.add(wordCountLabel);
charCountLabel = new JLabel(" Number of chars:");
charCountLabel.setBackground(Color.WHITE);
charCountLabel.setForeground(Color.BLUE);
charCountLabel.setOpaque(true);
south.add(charCountLabel);


setLayout( new BorderLayout(2,2) );
setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

JScrollPane scroller = new JScrollPane( textInput );
add(scroller, BorderLayout.CENTER);
add(south, BorderLayout.SOUTH);

} 
public void processInput() {
String text; 
int charCt, wordCt, lineCt; 
text = textInput.getText();
charCt = text.length(); 
wordCt = 0;
for (int i = 0; i < charCt; i++) {
boolean startOfWord; 
if ( Character.isLetter(text.charAt(i)) == false )
startOfWord = false;

else if (i == 0)
startOfWord = true; 

else if ( Character.isLetter(text.charAt(i-1)) )
startOfWord = false; 
else if ( text.charAt(i-1) == '\'' && i > 1

&& Character.isLetter(text.charAt(i-2))

)

startOfWord = false; 

else
startOfWord = true; 

if (startOfWord)
wordCt++;

}
lineCt = 1;
for (int i = 0; i < charCt; i++) {
if (text.charAt(i) == '\n')
lineCt++;

}
lineCountLabel.setText(" Number of Lines: " + lineCt);
wordCountLabel.setText(" Number of Words: " + wordCt);
charCountLabel.setText(" Number of Chars: " + charCt);
} 
} 