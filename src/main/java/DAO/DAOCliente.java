package DAO;

import Classes.Cliente;
import Interfaces.IDAOCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente implements IDAOCliente {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {
        //1A) Registrar drive JDBC
        Class.forName("com.mysql.jdbc.Driver");

        //1B) Abrir conexão com o BD
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/SonataBD", "root", "");
    }

    @Override
    public int incluir(Cliente cliente) {
        String query = "INSERT INTO cliente (NOME, CPF, SEXO, DTNASCIMENTO, ESTADOCIVIL, ENDERECO,"
                + "NUMERO, BAIRRO,CIDADE, ESTADO, EMAIL, TELEFONE)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        int idCliente = 0;

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getSexo());
                stmt.setString(4, cliente.getDataNascimento());
                stmt.setString(5, cliente.getEstadoCivil());
                stmt.setString(6, cliente.getEndereco());
                stmt.setString(7, cliente.getNumeroEnd());
                stmt.setString(8, cliente.getBairro());
                stmt.setString(9, cliente.getCidade());
                stmt.setString(10, cliente.getEstado());
                stmt.setString(11, cliente.getEmail());
                stmt.setString(12, cliente.getTelefone());
                stmt.executeUpdate();

                try (ResultSet chave = stmt.getGeneratedKeys()) {
                    if (chave.next()) {
                        idCliente = chave.getInt(1);
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
        return idCliente;
    }

    @Override
    public void procurar(Cliente cliente) {

    }

    @Override
    public List<Cliente> listar() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        Cliente cliente = new Cliente();
                        cliente.setId(resultados.getInt("ID"));
                        cliente.setNome(resultados.getString("NOME"));
                        cliente.setCpf(resultados.getString("CPF"));
                        cliente.setSexo(resultados.getString("SEXO"));
                        cliente.setDataNascimento(resultados.getString("DTNASCIMENTO"));
                        cliente.setEstadoCivil(resultados.getString("ESTADOCIVIL"));
                        cliente.setEndereco(resultados.getString("ENDERECO"));
                        cliente.setNumeroEnd(resultados.getString("NUMERO"));
                        cliente.setBairro(resultados.getString("BAIRRO"));
                        cliente.setCidade(resultados.getString("CIDADE"));
                        cliente.setEstado(resultados.getString("ESTADO"));
                        cliente.setEmail(resultados.getString("EMAIL"));
                        cliente.setTelefone(resultados.getString("TELEFONE"));
                        listaClientes.add(cliente);
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
        return listaClientes;
    }

    @Override
    public void atualizar(Cliente cliente) {

    }

    @Override
    public void excluir(Cliente cliente) {

    }

}
