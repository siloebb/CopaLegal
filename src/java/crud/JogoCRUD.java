/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import interfaces.DAO;
import java.util.List;
import model.Jogo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import javax.persistence.Entity; 


/**
 *
 * @author Bianca
 */
public class JogoCRUD implements DAO<Jogo, Long>{

    private Session sessao = null;
    private Transaction transacao = null;
    
    @Override
    public void create(Jogo o) {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(o);
        transacao.commit();
        sessao.close();
    
    }

    @Override
    public Jogo ready(Long id) {
        Jogo resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Jogo where id = :id");
        consulta.setLong("id", id);

        resultado = (Jogo) consulta.uniqueResult();
        transacao.commit();
        sessao.close();
        
        return resultado;
    
    }

    @Override
    public List<Jogo> getList() {
       List<Jogo> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Jogo");

        resultado = (List<Jogo>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado;  
    
    }

    @Override
    public void update(Jogo o) {
       
    sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.update(o);
        transacao.commit();
        sessao.close();
    
    }

    @Override
    public void delete(Jogo o) {
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

        Query consulta = sessao.createQuery("delete from Jogo");
        consulta.executeUpdate();
        transacao.commit();

        sessao.close();
    
    }
    
}
