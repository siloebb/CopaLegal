/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.List;
import model.Pais;
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
public class PaisCRUDTest {
    
    public PaisCRUDTest() {
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
     * Test of create method, of class PaisCRUD.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Pais o = new Pais();

        o.setNome("Brasil");
        o.setSigla("BR");
        o.setContinente("South America");

        PaisCRUD instance = new PaisCRUD();
        int valorAntigo =  instance.getList().size();
        
        instance.create(o);

        assertEquals(valorAntigo + 1, instance.getList().size(), 0);
    }

    /**
     * Test of ready method, of class PaisCRUD.
     */
    @Test
    public void testReady() {
        System.out.println("create");
        Pais o = new Pais();

        o.setNome("Brasil");
        o.setSigla("BR");
        o.setContinente("South America");

        PaisCRUD instance = new PaisCRUD();
        instance.create(o);

        Pais novo = instance.ready(o.getId());
        
        assertEquals(o, novo);
    }

    /**
     * Test of getList method, of class PaisCRUD.
     */
    @Test
    public void testGetList() {
        System.out.println("create");       

        PaisCRUD instance = new PaisCRUD();
        
        assertNotNull(instance.getList());
    }

    /**
     * Test of update method, of class PaisCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Pais o = new Pais();

        o.setNome("Estados Unidos");
        o.setSigla("BR");
        o.setContinente("North America");
        
        PaisCRUD instance = new PaisCRUD();
        
        instance.create(o);
        Pais ready = instance.ready(o.getId());
        
        ready.setSigla("USA");        
        
        instance.update(ready);
        
        ready = instance.ready(o.getId());
        assertEquals("USA", ready.getSigla());
    }

    /**
     * Test of delete method, of class PaisCRUD.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Pais o = new Pais();

        o.setNome("Estados Unidos");
        o.setSigla("BR");
        o.setContinente("North America");
        
        PaisCRUD instance = new PaisCRUD();
        
        instance.create(o);
        instance.delete(o);
        Pais ready = instance.ready(o.getId());
        
        assertNull(ready);        
    }

    /**
     * Test of deleteAll method, of class PaisCRUD.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        Pais o = new Pais();

        o.setNome("Estados Unidos");
        o.setSigla("BR");
        o.setContinente("North America");
        
        PaisCRUD instance = new PaisCRUD();
        
        instance.create(o);
        instance.deleteAll();
        
        assertEquals(0, instance.getList().size());
        
    }
    
}
