/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import interfaces.DAO;
import java.util.List;
import model.Escalacao;
import model.Jogador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author suka
 */
public class EscalacaoCRUD implements DAO<Escalacao,Long>{

    private Session sessao = null;
    private Transaction transacao = null;
    
    @Override
    public void create(Escalacao o) {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public Escalacao ready(Long id) {
        Escalacao resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Escalacao where id = :id");
        consulta.setLong("id", id);

        resultado = (Escalacao) consulta.uniqueResult();
        transacao.commit();
        sessao.close();
        
        return resultado;
    }

    @Override
    public List<Escalacao> getList() {
        List<Escalacao> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Escalacao");

        resultado = (List<Escalacao>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado;  
    }

    @Override
    public void update(Escalacao o) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.update(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void delete(Escalacao o) {
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

        Query consulta = sessao.createQuery("delete from Escalacao");
        consulta.executeUpdate();
        transacao.commit();

        sessao.close();
    }
    
}
