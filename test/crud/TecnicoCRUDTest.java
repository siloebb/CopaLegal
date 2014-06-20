/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.List;
import model.Pais;
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
        
        TecnicoCRUD tec = new TecnicoCRUD();
        int valorAntigo =  tec.getList().size();
        
        tec.create(tecnico1);   
        
        assertEquals(valorAntigo + 1, tec.getList().size(),0);   
    }

    /**
     * Test of ready method, of class TecnicoCRUD.
     */
    @Test
    public void testReady() {
        System.out.println("ready");
        
        Tecnico tecnico1 = new Tecnico();
        tecnico1.setNome("Felipão");
        tecnico1.setDataNascimento("22/05/1956");
        
         TecnicoCRUD tec = new TecnicoCRUD();
         tec.create(tecnico1);
         
        Tecnico novo = tec.ready(tecnico1.getNome());
        assertEquals(tecnico1, novo);
        
        
        
    }

    /**
     * Test of getList method, of class TecnicoCRUD.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        TecnicoCRUD tec = new TecnicoCRUD();
        
        assertNotNull(tec.getList());
    }

    /**
     * Test of update method, of class TecnicoCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Tecnico tecnico1 = new Tecnico();
        tecnico1.setNome("Felipão");
        tecnico1.setDataNascimento("22/05/1956");
        
        TecnicoCRUD tec = new TecnicoCRUD();
        
        
        tec.create(tecnico1);
        Tecnico ready = tec.ready(tecnico1.getNome());
        
        ready.setDataNascimento("30/05/1978");        
        
        tec.update(ready);
        
        ready = tec.ready(tecnico1.getNome());
        assertEquals("30/05/1978", ready.getDataNascimento());
        
    }

    /**
     * Test of delete method, of class TecnicoCRUD.
     */
    /*@Test
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
   /* @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        TecnicoCRUD instance = new TecnicoCRUD();
        instance.deleteAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
