/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.List;
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
public class PaisCRUDTest {

    public PaisCRUDTest() {
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
     * Test of create method, of class PaisCRUD.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Pais o = new Pais();

        o.setNome("Brasil");
        o.setSigla("BR");
        o.setContinente("South America");

        PaisCRUD instance = new PaisCRUD();
        instance.create(o);

        assertEquals(1, instance.getList().size(), 0);

    }

}
