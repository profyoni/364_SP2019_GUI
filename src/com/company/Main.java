package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class App extends JFrame {
    App() {
        setTitle("First App");
        setVisible(true);
        setSize(500, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);

        JButton button = new JButton("imPress Me"); // e.g. event source
        panel.add(button);

        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("OOOOOH I am SOOO impressed!!");
                    }
                }

        );
    }
}

public class Main {

    public static void main(String[] args) {
        App app = new App();


    }
}
