/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualzoo.util.mesinkar;

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
public class MesinkarTest {
    
    public MesinkarTest() {
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
     * Test of GetCC method, of class Mesinkar.
     */
    @Test
    public void testGetCC() {
        System.out.print("GetCC");
        Mesinkar instance = new Mesinkar();
        char expResult = 0;
        char result = instance.getCc();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetCI method, of class Mesinkar.
     */
    @Test
    public void testGetCI() {
        System.out.print("GetCI");
        Mesinkar instance = new Mesinkar();
        int expResult = -1;
        int result = instance.getCi();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetEOF method, of class Mesinkar.
     */
    @Test
    public void testGetEOF() {
        System.out.print("GetEOF");
        Mesinkar instance = new Mesinkar();
        boolean expResult = false;
        boolean result = instance.getEof();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of IsEOP method, of class Mesinkar.
     */
    @Test
    public void testIsEOP() {
        System.out.print("IsEOP");
        Mesinkar instance = new Mesinkar();
        boolean expResult = false;
        boolean result = instance.isEop();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of START method, of class Mesinkar.
     */
    @Test
    public void testSTART() {
        System.out.print("START");
        Mesinkar instance = new Mesinkar();
        instance.start();
        System.out.println(" berhasil");
    }

    /**
     * Test of ADV method, of class Mesinkar.
     */
    @Test
    public void testADV() {
        System.out.print("ADV");
        Mesinkar instance = new Mesinkar();
        System.out.println(" berhasil");
    }
    
}
