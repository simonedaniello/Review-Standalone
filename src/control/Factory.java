package control;

import entity.Review;


class Factory {

    private static Factory instance = new Factory();

    private Factory(){
    }

    static Factory getInstance(){
        return instance;
    }

    Review getReview(int rating, String text, String user, String article, String owner, boolean warning){

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
