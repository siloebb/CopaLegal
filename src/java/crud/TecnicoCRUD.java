/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import interfaces.DAO;
import java.util.List;
import model.Tecnico;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Jéssica Magally
 */
public class TecnicoCRUD implements DAO<Tecnico, String>{
    
    private Session sessao = null;
    private Transaction transacao = null;

    @Override
    public void create(Tecnico o) {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public Tecnico ready(String id) {
        Tecnico resultado = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Tecnico where id = :id");
        consulta.setString("id", id);

        resultado = (Tecnico) consulta.uniqueResult();
        transacao.commit();
        sessao.close();

        return resultado;
        
    }

    @Override
    public List<Tecnico> getList() {
        List<Tecnico> resultado = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Tecnico");

        resultado = (List<Tecnico>) consulta.list();
        transacao.commit();
        sessao.close();

        return resultado;
    }

    @Override
    public void update(Tecnico o) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.update(o);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void delete(Tecnico o) {
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

        Query consulta = sessao.createQuery("delete from Tecnico");
        consulta.executeUpdate();
        transacao.commit();

        sessao.close(); 
    }
}
