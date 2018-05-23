package Telas;

import Classes.Cliente;
import Servicos.ServicoCliente;
import java.util.Date;
import javax.swing.JOptionPane;

//classe que permite ao usuario editar os dados do cliente atraves do ServicoCliente
public class EditarCliente extends javax.swing.JInternalFrame {

    private Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EditarCliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        fieldNascimento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldCpf = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
            fieldCpf = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }
        comboEstadoCivil = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fieldEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldNumeroEnd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fieldTelefone = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##)#####-####");
            fieldTelefone = new javax.swing.JFormattedTextField(telefone);
        }
        catch (Exception e){
        }
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fieldBairro = new javax.swing.JTextField();
        fieldCidade = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar Cliente");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLabel5.setText("Nome:");

        fieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNomeKeyTyped(evt);
            }
        });

        jLabel7.setText("Sexo:");

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "Masculino", "Feminino" }));

        jLabel1.setText("Data de Nasc.:");

        fieldNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel6.setText("CPF:");

        comboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "Solteiro(a)", "Casado(a)", "Viúvo(a)", "Divorciado(a)" }));

        jLabel8.setText("Estado Civil:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(fieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contatos"));

        jLabel2.setText("Endereço:");

        fieldEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldEnderecoKeyTyped(evt);
            }
        });

        jLabel3.setText("Nº:");

        fieldNumeroEnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumeroEndKeyTyped(evt);
            }
        });

        jLabel4.setText("E-mail:");

        fieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldEmailKeyTyped(evt);
            }
        });

        jLabel9.setText("Telefone:");

        fieldTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTelefoneKeyTyped(evt);
            }
        });

        jLabel11.setText("Bairro:");

        jLabel12.setText("Cidade:");

        jLabel13.setText("Estado:");

        fieldBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBairroKeyTyped(evt);
            }
        });

        fieldCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldCidadeKeyTyped(evt);
            }
        });

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA) ", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumeroEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(fieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(fieldNumeroEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(fieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSalvar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //botao que salva os novos dados informados pelo usuario atraves do ServicoCliente
    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        getCliente().setNome(fieldNome.getText());
        getCliente().setCpf(fieldCpf.getText());
        getCliente().setSexo((String) comboSexo.getSelectedItem());
//        Date data = null;
//        try {
//            data = (Date) fieldNascimento.getValue();
//        } catch (Exception e) {
//
//        }
//        String dataNasc = (String) data;

        getCliente().setDataNascimento(fieldNascimento.getText());
        getCliente().setEstadoCivil((String) comboEstadoCivil.getSelectedItem());
        getCliente().setEndereco(fieldEndereco.getText());
        getCliente().setNumeroEnd(fieldNumeroEnd.getText());
        getCliente().setBairro(fieldBairro.getText());
        getCliente().setCidade(fieldCidade.getText());
        getCliente().setEstado((String) comboEstado.getSelectedItem());
        getCliente().setEmail(fieldEmail.getText());
        getCliente().setTelefone(fieldTelefone.getText());

        try {
            //solicita ao ServicoCliente a atualizacao dos dados do cliente
            ServicoCliente.atualizarCliente(getCliente());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            if (this.getDesktopPane().getTopLevelAncestor() instanceof TelaPrincipal) {
                TelaPrincipal principal = (TelaPrincipal) this.getDesktopPane().getTopLevelAncestor();
                if (principal != null) {
                    principal.getConsultarCliente().atualizaLista();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(rootPane, "Cliente atualizado com sucesso",
                "Cliente atualizado", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    //botao que cancela a operacao atual e volta para a tela anterior
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    //insere os dados atuais do cliente na tela de edicao para serem editados
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        fieldNome.setText(getCliente().getNome());
        fieldCpf.setText(getCliente().getCpf());
        for (int i = 0; i < comboSexo.getItemCount(); i++) {
            if (comboSexo.getItemAt(i).equals(getCliente().getSexo())) {
                comboSexo.setSelectedIndex(i);
            }
        }
        fieldNascimento.setText(getCliente().getDataNascimento());
        for (int i = 0; i < comboEstadoCivil.getItemCount(); i++) {
            if (comboEstadoCivil.getItemAt(i).equals(getCliente().getEstadoCivil())) {
                comboEstadoCivil.setSelectedIndex(i);
            }
        }
        fieldEndereco.setText(getCliente().getEndereco());
        fieldNumeroEnd.setText(getCliente().getNumeroEnd());
        fieldBairro.setText(getCliente().getBairro());
        fieldCidade.setText(getCliente().getCidade());
        for (int i = 0; i < comboEstado.getItemCount(); i++) {
            if (comboEstado.getItemAt(i).equals(getCliente().getEstado())) {
                comboEstado.setSelectedIndex(i);
            }
        }
        fieldEmail.setText(getCliente().getEmail());
        fieldTelefone.setText(getCliente().getTelefone());
    }//GEN-LAST:event_formInternalFrameOpened

    //limita o numero de caracteres que podem ser inseridos no campo numero
    private void fieldNumeroEndKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumeroEndKeyTyped
        if (fieldNumeroEnd.getText().length() > 4) {
            fieldNumeroEnd.setText(fieldNumeroEnd.getText().substring(0, 4));
        }
    }//GEN-LAST:event_fieldNumeroEndKeyTyped

    private void fieldTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTelefoneKeyTyped
        String caracteres = "0987654321-";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        if (fieldTelefone.getText().length() > 14) {
            fieldTelefone.setText(fieldTelefone.getText().substring(0, 14));
        }
    }//GEN-LAST:event_fieldTelefoneKeyTyped

    private void fieldNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNomeKeyTyped
        if (fieldNome.getText().length() > 99) {
            fieldNome.setText(fieldNome.getText().substring(0, 99));
        }
    }//GEN-LAST:event_fieldNomeKeyTyped

    private void fieldEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldEnderecoKeyTyped
        if (fieldEndereco.getText().length() > 99) {
            fieldEndereco.setText(fieldEndereco.getText().substring(0, 99));
        }
    }//GEN-LAST:event_fieldEnderecoKeyTyped

    private void fieldBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBairroKeyTyped
        if (fieldBairro.getText().length() > 49) {
            fieldBairro.setText(fieldBairro.getText().substring(0, 49));
        }
    }//GEN-LAST:event_fieldBairroKeyTyped

    private void fieldCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCidadeKeyTyped
        if (fieldCidade.getText().length() > 19) {
            fieldCidade.setText(fieldCidade.getText().substring(0, 19));
        }
    }//GEN-LAST:event_fieldCidadeKeyTyped

    private void fieldEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldEmailKeyTyped
        if (fieldEmail.getText().length() > 99) {
            fieldEmail.setText(fieldEmail.getText().substring(0, 99));
        }
    }//GEN-LAST:event_fieldEmailKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboEstadoCivil;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JTextField fieldBairro;
    private javax.swing.JTextField fieldCidade;
    private javax.swing.JTextField fieldCpf;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldEndereco;
    private javax.swing.JFormattedTextField fieldNascimento;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldNumeroEnd;
    private javax.swing.JTextField fieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
