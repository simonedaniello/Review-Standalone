package testing;

import control.DatabaseController;
import entity.Review;
import control.Factory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author dandi on 22/12/16.
 */
public class JunitDatabase {

    @Before
    public void before() {
        System.out.println("Starting new test on Database");
    }

    @Test
    public void testSetReview() throws ClassNotFoundException {
        Review review = Factory.getInstance().getReview(0, "test", "simone@gmail.com", "gonna lunga", "simone@gmail.com", false);
        assertTrue(DatabaseController.getInstance().setReview(review));
        review = Factory.getInstance().getReview(0, "test", "simone@gmail.com", "gonna lunga", "simone@gmail.com", true);
        assertTrue(DatabaseController.getInstance().setReview(review));
        review = Factory.getInstance().getReview(0, "test", "emailErrata@gmail.com", "gonna lunga", "simone@gmail.com", false);
        assertFalse(DatabaseController.getInstance().setReview(review));
    }
}
