/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Classes.Instrumento;
import Exceptions.InstrumentoException;
import Servicos.ServicoInstrumento;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author renan
 */
public class Estoque_Consultar extends javax.swing.JInternalFrame {

    Estoque_Alterar estoqueAlterar = new Estoque_Alterar();
    String ultimaPesquisa = null;

    public Estoque_Consultar() {
        initComponents();
        jTabelaResultados.getColumnModel().getColumn(0).setMinWidth(0);
        jTabelaResultados.getColumnModel().getColumn(0).setMaxWidth(0);
        jTabelaResultados.getColumnModel().getColumn(0).setWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaResultados = new javax.swing.JTable();
        tfPesquisa = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estoque"));

        jLabel1.setText("Nome:");

        jTabelaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Marca", "Tipo", "Estoque", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaResultados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTabelaResultados);

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        jButton1.setText("Alterar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btConsultar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConsultar)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        boolean resultSearch = false;

        if (tfPesquisa.getText() != null
                && !tfPesquisa.getText().equals("")) {
            try {
                ultimaPesquisa = tfPesquisa.getText();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Só é possível"
                        + " pesquisar por um valor inteiro válido",
                        "Campo de pesquisa inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            ultimaPesquisa = null;
        }

        try {
            resultSearch = atualizarLista();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!resultSearch) {
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou "
                    + "resultados ", "Sem resultados",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConsultarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            final int row = jTabelaResultados.getSelectedRow();
            if (row >= 0) {
                Integer id = (Integer) jTabelaResultados.getValueAt(row, 0);

                Instrumento instrumento = ServicoInstrumento.obterInstrumento(id);
             
                estoqueAlterar.dispose();
                estoqueAlterar = new Estoque_Alterar();
                estoqueAlterar.setInstrumento(instrumento);
                estoqueAlterar.setTitle("Instrumento " + instrumento.getNome());
                this.getParent().add(estoqueAlterar);
                this.openFrameInCenter(estoqueAlterar);
                estoqueAlterar.toFront();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Não é possível "
                    + "exibir os detalhes deste instrumento.",
                    "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean atualizarLista() throws InstrumentoException, Exception {
        //solicita ao ServicoInstrumento o retorno do instrumento
        List<Instrumento> resultado = ServicoInstrumento.
                procurarInstrumento(ultimaPesquisa);

        DefaultTableModel model = (DefaultTableModel) jTabelaResultados.getModel();
        model.setRowCount(0);

        if (resultado == null || resultado.size() <= 0) {
            return false;
        }

        //insere os dados do instrumento na tabela
        for (int i = 0; i < resultado.size(); i++) {
            Instrumento instrumento = resultado.get(i);
            if (instrumento != null) {
                Object[] row = new Object[6];
                row[0] = instrumento.getId();
                row[1] = instrumento.getNome();
                row[2] = instrumento.getMarca();
                row[3] = instrumento.getTipo();
                row[4] = instrumento.getQuantidade();
                row[5] = instrumento.getPreco();
                model.addRow(row);
            }
        }

        return true;
    }
    
    public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = this.getParent().getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaResultados;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
