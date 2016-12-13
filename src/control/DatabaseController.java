package control;

import entity.Review;

/**
 * Created by dandi on 13/12/16.
 */
public class DatabaseController {

    private static DatabaseController instance;

    private DatabaseController(){

    }

    static DatabaseController getInstance(){
        return instance;
    }

    void setReview(Review review){

    }

    void setWarning(Review review, String vendor){

    }

}
