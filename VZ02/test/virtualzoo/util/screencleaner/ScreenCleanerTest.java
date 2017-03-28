/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualzoo.util.screencleaner;

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
public class ScreenCleanerTest {
    
    public ScreenCleanerTest() {
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
     * Test of ClearScreen method, of class ScreenCleaner.
     */
    @Test
    public void testClearScreen() {
        System.out.print("ClearScreen");
        ScreenCleaner instance = new ScreenCleaner();
        instance.clearScreen();
        System.out.println(" berhasil");
    }
    
}
