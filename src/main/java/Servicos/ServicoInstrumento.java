package Servicos;

import Classes.Instrumento;
import DAO.DAOInstrumento;
import Exceptions.DataSourceException;
import Exceptions.InstrumentoException;
import java.awt.Component;
import java.util.List;
import javax.swing.JPanel;

public class ServicoInstrumento {

    public static void desabilitarPanel(JPanel panel) {
        Component[] com = panel.getComponents();
        for (int a = 0; a < com.length; a++) {
            com[a].setEnabled(false);
        }
    }

    public static void habilitarPanel(JPanel panel) {
        Component[] com = panel.getComponents();
        for (int a = 0; a < com.length; a++) {
            com[a].setEnabled(true);
        }
    }

    public static void cadastrarInstrumento(Instrumento instrumento) {
        DAOInstrumento dao = new DAOInstrumento();
        try {
            dao.incluir(instrumento);
        } catch (Exception ex) {

        }
    }
    
    public static List<Instrumento> procurarInstrumento(String valor)
            throws InstrumentoException, DataSourceException {
        DAOInstrumento dao = new DAOInstrumento();
        try {
            //se o campo de texto estiver vazio, solicitao ao DAO o retorno de todos 
                //os instrumentos ativos cadastrados
            if (valor == null) {
                return dao.listar();
            } else {
                //se nao estiver vazio, sera retornado instrumento com nomes que contenham os caracteres inseridos
                return dao.procurar(valor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static Instrumento obterInstrumento(Integer id)
            throws InstrumentoException, DataSourceException {
        DAOInstrumento dao = new DAOInstrumento();
        try {
            return dao.obter(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static void atualizarInstrumento(Instrumento instrumento)
            throws InstrumentoException, DataSourceException {
        //ValidadorInstrumento.validar(instrumento);
        DAOInstrumento dao = new DAOInstrumento();
        try {
            dao.atualizar(instrumento);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static void excluirInstrumento(Integer id)
            throws InstrumentoException, DataSourceException {
        DAOInstrumento dao = new DAOInstrumento();
        try {
            //Solicita ao DAO a exclusão do quarto informado
            dao.excluir(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
