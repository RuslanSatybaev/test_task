package gui;

import javax.swing.*;

public class SimpleGui {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JButton button = new JButton("click me");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(button);
        jFrame.setSize(300,300);
        jFrame.setVisible(true);
    }
}
