package boundary;

import control.ArticlesController;
import control.CharactersObserver;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewBoundary {

    private String username;
    private String article;
    private String vendor;
    private JFrame frame;

    public ReviewBoundary(String username, String article, String vendor, JFrame frame){

        this.username = username;
        this.article = article;
        this.vendor = vendor;
        this.frame = frame;

        JTextArea textArea = new JTextArea();
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(true);

        JLabel characters = new JLabel("300");
        CharactersObserver charactersObserver = new CharactersObserver(textArea, characters);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                charactersObserver.update();
            }

            public void removeUpdate(DocumentEvent e) {
                charactersObserver.update();
            }

            public void insertUpdate(DocumentEvent e) {
                charactersObserver.update();
            }
        });
        JScrollPane scrollpane = new JScrollPane(textArea);
        scrollpane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 5, 5);
        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setVisible(true);

        JButton segnalazioneB = new JButton("SEGNALAZIONE !");
        JButton okB = new JButton("Invia");

        JPanel mainJpanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(new JLabel("Recensisci " + article), gbc);

        gbc.ipady = 30;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(scrollpane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(characters, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(new JLabel("Rating"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(slider, gbc);

        JPanel buttons = new JPanel();
        buttons.add(okB);
        buttons.add(segnalazioneB);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainJpanel.add(buttons, gbc);

        this.frame.setContentPane(mainJpanel);
        this.frame.pack();
        this.frame.setVisible(true);



        segnalazioneB.addActionListener(e -> {
            frame.setVisible(false);
            ArticlesController.getInstance().getSegnalationBoundary(frame, vendor, article, username);
        });
        Actions okButtonAction = new Actions(textArea, slider.getValue());
        okB.addActionListener(okButtonAction);

    }

    private class Actions implements ActionListener {

        private JTextArea textarea;
        private int rating;

        private Actions(JTextArea textarea, int rating) {
            this.textarea = textarea;
            this.rating = rating;
        }

        public void actionPerformed(ActionEvent event){
            if(ArticlesController.getInstance().sendReview(textarea.getText(), article, username, rating, vendor) == 1){
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "successo");
                System.exit(0);
            }
            else if(ArticlesController.getInstance().sendReview(textarea.getText(), article, username, rating, vendor) == 0)
                JOptionPane.showMessageDialog(null, "fallimento, probabilmente hai già scritto una recensione riguardante questo articolo");
            else
                JOptionPane.showMessageDialog(null, "numero di caratteri consentito superato");

        }
    }


    }
