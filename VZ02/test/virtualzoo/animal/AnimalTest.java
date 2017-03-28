/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualzoo.animal;

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
public class AnimalTest {
    
    public AnimalTest() {
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
     * Test of SetPosition method, of class Animal.
     */
    @Test
    public void testSetPosition() {
        System.out.print("SetPosition");
        Point P = new Point(1,1);
        Animal instance = new Animal('a');
        instance.setPosition(P);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetFoodType method, of class Animal.
     */
    @Test
    public void testGetFoodType() {
        System.out.print("GetFoodType");
        Animal instance = new Animal('a');
        String expResult = "Omnivore";
        String result = instance.getFoodType();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetDeskripsi method, of class Animal.
     */
    @Test
    public void testGetDeskripsi() {
        System.out.print("GetDeskripsi");
        Animal instance = new Animal('a');
        String expResult = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki bulu dan sayap";
        String result = instance.getDeskripsi();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetClassName method, of class Animal.
     */
    @Test
    public void testGetClassName() {
        System.out.print("GetClassName");
        Animal instance = new Animal('a');
        String expResult = "Aves";
        String result = instance.getClassName();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetPosition method, of class Animal.
     */
    @Test
    public void testGetPosition() {
        System.out.print("GetPosition");
        Animal instance = new Animal('a');
        Point expResult = new Point(-1,-1);
        Point result = instance.getPosition();
        assertEquals(expResult.getX(), result.getX());
        assertEquals(expResult.getY(), result.getY());

        System.out.println(" berhasil");
    }

    /**
     * Test of GetSpeciesName method, of class Animal.
     */
    @Test
    public void testGetSpeciesName() {
        System.out.print("GetSpeciesName");
        Animal instance = new Animal('a');
        String expResult = "Angsa";
        String result = instance.getSpeciesName();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of GetFoodNum method, of class Animal.
     */
    @Test
    public void testGetFoodNum() {
        System.out.print("GetFoodNum");
        Animal instance = new Animal('a');
        double expResult = 1.275;
        double result = instance.getFoodNum();
        assertEquals(expResult, result, 0.0);
        System.out.println(" berhasil");
    }

    /**
     * Test of IsEnemy method, of class Animal.
     */
    @Test
    public void testIsEnemy() {
        System.out.print("IsEnemy");
        String animal = "";
        Animal instance = new Animal('a');
        boolean expResult = false;
        boolean result = instance.isEnemy(animal);
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of IsTamed method, of class Animal.
     */
    @Test
    public void testIsTamed() {
        System.out.print("IsTamed");
        Animal instance = new Animal('a');
        boolean expResult = true;
        boolean result = instance.isTamed();
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of Interact method, of class Animal.
     */
    @Test
    public void testInteract() {
        System.out.print("Interact");
        Animal instance = new Animal('a');
        instance.interact();
        System.out.println(" berhasil");
    }

    /**
     * Test of Deskripsi method, of class Animal.
     */
    @Test
    public void testDeskripsi() {
        System.out.print("Deskripsi");
        Animal instance = new Animal('a');
        instance.deskripsi();
        System.out.println(" berhasil");
    }

    /**
     * Test of AddAnimalType method, of class Animal.
     */
    @Test
    public void testAddAnimalType() {
        System.out.print("AddAnimalType");
        String type = "";
        Animal instance = new Animal('a');
        instance.addAnimalType(type);
        System.out.println(" berhasil");
    }

    /**
     * Test of AddEnemy method, of class Animal.
     */
    @Test
    public void testAddEnemy() {
        System.out.print("AddEnemy");
        String animalname = "";
        Animal instance = new Animal('a');
        instance.addEnemy(animalname);
        System.out.println(" berhasil");
    }

    /**
     * Test of IsTypeThere method, of class Animal.
     */
    @Test
    public void testIsTypeThere() {
        System.out.print("IsTypeThere");
        String S = "";
        Animal instance = new Animal('a');
        boolean expResult = false;
        boolean result = instance.isTypeThere(S);
        assertEquals(expResult, result);
        System.out.println(" berhasil");
    }

    /**
     * Test of Render method, of class Animal.
     */
    @Test
    public void testRender() {
        System.out.print("Render");
        Animal instance = new Animal('a');
        instance.render();
        System.out.println(" berhasil");
    }
    
}
