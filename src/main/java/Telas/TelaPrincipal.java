package Telas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;

public class TelaPrincipal extends javax.swing.JFrame {
    
    

    private CadastrarCliente cadastrarCliente = null;
    private ConsultarCliente consultarCliente = null;
    private CadastrarInstrumento cadastrarInstrumento = null;
    private ConsultarInstrumento consultarInstrumento = null;
    private Estoque_Consultar estoqueConsultar = null;
    Vendas venda = null;

    public TelaPrincipal() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/IconeTadsounds.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane(){
            private Image image;
            {
                try {
                    image = ImageIO.read(new File("src/main/resources/Imagens/Fundo6.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        barraMenu = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        itemCadastrarCliente = new javax.swing.JMenuItem();
        itemConsultarCliente = new javax.swing.JMenuItem();
        menuInstrumentos = new javax.swing.JMenu();
        itemCadastrarCordas = new javax.swing.JMenuItem();
        itemConsultarInstrumento = new javax.swing.JMenuItem();
        itemEstoque = new javax.swing.JMenuItem();
        menuVendas = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sonata");

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cliente.png"))); // NOI18N
        menuClientes.setText("Clientes");

        itemCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/AdicionarCliente.png"))); // NOI18N
        itemCadastrarCliente.setText("Cadastrar Cliente");
        itemCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(itemCadastrarCliente);

        itemConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ConsultarCliente.png"))); // NOI18N
        itemConsultarCliente.setText("Consultar Cliente");
        itemConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(itemConsultarCliente);

        barraMenu.add(menuClientes);

        menuInstrumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Produto.png"))); // NOI18N
        menuInstrumentos.setText("Instrumentos");
        menuInstrumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInstrumentosActionPerformed(evt);
            }
        });

        itemCadastrarCordas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/guitarra.png"))); // NOI18N
        itemCadastrarCordas.setText("Cadastrar Instrumento");
        itemCadastrarCordas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarCordasActionPerformed(evt);
            }
        });
        menuInstrumentos.add(itemCadastrarCordas);

        itemConsultarInstrumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/consultarInstrumento.png"))); // NOI18N
        itemConsultarInstrumento.setText("Consultar Instrumento");
        itemConsultarInstrumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarInstrumentoActionPerformed(evt);
            }
        });
        menuInstrumentos.add(itemConsultarInstrumento);

        itemEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/box.png"))); // NOI18N
        itemEstoque.setText("Gerenciar Estoque");
        itemEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEstoqueActionPerformed(evt);
            }
        });
        menuInstrumentos.add(itemEstoque);

        barraMenu.add(menuInstrumentos);

        menuVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Venda.png"))); // NOI18N
        menuVendas.setText("Vendas");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/RealizarVenda.png"))); // NOI18N
        jMenuItem2.setText("Realizar Venda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuVendas.add(jMenuItem2);

        barraMenu.add(menuVendas);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                menuSairMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuSairMenuSelected(evt);
            }
        });
        barraMenu.add(menuSair);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarClienteActionPerformed
        if (consultarCliente == null || !consultarCliente.isDisplayable()) {
            consultarCliente = new ConsultarCliente();
            desktop.add(consultarCliente);
            this.openFrameInCenter(consultarCliente);
        }
        consultarCliente.toFront();
    }//GEN-LAST:event_itemConsultarClienteActionPerformed

    private void menuSairMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuSairMenuSelected
        System.exit(0);
    }//GEN-LAST:event_menuSairMenuSelected

    private void menuSairMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_menuSairMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSairMenuKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (venda == null || !venda.isDisplayable()) {
            venda = new Vendas();
            desktop.add(venda);
            this.openFrameInCenter(venda);
        }
        venda.toFront();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void itemCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarClienteActionPerformed
        if (cadastrarCliente == null || !cadastrarCliente.isDisplayable()) {
            cadastrarCliente = new CadastrarCliente();
            desktop.add(cadastrarCliente);
            this.openFrameInCenter(cadastrarCliente);
        }
        cadastrarCliente.toFront();
    }//GEN-LAST:event_itemCadastrarClienteActionPerformed

    private void itemCadastrarCordasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarCordasActionPerformed
        if (cadastrarInstrumento == null || !cadastrarInstrumento.isDisplayable()) {
            cadastrarInstrumento = new CadastrarInstrumento();
            desktop.add(cadastrarInstrumento);
            this.openFrameInCenter(cadastrarInstrumento);
        }
        cadastrarInstrumento.toFront();
    }//GEN-LAST:event_itemCadastrarCordasActionPerformed

    private void itemConsultarInstrumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarInstrumentoActionPerformed
        if (consultarInstrumento == null || !consultarInstrumento.isDisplayable()) {
            consultarInstrumento = new ConsultarInstrumento();
            desktop.add(consultarInstrumento);
            this.openFrameInCenter(consultarInstrumento);
        }
        consultarInstrumento.toFront();
    }//GEN-LAST:event_itemConsultarInstrumentoActionPerformed

    private void itemEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEstoqueActionPerformed
        if (getEstoqueConsultar() == null || !estoqueConsultar.isDisplayable()) {
            setEstoqueConsultar(new Estoque_Consultar());
            desktop.add(getEstoqueConsultar());
            this.openFrameInCenter(getEstoqueConsultar());
        }
        consultarCliente.toFront();
    }//GEN-LAST:event_itemEstoqueActionPerformed

    private void menuInstrumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInstrumentosActionPerformed
        
    }//GEN-LAST:event_menuInstrumentosActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem itemCadastrarCliente;
    private javax.swing.JMenuItem itemCadastrarCordas;
    private javax.swing.JMenuItem itemConsultarCliente;
    private javax.swing.JMenuItem itemConsultarInstrumento;
    private javax.swing.JMenuItem itemEstoque;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuInstrumentos;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuVendas;
    // End of variables declaration//GEN-END:variables

    public CadastrarCliente getCadastrarCliente() {
        return cadastrarCliente;
    }

    public void setCadastrarCliente(CadastrarCliente cadastrarCliente) {
        this.cadastrarCliente = cadastrarCliente;
    }
    
    public ConsultarCliente getConsultarCliente() {
        return consultarCliente;
    }

    public void setConsultarCliente(ConsultarCliente consultarCliente) {
        this.consultarCliente = consultarCliente;
    }
    
    public ConsultarInstrumento getConsultarProduto() {
        return consultarInstrumento;
    }
    
    public void setConsultarProduto (ConsultarInstrumento consultarProduto) {
        this.consultarInstrumento = consultarProduto;
    }

    public Estoque_Consultar getEstoqueConsultar() {
        return estoqueConsultar;
    }

    public void setEstoqueConsultar(Estoque_Consultar estoqueConsultar) {
        this.estoqueConsultar = estoqueConsultar;
    }
}
