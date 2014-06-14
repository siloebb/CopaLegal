package interfaces;


import java.util.List;


/**
 *
 * @author Siloe
 * @param <T> POJO que será adicionada
 * @param <ID> Tipo de id que se quer na busca padrão
 */
public interface DAO<T, ID> {
    
    public void create(T o);
    public T ready(ID id);
    public List<T> getList();
    public void update(T o);
    public void delete(T o);
    public void deleteAll();
    
}
