package control;

import boundary.ReviewBoundary;
import entity.Review;

import javax.swing.*;

/**
 * Created by dandi on 13/12/16.
 */
public class ArticlesController {

    private static ArticlesController instance;

    private ArticlesController(){

    }

    public static ArticlesController getInstance(){
        return instance;
    }

    public void returnRevBoundary(JFrame frame){
        new ReviewBoundary(frame);
    }

    public void sendReview(String text, String articlename, String username, float rating){

        Review review = new Review();
        review.setArticle(articlename);
        review.setUser(username);
        review.setReview(text.replace("\'", "\""));
        review.setRating(rating);
        review.setWarning(false);

        DatabaseController.getInstance().setReview(review);
    }

    public void sendWarning(String text, String articlename, String username, String vendor){

        Review review = new Review();
        review.setArticle(articlename);
        review.setUser(username);
        review.setReview(text.replace("\'", "\""));
        review.setWarning(true);

        DatabaseController.getInstance().setWarning(review, vendor);
    }



}
