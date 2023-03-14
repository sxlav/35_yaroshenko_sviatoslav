package ex02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
/**
 * The MainTest class provides test cases for the Item2d and View classes.
 */
public class MainTest {

    Item2d item;

    View view;
    /**
     * Sets up the environment before each test case is executed.
     */
    @Before
    public void setUp() {
        item = new Item2d(123.456, 3, 5);
        view = new ViewResult();
    }
    /**
     * Tests the calculation functionality of the Item2d class.
     */
    @Test
    public void testCalc() {
        assertEquals(123.456, item.getInput(), 0.001);
        assertEquals(5, item.getHex());
        assertEquals(5, item.getOct());
        item.setInput(789.123);
        item.setHex(4);
        item.setOct(6);
        assertEquals(789.123, item.getInput(), 0.001);
        assertEquals(6, item.getHex());
        assertEquals(6, item.getOct());
        assertNotNull(item.toString());
    }
    /**
     * Tests the getView() method of the ViewableResult class.
     */
    @Test
    public void testViewableResult() {
        assertNotNull(new ViewableResult().getView());
    }
    /**
     * Tests the getView() method of the Viewable interface.
     */
    @Test
    public void testViewable() {
        assertNotNull(new ViewableResult().getView());
    }

}