package control;

import boundary.ReviewBoundary;
import boundary.SegnalationBoundary;
import entity.Review;

import javax.swing.*;

/**
 * Created by dandi on 13/12/16.
 */
public class ArticlesController {

    private static ArticlesController instance = new ArticlesController();

    private ArticlesController(){
    }

    public static ArticlesController getInstance(){
        return instance;
    }

    public int sendReview(String text, String articlename, String username, float rating, String owner){

        if(text.length() > 300)
            return 2;
        else {
            Review review = new Review();
            review.setArticle(articlename);
            review.setUser(username);
            review.setReview(text.replace("\'", "\""));
            review.setRating(rating);
            review.setOwner(owner);
            review.setWarning(false);

            if (DatabaseController.getInstance().setReview(review)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public void sendWarning(String text, String articlename, String username, String vendor){

        Review review = new Review();
        review.setArticle(articlename);
        review.setUser(username);
        review.setReview(text.replace("\'", "\""));
        review.setOwner(vendor);
        review.setWarning(true);

        DatabaseController.getInstance().setReview(review);
    }

    public void getSegnalationBoundary(JFrame frame, String vendor){
        new SegnalationBoundary(frame, vendor);
    }

}
