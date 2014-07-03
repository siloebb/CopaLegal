package crud;

import java.util.List;
import model.Copa;
import model.Gol;
import model.Jogador;
import model.Pais;
import model.Selecao;
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

     public List<Pais> listarPaisesCopa(Copa copa) {
        List<Pais> resultado = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();

            Query consulta = sessao.createQuery("select Pais from Selecao join Copa where ano=:parametro");
            consulta.setInteger("parametro", copa.getAno());
            transacao = sessao.beginTransaction();
            resultado = (List<Pais>) consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.err.println("Nao foi possivel listar os objetos. Erro: " + e.getMessage());
            throw new HibernateException(e);
        } finally {
            try {
                sessao.close();
            } catch (HibernateException e) {
                System.err.println("Erro ao fechar operacao de listagem. Mensagem: " + e.getMessage());
            }
        }
    }
     
    

}
