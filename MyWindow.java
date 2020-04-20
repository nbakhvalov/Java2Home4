package ru.geekbrains.java2.hw4;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Chat Window");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 600, 400);

        TextPanel textPanel = new TextPanel();
        SendPanel sendPanel = new SendPanel(textPanel.getTextArea());

        add(textPanel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);



        setVisible(true);

    }
}