/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import model.Gol;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.HibernateUtil;

/**
 *
 * @author Jéssica Magally
 */
public class GolCRUDTest {
    GolCRUD instance;
    Gol gol1, gol2, gol3;
    
    
    @Before
    public void setUp() throws Exception{
        
       
        gol1 = new Gol();
        
        
        System.out.println("update"+gol1.getId() );
        
        gol2 = new Gol();
        
        System.out.println("update"+gol2.getId() );
        
        gol3 = new Gol();
        
        System.out.println("update"+gol2.getId() );
        
        instance = new GolCRUD();
        instance.deleteAll();
    }
    
    

    /**
     * Test of create method, of class GolCRUD.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        int valorAntigo =  instance.getList().size();
        instance.create(gol1);
        

        assertEquals(valorAntigo + 1, instance.getList().size(), 0);
        
    }

    /**
     * Test of ready method, of class GolCRUD.
     */
    @Test
    public void testReady() {
        System.out.println("ready");
       
    }

    /**
     * Test of getList method, of class GolCRUD.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        
    }

    /**
     * Test of update method, of class GolCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
    }

    /**
     * Test of delete method, of class GolCRUD.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        
    }

    /**
     * Test of deleteAll method, of class GolCRUD.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
       
    }
    
}
