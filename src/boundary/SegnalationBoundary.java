package boundary;


import javax.swing.*;
import java.awt.*;

public class SegnalationBoundary {

    private JFrame frame;
    private String vendor;


    public SegnalationBoundary(JFrame frame, String vendor){

        this.frame = frame;
        this.vendor = vendor;
//        initWindow();
        JTextArea textArea = new JTextArea();
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(true);

        JScrollPane scrollpane = new JScrollPane(textArea);
        scrollpane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );


        JButton backButton = new JButton("Back");
        JButton okB = new JButton("Invia");

        JPanel mainJpanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(new JLabel("Seganala " + this.vendor), gbc);

        gbc.ipady = 30;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(scrollpane, gbc);

        JPanel buttons = new JPanel();
        buttons.add(okB);
        buttons.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(buttons, gbc);

        this.frame.setContentPane(mainJpanel);
        this.frame.setVisible(true);

    }

    private void initWindow(){

        JTextArea textArea = new JTextArea();
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(true);

        JScrollPane scrollpane = new JScrollPane(textArea);
        scrollpane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );


        JButton backButton = new JButton("Back");
        JButton okB = new JButton("Invia");

        JPanel mainJpanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(new JLabel("Seganala " + this.vendor), gbc);

        gbc.ipady = 30;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(scrollpane, gbc);

        JPanel buttons = new JPanel();
        buttons.add(okB);
        buttons.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(buttons, gbc);

        this.frame.setContentPane(mainJpanel);
        this.frame.setVisible(true);

    }

}
