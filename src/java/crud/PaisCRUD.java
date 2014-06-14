package crud;


import interfaces.DAO;
import model.Pais;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Siloe
 */
public class PaisCRUD implements DAO<Pais, Long> {

    private Session sessao = null;
    private Transaction transacao = null;

    @Override
    public void create(Pais o) {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(o);
        transacao.commit();
        sessao.close();

    }

    @Override
    public Pais ready(Long id) {
        Pais resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Pais where id = :id");
        consulta.setLong("id", id);

        resultado = (Pais) consulta.uniqueResult();
        transacao.commit();
        sessao.close();
        
        return resultado;
    }

    @Override
    public List<Pais> getList() {
        List<Pais> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Pais");

        resultado = (List<Pais>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado;
    }

    @Override
    public void update(Pais o) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.update(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void delete(Pais o) {
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

        Query consulta = sessao.createQuery("delete from Pais");
        consulta.executeUpdate();
        transacao.commit();

        sessao.close();
    }

}
