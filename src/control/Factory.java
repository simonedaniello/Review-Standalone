package control;

import entity.Review;


public class Factory {

    private static Factory instance = new Factory();

    private Factory(){
    }

    public static Factory getInstance(){
        return instance;
    }

    public Review getReview(int rating, String text, String user, String article, String owner, boolean warning){

        Review review = new Review();

        review.setOwner(owner);
        review.setArticle(article);
        review.setWarning(warning);
        review.setReview(text);
        review.setUser(user);
        review.setRating(rating);

        return review;
    }
}
