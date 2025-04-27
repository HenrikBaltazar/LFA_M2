package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private static final int H = 800;
    private static final int W = 1000;
    private static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 24);
    private static final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 20);
    private static final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 22);
    private static final int PADDING = 10;
    private static final int TEXT_AREA_ROWS = 10;

    private JTextArea textInput;
    private JTextArea textOutput;
    private JButton buttonAnalyze;
    private JButton buttonClean;

    public GUI() {
        setTitle("Reconhecedor de Linguagem Regular");
        setSize(W, H);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(PADDING, PADDING));
        panel.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(0, 5));
        JLabel labelInput = new JLabel("Insira o texto:");
        labelInput.setFont(LABEL_FONT);
        inputPanel.add(labelInput, BorderLayout.NORTH);

        textInput = new JTextArea(TEXT_AREA_ROWS, 0);
        textInput.setFont(TEXT_FONT);
        textInput.setLineWrap(true);
        textInput.setWrapStyleWord(true);
        JScrollPane scrollPaneInput = new JScrollPane(textInput);
        inputPanel.add(scrollPaneInput, BorderLayout.CENTER);

        panel.add(inputPanel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        buttonAnalyze = new JButton("✨ Analisar");
        buttonAnalyze.setFont(BUTTON_FONT);
        buttonClean = new JButton("\uD83E\uDDF9 Limpar");
        buttonClean.setFont(BUTTON_FONT);
        buttonPanel.add(buttonAnalyze);
        buttonPanel.add(buttonClean);

        panel.add(buttonPanel, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout(0, 5));
        JLabel labelOutput = new JLabel("Resultado da Análise:");
        labelOutput.setFont(LABEL_FONT);
        outputPanel.add(labelOutput, BorderLayout.NORTH);

        textOutput = new JTextArea(TEXT_AREA_ROWS, 0);
        textOutput.setFont(TEXT_FONT);
        textOutput.setLineWrap(true);
        textOutput.setWrapStyleWord(true);
        textOutput.setEditable(false);
        JScrollPane scrollPaneOutput = new JScrollPane(textOutput);
        outputPanel.add(scrollPaneOutput, BorderLayout.CENTER);

        panel.add(outputPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);

        buttonAnalyze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Analyzer analyzer = new Analyzer(textInput.getText());
                textOutput.setText(analyzer.Analyzer());
            }
        });

        buttonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText("");
                textOutput.setText("");
            }
        });

    }

}