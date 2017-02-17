package testing;

import control.ImageController;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * @author dandi on 28/12/16.
 */

public class JunitImageController {
    private File file = new File("/home/dandi/Pictures/Success.png");

    @Before
    public void before() {
        System.out.println("Starting new test on ImageController");
    }

    @Test
    public void testCopyFile() throws IOException {
        assertTrue(ImageController.getInstance().copyFile(file));
    }
}
