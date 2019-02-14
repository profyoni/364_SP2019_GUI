package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

class App extends JFrame {
    private List<Point> pointList = new LinkedList<>();

    class MyInnerClassThatHappensToBeAnEventListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("eh...");
            App.this.setTitle("ehhhhhhhhhhhh");
        }
    }
    private Point ball = new Point(10,10), delta = new Point(3,3);
    private Timer timer;

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

    public App() {
        setTitle("First App");
        setVisible(true);
        setSize(500, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setBackground(Color.ORANGE);


        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                timer.start();
          }

            @Override
            public void mouseMoved(MouseEvent e) {
//                Point p = e.getPoint();
//                System.out.println(p);
//                pointList.add(p);
//                //repaint();
//                Graphics g = getGraphics();
//                g.fillOval(p.x, p.y, 10,10);
            }
        });

        timer = new Timer(100, new ActionListener() {
            int counter=0;
            @Override
            public void actionPerformed(ActionEvent e) {
               updateBall();
               System.out.println("tick");
               repaint();
            }
        });
        //JPanel panel = new JPanel();
        //add(panel);

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

public class Main {

    public static void main(String[] args) {
        App app = new App();

//        Timer t = new Timer(100, new ActionListener() {
//            int counter=0;
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Hiccup #" + counter++);
//
//            }
//        });
//        t.start();
//
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Ended Main Thread");
        }
}
