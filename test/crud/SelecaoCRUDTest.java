/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import model.Pais;
import model.Selecao;
import model.Tecnico;
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
public class SelecaoCRUDTest {
    public SelecaoCRUDTest(){
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
    public void createTest(){
        System.out.println("create");
        Selecao s = new Selecao();
        s.setAno(1930);
        s.setPosicao(30);
        s.setGrupo("A");
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        Pais p = new Pais();
        s.setPais(p);
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(s);
        
        int valorAntigo = instance.getList().size();
        
        instance.create(s);
        
        assertEquals(valorAntigo + 1, instance.getList().size(), 0);
    }
     /**
     * Test of ready method, of class SelecaoCRUD.
     */
    @Test
    public void testReady(){
        System.out.println("Ready");
        Selecao s = new Selecao();
        s.setAno(1920);
        s.setGrupo("B");
        s.setPosicao(45);
        Pais p = new Pais();
        s.setPais(p);
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(s);
        
        Selecao novo = instance.ready(s.getID());
        
        assertEquals(s,novo);   
    }
    /**
     * Test of getList method, of class SelecaoCRUD.
     */
    @Test
    public void TestGetList(){
        System.out.println("GetList");
        Selecao s = new Selecao();
        s.setAno(1500);
        s.setGrupo("Z");
        s.setPosicao(100);
        Pais p = new Pais();
        s.setPais(p);
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        int tamanhoLista = instance.getList().size();
        instance.create(s);
        assertEquals(tamanhoLista+1,instance.getList().size() );
    }
    /**
     * Test of update method, of class SelecaoCRUD.
     */
    @Test
    public void TestUpdate(){
        System.out.println("update");
        Selecao s = new Selecao();
        s.setAno(1230);
        s.setGrupo("G");
        s.setPosicao(1000);
        Pais p = new Pais();
        s.setPais(p);
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(s);
        s.setAno(100);
       
        instance.update(s);

        assertEquals(s.getAno(), instance.ready(s.getID()).getAno());
    }
    /**
     * Test of delete method, of class SelecaoCRUD.
     */
    @Test
    public void TestDelete(){
        System.out.println("delete");
        Selecao s = new Selecao();
        s.setAno(1);
        s.setGrupo("P");
        s.setPosicao(1780);
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        Pais p = new Pais();
        s.setPais(p);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(s);
        
        Long ID = s.getID();
        instance.delete(s);
        
        assertNull(instance.ready(ID));
    }
    
    /**
     * Test of deleteAll method, of class SelecaoCRUD.
     */
    @Test
    public void TestDeleteAll(){
        System.out.println("deleteAll");
        
        Selecao s = new Selecao();
        s.setAno(2);
        s.setGrupo("J");
        s.setPosicao(230);
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        Pais p = new Pais();
        s.setPais(p);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(s);
        instance.deleteAll();
        assertEquals(0, instance.getList().size());
    }
}
