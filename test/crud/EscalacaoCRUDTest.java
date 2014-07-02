/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import model.Escalacao;
import model.Jogador;
import model.Pais;
import model.Selecao;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author suka
 */
public class EscalacaoCRUDTest {
    public EscalacaoCRUDTest(){
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
     * Test of create method, of class EscalacaoCRUD.
     */
    @Test
    public void testCreate(){
        System.out.println("create");
        Escalacao e = new Escalacao();
        Selecao s = new Selecao();
       /* s.setAno(1234);
        s.setGrupo("A");
        s.setPosicao(23);
        Pais p = new Pais();
        p.setContinente("Asia");
        p.setNome("Japão");
        p.setSigla("JP");
        s.setPais(p);
        s.setPais(p);*/
        e.setSelecao(s);
        
        EscalacaoCRUD instance = new EscalacaoCRUD();
        instance.create(e);
        int valorAntigo = instance.getList().size();
        instance.create(e);
        assertEquals(valorAntigo + 1, instance.getList().size(), 0);
        
    }
    
    /**
     * Test of ready method, of class EscalacaoCRUD.
     */
    
    @Test
    public void testReady(){
        System.out.println("ready");
        Escalacao e = new Escalacao();
        Selecao s = new Selecao();
      /*  s.setAno(1234);
        s.setGrupo("A");
        s.setPosicao(23);
        Pais p = new Pais();
        p.setContinente("Asia");
        p.setNome("Japão");
        p.setSigla("JP");
        s.setPais(p);
        s.setPais(p);*/
        e.setSelecao(s);
        
        EscalacaoCRUD instance = new EscalacaoCRUD();
        instance.create(e);
        Escalacao novo = instance.ready(e.getID());

        assertEquals(e, novo);
        
    }
    /**
     * Test of getList method, of class EscalacaoCRUD.
     */
    @Test
    public void testGetList(){
        System.out.println("getList");
        Escalacao e = new Escalacao();
        Selecao s = new Selecao();
      /*  s.setAno(1234);
        s.setGrupo("A");
        s.setPosicao(23);
        Pais p = new Pais();
        p.setContinente("Asia");
        p.setNome("Japão");
        p.setSigla("JP");
        s.setPais(p);
        s.setPais(p);*/
        e.setSelecao(s);
        
        EscalacaoCRUD instance = new EscalacaoCRUD();
        instance.create(e);
        int tamanhoLista = instance.getList().size();
        
        instance.create(e);
        
        assertEquals(tamanhoLista+1,instance.getList().size() );
    }
    /**
     * Test of update method, of class EscalacaoCRUD.
     */
    @Test
    public void testUpdate(){
        System.out.println("update");
        Escalacao e = new Escalacao();
        Selecao s = new Selecao();
      /*  s.setAno(1234);
        s.setGrupo("A");
        s.setPosicao(23);
        Pais p = new Pais();
        p.setContinente("Asia");
        p.setNome("Japão");
        p.setSigla("JP");
        s.setPais(p);
        s.setPais(p);*/
        e.setSelecao(s);
        EscalacaoCRUD instance = new EscalacaoCRUD();
        instance.create(e);
        
        Selecao se = new Selecao();
      /*  se.setAno(4321);
        s.setGrupo("D");
        s.setPosicao(24);
        Pais pa = new Pais();
        pa.setContinente("Asia");
        pa.setNome("China");
        pa.setSigla("CH");
        s.setPais(pa);
        s.setPais(pa);*/
        
        e.setSelecao(se);
        instance.update(e);

        assertEquals(e.getSelecao(), instance.ready(e.getID()).getSelecao());
        
    }
    /**
     * Test of delete method, of class EscalacaoCRUD.
     */
    @Test
    public void testDelete(){
        System.out.println("delete");
        Escalacao e = new Escalacao();
        Selecao s = new Selecao();
      /*  s.setAno(1234);
        s.setGrupo("A");
        s.setPosicao(23);
        Pais p = new Pais();
        p.setContinente("Asia");
        p.setNome("Japão");
        p.setSigla("JP");
        s.setPais(p);
        s.setPais(p);*/
        e.setSelecao(s);
        EscalacaoCRUD instance = new EscalacaoCRUD();
        instance.create(e);
        
        Long ID = e.getID();
        instance.delete(e);
       
        assertNull(instance.ready(ID));
    }
    /*
     * Test of deleteAll method, of class EsalacaoCRUD.
     */
    @Test
    public void testDeleteAll(){
        System.out.println("deleteAll");
        Escalacao e = new Escalacao();
        Selecao s = new Selecao();
       /* s.setAno(1234);
        s.setGrupo("A");
        s.setPosicao(23);
        Pais p = new Pais();
        p.setContinente("Asia");
        p.setNome("Japão");
        p.setSigla("JP");
        s.setPais(p);
        s.setPais(p);*/
        e.setSelecao(s);
        EscalacaoCRUD instance = new EscalacaoCRUD();
        instance.create(e);
        
        instance.deleteAll();
        assertEquals(0, instance.getList().size());
    }
}
