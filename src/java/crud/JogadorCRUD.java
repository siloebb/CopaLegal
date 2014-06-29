/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import interfaces.DAO;
import java.util.List;
import model.Jogador;
import model.Pais;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Bianca
 */
public class JogadorCRUD implements DAO<Jogador, Long>{
    
    private Session sessao = null;
    private Transaction transacao = null;
    
    @Override
    public void create(Jogador o) {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(o);
        transacao.commit();
        sessao.close();

    }

    @Override
    public Jogador ready(Long id) {
        Jogador resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Jogador where id = :id");
        consulta.setLong("id", id);

        resultado = (Jogador) consulta.uniqueResult();
        transacao.commit();
        sessao.close();
        
        return resultado;
        
    }

    @Override
    public List<Jogador> getList() {
        List<Jogador> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Jogador");

        resultado = (List<Jogador>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado;  
    }

    @Override
    public void update(Jogador o) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.update(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void delete(Jogador o) {
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

        Query consulta = sessao.createQuery("delete from Jogador");
        consulta.executeUpdate();
        transacao.commit();

        sessao.close();
    }

   
    
    
}
