package DAO;

import Classes.Cliente;
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
import Interfaces.IDAO;

public class DAOCliente implements IDAO<Cliente> {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/SonataBD", "root", "");
    }

    @Override
    public int incluir(Cliente cliente) {
        String query = "INSERT INTO cliente (NOME, CPF, SEXO, DTNASCIMENTO, ESTADOCIVIL, ENDERECO,"
                + "NUMERO, BAIRRO,CIDADE, ESTADO, EMAIL, TELEFONE, ATIVO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
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
                stmt.setBoolean(13, true);
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
    public List<Cliente> procurar(String valor) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente WHERE Nome LIKE ? AND Ativo = ?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, "%" + valor + "%");
                stmt.setBoolean(2, true);
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
    public List<Cliente> listar() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String query = "SELECT * FROM cliente WHERE ativo = ?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setBoolean(1, true);
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
        String query = "UPDATE CLIENTE SET NOME=?, CPF=?, SEXO=?, DTNASCIMENTO=?, ESTADOCIVIL=?,"
                + "ENDERECO=?, NUMERO=?, BAIRRO=?, CIDADE=?, ESTADO=?, EMAIL=?, TELEFONE=? WHERE ID=?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {

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
                stmt.setInt(13, cliente.getId());

                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(int id) {
        String query = "UPDATE Cliente SET Ativo = ? WHERE(ID = ?)";
        try (Connection conn = obterConexao()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setBoolean(1, false);
                stmt.setInt(2, id);
                stmt.executeUpdate();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente obter(int id) {
        String query = "SELECT * FROM CLIENTE WHERE ID = ? AND ATIVO = ?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);
                stmt.setBoolean(2, true);
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
                        return cliente;
                    }
                }

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}


