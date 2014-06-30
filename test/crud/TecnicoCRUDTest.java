/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.List;
import model.Tecnico;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import util.HibernateUtil;

/**
 *
 * @author Jéssica Magally
 */
public class TecnicoCRUDTest {
    TecnicoCRUD instance;
    Tecnico tecnico1, tecnico2, tecnico3;
    
    @Before
    public void setUp() throws Exception {
        HibernateUtil.getInstance().zerarSistema();
       
        tecnico1 = new Tecnico();
        tecnico1.setDataNascimento("22/02/1958");
        tecnico1.setNome("Felipão");
        System.out.println("update"+tecnico1.getId() );
        
        tecnico2 = new Tecnico();
        tecnico2.setDataNascimento("28/06/1960");
        tecnico2.setNome("Sampaoli");
        System.out.println("update"+tecnico2.getId() );
        
        tecnico3 = new Tecnico();
        tecnico3.setDataNascimento("28/06/1960");
        tecnico3.setNome("Paulo Bento");
        System.out.println("update"+tecnico2.getId() );
        
        instance = new TecnicoCRUD();
        instance.deleteAll();
    }
    

    /**
     * Test of create method, of class TecnicoCRUD.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
         int valorAntigo =  instance.getList().size();
        instance.create(tecnico1);
        

        assertEquals(valorAntigo + 1, instance.getList().size(), 0);      
    }

    /**
     * Test of ready method, of class TecnicoCRUD.
     */
    @Test
    public void testReady() {
        System.out.println("ready");
        
        instance.create(tecnico1);
        instance.create(tecnico2);
        instance.create(tecnico3);
        
        Tecnico resuTecnico =instance.ready(tecnico1.getId());
	assertEquals(tecnico1, resuTecnico);   
       
    }

    /**
     * Test of getList method, of class TecnicoCRUD.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        
      instance.create(tecnico1);
      instance.create(tecnico2);	
      instance.create(tecnico3);
      
      List<Tecnico> resultadoConsulta = instance.getList();
      assertFalse(resultadoConsulta.isEmpty());
      assertEquals(tecnico1, resultadoConsulta.get(0));
      assertEquals(tecnico2, resultadoConsulta.get(1));
      assertEquals(tecnico3, resultadoConsulta.get(2));
           
    }

    /**
     * Test of update method, of class TecnicoCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        instance.create(tecnico1);
        tecnico1.setNome("Parreira");
        instance.update(tecnico1);
        List<Tecnico> resultadoConsulta = instance.getList();
        assertEquals(tecnico1, resultadoConsulta.get(0));
        System.out.println(tecnico1.getId());
        System.out.println(resultadoConsulta.get(0).getId());
        
        
    }

    /**
     * Test of delete method, of class TecnicoCRUD.
     */
    @Test
    public void testDelete() {
        instance.create(tecnico1);
	instance.delete(tecnico1);
	List<Tecnico> resultadoConsulta = instance.getList();
	assertTrue(resultadoConsulta.isEmpty());
        
    }

    /**
     * Test of deleteAll method, of class TecnicoCRUD.
     */
    @Test
    public void testDeleteAll() {
      instance.create(tecnico1);
      instance.create(tecnico2);	
      instance.create(tecnico2);
      
      instance.deleteAll();
		
    List<Tecnico> resultadoConsulta = instance.getList();
    assertTrue(resultadoConsulta.isEmpty());
    }
    
}
