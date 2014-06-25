/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud;

import interfaces.DAO;
import java.util.List;
import model.Tecnico;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Jéssica Magally
 */
public class TecnicoCRUD implements DAO<Tecnico, Long>{
    
    private Session sessao = null;
    private Transaction transacao = null;

    @Override
    public void create(Tecnico o) {
        try {
            sessao = (Session) HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(o);
            transacao.commit();
         } catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o Tecnico. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de insercao. Mensagem: " + e.getMessage());				
			}
		}
    }
    
     @Override
    public Tecnico ready(Long id){
        
        Tecnico resultado = null;
        
	try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Query consulta = sessao.createQuery("from Tecnico where id = :id");
        consulta.setLong("id", id);

        resultado = (Tecnico) consulta.uniqueResult();
        transacao.commit();       
        
        } catch (HibernateException e) {
            System.err.println("Nao foi possivel buscar o objeto. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());
            }
        }
	return resultado;	
    }     
    

    @Override
    public List<Tecnico> getList() {
        List<Tecnico> resultado = null;      
        
	try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            Query consulta = sessao.createQuery("from Tecnico");

            transacao = sessao.beginTransaction();
            resultado = (List<Tecnico>) consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.err.println("Nao foi possivel listar os objetos. Erro: " + e.getMessage());
            throw new HibernateException(e);
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.err.println("Erro ao fechar operacao de listagem. Mensagem: " + e.getMessage());
            }
        }

        
    }

    @Override
    public void update(Tecnico o) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(o);
            transacao.commit();
        } catch (HibernateException e) {
            System.err.println("Nao foi possivel atualizar o Tecnico. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.err.println("Erro ao fechar operacao de atualizacao. Mensagem: " + e.getMessage());
            }
        }
    }

    @Override
    public void delete(Tecnico o) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(o);
            transacao.commit();
        } catch (HibernateException e) {
            System.err.println("Nao foi possivel excluir o Tecnico. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());
            }
        }
    }

    @Override
    public void deleteAll() {
               
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            Query consulta = sessao.createQuery("delete from Tecnico");

            consulta.executeUpdate();
            transacao.commit();
        } catch (HibernateException e) {
            System.err.println("Nao foi possivel excluir os Tecnicos. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());
            }
        }
    }
}
