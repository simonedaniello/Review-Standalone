package boundary;

import control.ArticlesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class ExampleBoundary {

    private static ExampleBoundary instance = new ExampleBoundary();

    private ArrayList<String> articoli;
    private JList<String> list1;
    private JFrame boundaryCatalogo;

    /* costruisce la starter boundary del caso d'uso */
    private ExampleBoundary(){

        DefaultListModel<String> model = new DefaultListModel<>();
        list1 = new JList<>();
        list1.setModel(model);
        JScrollPane scrollpane = new JScrollPane(list1);
        boundaryCatalogo = new JFrame("Recensisci articolo");

        try {
            articoli = ArticlesController.getInstance().addElements(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton okB = new JButton("OK");
        Actions azione = new Actions();
        okB.addActionListener(azione);

        JPanel pannello = new JPanel();
        pannello.add(scrollpane);
        pannello.add(okB);

        boundaryCatalogo.add(pannello);
        boundaryCatalogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boundaryCatalogo.setResizable(false);
        boundaryCatalogo.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        boundaryCatalogo.setLocation(dim.width/2- boundaryCatalogo.getSize().width/2, dim.height/2- boundaryCatalogo.getSize().height/2);
        boundaryCatalogo.setVisible(true);

    }

    public static ExampleBoundary getInstance(){
        return instance;
    }

    /*contiene l'azione dell'unico JButton della boundary*/
    private class Actions implements ActionListener {

        private Actions(){
        }
        public void actionPerformed(ActionEvent event) {
            String chosen = list1.getSelectedValue();
            boundaryCatalogo.setVisible(false);
            for(int i = 0; i<(articoli.size())/2; i++){
                if(articoli.get(i*2).equals(chosen)){
                    String username = "simone@gmail.com";
                    ArticlesController.getInstance().getInitialReviewBoundary(username, articoli.get(i*2), articoli.get((i*2)+1), boundaryCatalogo);
                }
            }
        }
    }
}
