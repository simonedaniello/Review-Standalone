package starter;

import control.ArticlesController;

public class Main {

    public static void main(String[] args) {
        ArticlesController.getInstance().sendReview("review di prova", "gonna lunga", "simone@gmail.com", 3, "simone@gmail.com");
    }
}
