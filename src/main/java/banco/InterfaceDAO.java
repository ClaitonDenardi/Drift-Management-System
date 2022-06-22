package banco;

import java.util.Collection;
public interface InterfaceDAO<T extends Registro> {
        
    abstract Integer inserir(T t);
    
    abstract void alterar(T t);
    
    abstract void excluir(T t);
    
    abstract Collection<T> buscar(T t);
    
    abstract T buscar(String id);

    abstract Collection<T> buscarTodos();
    
}
