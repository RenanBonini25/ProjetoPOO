package Interfaces;

import java.util.List;

public interface IDAO<E> {

    int incluir(E c);

    List<E> procurar(String valor);

    List<E> listar();

    void atualizar(E c);

    void excluir(int id);
    
    E obter(int id);

}
