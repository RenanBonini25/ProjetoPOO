package Servicos;

import Classes.Cliente;
import DAO.DAOCliente;
import Exceptions.ClienteException;
import Exceptions.DataSourceException;
import Validadores.ValidadorCliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoCliente {

    public static void cadastrarCliente(Cliente cliente) {
        DAOCliente dao = new DAOCliente();
        try {
            ValidadorCliente.validar(cliente);
            int id = dao.incluir(cliente);
        } catch (ClienteException ex) {
            Logger.getLogger(ServicoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Cliente obterCliente(Integer id) throws ClienteException, DataSourceException {
        DAOCliente dao = new DAOCliente();
        try {
            Cliente cliente = dao.obter(id);
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }
    }

    public static List<Cliente> procurarCliente(String nome) throws ClienteException,
            DataSourceException {
        try {
            DAOCliente dao = new DAOCliente();
            if (nome == null || "".equals(nome)) {
                return dao.listar();
            } else {
                return dao.procurar(nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static void atualizarCliente(Cliente cliente) throws ClienteException, 
            DataSourceException {
        DAOCliente dao = new DAOCliente();
        ValidadorCliente.validar(cliente);
        try {
            dao.atualizar(cliente);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }
    }
    
    public static void excluirCliente(Integer id) throws ClienteException, DataSourceException {
        DAOCliente dao = new DAOCliente();
        try {
            dao.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }
    }

}
