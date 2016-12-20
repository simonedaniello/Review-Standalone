package control;

import boundary.ReviewBoundary;
import boundary.SegnalationBoundary;
import entity.Review;

import javax.swing.*;

import static com.sun.imageio.plugins.jpeg.JPEG.vendor;

/**
 * Created by dandi on 13/12/16.
 */
public class ArticlesController {

    private static ArticlesController instance = new ArticlesController();
    private String articlename;
    private String username;

    private ArticlesController(){
    }

    public static ArticlesController getInstance(){
        return instance;
    }

    public int sendReview(String text, String articlename, String username, int rating, String owner){

        if(text.length() > 300)
            return 2;
        else {
            Review review = Factory.getInstance().getReview(rating, text.replace("\'", "\""), username, articlename, owner, false);
            if (DatabaseController.getInstance().setReview(review)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int sendWarning(String text, String vendor){

        Review review = Factory.getInstance().getReview(0, text.replace("\'", "\""), username, articlename, vendor, true);
        if(DatabaseController.getInstance().setReview(review))
            return 1;
        else
            return 0;
    }

    public void getSegnalationBoundary(JFrame frame, String vendor, String articleName, String username){
        this.articlename = articleName;
        this.username = username;
        new SegnalationBoundary(frame, vendor);
    }

    public void getReviewBoundary(JFrame frame, String vendor){
        frame.repaint();
        new ReviewBoundary(username, articlename, vendor, frame);
    }

}
