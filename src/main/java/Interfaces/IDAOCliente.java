package Interfaces;

import Classes.Cliente;
import java.util.List;

public interface IDAOCliente {

    int incluir(Cliente cliente);

    void procurar(Cliente cliente);

    List<Cliente> listar();

    void atualizar(Cliente cliente);

    void excluir(Cliente cliente);

}
