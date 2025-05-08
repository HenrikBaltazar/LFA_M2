package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;

public class GUI extends JFrame {
    private static final int H = 800;
    private static final int W = 1000;
    private static final Font LABEL_FONT = new Font("SansSerif", Font.PLAIN, 24);
    private static final Font TEXT_FONT = new Font("SansSerif", Font.PLAIN, 20);
    private static final Font BUTTON_FONT = new Font("SansSerif", Font.PLAIN, 22);
    private static final Font DIAGRAMA_FONT = new Font("SansSerif", Font.PLAIN, 16);
    private static final int PADDING = 10;
    private static final int TEXT_AREA_ROWS = 10;
    private int non_suspicious_counter = 0;

    private JTextArea textInput;
    private JTextArea textOutput;
    private JButton buttonAnalyze;
    private JButton buttonClean;

    private void newImageWindow(ImageIcon icon, URL iconUrl, String title) {
        Image scaled = icon.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaled);

        JFrame frameImagem = new JFrame(title);
        frameImagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameImagem.setSize(620, 440);

        JLabel labelImagem = new JLabel(scaledIcon);
        if(iconUrl != null) {
            frameImagem.setIconImage(icon.getImage());
        }
        frameImagem.add(labelImagem);
        frameImagem.setLocationRelativeTo(null);
        frameImagem.setVisible(true);
    }

    public GUI() {
        setTitle("Reconhecedor de Linguagem Regular");
        setSize(W, H);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        URL iconUrl = Main.class.getResource("/alessandro.png");
        if(iconUrl != null) {
            ImageIcon icon = new ImageIcon(iconUrl);
            setIconImage(icon.getImage());
        }
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Diagrama");
        JMenuItem openItem = new JMenuItem("Abrir");
        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        fileMenu.setFont(DIAGRAMA_FONT);
        openItem.setFont(DIAGRAMA_FONT);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(PADDING, PADDING));
        panel.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(0, 5));

        textInput = new JTextArea(TEXT_AREA_ROWS, 0);
        textInput.setFont(TEXT_FONT);
        textInput.setLineWrap(true);
        textInput.setWrapStyleWord(true);
        JScrollPane scrollPaneInput = new JScrollPane(textInput);
        inputPanel.add(scrollPaneInput, BorderLayout.CENTER);

        panel.add(inputPanel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonAnalyze = new JButton("✨ Analisar");
        buttonAnalyze.setFont(BUTTON_FONT);
        buttonClean = new JButton("❌ Limpar");
        buttonClean.setFont(BUTTON_FONT);
        buttonPanel.add(buttonAnalyze);
        buttonPanel.add(buttonClean);

        panel.add(buttonPanel, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout(0, 0));
        JButton labelOutput = new JButton("Tokens:");
        labelOutput.setFont(LABEL_FONT);
        labelOutput.setFocusPainted(false);
        labelOutput.setBorderPainted(false);
        labelOutput.setContentAreaFilled(false);
        labelOutput.setOpaque(false);
        labelOutput.setHorizontalAlignment(SwingConstants.LEFT);
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

        openItem.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/alessandro.png"));
                    newImageWindow(icon,iconUrl,"Diagrama");
                } catch (Exception ex) {
                    System.out.println("Erro ao carregar imagem: " + ex.getMessage());
                }
            }
        });

        buttonAnalyze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Analyzer analyzer = new Analyzer(textInput.getText());
                textOutput.setText(analyzer.AnalizaEntrada(textInput.getText()));
            }
        });

        buttonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText("");
                textOutput.setText("");
            }
        });
        
        labelOutput.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (non_suspicious_counter == 4) {
                    try {
                        ImageIcon icon = new ImageIcon(getClass().getResource("/alessandro.png"));
                        newImageWindow(icon,iconUrl,"Diagrama");
                    } catch (Exception ex) {
                        System.out.println("Erro ao carregar imagem: " + ex.getMessage());
                    }
                    non_suspicious_counter = 0;
                }
                non_suspicious_counter++;
            }
        });

    }

}