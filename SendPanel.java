package ru.geekbrains.java2.hw4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

class SendPanel extends JPanel {
    private JTextField textField;
    private JTextArea textArea;
    private String br;
    private Date date;
    private final SimpleDateFormat dateFormat;

    SendPanel(JTextArea textArea) {
        this.textArea = textArea;

        textField = new JTextField() {
            @Override
            public void addNotify() {
                super.addNotify();
                requestFocus();
            }
        };

        br = "";
        dateFormat = new SimpleDateFormat("HH:mm:ss");

        setup();
    }

    private void setup() {
        setLayout(new BorderLayout());
        JButton button = new JButton("Go!");

        button.addActionListener(new SendBtnListener());
        textField.addActionListener(new SendBtnListener());

        add(textField, BorderLayout.CENTER);
        add(button, BorderLayout.EAST);
    }

    private String getTime() {
        date = new Date();
        return dateFormat.format(date);
    }

    private void append() {
        String text = textField.getText();

        if (!text.isEmpty()) {
            textArea.setText(String.format("%s%s[%s] %s", textArea.getText(), br, getTime(), text));
            textField.setText("");
            br = "\n";
        }
    }

    private class SendBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() instanceof JButton) {
                append();
            }

            if (e.getSource() instanceof JTextField) {
                append();
            }
        }
    }

}
