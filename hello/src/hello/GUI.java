package hello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private JTextField atributo1TextField;
    private JTextField atributo2TextField;
    private JTextField atributo3TextField;
    private JTextArea displayTextArea;
    private ControlaDatos controller;

    public GUI() {
        controller = new ControlaDatos();
        createFrame();
        createInputPanel();
        createDisplayPanel();
        frame.setVisible(true);
    }

    private void createFrame() {
        frame = new JFrame();
        frame.setTitle("Entrada de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());
    }

    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Data"));

        JLabel atributo1Label = new JLabel("Atributo 1:");
        atributo1TextField = new JTextField();

        JLabel atributo2Label = new JLabel("Atributo 2:");
        atributo2TextField = new JTextField();

        JLabel atributo3Label = new JLabel("Atributo 3:");
        atributo3TextField = new JTextField();

        JButton agregaButton = new JButton("Agregar");
        agregaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String atributo1 = atributo1TextField.getText();
                String atributo2 = atributo2TextField.getText();
                String atributo3 = atributo3TextField.getText();
                Atributos object = new Atributos(atributo1, atributo2, atributo3);
                controller.EscribeDatosArchivo(object);
                atributo1TextField.setText("");
                atributo2TextField.setText("");
                atributo3TextField.setText("");
                JOptionPane.showMessageDialog(frame, "Los datos se han añadido exitosamente");
            }
        });

        inputPanel.add(atributo1Label);
        inputPanel.add(atributo1TextField);
        inputPanel.add(atributo2Label);
        inputPanel.add(atributo2TextField);
        inputPanel.add(atributo3Label);
        inputPanel.add(atributo3TextField);
        inputPanel.add(new JLabel());
        inputPanel.add(agregaButton);

        frame.add(inputPanel, BorderLayout.NORTH);
    }

    private void createDisplayPanel() {
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Display Data"));

        displayTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayTextArea);
        displayPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton readButton = new JButton("Lee");
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = controller.LeeDatos();
                displayTextArea.setText(data);
            }
        });
        JButton displayButton = new JButton("Muestras");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Atributos object = controller.LeeDatosArchivo();
                if (object != null) {
                    JOptionPane.showMessageDialog(frame, object.toString());
                } else {
                    JOptionPane.showMessageDialog(frame, "No hay nada que mostrar");
                }
            }
        });
        buttonPanel.add(readButton);
        buttonPanel.add(displayButton);
        displayPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(displayPanel, BorderLayout.CENTER);
    }
}
