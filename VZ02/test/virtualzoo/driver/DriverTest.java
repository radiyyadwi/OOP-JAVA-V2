/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualzoo.driver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import virtualzoo.util.point.Point;

/**
 *
 * @author David
 */
public class DriverTest {
    
    public DriverTest() {
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
     * Test of DisplayVirtualZoo method, of class Driver.
     */
    @Test
    public void testDisplayVirtualZoo_0args() {
        System.out.print("DisplayVirtualZoo");
        Driver instance = new Driver();
        instance.DisplayVirtualZoo();
        System.out.println(" berhasil");
    }

    /**
     * Test of DisplayVirtualZoo method, of class Driver.
     */
    @Test
    public void testDisplayVirtualZoo_Point_Point() {
        System.out.print("DisplayVirtualZoo");
        Point upleft = new Point(1,1);
        Point downright = new Point(4,4);
        Driver instance = new Driver();
        instance.DisplayVirtualZoo(upleft, downright);
        System.out.println(" berhasil");
    }

    /**
     * Test of HitungMakanan method, of class Driver.
     */
    @Test
    public void testHitungMakanan() {
        System.out.print("HitungMakanan");
        Driver instance = new Driver();
        instance.HitungMakanan();
        System.out.println(" berhasil");
    }

    /**
     * Test of MoveAnimal method, of class Driver.
     */
    @Test
    public void testMoveAnimal() {
        System.out.print("MoveAnimal");
        Driver instance = new Driver();
        instance.MoveAnimal();
        System.out.println(" berhasil");
    }

    /**
     * Test of PrintTitle method, of class Driver.
     */
    @Test
    public void testPrintTitle() {
        System.out.print("PrintTitle");
        Driver instance = new Driver();
        instance.PrintTitle();
        System.out.println(" berhasil");
    }

    /**
     * Test of TourVirtualZoo method, of class Driver.
     */
    @Test
    public void testTourVirtualZoo() {
        System.out.print("TourVirtualZoo");
        Driver instance = new Driver();
    }

    /**
     * Test of PrintAllAnimal method, of class Driver.
     */
    @Test
    public void testPrintAllAnimal() {
        System.out.print("PrintAllAnimal");
        Driver instance = new Driver();
        instance.PrintAllAnimal();
        System.out.println(" berhasil");
    }
    
}
