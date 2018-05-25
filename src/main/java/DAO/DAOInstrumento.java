package DAO;

import Classes.Cliente;
import Classes.Cordas;
import Classes.Instrumento;
import Classes.Percussao;
import Classes.Sopro;
import Interfaces.IDAO;
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

public class DAOInstrumento implements IDAO<Instrumento> {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/SonataBD", "root", "");
    }

    @Override
    public int incluir(Instrumento instrumento) {
        String queryCordas = "INSERT INTO instrumento (NOME, MARCA, COR, PRECO, QUANTIDADE, TIPO, QTDCORDAS_CORDAS, "
                + "TIPOBRACO_CORDAS, TIPOCORPO_CORDAS, ORIGEM_CORDAS, ATIVO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String queryPercussao = "INSERT INTO instrumento (NOME, MARCA, COR, PRECO, QUANTIDADE, TIPO, TIPOMADEIRA_PERCUSSAO, "
                + "QTDPRATOS_PERCUSSAO, DIMENSAOCAIXA_PERCUSSAO, DIMENSAOTOMS_PERCUSSAO, ATIVO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String querySopro = "INSERT INTO instrumento (NOME, MARCA, COR, PRECO, QUANTIDADE, TIPO, MATERIAL_SOPRO, "
                + "ACABAMENTO_SOPRO, AFINACAO_SOPRO, ATIVO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int idInstrumento = 0;

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            if (instrumento instanceof Cordas) {
                Cordas instrumentoCordas = (Cordas) instrumento;
                try (PreparedStatement stmt = conn.prepareStatement(queryCordas, Statement.RETURN_GENERATED_KEYS)) {

                    stmt.setString(1, instrumentoCordas.getNome());
                    stmt.setString(2, instrumentoCordas.getMarca());
                    stmt.setString(3, instrumentoCordas.getCor());
                    stmt.setDouble(4, instrumentoCordas.getPreco());
                    stmt.setInt(5, instrumentoCordas.getQuantidade());
                    stmt.setString(6, instrumentoCordas.getTipo());
                    stmt.setString(7, instrumentoCordas.getQtdCordas());
                    stmt.setString(8, instrumentoCordas.getTipoBraco());
                    stmt.setString(9, instrumentoCordas.getTipoCorpo());
                    stmt.setString(10, instrumentoCordas.getOrigem());
                    stmt.setBoolean(11, true);

                    stmt.executeUpdate();

                    try (ResultSet chave = stmt.getGeneratedKeys()) {
                        if (chave.next()) {
                            idInstrumento = chave.getInt(1);
                        }
                    }
                } catch (SQLException e) {
                    conn.rollback();
                    throw e;
                }
            } else if (instrumento instanceof Percussao) {
                Percussao instrumentoPercussao = (Percussao) instrumento;
                try (PreparedStatement stmt = conn.prepareStatement(queryPercussao, Statement.RETURN_GENERATED_KEYS)) {

                    stmt.setString(1, instrumentoPercussao.getNome());
                    stmt.setString(2, instrumentoPercussao.getMarca());
                    stmt.setString(3, instrumentoPercussao.getCor());
                    stmt.setDouble(4, instrumentoPercussao.getPreco());
                    stmt.setInt(5, instrumentoPercussao.getQuantidade());
                    stmt.setString(6, instrumentoPercussao.getTipo());
                    stmt.setString(7, instrumentoPercussao.getTipoMadeira());
                    stmt.setString(8, instrumentoPercussao.getQtdPratos());
                    stmt.setString(9, instrumentoPercussao.getDimensaoCaixa());
                    stmt.setString(10, instrumentoPercussao.getDimensaoToms());
                    stmt.setBoolean(11, true);

                    stmt.executeUpdate();

                    try (ResultSet chave = stmt.getGeneratedKeys()) {
                        if (chave.next()) {
                            idInstrumento = chave.getInt(1);
                        }
                    }
                } catch (SQLException e) {
                    conn.rollback();
                    throw e;
                }
            } else if (instrumento instanceof Sopro) {
                Sopro instrumentoSopro = (Sopro) instrumento;
                try (PreparedStatement stmt = conn.prepareStatement(querySopro, Statement.RETURN_GENERATED_KEYS)) {

                    stmt.setString(1, instrumentoSopro.getNome());
                    stmt.setString(2, instrumentoSopro.getMarca());
                    stmt.setString(3, instrumentoSopro.getCor());
                    stmt.setDouble(4, instrumentoSopro.getPreco());
                    stmt.setInt(5, instrumentoSopro.getQuantidade());
                    stmt.setString(6, instrumentoSopro.getTipo());
                    stmt.setString(7, instrumentoSopro.getMaterial());
                    stmt.setString(8, instrumentoSopro.getAcabamento());
                    stmt.setString(9, instrumentoSopro.getAfinacao());
                    stmt.setBoolean(10, true);

                    stmt.executeUpdate();

                    try (ResultSet chave = stmt.getGeneratedKeys()) {
                        if (chave.next()) {
                            idInstrumento = chave.getInt(1);
                        }
                    }
                } catch (SQLException e) {
                    conn.rollback();
                    throw e;
                }
            }
            conn.commit();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idInstrumento;
    }

    @Override
    public List<Instrumento> procurar(String valor) {
        ArrayList<Instrumento> listaInstrumentos = new ArrayList<>();
        String query = "SELECT * FROM instrumento WHERE Nome LIKE ? AND Ativo = ?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, "%" + valor + "%");
                stmt.setBoolean(2, true);
                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        if (resultados.getString("TIPO").equals("Cordas")) {
                            Cordas instrumento = new Cordas();
                            instrumento.setId(resultados.getInt("ID"));
                            instrumento.setNome(resultados.getString("NOME"));
                            instrumento.setMarca(resultados.getString("MARCA"));
                            instrumento.setTipo(resultados.getString("TIPO"));
                            instrumento.setQuantidade(resultados.getInt("QUANTIDADE"));
                            instrumento.setPreco(resultados.getDouble("PRECO"));
                            listaInstrumentos.add(instrumento);
                        } else if (resultados.getString("TIPO").equals("Percussão")) {
                            Percussao instrumento = new Percussao();
                            instrumento.setId(resultados.getInt("ID"));
                            instrumento.setNome(resultados.getString("NOME"));
                            instrumento.setMarca(resultados.getString("MARCA"));
                            instrumento.setTipo(resultados.getString("TIPO"));
                            instrumento.setQuantidade(resultados.getInt("QUANTIDADE"));
                            instrumento.setPreco(resultados.getDouble("PRECO"));
                            listaInstrumentos.add(instrumento);
                        } else if (resultados.getString("TIPO").equals("Sopro")) {
                            Sopro instrumento = new Sopro();
                            instrumento.setId(resultados.getInt("ID"));
                            instrumento.setNome(resultados.getString("NOME"));
                            instrumento.setMarca(resultados.getString("MARCA"));
                            instrumento.setTipo(resultados.getString("TIPO"));
                            instrumento.setQuantidade(resultados.getInt("QUANTIDADE"));
                            instrumento.setPreco(resultados.getDouble("PRECO"));
                            listaInstrumentos.add(instrumento);
                        }
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
        return listaInstrumentos;
    }

    @Override
    public List<Instrumento> listar() {
        ArrayList<Instrumento> listaInstrumentos = new ArrayList<>();
        String query = "SELECT * FROM instrumento WHERE ativo = ?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setBoolean(1, true);
                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        if (resultados.getString("TIPO").equals("Cordas")) {
                            Cordas instrumento = new Cordas();
                            instrumento.setId(resultados.getInt("ID"));
                            instrumento.setNome(resultados.getString("NOME"));
                            instrumento.setMarca(resultados.getString("MARCA"));
                            instrumento.setCor(resultados.getString("COR"));
                            instrumento.setQuantidade(resultados.getInt("QUANTIDADE"));
                            instrumento.setPreco(resultados.getDouble("PRECO"));
                            instrumento.setTipo(resultados.getString("TIPO"));
                            instrumento.setQtdCordas(resultados.getString("QTDCORDAS_CORDAS"));
                            instrumento.setTipoBraco(resultados.getString("TIPOBRACO_CORDAS"));
                            instrumento.setTipoCorpo(resultados.getString("TIPOCORPO_CORDAS"));
                            instrumento.setOrigem(resultados.getString("ORIGEM_CORDAS"));
                            listaInstrumentos.add(instrumento);
                        } else if (resultados.getString("TIPO").equals("Percussão")) {
                            Percussao instrumento = new Percussao();
                            instrumento.setId(resultados.getInt("ID"));
                            instrumento.setNome(resultados.getString("NOME"));
                            instrumento.setMarca(resultados.getString("MARCA"));
                            instrumento.setCor(resultados.getString("COR"));
                            instrumento.setQuantidade(resultados.getInt("QUANTIDADE"));
                            instrumento.setPreco(resultados.getDouble("PRECO"));
                            instrumento.setTipo(resultados.getString("TIPO"));
                            instrumento.setTipoMadeira(resultados.getString("TIPOMADEIRA_PERCUSSAO"));
                            instrumento.setQtdPratos(resultados.getString("QTDPRATOS_PERCUSSAO"));
                            instrumento.setDimensaoCaixa(resultados.getString("DIMENSAOCAIXA_PERCUSSAO"));
                            instrumento.setDimensaoToms(resultados.getString("DIMENSAOTOMS_PERCUSSAO"));
                            listaInstrumentos.add(instrumento);
                        } else if (resultados.getString("TIPO").equals("Sopro")) {
                            Sopro instrumento = new Sopro();
                            instrumento.setId(resultados.getInt("ID"));
                            instrumento.setNome(resultados.getString("NOME"));
                            instrumento.setMarca(resultados.getString("MARCA"));
                            instrumento.setCor(resultados.getString("COR"));
                            instrumento.setQuantidade(resultados.getInt("QUANTIDADE"));
                            instrumento.setPreco(resultados.getDouble("PRECO"));
                            instrumento.setTipo(resultados.getString("TIPO"));
                            instrumento.setMaterial(resultados.getString("MATERIAL_SOPRO"));
                            instrumento.setAcabamento(resultados.getString("ACABAMENTO_SOPRO"));
                            instrumento.setAfinacao(resultados.getString("AFINACAO_SOPRO"));
                            listaInstrumentos.add(instrumento);
                        }
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
        return listaInstrumentos;
    }

    @Override
    public void atualizar(Instrumento instrumento) {
        String queryCordas = "UPDATE instrumento SET NOME=?, MARCA=?, COR=?, PRECO=?, QUANTIDADE=?, TIPO=?, QTDCORDAS_CORDAS=?, "
                + "TIPOBRACO_CORDAS=?, TIPOCORPO_CORDAS=?, ORIGEM_CORDAS=? WHERE ID=?";
        String queryPercussao = "UPDATE instrumento SET NOME=?, MARCA=?, COR=?, PRECO=?, QUANTIDADE=?, TIPO=?, TIPOMADEIRA_PERCUSSAO=?, "
                + "QTDPRATOS_PERCUSSAO=?, DIMENSAOCAIXA_PERCUSSAO=?, DIMENSAOTOMS_PERCUSSAO=? WHERE ID=?";
        String querySopro = "UPDATE instrumento SET NOME=?, MARCA=?, COR=?, PRECO=?, QUANTIDADE=?, TIPO=?, MATERIAL_SOPRO=?, "
                + "ACABAMENTO_SOPRO=?, AFINACAO_SOPRO=? WHERE ID=?";


        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            if (instrumento instanceof Cordas) {
                Cordas instrumentoCordas = (Cordas) instrumento;
                try (PreparedStatement stmt = conn.prepareStatement(queryCordas, Statement.RETURN_GENERATED_KEYS)) {

                    stmt.setString(1, instrumentoCordas.getNome());
                    stmt.setString(2, instrumentoCordas.getMarca());
                    stmt.setString(3, instrumentoCordas.getCor());
                    stmt.setDouble(4, instrumentoCordas.getPreco());
                    stmt.setInt(5, instrumentoCordas.getQuantidade());
                    stmt.setString(6, instrumentoCordas.getTipo());
                    stmt.setString(7, instrumentoCordas.getQtdCordas());
                    stmt.setString(8, instrumentoCordas.getTipoBraco());
                    stmt.setString(9, instrumentoCordas.getTipoCorpo());
                    stmt.setString(10, instrumentoCordas.getOrigem());
                    stmt.setInt(11, instrumentoCordas.getId());

                    stmt.executeUpdate();

                } catch (SQLException e) {
                    conn.rollback();
                    throw e;
                }
            } else if (instrumento instanceof Percussao) {
                Percussao instrumentoPercussao = (Percussao) instrumento;
                try (PreparedStatement stmt = conn.prepareStatement(queryPercussao, Statement.RETURN_GENERATED_KEYS)) {

                    stmt.setString(1, instrumentoPercussao.getNome());
                    stmt.setString(2, instrumentoPercussao.getMarca());
                    stmt.setString(3, instrumentoPercussao.getCor());
                    stmt.setDouble(4, instrumentoPercussao.getPreco());
                    stmt.setInt(5, instrumentoPercussao.getQuantidade());
                    stmt.setString(6, instrumentoPercussao.getTipo());
                    stmt.setString(7, instrumentoPercussao.getTipoMadeira());
                    stmt.setString(8, instrumentoPercussao.getQtdPratos());
                    stmt.setString(9, instrumentoPercussao.getDimensaoCaixa());
                    stmt.setString(10, instrumentoPercussao.getDimensaoToms());
                    stmt.setInt(11, instrumentoPercussao.getId());

                    stmt.executeUpdate();

                } catch (SQLException e) {
                    conn.rollback();
                    throw e;
                }
            } else if (instrumento instanceof Sopro) {
                Sopro instrumentoSopro = (Sopro) instrumento;
                try (PreparedStatement stmt = conn.prepareStatement(querySopro, Statement.RETURN_GENERATED_KEYS)) {

                    stmt.setString(1, instrumentoSopro.getNome());
                    stmt.setString(2, instrumentoSopro.getMarca());
                    stmt.setString(3, instrumentoSopro.getCor());
                    stmt.setDouble(4, instrumentoSopro.getPreco());
                    stmt.setInt(5, instrumentoSopro.getQuantidade());
                    stmt.setString(6, instrumentoSopro.getTipo());
                    stmt.setString(7, instrumentoSopro.getMaterial());
                    stmt.setString(8, instrumentoSopro.getAcabamento());
                    stmt.setString(9, instrumentoSopro.getAfinacao());
                    stmt.setInt(10, instrumentoSopro.getId());

                    stmt.executeUpdate();

                } catch (SQLException e) {
                    conn.rollback();
                    throw e;
                }
            }
            conn.commit();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(int id) {
        String query = "UPDATE Instrumento SET Ativo = ? WHERE(ID = ?)";
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
    public Instrumento obter(int id) {
        String query = "SELECT * FROM instrumento WHERE ID = ? AND ATIVO = ?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);
                stmt.setBoolean(2, true);
                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        if (resultados.getString("TIPO").equals("Cordas")) {
                            Cordas instrumento = new Cordas();
                            instrumento.setId(resultados.getInt("ID"));
                            instrumento.setNome(resultados.getString("NOME"));
                            instrumento.setMarca(resultados.getString("MARCA"));
                            instrumento.setCor(resultados.getString("COR"));
                            instrumento.setQuantidade(resultados.getInt("QUANTIDADE"));
                            instrumento.setPreco(resultados.getDouble("PRECO"));
                            instrumento.setQtdCordas(resultados.getString("QTDCORDAS_CORDAS"));
                            instrumento.setTipoBraco(resultados.getString("TIPOBRACO_CORDAS"));
                            instrumento.setTipoCorpo(resultados.getString("TIPOCORPO_CORDAS"));
                            instrumento.setOrigem(resultados.getString("ORIGEM_CORDAS"));
                            return instrumento;
                        } else if (resultados.getString("TIPO").equals("Percussão")) {
                            Percussao instrumento = new Percussao();
                            instrumento.setId(resultados.getInt("ID"));
                            instrumento.setNome(resultados.getString("NOME"));
                            instrumento.setMarca(resultados.getString("MARCA"));
                            instrumento.setCor(resultados.getString("COR"));
                            instrumento.setQuantidade(resultados.getInt("QUANTIDADE"));
                            instrumento.setPreco(resultados.getDouble("PRECO"));
                            instrumento.setTipoMadeira(resultados.getString("TIPOMADEIRA_PERCUSSAO"));
                            instrumento.setQtdPratos(resultados.getString("QTDPRATOS_PERCUSSAO"));
                            instrumento.setDimensaoCaixa(resultados.getString("DIMENSAOCAIXA_PERCUSSAO"));
                            instrumento.setDimensaoToms(resultados.getString("DIMENSAOTOMS_PERCUSSAO"));
                            return instrumento;
                        } else if (resultados.getString("TIPO").equals("Sopro")) {
                            Sopro instrumento = new Sopro();
                            instrumento.setId(resultados.getInt("ID"));
                            instrumento.setNome(resultados.getString("NOME"));
                            instrumento.setMarca(resultados.getString("MARCA"));
                            instrumento.setCor(resultados.getString("COR"));
                            instrumento.setQuantidade(resultados.getInt("QUANTIDADE"));
                            instrumento.setPreco(resultados.getDouble("PRECO"));
                            instrumento.setMaterial(resultados.getString("MATERIAL_SOPRO"));
                            instrumento.setAcabamento(resultados.getString("ACABAMENTO_SOPRO"));
                            instrumento.setAfinacao(resultados.getString("AFINACAO_SOPRO"));
                            return instrumento;
                        }
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
