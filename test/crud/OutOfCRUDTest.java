/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.List;
import model.Copa;
import model.Gol;
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
public class OutOfCRUDTest {
    
    public OutOfCRUDTest() {
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
     * Test of listarPaisesCopa method, of class OutOfCRUD.
     */
    @Test
    public void testListarPaisesCopa() {
        System.out.println("listarPaisesCopa");
        
        Pais o = new Pais();

        o.setNome("Brasil");
        o.setSigla("BRA");
        o.setContinente("South America");

        PaisCRUD pcrud = new PaisCRUD();        
        pcrud.create(o);        
        
        Copa copa = new Copa();
        copa.setAno(2014);
        copa.setObservacao("Nenhuma");
        copa.setPais(o);
        
        CopaCRUD instance = new CopaCRUD();
        instance.create(copa);
        
        OutOfCRUD ooc = new OutOfCRUD();
        
        List<Pais> result = ooc.listarPaisesCopa(copa);
        
        assertEquals(1, result.size());
    }
    
}
