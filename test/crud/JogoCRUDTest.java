/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.List;
import model.Fase;
import model.Jogo;
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
public class JogoCRUDTest {

    public JogoCRUDTest() {
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
     * Test of create method, of class JogoCRUD.
     */
    @Test
    public void testCreate() {
        System.out.println("create");

        Jogo o = new Jogo();
        o.setData("10/06/2014");
        o.setFase(Fase.PRIMEIRA);
        o.setHorario("13:00");
        o.setLocal("arena fonte nova");

        JogoCRUD instance = new JogoCRUD();
        instance.create(o);

        int valorAntigo = instance.getList().size();

        instance.create(o);

        assertEquals(valorAntigo + 1, instance.getList().size(), 0);
    }

    /**
     * Test of ready method, of class JogoCRUD.
     */
    @Test
    public void testReady() {

       System.out.println("Ready");
        Jogo o = new Jogo();
        o.setData("10/06/2032");
        o.setFase(Fase.OITAVAS);
        o.setHorario("16:00");
        o.setLocal("nova");


        JogoCRUD instance = new JogoCRUD();
        instance.create(o);

        Jogo novo = instance.ready(o.getID());

        assertEquals(o, novo);
    }

    /**
     * Test of getList method, of class JogoCRUD.
     */
    @Test
    public void testGetList() {

        System.out.println("getList");

        Jogo o = new Jogo();

        o.setData("10/06/2015");
        o.setFase(Fase.FINAL);
        o.setHorario("13:30");
        o.setLocal("oi");

        JogoCRUD instance = new JogoCRUD();
        int tamanhoLista = instance.getList().size();

        instance.create(o);

        assertEquals(tamanhoLista + 1, instance.getList().size());
    }

    /**
     * Test of update method, of class JogoCRUD.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");

        Jogo o = new Jogo();

        o.setData("10/06/2016");
        o.setFase(Fase.QUARTAS);
        o.setHorario("13:30");
        o.setLocal("oi");

        JogoCRUD instance = new JogoCRUD();
        instance.create(o);
        o.setHorario("dfdf");

        instance.update(o);

        assertEquals(o.getHorario(), instance.ready(o.getID()).getHorario());
    }

    /**
     * Test of delete method, of class JogoCRUD.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Jogo o = new Jogo();

        o.setData("10/06/2020");
        o.setFase(Fase.QUARTAS);
        o.setHorario("13:30");
        o.setLocal("oi");

        JogoCRUD instance = new JogoCRUD();
        instance.create(o);

        Long ID = o.getID();
        instance.delete(o);

        assertNull(instance.ready(ID));
    }

    /**
     * Test of deleteAll method, of class JogoCRUD.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        Jogo o = new Jogo();

        o.setData("10/06/2020");
        o.setFase(Fase.QUARTAS);
        o.setHorario("15:30");
        o.setLocal("olalalal");

        JogoCRUD instance = new JogoCRUD();
        instance.create(o);
        instance.deleteAll();

        assertEquals(0, instance.getList().size());

    }

}
