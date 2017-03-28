/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualzoo.cell;

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
public class CellTest {
    
    public CellTest() {
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
     * Test of SetCellType method, of class Cell.
     */
    @Test
    public void testSetCellType() {
        System.out.print("SetCellType");
        String tipe = "";
        Cell instance = new Cell();
        instance.SetCellType(tipe);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetCellType method, of class Cell.
     */
    @Test
    public void testGetCellType() {
        System.out.print("GetCellType");
        Cell instance = new Cell();
        String expResult = "Facility";
        String result = instance.GetCellType();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of AddPilihan method, of class Cell.
     */
    @Test
    public void testAddPilihan() {
        System.out.print("AddPilihan");
        String _pilihan = "";
        Cell instance = new Cell();
        instance.AddPilihan(_pilihan);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetFacHabType method, of class Cell.
     */
    @Test
    public void testGetFacHabType() {
        System.out.print("GetFacHabType");
        Cell instance = new Cell();
        String expResult = "Road";
        String result = instance.GetFacHabType();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of Render method, of class Cell.
     */
    @Test
    public void testRender_boolean() {
        System.out.print("Render");
        boolean oncage = false;
        Cell instance = new Cell();
        instance.Render(oncage);
        System.out.println(" berhasil");
    }

    /**
     * Test of Render method, of class Cell.
     */
    @Test
    public void testRender_0args() {
        System.out.print("Render");
        Cell instance = new Cell();
        instance.Render();
        System.out.println(" berhasil");
    }

    /**
     * Test of Enter method, of class Cell.
     */
    @Test
    public void testEnter() {
        System.out.print("Enter");
        Cell instance = new Cell();
    }

    /**
     * Test of DelPilihan method, of class Cell.
     */
    @Test
    public void testDelPilihan() {
        System.out.print("DelPilihan");
        String _pilihan = "";
        Cell instance = new Cell();
        instance.DelPilihan(_pilihan);
        System.out.println(" berhasil");
    }
    
}
