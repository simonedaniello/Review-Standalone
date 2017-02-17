package boundary;


import control.ArticlesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SegnalationBoundary {

    private JFrame frame;
    private String vendor;
    private JTextArea textArea;
    private JFrame confirmFrame;


    public SegnalationBoundary(JFrame frame, String vendor){

        this.frame = frame;
        this.vendor = vendor;

        textArea = new JTextArea();
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
        mainJpanel.add(new JLabel("Segnala " + this.vendor), gbc);

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

        Actions azioneBack = new Actions(1);

        backButton.addActionListener(azioneBack);
        okB.addActionListener(e -> initSuccessFrame());

        this.frame.setContentPane(mainJpanel);
        this.frame.pack();
        this.frame.setVisible(true);

    }

    private class Actions implements ActionListener {

        private int kind;

        private Actions(int kind) {
            this.kind = kind;
        }

        public void actionPerformed(ActionEvent event){
            if(kind == 1){
                frame.setVisible(false);
                ArticlesController.getInstance().getReviewBoundary(frame, vendor);
            }
            else if (kind == 0){
                confirmFrame.setVisible(false);
                try {
                    if(ArticlesController.getInstance().sendWarning(textArea.getText(), vendor) == 1) {
                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "successo");
                        System.exit(0);
                    }
                    else if(ArticlesController.getInstance().sendWarning(textArea.getText(), vendor) == 0){
                        JOptionPane.showMessageDialog(null, "fallimento, probabilmente hai già scritto una segnalazione riguardante questo venditore","Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initSuccessFrame() {

        confirmFrame = new JFrame();
        JPanel confirmPanel = new JPanel();
        confirmPanel.add(new JLabel("Confermare invio?"));
        JButton yes = new JButton("Si");
        JButton no = new JButton("No");

        confirmPanel.add(yes);
        confirmPanel.add(no);
        confirmFrame.add(confirmPanel);
        confirmFrame.pack();
        confirmFrame.setVisible(true);

        Actions azione = new Actions(0);
        yes.addActionListener(azione);

        no.addActionListener(e -> confirmFrame.setVisible(false));
    }
}
