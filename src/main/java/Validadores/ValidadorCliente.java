package Validadores;

import Classes.Cliente;
import Exceptions.ClienteException;
import java.util.List;

//classe que permite a validacao dos dados inseridos nos campos obrigatorios na tela de cadastro do cliente
public class ValidadorCliente {

    public static void validar(Cliente cliente) throws ClienteException {
        if (cliente == null) {
            throw new ClienteException("Cliente não foi informado");
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClienteException("Nome não informado");
        }
        if (cliente.getCpf() == null || "".equals(cliente.getCpf())) {
            throw new ClienteException("CPF não informado");
        }
        //valida o cpf inserido pelo usuario
        Cpf valida = new Cpf();
        if (!valida.validacaoCpf(cliente)) {
            throw new ClienteException("CPF inválido");
        }
        if (cliente.getSexo() == null || "SELECIONE".equals(cliente.getSexo())) {
            throw new ClienteException("Sexo não informado");
        }
        if (cliente.getDataNascimento() == null) {
            throw new ClienteException("Data inválida");
        }
        if (cliente.getEstadoCivil() == null || "SELECIONE".equals(cliente.getEstadoCivil())) {
            throw new ClienteException("Estado civil não informado");
        }
        if (cliente.getEndereco() == null || "".equals(cliente.getEndereco())) {
            throw new ClienteException("Endereço não informado");
        }
        if (cliente.getNumeroEnd() == null || "".equals(cliente.getNumeroEnd())) {
            throw new ClienteException("Número do endereço não informado");
        }
        if (cliente.getBairro() == null || "".equals(cliente.getBairro())) {
            throw new ClienteException("Bairro não informado");
        }
        if (cliente.getCidade() == null || "".equals(cliente.getCidade())) {
            throw new ClienteException("Cidade não informada");
        }
        if (cliente.getEstado() == null || "SELECIONE".equals(cliente.getEstado())) {
            throw new ClienteException("Estado não informado");
        }
        if (cliente.getEmail() == null || "SELECIONE".equals(cliente.getEmail())) {
            throw new ClienteException("E-mail não informado");
        }
        if (cliente.getTelefone() == null || "SELECIONE".equals(cliente.getTelefone())) {
            throw new ClienteException("Telefone não informado");
        }

    }

    //verifica se o cpf inserido pelo usuario ja nao esta cadastrado no sistema
    public static void verificarCPFUnico(List<String> CPF, Cliente cliente) throws ClienteException {
        for (String cpfCadastrado : CPF) {
            if (cliente != null && CPF != null) {
                if (cliente.getCpf().equals(cpfCadastrado)) {
                    throw new ClienteException("CPF já cadastrado!");
                }
            }
        }
    }

}
