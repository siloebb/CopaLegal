/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import interfaces.DAO;
import java.util.List;
import model.Jogador;
import model.Selecao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author suka
 */
public class SelecaoCRUD implements DAO<Selecao, Long> {
    
    private Session sessao = null;
    private Transaction transacao = null;

    @Override
    public void create(Selecao o) {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public Selecao ready(Long id) {
        Selecao resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Selecao where id = :id");
        consulta.setLong("id", id);

        resultado = (Selecao) consulta.uniqueResult();
        transacao.commit();
        sessao.close();
        
        return resultado;
    }

    @Override
    public List<Selecao> getList() {
        List<Selecao> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Selecao");

        resultado = (List<Selecao>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado; 
    }

    @Override
    public void update(Selecao o) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.update(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void delete(Selecao o) {
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

        Query consulta = sessao.createQuery("delete from Selecao");
        consulta.executeUpdate();
        transacao.commit();

        sessao.close();
    }
    
}
