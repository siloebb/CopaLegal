/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.List;
import model.Substituicao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Siloe
 */
public class SubstituicaoCRUDTest {
    
    public SubstituicaoCRUDTest() {
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
     * Test of create method, of class SubstituicaoCRUD.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Substituicao o = null;
        o.setTempo(10005l);
        
        
        SubstituicaoCRUD instance = new SubstituicaoCRUD();
        
        
        
        instance.create(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ready method, of class SubstituicaoCRUD.
     */
    @Test
    public void testReady() {
        System.out.println("ready");
        Long id = null;
        SubstituicaoCRUD instance = new SubstituicaoCRUD();
        Substituicao expResult = null;
        Substituicao result = instance.ready(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getList method, of class SubstituicaoCRUD.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        SubstituicaoCRUD instance = new SubstituicaoCRUD();
        List<Substituicao> expResult = null;
        List<Substituicao> result = instance.getList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SubstituicaoCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Substituicao o = null;
        SubstituicaoCRUD instance = new SubstituicaoCRUD();
        instance.update(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SubstituicaoCRUD.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Substituicao o = null;
        SubstituicaoCRUD instance = new SubstituicaoCRUD();
        instance.delete(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAll method, of class SubstituicaoCRUD.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        SubstituicaoCRUD instance = new SubstituicaoCRUD();
        instance.deleteAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
