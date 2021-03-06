/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import java.util.ArrayList;
import java.util.List;
import model.Copa;
import model.Fase;
import model.Gol;
import model.Jogador;
import model.Jogo;
import model.Pais;
import model.Posicao;
import model.Selecao;
import model.Substituicao;
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
    @Test
    public void testListarPaisesCopa() {
        System.out.println("listarPaisesCopa");
        
        Pais p1 = new Pais();

        p1.setNome("Brasil");
        p1.setSigla("BRA");
        p1.setContinente("America do Sul");
        
        Pais p2 = new Pais();
        
        p2.setNome("Holanda");
        p2.setSigla("HOL");
        p2.setContinente("Europa");

        PaisCRUD pcrud = new PaisCRUD();        
        pcrud.create(p1);  
        pcrud.create(p2);
        
        Copa copa = new Copa();
        copa.setAno(2014);
        copa.setObservacao("Nenhuma");
        copa.setPais(p1);
        copa.setPais(p2);
        
        CopaCRUD instance = new CopaCRUD();
        instance.create(copa);
        
        OutOfCRUD ooc = new OutOfCRUD();
        
        List<Pais> result = pcrud.getList();       
        for (Pais pais : result) {
            System.out.println("SAPO Pais = "+pais.getNome());
        }
        
        assertEquals(p1, result.get(0));
        assertEquals(p2, result.get(1));
        assertEquals(2, result.size());
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
    
    @Test
    public void testListarJogosCopa(){
        System.out.println("ListarJogosCopa");
      
        CopaCRUD ccrud = new CopaCRUD();
        PaisCRUD pcrud = new PaisCRUD();
        SelecaoCRUD scrud = new SelecaoCRUD();
        TecnicoCRUD tcrud = new TecnicoCRUD();
        
        Pais p1 = new Pais();
        p1.setNome("Brasil");
        
        Pais p2 = new Pais();
        p2.setNome("Alemanha");
        
        Copa c = new Copa();
        c.setAno(2014);
        c.setPais(p1);
 
        
        Selecao s1 = new Selecao();
        s1.setAno(2014);
        s1.setPosicao(2);
        s1.setGrupo("A");
        Tecnico t1 = new Tecnico();
        s1.setTecnico(t1);
        s1.setPais(p1);
        
        Selecao s2 = new Selecao();
        s2.setAno(2014);
        s2.setPosicao(3);
        s2.setGrupo("A");
        Tecnico t2 = new Tecnico();
        s2.setTecnico(t2);
        s2.setPais(p2);
        
        pcrud.create(p2);
        pcrud.create(p1);
        
        tcrud.create(t2);
        tcrud.create(t1);
        
        scrud.create(s1);
        scrud.create(s2);
        
        ccrud.create(c);
        
        Jogo j1= new Jogo();
        j1.setAno(2014);
        j1.setLocal("Mineirao");
        
        Jogo j2= new Jogo();
        j2.setAno(2014);
        j2.setLocal("FonteNova");
                
        JogoCRUD instance = new JogoCRUD();
        instance.create(j1);
        instance.create(j2);
        
        
        OutOfCRUD ooCRUD = new OutOfCRUD();
        List<Jogo> jogos = ooCRUD.listarJogosCopa(c);
        
                
        assertEquals(j2.getLocal(), jogos.get(1).getLocal());
        assertEquals(j1.getLocal(), jogos.get(0).getLocal());
        
    }
    
    //@Test
    public void testarListarJogadoresSelecao(){
        Jogador j1 = new Jogador();
        j1.setNome("Hulk");
        j1.setDataNascimento("12/06/1986");
        j1.setNumero(10);
        
        Jogador j2 = new Jogador();
        j2.setNome("David Luiz");
        j2.setDataNascimento("22/04/1987");
        j2.setNumero(7);

        JogadorCRUD instance = new JogadorCRUD();
        instance.create(j1);
        instance.create(j2);

        Selecao s1 = new Selecao();
        s1.setAno(2014);
        ArrayList<Jogador> list = new ArrayList<>();
        list.add(j1);
        list.add(j2);
        s1.setJogador(list);
        
        OutOfCRUD ooc = new OutOfCRUD();
        
        List<Jogador> jogador = ooc.listarJogadoresSelecao(s1);
        assertFalse(jogador.isEmpty());
        assertEquals(j1, jogador.get(0));
        assertEquals(j2, jogador.get(1));
    }
    //@Test
    public void testarConsultarTecnicoSelecao(){
        Tecnico t1 = new Tecnico();

        t1.setNome("Felipão");
        t1.setDataNascimento("22/02/1958");
        
        TecnicoCRUD tcrud = new TecnicoCRUD();        
        tcrud.create(t1);  
        
        Selecao selecao = new Selecao();
        selecao.setGrupo("A");
        selecao.setAno(2014);
        selecao.setTecnico(t1);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(selecao);
        
        OutOfCRUD ooc = new OutOfCRUD();
       
        Tecnico t = ooc.consultarTecnicoSelecao(selecao);
        
        assertEquals(selecao.getTecnico(), t);
        
        
    }
    
    @Test
    public void testQtdDeParticipacoesEmCopa(){
        System.out.println("qtdDeParticipacoesEmCopa");
        PaisCRUD pcrud = new PaisCRUD();
        TecnicoCRUD tcrud = new TecnicoCRUD();
        CopaCRUD ccrud = new CopaCRUD();
        
        
        Selecao s = new Selecao();
        s.setAno(1930);
        s.setPosicao(1);
        s.setGrupo("A");
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        Pais p = new Pais();
        p.setNome("Bósnia e Herzegovina");
        s.setPais(p);
        
        Copa copa= new Copa();
        copa.setAno(2015);
        copa.setPais(p);
        
        s.setCopa(copa);
        
        Selecao s1 = new Selecao();
        s1.setAno(1930);
        s1.setPosicao(2);
        s1.setGrupo("A");
        s1.setCopa(copa);
        Tecnico t1 = new Tecnico();
        s1.setTecnico(t1);
        Pais p1 = new Pais();
        p1.setNome("Rússia");
        s1.setPais(p1);
        
        pcrud.create(p);
        pcrud.create(p1);
        
        ccrud.create(copa);
        
        tcrud.create(t);
        tcrud.create(t1);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(s);
        instance.create(s1);
        
        List<Selecao> list = instance.getList();
        
        OutOfCRUD oocrud = new OutOfCRUD();
        
        int qtdDeParticipacoesEmCopa = oocrud.qtdDeParticipacoesEmCopa(s1);
        
        assertEquals(1, qtdDeParticipacoesEmCopa);
    }
    
    @Test
    public void testGetJogadoresPorSelecao(){
        System.out.println("getJogadoresPorSelecao");
        PaisCRUD pcrud = new PaisCRUD();
        TecnicoCRUD tcrud = new TecnicoCRUD();
        CopaCRUD ccrud = new CopaCRUD();
        
        
        Selecao s = new Selecao();
        s.setAno(2002);
        s.setPosicao(1);
        s.setGrupo("A");
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        Pais p = new Pais();
        p.setNome("Brazilzão");
        s.setPais(p);
        
        Copa copa= new Copa();
        copa.setAno(20022);
        copa.setPais(p);
        
        s.setCopa(copa);
               
        
        pcrud.create(p);
        
        ccrud.create(copa);
        
        tcrud.create(t);
        
        Jogador j1 = new Jogador();
        j1.setNome("Marcão");
        j1.setPosicao(Posicao.GOLEIRO);
        j1.setNumero(1);
        
        Jogador j2 = new Jogador();
        j2.setNome("Kaka");
        j2.setPosicao(Posicao.MEIOCAMPO);
        j2.setNumero(7);
        
        Jogador j3 = new Jogador();
        j3.setNome("RRRR");
        j3.setPosicao(Posicao.ATACANTE);
        j3.setNumero(9);
        
        JogadorCRUD jocrud = new JogadorCRUD();
        jocrud.create(j1);
        jocrud.create(j2);
        jocrud.create(j3);
        
        ArrayList<Jogador> listaJogador = new ArrayList<>();
        listaJogador.add(j1);
        listaJogador.add(j2);
        listaJogador.add(j3);
        
        s.setJogador(listaJogador);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(s);
        
        List<Selecao> list = instance.getList();
        
        OutOfCRUD oocrud = new OutOfCRUD();
        
        List<Jogador> jogadoresPorSelecao = oocrud.getJogadoresPorSelecao(s);
        
        assertEquals(3, jogadoresPorSelecao.size());
    }
    

    @Test
    public void testListaSubstituicoes(){
        PaisCRUD pcrud = new PaisCRUD();
        TecnicoCRUD tcrud = new TecnicoCRUD();
        CopaCRUD ccrud = new CopaCRUD();
        JogadorCRUD jcrud = new JogadorCRUD();
        SubstituicaoCRUD scrud = new SubstituicaoCRUD();
        List<Jogador> jog = new ArrayList<Jogador>();
        List<Jogador> jog2 = new ArrayList<Jogador>();
        JogoCRUD jogcrud = new JogoCRUD();
        
        Jogo jogo = new Jogo();
        jogo.setAno(2344);
        jogo.setData("23/12/2344");
        
        Selecao s = new Selecao();
        s.setAno(1930);
        s.setPosicao(1);
        s.setGrupo("A");
        Tecnico t = new Tecnico();
        s.setTecnico(t);
        Pais p = new Pais();
        p.setNome("Bósnia e Herzegovina");
        s.setPais(p);
        
        Jogador j = new Jogador();
        j.setCamisa(40);
        j.setDataNascimento("23/01/1920");
        j.setNome("kaehau");
        
        Jogador j2 = new Jogador();
        j2.setCamisa(40);
        j2.setDataNascimento("23/01/1920");
        j2.setNome("kaka");
        jog.add(j);
        jog.add(j2);
        s.setJogador(jog);
        
        Copa copa= new Copa();
        copa.setAno(3889);
        copa.setPais(p);
        
        s.setCopa(copa);
        
        Selecao s1 = new Selecao();
        s1.setAno(1930);
        s1.setPosicao(2);
        s1.setGrupo("A");
        s1.setCopa(copa);
        Tecnico t1 = new Tecnico();
        s1.setTecnico(t1);
        Pais p1 = new Pais();
        p1.setNome("Rússia");
        s1.setPais(p1);
        
        Jogador j3 = new Jogador();
        j3.setCamisa(40);
        j3.setDataNascimento("23/01/1920");
        j3.setNome("Benjamin");
        
        Jogador j4 = new Jogador();
        j4.setCamisa(40);
        j4.setDataNascimento("23/01/1920");
        j4.setNome("Bittencourt");
        jog2.add(j3);
        jog2.add(j4);
        s1.setJogador(jog2);
        
        pcrud.create(p);
        pcrud.create(p1);
        jcrud.create(j);
        jcrud.create(j2);
        jcrud.create(j3);
        jcrud.create(j4);
        ccrud.create(copa);
        
        tcrud.create(t);
        tcrud.create(t1);
        
        SelecaoCRUD instance = new SelecaoCRUD();
        instance.create(s);
        instance.create(s1);
        
        jogcrud.create(jogo);
       Substituicao subs = new Substituicao();
       subs.setJogadorEntrou(j);
       subs.setJogadorSaiu(j2);
       
       Substituicao subs2 = new Substituicao();
       subs2.setJogadorEntrou(j3);
       subs2.setJogadorSaiu(j4);
       subs.setJogo(jogo);
       subs2.setJogo(jogo);
       scrud.create(subs);
       scrud.create(subs2);
       
       OutOfCRUD ocrud = new OutOfCRUD();
        List<String> listaSubstituicoes = ocrud.listaSubstituicoes(jogo);
        
        assertEquals(2, listaSubstituicoes.size());
       
        
        
    }
    @Test
    public void testGolRelmpago(){
        GolCRUD gcrud = new GolCRUD();
        
        Gol gol = new Gol();
        gol.setTempo(0l);
        Gol gol2 = new Gol();
        gol2.setTempo(3l);
        
        gcrud.create(gol);
        gcrud.create(gol2);
        
        OutOfCRUD ocrud = new OutOfCRUD();
        Gol golRelampago = ocrud.golRelampago();
        
        assertEquals(Long.valueOf(0), golRelampago.getTempo());
    }
    @Test
    public void testBolaFora(){
        GolCRUD gcrud = new GolCRUD();
        
        Gol gol = new Gol();
        gol.setTempo(0l);
        gol.setFoiContra(true);
        Gol gol2 = new Gol();
        gol2.setTempo(3l);
        gol2.setFoiContra(false);
        gcrud.deleteAll();
        gcrud.create(gol);
        gcrud.create(gol2);
        
        OutOfCRUD ocrud = new OutOfCRUD();
        List<Gol> bolaFora = ocrud.bolaFora();
        
        assertEquals(1, bolaFora.size());
        
    }

    @Test
    public void testQuantidadeDeJogos(){
        JogoCRUD jcrud = new JogoCRUD();
        SelecaoCRUD scrud = new SelecaoCRUD();
        PaisCRUD pcrud = new PaisCRUD();
        
        Jogo jogo = new Jogo();
        jogo.setAno(1234);
        jogo.setData("23/12/1234");
        
        Selecao s1 = new Selecao();
        s1.setAno(1930);
        s1.setPosicao(2);
        s1.setGrupo("A");
        
        Pais p1 = new Pais();
        p1.setNome("Japão");
        s1.setPais(p1);
        jogo.setS1(s1);
        pcrud.create(p1);
        scrud.create(s1);
        jcrud.create(jogo);
        
        OutOfCRUD ocrud = new OutOfCRUD();
        int quantidadeDeJogos = ocrud.quantidadeDeJogos(p1);
        
        assertEquals(1, quantidadeDeJogos);
    }
}
