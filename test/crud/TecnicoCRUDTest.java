/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.List;
import model.Tecnico;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jéssica Magally
 */
public class TecnicoCRUDTest {
    
    public TecnicoCRUDTest() {
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
     * Test of create method, of class TecnicoCRUD.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        
        Tecnico tecnico1 = new Tecnico();
        tecnico1.setNome("Felipão");
        tecnico1.setDataNascimento("22/05/1956");
        
        TecnicoCRUD instance = new TecnicoCRUD();
        instance.create(tecnico1);

        //assertEquals();
        fail("The test case is a prototype.");
    }

    /**
     * Test of ready method, of class TecnicoCRUD.
     */
    @Test
    public void testReady() {
        System.out.println("ready");
        String id = "";
        TecnicoCRUD instance = new TecnicoCRUD();
        Tecnico expResult = null;
        Tecnico result = instance.ready(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getList method, of class TecnicoCRUD.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        TecnicoCRUD instance = new TecnicoCRUD();
        List<Tecnico> expResult = null;
        List<Tecnico> result = instance.getList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TecnicoCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Tecnico o = null;
        TecnicoCRUD instance = new TecnicoCRUD();
        instance.update(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class TecnicoCRUD.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Tecnico o = null;
        TecnicoCRUD instance = new TecnicoCRUD();
        instance.delete(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAll method, of class TecnicoCRUD.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        TecnicoCRUD instance = new TecnicoCRUD();
        instance.deleteAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
