package DAO;

import Classes.ItemCarrinho;
import Classes.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOVenda {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/SonataBD", "root", "");
    }

    public int incluirVenda(Venda venda) {
        String query = "INSERT INTO venda (ID_CLIENTE, FORMA_PGTO, DATA_VENDA, VALOR_VENDA)"
                + "VALUES (?, ?, ?, ?) ";
        int idVenda = 1;

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, venda.getCliente().getId());
                stmt.setString(2, venda.getFormaPagamento());
                stmt.setString(3, venda.getDataVenda());
                stmt.setDouble(4, venda.getTotal());

                stmt.execute();

                try (ResultSet chave = stmt.getGeneratedKeys()) {
                    while (chave.next()) {
                        idVenda = chave.getInt(1);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idVenda;
    }

    public void incluirItemCarrinho(ItemCarrinho itemCarrinho, int idVenda) {
        String query = "INSERT INTO itemcarrinho (ID_INSTRUMENTO, ID_VENDA, QUANTIDADE, SUB_TOTAL)"
                + "VALUES (?, ?, ?, ?);";

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, itemCarrinho.getInstrumento().getId());
                stmt.setInt(2, idVenda);
                stmt.setInt(3, itemCarrinho.getQuantidade());
                stmt.setDouble(4, itemCarrinho.getSubtotal());

                stmt.execute();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementoEstoque(Venda venda) {
        String query = "UPDATE instrumento SET QUANTIDADE = ? "
                + "WHERE ID_INSTRUMENTO = ?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                for (ItemCarrinho c : venda.getCarrinho()) {
                    stmt.setInt(1, c.getInstrumento().getQuantidade());
                    stmt.setInt(2, c.getInstrumento().getId());
                    stmt.executeUpdate();
                }

                stmt.execute();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
