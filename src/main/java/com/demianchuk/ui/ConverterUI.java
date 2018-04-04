package com.demianchuk.ui;

import com.demianchuk.converter.*;
import com.demianchuk.exceptions.*;
import org.apache.log4j.Logger;

import java.awt.event.*;
import javax.swing.*;

public class ConverterUI extends JFrame {
    private static Logger logger = Logger.getLogger(ConverterUI.class);

    private JPanel jPanel1;
    private JLabel mainLabel;
    private JLabel mainLabel2;
    private JLabel arabicLabel;
    private JLabel romanLabel;
    private JTextField arabicTextField;
    private JTextField romanTextField;
    private NumeralConverter aRConverter;
    private NumeralConverter rAConverter;

    public ConverterUI(NumeralConverter aRConverter,
                       NumeralConverter rAConverter) {
        this.aRConverter = aRConverter;
        this.rAConverter = rAConverter;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new JPanel();
        mainLabel = new JLabel();
        mainLabel2 = new JLabel();
        arabicLabel = new JLabel();
        romanLabel = new JLabel();
        arabicTextField = new JTextField();
        romanTextField = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArabicRomanConverter");

        arabicTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        arabicTextField.setToolTipText("Press Enter to convert");
        arabicTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                arabicTextFieldKeyPressed(evt);
            }
        });

        mainLabel.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainLabel.setText("Arabic - Roman");
        mainLabel.setToolTipText(""); // NOI18N

        arabicLabel.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        arabicLabel.setText("Arabic numeral");

        romanLabel.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        romanLabel.setText("Roman numeral");

        romanTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        romanTextField.setToolTipText("Press Enter to convert");
        romanTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                romanTextFieldKeyPressed(evt);
            }
        });

        mainLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        mainLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        mainLabel2.setText("numeral converter");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(mainLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mainLabel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 34, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(arabicLabel)
                                                        .addComponent(romanLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(arabicTextField, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                                        .addComponent(romanTextField))
                                                .addGap(35, 35, 35)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(mainLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)
                                .addComponent(mainLabel2)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(arabicLabel)
                                        .addComponent(arabicTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(romanTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(romanLabel))
                                .addGap(30, 30, 30))
        );

        arabicTextField.getAccessibleContext().setAccessibleName("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        JOptionPane.showMessageDialog(jPanel1, "Application converts numerals"
                + " in a range from 1 to 3999",
                "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void arabicTextFieldKeyPressed(KeyEvent evt) {
        if (isEnter(evt)) {
            performAction(arabicTextField, romanTextField, aRConverter);
        }
    }

    private void romanTextFieldKeyPressed(KeyEvent evt) {
        if (isEnter(evt)) {
            performAction(romanTextField, arabicTextField, rAConverter);
        }
    }

    private void performAction(JTextField from, JTextField to,
            NumeralConverter converter) {

        String text = from.getText().trim();
        try {
            if (text.isEmpty()) {
                throw new EmptyInputException();
            }
            String result = converter.convert(text);
            to.setText(result);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isEnter(KeyEvent evt) {
        return evt.getKeyCode() == 10;
    }
}
