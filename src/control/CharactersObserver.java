package control;


import javax.swing.*;

public class CharactersObserver{

    private JLabel component;
    private JTextArea textArea;

    public CharactersObserver(JTextArea textArea, JLabel jlabel){
        this.component = jlabel;
        this.textArea = textArea;
    }

    public void update() {
        int x = 300- this.textArea.getText().length();
        if(x > 0)
            this.component.setText(String.valueOf(x));
        else
            this.component.setText(String.valueOf(x) + " superati caratteri massimi");
    }
}
