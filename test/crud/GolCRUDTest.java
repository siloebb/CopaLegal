/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.List;
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
    Gol gol1 =null, gol2, gol3;
        
    
    @Before
    public void setUp() throws Exception{
        HibernateUtil.getInstance().zerarSistema();
        
       
        gol1 = new Gol();
        gol1.setTempo(10005l);
        gol1.setFoiContra(false);   
        System.out.println("update" +gol1.getId() );
        
        gol2 = new Gol();
        gol2.setTempo(10005l);
        gol2.setFoiContra(false); 
        
        System.out.println("update" +gol2.getId() );
        
        gol3 = new Gol();
        gol3.setTempo(10005l);
        gol3.setFoiContra(true); 
        
        System.out.println("update" +gol3.getId() );
        
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
        
        instance.create(gol1);
        instance.create(gol2);
        instance.create(gol3);
        
        Gol resuGol =instance.ready(gol1.getId());
	assertEquals(gol1, resuGol);
       
    }

    /**
     * Test of getList method, of class GolCRUD.
     */
    @Test
    public void testGetList() {
      System.out.println("getList");
      instance.create(gol1);
      instance.create(gol2);	
      instance.create(gol3);
      
      List<Gol> resultadoConsulta = instance.getList();
      assertFalse(resultadoConsulta.isEmpty());
      assertEquals(gol1, resultadoConsulta.get(0));
      assertEquals(gol2, resultadoConsulta.get(1));
      assertEquals(gol3, resultadoConsulta.get(2));
        
    }

    /**
     * Test of update method, of class GolCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        instance.create(gol1);
        gol1.setFoiContra(true);
        instance.update(gol1);
        List<Gol> resultadoConsulta = instance.getList();
        assertEquals(gol1, resultadoConsulta.get(0));
        System.out.println(gol1.getId());
        System.out.println(resultadoConsulta.get(0).getId());
    }

    /**
     * Test of delete method, of class GolCRUD.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        instance.create(gol1);
	instance.delete(gol1);
	List<Gol> resultadoConsulta = instance.getList();
	assertTrue(resultadoConsulta.isEmpty());
        
    }

    /**
     * Test of deleteAll method, of class GolCRUD.
     */
    @Test
    public void testDeleteAll() {
      System.out.println("deleteAll");
      instance.create(gol1);
      instance.create(gol2);	
      instance.create(gol3);
      
      instance.deleteAll();
		
    List<Gol> resultadoConsulta = instance.getList();
    assertTrue(resultadoConsulta.isEmpty());
       
    }
    
}
