
package Servicos;

import Classes.Cliente;
import DAO.DAOCliente;
import Exceptions.ClienteException;
import Validadores.ValidadorCliente;
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
    
}
