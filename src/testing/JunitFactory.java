package testing;

import control.Factory;
import entity.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author dandi on 22/12/16.
 */
public class JunitFactory {

    @Before
    public void before() {
        System.out.println("Starting new test on Factory");
    }

    @Test
    public void testGetReview()
    {
        Review reviewSample = new Review();
        reviewSample.setRating(1);
        reviewSample.setReview("testReview");
        reviewSample.setUser("testUser");
        reviewSample.setWarning(false);
        reviewSample.setArticle("testArticle");
        reviewSample.setOwner("testOwner");

        Review reviewToTest = Factory.getInstance().getReview(1,"testReview", "testUser", "testArticle", "testOwner", false);

        assertEquals(reviewSample.getArticle(), reviewToTest.getArticle());
        assertEquals(reviewSample.getOwner(), reviewToTest.getOwner());
        assertEquals(reviewSample.getRating(), reviewToTest.getRating());
        assertEquals(reviewSample.getReview(), reviewToTest.getReview());
        assertEquals(reviewSample.getUser(), reviewToTest.getUser());

    }
}

