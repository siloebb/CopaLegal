/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.List;
import model.Copa;
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
public class CopaCRUDTest {
    
    public CopaCRUDTest() {
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
     * Test of create method, of class CopaCRUD.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Pais o = new Pais();

        o.setNome("Brasil");
        o.setSigla("BRA");
        o.setContinente("South America");

        PaisCRUD pcrud = new PaisCRUD();
        int valorAntigo =  pcrud.getList().size();
        
        pcrud.create(o);
        
        
        Copa copa = new Copa();
        copa.setAno(2014);
        copa.setObservacao("Nenhuma");
        copa.setPais(o);
        
        CopaCRUD instance = new CopaCRUD();
        instance.create(copa);

        assertEquals(valorAntigo + 1, instance.getList().size(), 0);
    }

    /**
     * Test of ready method, of class CopaCRUD.
     */
    @Test
    public void testReady() {
        System.out.println("ready");
        Pais o = new Pais();

        o.setNome("South Africa");
        o.setSigla("AF");
        o.setContinente("Africa");

        PaisCRUD pcrud = new PaisCRUD();
        int valorAntigo =  pcrud.getList().size();
        
        pcrud.create(o);
        
        
        Copa copa = new Copa();
        copa.setAno(2010);
        copa.setObservacao("Nenhuma");
        copa.setPais(o);
        
        CopaCRUD instance = new CopaCRUD();
        instance.create(copa);

        assertEquals(copa, instance.ready(copa.getAno()));
    }

    /**
     * Test of getList method, of class CopaCRUD.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        Pais o = new Pais();

        o.setNome("Brasil");
        o.setSigla("BRA");
        o.setContinente("South America");

        PaisCRUD pcrud = new PaisCRUD();
        int valorAntigo =  pcrud.getList().size();
        
        pcrud.create(o);
        
        
        Copa copa = new Copa();
        copa.setAno(2018);
        copa.setObservacao("Nenhuma");
        copa.setPais(o);
        
        CopaCRUD instance = new CopaCRUD();
        instance.create(copa);

        assertNotNull(instance.getList());
    }

    /**
     * Test of update method, of class CopaCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Pais o = new Pais();

        o.setNome("Brasil");
        o.setSigla("BRA");
        o.setContinente("South America");

        PaisCRUD pcrud = new PaisCRUD();
        int valorAntigo =  pcrud.getList().size();
        
        pcrud.create(o);
        
        
        Copa copa = new Copa();
        copa.setAno(2022);
        copa.setObservacao("Nenhuma");
        copa.setPais(o);
        
        CopaCRUD instance = new CopaCRUD();
        instance.create(copa);
        copa = instance.ready(copa.getAno());
        
        copa.setObservacao("Alterado");
        instance.update(copa);
        Copa ready = instance.ready(copa.getAno());

        assertEquals("Alterado", ready.getObservacao());
    }

    /**
     * Test of delete method, of class CopaCRUD.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Pais o = new Pais();

        o.setNome("Brasil");
        o.setSigla("BRA");
        o.setContinente("South America");

        PaisCRUD pcrud = new PaisCRUD();
        int valorAntigo =  pcrud.getList().size();
        
        pcrud.create(o);
        
        
        Copa copa = new Copa();
        copa.setAno(2026);
        copa.setObservacao("Nenhuma");
        copa.setPais(o);
        
        CopaCRUD instance = new CopaCRUD();
        instance.create(copa);
        instance.delete(copa);
        
        assertNull(instance.ready(copa.getAno()));
    }

    /**
     * Test of deleteAll method, of class CopaCRUD.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        Pais o = new Pais();

        o.setNome("Brasil");
        o.setSigla("BRA");
        o.setContinente("South America");

        PaisCRUD pcrud = new PaisCRUD();
        
        pcrud.create(o);
        
        Copa copa = new Copa();
        copa.setAno(2030);
        copa.setObservacao("Nenhuma");
        copa.setPais(o);
        
        CopaCRUD instance = new CopaCRUD();
        instance.create(copa);
        instance.deleteAll();
        
        assertEquals(0, instance.getList().size());
    }
    
}
