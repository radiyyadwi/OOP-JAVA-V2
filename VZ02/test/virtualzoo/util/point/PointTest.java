/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualzoo.util.point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class PointTest {
    
    public PointTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetX method, of class Point.
     */
    @Test
    public void testGetX() {
        System.out.print("GetX");
        Point instance = new Point();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetY method, of class Point.
     */
    @Test
    public void testGetY() {
        System.out.print("GetY");
        Point instance = new Point();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of SetX method, of class Point.
     */
    @Test
    public void testSetX() {
        System.out.print("SetX");
        int x = 0;
        Point instance = new Point();
        instance.setX(x);
        System.out.println(" berhasil");
    }

    /**
     * Test of SetY method, of class Point.
     */
    @Test
    public void testSetY() {
        System.out.print("SetY");
        int y = 0;
        Point instance = new Point();
        instance.setY(y);
        System.out.println(" berhasil");
    }
    
}
