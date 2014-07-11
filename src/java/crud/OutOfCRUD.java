package crud;

import java.util.ArrayList;
import java.util.List;
import model.Copa;
import model.Gol;
import model.Jogador;
import model.Jogo;
import model.Pais;
import model.Selecao;
import model.Substituicao;
import model.Tecnico;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Siloe
 */
public class OutOfCRUD {

    private Session sessao = null;
    private Transaction transacao = null;

    public List<Gol> getPlacarByGame() {
        List<Gol> resultado = null;

        sessao = HibernateUtil.getInstance().getSessionFactory().openSession();

        Query consulta = sessao.createQuery("from Gol");

        transacao = sessao.beginTransaction();
        resultado = (List<Gol>) consulta.list();
        transacao.commit();
        sessao.close();
        return resultado;
    }
    //17
    public List<Pais> listarPaisesCopa(Copa copa) {
        List<Pais> resultado = null;
       
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            Query consulta = sessao.createQuery("from Pais as  pais where pais.copa.ano =:idCopa");
            consulta.setInteger("idCopa", copa.getAno());
           
            resultado = (List<Pais>) consulta.list();
            transacao.commit();
            return resultado;     
    }

    //18
    public List<Gol> getPlacarDoJogo(Jogo jogo) {
        List<Gol> resultado = null;
        try {
            sessao = HibernateUtil.getInstance().getSessionFactory().openSession();

            Query consulta = sessao.createQuery("FROM Gol AS gol WHERE gol.jogo.id = :id");
            consulta.setLong("id", jogo.getID());

            transacao = sessao.beginTransaction();
            resultado = (List<Gol>) consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.err.println("Nao foi possivel listar os objetos. Erro: " + e.getMessage());
            throw new HibernateException(e);
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.err.println("Erro ao fechar operacao de listagem. Mensagem: " + e.getMessage());
            }
        }
    }

    //29
    public List<Selecao> getRankingSelecao(Copa copa) {
        List<Selecao> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Selecao as selecao where selecao.ano = :idCopa order by selecao.posicao asc");
        consulta.setInteger("idCopa", copa.getAno());

        resultado = (List<Selecao>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado;
    }

    //19
    public List<Jogo> listarJogosCopa(Copa copa) {
        List<Jogo> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Jogo as jogo where jogo.ano = :idCopa ");
        consulta.setInteger("idCopa", copa.getAno());

        resultado = (List<Jogo>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado;
    }
    //21
    public List<String> listaSubstituicoes(Jogo B){
        List<Substituicao> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Substituicao as substituicao where substituicao.jogo.id = :idjogo ");
        consulta.setLong("idjogo", B.getID());
        List<String> a = new ArrayList<String>();
        resultado = (List<Substituicao>) consulta.list();
        transacao.commit();
        sessao.close();
        for (Substituicao substituicao : resultado) {
            String nomeBonito =  "Sai:" + substituicao.getJogadorSaiu() + "Entra:" + substituicao.getJogadorEntrou();
            a.add(nomeBonito);
        }
        return a;
       
    }
    //44
    public Gol golRelampago(){
        Gol resultado = null;

        try {
            sessao = HibernateUtil.getInstance().getSessionFactory().openSession();

            Query consulta = sessao.createQuery("from Gol as gol order by tempo asc ");
            consulta.setMaxResults(1);
            transacao = sessao.beginTransaction();

            resultado = (Gol) consulta.uniqueResult();
            transacao.commit();
            return resultado;

        } catch (HibernateException e) {
            System.err.println("Nao foi possivel buscar o objeto. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());
            }
        }
        return resultado;
    }
    //14
    public List<Jogador> listarJogadoresSelecao(Selecao selecao){
        List<Jogador> resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        
        Query consulta = sessao.createQuery("from Jogador where selecao=:idSelecao");
        consulta.setLong("idSelecao", selecao.getID());
        

        resultado = (List<Jogador>) consulta.list();
        transacao.commit();
        sessao.close();

        
        
        return resultado;
        
    }
    //15
    
    public Tecnico consultarTecnicoSelecao(Selecao selecao){
        
      Tecnico resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        
        Query consulta = sessao.createQuery("from Tecnico  where selecao=:idSelecao");
        consulta.setLong("idSelecao", selecao.getID());

        resultado = (Tecnico) consulta.uniqueResult();
        transacao.commit();
        sessao.close();
        
        return resultado;  
    }
    
    //37
    public int qtdDeParticipacoesEmCopa(Selecao selecao) {
        List<Jogo> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Selecao as selecao where selecao.id = :idSelecao ");
        consulta.setLong("idSelecao", selecao.getID());

        resultado = (List<Jogo>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado.size();
    }
    //34
    public List<Gol> bolaFora(){
        List<Gol> resultado = null;
        try {
            sessao = HibernateUtil.getInstance().getSessionFactory().openSession();

            Query consulta = sessao.createQuery("from Gol as gol where gol.foiContra = true");
            
            transacao = sessao.beginTransaction();
            resultado = (List<Gol>) consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.err.println("Nao foi possivel listar os objetos. Erro: " + e.getMessage());
            throw new HibernateException(e);
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.err.println("Erro ao fechar operacao de listagem. Mensagem: " + e.getMessage());
            }
        }
    }
    
    //20
    public List<Jogador> getJogadoresPorSelecao(Selecao selecao) {
        Selecao resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Selecao where id = :id");
        consulta.setLong("id", selecao.getID());

        resultado = (Selecao) consulta.uniqueResult();
        transacao.commit();
        sessao.flush();
        sessao.close();
        
        return resultado.getJogador();
    }
    
    
    //22
    public List<Gol> listarGolsPartida(Jogo jogo){
        List<Gol> resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();

            Query consulta = sessao.createQuery("from Gol AS gol WHERE gol.jogo.id = :id");
            consulta.setLong("id", jogo.getID());
            transacao = sessao.beginTransaction();
            resultado = (List<Gol>) consulta.list();
            
            Selecao sele;
            Jogador joga;
            for (Gol gol1 : resultado) {
                consulta = sessao.createQuery("from Selecao where id = :id");
                consulta.setLong("id", gol1.getSelecao().getID());
                sele = (Selecao) consulta.uniqueResult();
                gol1.setSelecao(sele);
            }
            for (Gol goll : resultado) {
                consulta = sessao.createQuery("from Jogador where id=:parametro");
                consulta.setLong("id", goll.getJogador().getID());
                joga = (Jogador) consulta.uniqueResult();
                goll.setJogador(joga);
            }

            transacao.commit();
            sessao.close();
            return resultado;
            
    }
    //32
    
   /* public List<Jogo> ListarFinais(){
        List<Jogo> resultado = null;
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Jogo where fase = 'Final'");
        List<Jogo> jogos = (List<Jogo>) consulta.list();
        
        Selecao sele;
            for (Jogo jg : jogos) {
                consulta = sessao.createQuery("from Selecao where id = :idSelecao");
                
                sele = (Selecao) consulta.uniqueResult();
                jg.setSelecaoBySelecaoA(sele);
            }
            for (Jogo jg : jogos) {
                consulta = sessao.createQuery("from Selecao where id = :parametro");
                consulta.setInteger("parametro", jg.getSelecaoBySelecaoB().getId());
                sele = (Selecao) consulta.uniqueResult();
                jg.setSelecaoBySelecaoB(sele);
            }

            for (Jogo jg : jogos) {
                resultado.add(jg);
            }

            transacao.commit();
            return resultado;
        transacao.commit();
        sessao.close();

        
        return resultado;
    }*/
}
