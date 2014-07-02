package crud;

import java.util.List;
import model.Copa;
import model.Gol;
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

}
