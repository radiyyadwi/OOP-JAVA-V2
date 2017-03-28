/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualzoo.cage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import virtualzoo.animal.Animal;
import virtualzoo.util.point.Point;

/**
 *
 * @author David
 */
public class CageTest {
    
    public CageTest() {
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
     * Test of GetCageSize method, of class Cage.
     */
    @Test
    public void testGetCageSize() {
        System.out.print("GetCageSize");
        Cage instance = new Cage();
        int expResult = 0;
        int result = instance.getCageSize();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetID method, of class Cage.
     */
    @Test
    public void testGetID() {
        System.out.print("GetID");
        Cage instance = new Cage();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of NumberOfAnimal method, of class Cage.
     */
    @Test
    public void testNumberOfAnimal() {
        System.out.print("NumberOfAnimal");
        Cage instance = new Cage();
        int expResult = 0;
        int result = instance.numberOfAnimal();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetTypeCage method, of class Cage.
     */
    @Test
    public void testGetTypeCage() {
        System.out.print("GetTypeCage");
        int id = 0;
        Point[] area = new Point[1];
        area[0] = new Point(1,1);
        int ukuran = 1;
        String type = "Land";
        Cage instance = new Cage(id, area, ukuran, type);
        String expResult = "Land";
        String result = instance.getTypeCage();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetAreaElmt method, of class Cage.
     */
    @Test
    public void testGetAreaElmt() {
        System.out.print("GetAreaElmt");
        int i = 0;
        int id = 0;
        Point[] area = new Point[1];
        area[0] = new Point(1,1);
        int ukuran = 1;
        String type = "Land";
        Cage instance = new Cage(id, area, ukuran, type);
        Point expResult = new Point(1,1);
        Point result = instance.getAreaElmt(i);
        assertEquals(expResult.getX(), result.getX());
        assertEquals(expResult.getY(), result.getY());

        System.out.println(" berhasil");
    }

    /**
     * Test of GetAnimal method, of class Cage.
     */
    @Test
    public void testGetAnimal() {
        System.out.print("GetAnimal");
        int i = 0;
        int id = 0;
        Point[] area = new Point[1];
        area[0] = new Point(1,1);
        int ukuran = 1;
        String type = "Land";
        Cage instance = new Cage(id, area, ukuran, type);
        instance.inputAnimal(new Animal('a'), 0);
        Animal expResult = null;
        Animal result = instance.getAnimal(i);
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of InputAnimal method, of class Cage.
     */
    @Test
    public void testInputAnimal() {
        System.out.print("InputAnimal");
        Animal hewan = new Animal('a');
        int area_id = 0;
        Cage instance = new Cage();
        instance.inputAnimal(hewan, area_id);
        System.out.println(" berhasil");
    }

    /**
     * Test of Aman method, of class Cage.
     */
    @Test
    public void testAman() {
        System.out.print("Aman");
        Animal hewan = new Animal('a');
        Cage instance = new Cage();
        boolean expResult = true;
        boolean result = instance.aman(hewan);
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of IsPassAble method, of class Cage.
     */
    @Test
    public void testIsPassAble() {
        System.out.print("IsPassAble");
        Point p = null;
        Cage instance = new Cage();
        boolean expResult = false;
        boolean result = instance.isPassAble(p);
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of MoveAnimal method, of class Cage.
     */
    @Test
    public void testMoveAnimal() {
        System.out.print("MoveAnimal");
        Cage instance = new Cage();
        instance.moveAnimal();
        System.out.println(" berhasil");
    }

    /**
     * Test of Render method, of class Cage.
     */
    @Test
    public void testRender() {
        System.out.print("Render");
        Cage instance = new Cage();
        instance.render();
        System.out.println(" berhasil");
    }
    
}
