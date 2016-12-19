package starter;

import boundary.ReviewBoundary;
import control.ArticlesController;

public class Main {

    public static void main(String[] args) {
       // ArticlesController.getInstance().sendReview("review di prova", "gonna lunga", "simone@gmail.com", 3, "simone@gmail.com");
       // ArticlesController.getInstance().sendWarning("review di prova", "gonna lunga", "simone@gmail.com", "simone@gmail.com");
        new ReviewBoundary("simone@gmail.com", "gonna lunga", "simone@gmail.com");
    }
}
