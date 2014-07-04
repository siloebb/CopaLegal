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
import model.Selecao;
import model.Tecnico;
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
    
    @Test
    public void testGetRankingSelecao(){
        System.out.println("GetRankingSelecao");
        PaisCRUD pcrud = new PaisCRUD();
        TecnicoCRUD tcrud = new TecnicoCRUD();
        
        Selecao s = new Selecao();
        s.setAno(1930);
        s.setPosicao(1);
        s.setGrupo("A");
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        Pais p = new Pais();
        p.setNome("Bósnia e Herzegovina");
        s.setPais(p);
        
        Selecao s1 = new Selecao();
        s1.setAno(1930);
        s1.setPosicao(2);
        s1.setGrupo("A");
        Tecnico t1 = new Tecnico();
        s1.setTecnico(t1);
        Pais p1 = new Pais();
        p1.setNome("Rússia");
        s1.setPais(p1);
        
        pcrud.create(p);
        pcrud.create(p1);
        
        tcrud.create(t);
        tcrud.create(t1);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(s);
        instance.create(s1);
        
        List<Selecao> list = instance.getList();
        
        assertEquals(s, list.get(0));
    }
    
}
