/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualzoo.zoo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import virtualzoo.cell.Cell;

/**
 *
 * @author David
 */
public class ZooTest {
    
    public ZooTest() {
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
     * Test of GetZooElmt method, of class Zoo.
     */
    @Test
    public void testGetZooElmt() {
        System.out.print("GetZooElmt");
        int i = 0;
        int j = 0;
        Zoo instance = new Zoo();
        Cell expResult = null;
        Cell result = instance.GetZooElmt(i, j);
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of SetZooElmt method, of class Zoo.
     */
    @Test
    public void testSetZooElmt() {
        System.out.print("SetZooElmt");
        int i = 0;
        int j = 0;
        Cell elmt = null;
        Zoo instance = new Zoo();
        instance.SetZooElmt(i, j, elmt);
        System.out.println(" berhasil");
    }
    
}
