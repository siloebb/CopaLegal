/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.List;
import model.Copa;
import model.Fase;
import model.Gol;
import model.Jogo;
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
    //@Test
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
        
        for (Pais pais : result) {
            System.out.println("SAPO Pais = "+pais.getNome());
        }
        
        assertEquals(1, result.size());
    }
    
    @Test
    public void testGetPlacarDoJogo(){
        Jogo o = new Jogo();
        o.setData("10/06/2014");
        o.setFase(Fase.PRIMEIRA);
        o.setHorario("13:00");
        o.setLocal("arena fonte nova");

        JogoCRUD instance = new JogoCRUD();
        instance.create(o);
        
        Gol gol1, gol2, gol3;
        
        gol1 = new Gol();
        gol1.setTempo(10005l);
        gol1.setFoiContra(false);   
        gol1.setJogo(o);
        
        gol2 = new Gol();
        gol2.setTempo(22000l);
        gol2.setJogo(o);
        gol2.setFoiContra(false);
        
        gol3 = new Gol();
        gol3.setTempo(50000l);
        gol3.setJogo(o);
        gol3.setFoiContra(true);
        
        GolCRUD golCRUD = new GolCRUD();
        golCRUD.create(gol1);
        golCRUD.create(gol2);
        golCRUD.create(gol3);
        
        OutOfCRUD ooCRUD = new OutOfCRUD();
        List<Gol> placarDoJogo = ooCRUD.getPlacarDoJogo(o);
        
        assertEquals(3, placarDoJogo.size());
    }
    
}
