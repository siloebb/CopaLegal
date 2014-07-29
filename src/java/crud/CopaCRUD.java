package crud;

import interfaces.DAO;
import java.util.List;
import model.Copa;
import model.Jogador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Siloe
 */
public class CopaCRUD implements DAO<Copa, Integer> {

    private Session sessao = null;
    private Transaction transacao = null;

    @Override
    public void create(Copa o) {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public Copa ready(Integer id) {
        Copa resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Copa where id = :id");
        consulta.setLong("id", id);

        resultado = (Copa) consulta.uniqueResult();
        transacao.commit();
        sessao.close();

        return resultado;
    }

    @Override
    public List<Copa> getList() {
        List<Copa> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Copa");

        resultado = (List<Copa>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado;
    }

    @Override
    public void update(Copa o) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.update(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void delete(Copa o) {
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

        Query consulta = sessao.createQuery("delete from Copa");
        consulta.executeUpdate();
        transacao.commit();

        sessao.close();
    }

    public Copa ready(Long ano) {
        Copa resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Copa where ano = :id");
        consulta.setLong("id", ano);

        resultado = (Copa) consulta.uniqueResult();
        transacao.commit();
        sessao.close();
        
        return resultado;
    }

}
