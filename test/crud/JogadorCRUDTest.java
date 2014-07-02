/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.List;
import model.Jogador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bianca
 */
public class JogadorCRUDTest {

    public JogadorCRUDTest() {
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
     * Test of create method, of class JogadorCRUD.
     */
    @Test
    public void testCreate() {
        System.out.println("create agora vai porra");
        Jogador o = new Jogador();
        o.setNome("Bianca");
        o.setDataNascimento("12/06/1992");
        o.setNumero(10);

        JogadorCRUD instance = new JogadorCRUD();
        instance.create(o);

        int valorAntigo = instance.getList().size();

        instance.create(o);

        assertEquals(valorAntigo + 1, instance.getList().size(), 0);
    }

    /**
     * Test of ready method, of class JogadorCRUD.
     */
    @Test
    public void testReady() {
        System.out.println("create");
        Jogador o = new Jogador();

        o.setNome("Brasil");
        o.setDataNascimento("BR");
        o.setNumero(10);

        JogadorCRUD instance = new JogadorCRUD();
        instance.create(o);

        Jogador novo = instance.ready(o.getID());

        assertEquals(o, novo);

    }

    /**
     * Test of getList method, of class JogadorCRUD.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
       
       Jogador o = new Jogador();
        o.setNome("Bia boa programadora");
        o.setDataNascimento("12/06/1992");
        o.setNumero(10);
        
               
        JogadorCRUD instance = new JogadorCRUD();
        int tamanhoLista = instance.getList().size();
        
        instance.create(o);
        
        assertEquals(tamanhoLista+1,instance.getList().size() );
        
    }

    /**
     * Test of update method, of class JogadorCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");

        Jogador o = new Jogador();
        o.setNome("Bialinda");
        o.setDataNascimento("12/06/1992");
        o.setNumero(10);

        JogadorCRUD instance = new JogadorCRUD();
        instance.create(o);
        o.setNome("BiaMais linda ainda");

        instance.update(o);

        assertEquals(o.getNome(), instance.ready(o.getID()).getNome());
    }

    /**
     * Test of delete method, of class JogadorCRUD.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");

        Jogador o = new Jogador();
        o.setNome("BiaFeia");
        o.setDataNascimento("12/06/1992");
        o.setNumero(10);
        
        JogadorCRUD instance = new JogadorCRUD();
        instance.create(o);
        
        Long ID = o.getID();
        instance.delete(o);
       
        assertNull(instance.ready(ID));
    }

    /**
     * Test of deleteAll method, of class JogadorCRUD.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        
        Jogador o = new Jogador();
        o.setNome("BiaLindissima");
        o.setDataNascimento("12/06/1992");
        o.setNumero(10);
        
        
        JogadorCRUD instance = new JogadorCRUD();
        instance.create(o);
        instance.deleteAll();
         
        assertEquals(0, instance.getList().size());
        
    }

}
