package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DownloadButtonAction {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Download Text");
        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Download");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                try {
                    File file = new File("output.txt");
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(text);
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
}}