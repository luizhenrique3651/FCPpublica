
package br.com.infox.telas;

import br.com.infox.DAO.PendenciaDAO;
import br.com.infox.model.bean.Pendencia;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luiz
 */
public class TelaAdministrador extends javax.swing.JFrame {
        static String causaRaizVariavel;
        static String tipoVariavel;
        static String SetorVariavel;
        static String dataVariavel;
        static String criticidadeVariavel;
        static String StatusVariavel;
    public TelaAdministrador() {
        initComponents();
        readJTable();
        linhaSelec();
    }

            public void readJTable() {
        
        DefaultTableModel modelo = (DefaultTableModel) tablePendencia.getModel();
        modelo.setNumRows(0);
            PendenciaDAO pdao = new PendenciaDAO();

        for (Pendencia p : pdao.read()) {

            modelo.addRow(new Object[]{
                p.getCausaRaiz(),        
                p.getTipo(),
                p.getSetorOperacaoPendencia(),
               p.getDataPendencia(),
               p.getCriticidade(),
             p.getStatusPendencia()
              /* p.getOrdemServico(),
               p.getSolicitaCompra(),
               p.getOrigem()*/
                    
            }
            );

        }

    }
            
            
            
            
            public void lerComFiltro(){
            
            
              //PendenciaDAO pendenciadao = new  PendenciaDAO();
       String filtroSetor = (String) comboSetor.getSelectedItem();
       //pendenciadao.readForDesc(filtroSetor);
       
       
        DefaultTableModel modelo = (DefaultTableModel) tablePendencia.getModel();
        modelo.setNumRows(0);
            PendenciaDAO pdao = new PendenciaDAO();

        for (Pendencia p : pdao.readForDesc(filtroSetor)) {

            modelo.addRow(new Object[]{
                p.getCausaRaiz(),        
                p.getTipo(),
                p.getSetorOperacaoPendencia(),
               p.getDataPendencia(),
               p.getCriticidade(),
               p.getStatusPendencia()

              /* p.getOrdemServico(),
               p.getSolicitaCompra(),
               p.getOrigem()*/
                    
            }
            );

        }
            
            }
            
            
           public void linhaSelec(){
           
            tablePendencia.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2 && tablePendencia.getSelectedRow() != -1) {
                    
                      causaRaizVariavel =  (String) tablePendencia.getValueAt(tablePendencia.getSelectedRow(), 0);
                   tipoVariavel =     (String) tablePendencia.getValueAt(tablePendencia.getSelectedRow(), 1);
                   SetorVariavel =  (String) tablePendencia.getValueAt(tablePendencia.getSelectedRow(), 2);
                   dataVariavel =  (String) tablePendencia.getValueAt(tablePendencia.getSelectedRow(), 3);
                   criticidadeVariavel = (String) tablePendencia.getValueAt(tablePendencia.getSelectedRow(), 4);
                   StatusVariavel =  (String) tablePendencia.getValueAt(tablePendencia.getSelectedRow(), 5);
                   
                   
                   
                   
                   AdministradorPendenciaDetalhada detalhe = new AdministradorPendenciaDetalhada();
                   detalhe.setVisible(true);
                   
                }
            }
        });
           
           }
            
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablePendencia = new javax.swing.JTable();
        btnPesquisa = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAtualiza = new javax.swing.JButton();
        comboSetor = new javax.swing.JComboBox<>();
        lblSetor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablePendencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Causa Raiz", "Tipo de registro", "Setor", "Data", "Criticidade", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePendencia.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablePendenciaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(tablePendencia);

        btnPesquisa.setForeground(new java.awt.Color(51, 51, 51));
        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/pesquisaAzul.png"))); // NOI18N
        btnPesquisa.setBorder(null);
        btnPesquisa.setHideActionText(true);
        btnPesquisa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnAtualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/iconeReload36.png"))); // NOI18N
        btnAtualiza.setBorder(null);
        btnAtualiza.setBorderPainted(false);
        btnAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaActionPerformed(evt);
            }
        });

        comboSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALMOXARIFADO", "COMPRAS", "GERÊNCIA", "GESTÃO SGI", "GESTÃO SONDAS", "MANUT_ELÉTRICA", "MANUT_MECÂNICA", "OPERAÇÃO", "QSMS", "RNB" }));

        lblSetor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSetor.setText("Setor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSetor)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1198, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(comboSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(btnAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1208, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
      lerComFiltro();

    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
 this.dispose();
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
                // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
            readJTable();
                    
    }//GEN-LAST:event_btnAtualizaActionPerformed

    private void tablePendenciaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablePendenciaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePendenciaAncestorAdded

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdministrador().setVisible(true);
            }
        });
        
        
        
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualiza;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> comboSetor;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSetor;
    private javax.swing.JTable tablePendencia;
    // End of variables declaration//GEN-END:variables
}
