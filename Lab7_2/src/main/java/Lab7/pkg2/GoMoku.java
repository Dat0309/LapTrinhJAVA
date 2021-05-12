/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.pkg2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 *
 * @author Kin
 */
public class GoMoku extends JPanel {

    public static void main(String[] args) {
        JFrame window = new JFrame("GoMoku");
        GoMoku content = new GoMoku();
        window.setContentPane(content);
        window.pack();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((screensize.width - window.getWidth()) / 2,
                (screensize.height - window.getHeight()) / 2);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
    }
    public static class Applet extends JApplet {

        public void init() {
            setContentPane(new GoMoku());
        }
    }
    private JButton newGameButton;
    private JButton resignButton;
    private JLabel message;
    public GoMoku() {
        setLayout(null);
        setPreferredSize(new Dimension(350, 250));
        setBackground(new Color(61, 61, 41));
        Board board = new Board();
        add(board);
        add(newGameButton);
        add(resignButton);
        add(message);
        board.setBounds(16, 16, 172, 172);
        newGameButton.setBounds(210, 60, 120, 30);
        resignButton.setBounds(210, 120, 120, 30);
        message.setBounds(0, 200, 350, 30);
    }
    class Board extends JPanel implements ActionListener, MouseListener {
        int[][] board; 
        static final int EMPTY = 0,
                WHITE = 1, 
                BLACK = 2;       

        boolean gameInProgress;
        int currentPlayer;
        int win_r1, win_c1, win_r2, win_c2;
        public Board() {
            setBackground(Color.LIGHT_GRAY);
            addMouseListener(this);
            resignButton = new JButton("Resign");
            resignButton.addActionListener(this);
            newGameButton = new JButton("New Game");
            newGameButton.addActionListener(this);
            message = new JLabel("", JLabel.CENTER);
            message.setFont(new Font("Serif", Font.BOLD, 14));
            message.setForeground(Color.GREEN);
            board = new int[13][13];
            doNewGame();
        }
        public void actionPerformed(ActionEvent evt) {
            Object src = evt.getSource();
            if (src == newGameButton) {
                doNewGame();
            } else if (src == resignButton) {
                doResign();
            }
        }
        void doNewGame() {
            if (gameInProgress == true) {
                message.setText("Finish the current game first!");
                return;
            }
            for (int row = 0; row < 13; row++)
            {
                for (int col = 0; col < 13; col++) {
                    board[row][col] = EMPTY;
                }
            }
            currentPlayer = BLACK; 
            message.setText("BLACK:  Make your move.");
            gameInProgress = true;
            newGameButton.setEnabled(false);
            resignButton.setEnabled(true);
            win_r1 = -1; 
            repaint();
        }
        void doResign() {
            if (gameInProgress == false) {
                message.setText("There is no game in progress!");
                return;
            }
            if (currentPlayer == WHITE) {
                message.setText("WHITE resigns.  BLACK wins.");
            } else {
                message.setText("BLACK resigns.  WHITE wins.");
            }
            newGameButton.setEnabled(true);
            resignButton.setEnabled(false);
            gameInProgress = false;
        }
        void gameOver(String str) {
            message.setText(str);
            newGameButton.setEnabled(true);
            resignButton.setEnabled(false);
            gameInProgress = false;
        }
        void doClickSquare(int row, int col) {
            if (board[row][col] != EMPTY) {
                if (currentPlayer == BLACK) {
                    message.setText("BLACK:  Please click an empty square.");
                } else {
                    message.setText("WHITE:  Please click an empty square.");
                }
                return;
            }
            board[row][col] = currentPlayer;
            repaint();

            if (winner(row, col)) {
                if (currentPlayer == WHITE) {
                    gameOver("WHITE wins the game!");
                } else {
                    gameOver("BLACK wins the game!");
                }
                return;
            }
            boolean emptySpace = false;
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 13; j++) {
                    if (board[i][j] == EMPTY) {
                        emptySpace = true;
                    }
                }
            }
            if (emptySpace == false) {
                gameOver("The game ends in a draw.");
                return;
            }
            if (currentPlayer == BLACK) {
                currentPlayer = WHITE;
                message.setText("WHITE:  Make your move.");
            } else {
                currentPlayer = BLACK;
                message.setText("BLACK:  Make your move.");
            }

        }
        private boolean winner(int row, int col) {

            if (count(board[row][col], row, col, 1, 0) >= 5) {
                return true;
            }
            if (count(board[row][col], row, col, 0, 1) >= 5) {
                return true;
            }
            if (count(board[row][col], row, col, 1, -1) >= 5) {
                return true;
            }
            if (count(board[row][col], row, col, 1, 1) >= 5) {
                return true;
            }
            win_r1 = -1;
            return false;

        }
        private int count(int player, int row, int col, int dirX, int dirY) {
            int ct = 1;  
            int r, c;  
            r = row + dirX; 
            c = col + dirY;
            while (r >= 0 && r < 13 && c >= 0 && c < 13 && board[r][c] == player) {
                ct++;
                r += dirX;
                c += dirY;
            }
            win_r1 = r - dirX;
            win_c1 = c - dirY;
            r = row - dirX;
            c = col - dirY;
            while (r >= 0 && r < 13 && c >= 0 && c < 13 && board[r][c] == player) {
                ct++;
                r -= dirX;
                c -= dirY;
            }
            win_r2 = r + dirX;
            win_c2 = c + dirY;
            return ct;

        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.DARK_GRAY);
            for (int i = 1; i < 13; i++) {
                g.drawLine(1 + 13 * i, 0, 1 + 13 * i, getSize().height);
                g.drawLine(0, 1 + 13 * i, getSize().width, 1 + 13 * i);
            }
            g.setColor(Color.BLACK);
            g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
            g.drawRect(1, 1, getSize().width - 3, getSize().height - 3);

            /* Draw the pieces that are on the board. */
            for (int row = 0; row < 13; row++) {
                for (int col = 0; col < 13; col++) {
                    if (board[row][col] != EMPTY) {
                        drawPiece(g, board[row][col], row, col);
                    }
                }
            }
            if (win_r1 >= 0) {
                drawWinLine(g);
            }
        }
        private void drawPiece(Graphics g, int piece, int row, int col) {
            if (piece == WHITE) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillOval(3 + 13 * col, 3 + 13 * row, 10, 10);
        }
        private void drawWinLine(Graphics g) {
            g.setColor(Color.RED);
            g.drawLine(8 + 13 * win_c1, 8 + 13 * win_r1, 8 + 13 * win_c2, 8 + 13 * win_r2);
            if (win_r1 == win_r2) {
                g.drawLine(8 + 13 * win_c1, 7 + 13 * win_r1, 8 + 13 * win_c2, 7 + 13 * win_r2);
            } else {
                g.drawLine(7 + 13 * win_c1, 8 + 13 * win_r1, 7 + 13 * win_c2, 8 + 13 * win_r2);
            }
        }
        public void mousePressed(MouseEvent evt) {
            if (gameInProgress == false) {
                message.setText("Click \"New Game\" to start a new game.");
            } else {
                int col = (evt.getX() - 2) / 13;
                int row = (evt.getY() - 2) / 13;
                if (col >= 0 && col < 13 && row >= 0 && row < 13) {
                    doClickSquare(row, col);
                }
            }
        }
        public void mouseReleased(MouseEvent evt) {}
        public void mouseClicked(MouseEvent evt) {}
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
    }
}
