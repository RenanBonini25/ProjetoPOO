
package Servicos;

import Classes.Cliente;
import Classes.ItemCarrinho;
import Classes.Venda;
import DAO.DAOVenda;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ServicoVenda {
    
    public static void fazerVenda(Venda venda){
        //verifica a integridade dos dados da venda
        //ValidadorVenda.validar(venda);
        DAOVenda dao = new DAOVenda();
        try {
            //armazena o id(chave primaria) da venda realizada
            int idVenda = dao.incluirVenda(venda);
            System.out.println(idVenda);
            //solicita ao DAO a insercao dos itens de venda na venda, usando o id retornado anteriormente
                //e solicita ao DAO o decremento das quantidades vendidas dos instrumentos no estoque
            for (int i = 0; i < venda.getCarrinho().size(); i++) {
                ItemCarrinho itemCarrinho = venda.getCarrinho().get(i);
                dao.incluirItemCarrinho(itemCarrinho, idVenda);
                dao.decrementoEstoque(venda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean verificarInstrSelec(JRootPane rootPane, DefaultTableModel tabelaInstrModel,
            DefaultTableModel tabelaCarrinhoModel, int row) {
        boolean instr = false;
        try {
            Integer idInstrumentoAComprar = (Integer) tabelaInstrModel.getValueAt(row, 0);
            for (int i = 0; i < tabelaCarrinhoModel.getRowCount(); i++) {
                Integer idInstrumentoComprado = (Integer) tabelaCarrinhoModel.getValueAt(i, 0);
                //se o id do instrumento for igual ao de algum instrumento que ja esteja no carrinho
                    //retornara false
                if (idInstrumentoAComprar == idInstrumentoComprado) {
                    instr = false;
                    return instr;
                } else {
                    //se nao, retornara true
                    instr = true;
                }
            }
            //retornara true tambem se nao tiver nenhum instrumento no carrinho
            if (tabelaCarrinhoModel.getRowCount() == 0) {
                instr = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Instrumento "
                    + "não selecionado!", "Instrumento",
                    JOptionPane.ERROR_MESSAGE);
        }
        return instr;
    }
    
    public static boolean verificarClienteSelec(Cliente clienteVenda, JTable tabelaClientes) {
        boolean clienteSelecionado = false;
        try {
            int linhaSelCli = tabelaClientes.getSelectedRow();

            if (linhaSelCli >= 0) {
                clienteVenda = ServicoCliente.
                        obterCliente((Integer) tabelaClientes.getValueAt(linhaSelCli, 0));
                return true;
            }
        } catch (Exception ex) {

        }
        return clienteSelecionado;
    }
    
    public static double atualizarTotalLabel(DefaultTableModel tabelaCarrinhoModel,
            JTable tabelaCarrinho, JLabel labelTotal) {
        NumberFormat formatadorReal = NumberFormat.getCurrencyInstance();
        double totalLabel = 0;
        String preco = "";
        try {
            for (int i = 0; i < tabelaCarrinhoModel.getRowCount(); i++) {
                if (tabelaCarrinho.getValueAt(i, 0) != null) {
                    double subtotal = converterMoeda(tabelaCarrinhoModel, i, 4);
                    totalLabel += subtotal;
                }
                preco = formatadorReal.format(totalLabel);
            }
            labelTotal.setText(preco);
        } catch (Exception e) {
            System.out.println("erro");
        }
        return totalLabel;
    }
    
    public static void limpaTabelaInstrumento(JTextField field, DefaultTableModel tabelaInstrModel) {
        field.setText("");
        tabelaInstrModel.setRowCount(0);
    }

    //converte o valor de uma moeda (R$) para float
    public static double converterMoeda(DefaultTableModel tabelaCarrinhoModel, int coluna, int linha) {
        double valor = 0;
        try {
            String valorMoeda = (String) tabelaCarrinhoModel.getValueAt(coluna, linha);
            String valorConvertido = DecimalFormat.getCurrencyInstance(Locale.getDefault()).parse(valorMoeda).toString();
            valor = Double.parseDouble(valorConvertido);
        } catch (Exception ex) {

        }
        return valor;
    }

    //converte o valor de um float para moeda (R$)
    public static String converterValor(double valor) {
        String moeda = "";
        try {
            NumberFormat formatadorReal = NumberFormat.getCurrencyInstance();
            moeda = formatadorReal.format(valor);
        } catch (Exception ex) {

        }
        return moeda;
    }
    
    public static void limpaTabelaVendas(JLabel labelCliente, DefaultTableModel tabelaCarrinhoModel,
            JTextField fieldCliente, DefaultTableModel tabelaClienteModel, JComboBox formaPagamento,
            JTextField fieldRecebido, JLabel labelTroco) {
        labelCliente.setText("");
        tabelaCarrinhoModel.setRowCount(0);
        tabelaClienteModel.setRowCount(0);
        fieldCliente.setText("");
        formaPagamento.setSelectedIndex(0);
        fieldRecebido.setText("");
        labelTroco.setText("R$ 00,00");
    }

    //verifica se o campo de forma de pagamento esta selecionado
    public static boolean verificarFormaPgto(JComboBox comboPagamento) {
        boolean selecionado = false;
        if (comboPagamento.getSelectedIndex() == 0) {
            return selecionado;
        } else {
            selecionado = true;
        }
        return selecionado;
    }
    
    public static double calcularTroco(JTextField fieldRecebido, JLabel labelTotal) {
        double troco = 0;
        try {
            String totalLabel = labelTotal.getText();
            String valorConvertido = DecimalFormat.getCurrencyInstance(Locale.getDefault()).parse(totalLabel).toString();
            double valorTotal = Double.parseDouble(valorConvertido);
            String receb = fieldRecebido.getText().replaceAll(",", ".");
            double recebido = Double.parseDouble(receb);
            troco = recebido - valorTotal;
        } catch (Exception ex) {

        }
        return troco;
    }
    
}
