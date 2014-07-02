package crud;

import interfaces.DAO;
import java.util.List;
import model.Jogador;
import model.Substituicao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Siloe
 */
public class SubstituicaoCRUD implements DAO<Substituicao, Long> {

    private Session sessao = null;
    private Transaction transacao = null;

    @Override
    public void create(Substituicao o) {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public Substituicao ready(Long id) {
        Substituicao resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Substituicao where id = :id");
        consulta.setLong("id", id);

        resultado = (Substituicao) consulta.uniqueResult();
        transacao.commit();
        sessao.close();

        return resultado;
    }

    @Override
    public List<Substituicao> getList() {
        List<Substituicao> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Substituicao");

        resultado = (List<Substituicao>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado;
    }

    @Override
    public void update(Substituicao o) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.update(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void delete(Substituicao o) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.delete(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void deleteAll() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("delete from Substituicao");
        consulta.executeUpdate();
        transacao.commit();

        sessao.close();
    }

}
