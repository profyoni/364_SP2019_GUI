package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

class PongPanel extends JPanel{
    private Timer timer;
    private Point ball = new Point(10,10), delta = new Point(3,3);

    public PongPanel() {

        setBackground(Color.BLACK);
        timer = new Timer(100, new ActionListener() {
            int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                updateBall();
                repaint();
            }
        });
    }
    private void updateBall()
    {
        // check for intersections to LEFT_X, RIGHT_X, TOP_Y, BOTTOM_Y
        if (ball.y > 130){
            delta.y = -delta.y;
        }
        ball.x += delta.x;
        ball.y += delta.y;
        System.out.println(ball);
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g); // cal JFrame paint emthod first to ensure all JFRame's stuff gets drawn first
//        g.setColor( Color.GREEN);
//        g.fillOval(100,200,300, 400);
//        g.setColor( new Color(0,0,255));
//        g.translate(100,100);
//        g.fillArc(20,20,100,100,270, 270);
//        for(Point p: pointList)
//        {
//            g.fillOval(p.x, p.y, 10,10);
//        }
        g.fillOval(ball.x, ball.y, 30,30);
    }
}
public class Pong extends JFrame {

    public Pong() {
        setTitle("Pong 0.1");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel panel = new PongPanel();
        add(panel, BorderLayout.CENTER);

        JLabel statusBar = new JLabel("Welcome to Pong!");
        add(statusBar, BorderLayout.SOUTH);
        JPanel scorePanel = new JPanel();
        JLabel player1Score = new JLabel("Player1: ");
        JLabel player2Score = new JLabel("Player2:");
        JLabel highScore = new JLabel("High Score:");
        scorePanel.setLayout(new GridLayout(1,3));
        scorePanel.add(player1Score);
        scorePanel.add(player2Score);
        scorePanel.add(highScore);

        add(scorePanel, BorderLayout.NORTH);


//        JButton button = new JButton("imPress Me"); // e.g. event source
//        panel.add(button);
//        button.addActionListener(new MyInnerClassThatHappensToBeAnEventListener());
//        button.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        try{
//                            System.out.println("OOOOOH I am SOOO impressed!!");
//                            throw new RuntimeException();
//                        }
//                        catch(Exception e1)
//                        {
//                        }
//                    }
//                }
//
//        );
    }
}


