
package br.com.infox.telas;

import br.com.infox.DAO.PendenciaDAO;
import br.com.infox.model.bean.Pendencia;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luiz
 */
public class TelaAdministrador extends javax.swing.JFrame {

    
    public TelaAdministrador() {
        initComponents();
        readJTable();
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
            
            
              PendenciaDAO pendencia = new  PendenciaDAO();
       String filtroSetor = (String) comboSetor.getSelectedItem();
       pendencia.readForDesc(filtroSetor);
       
       
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
            
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablePendencia = new javax.swing.JTable();
        btnPesquisa = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAtualiza = new javax.swing.JButton();
        comboSetor = new javax.swing.JComboBox<>();
        comboCriticidade = new javax.swing.JComboBox<>();
        comboOrigem = new javax.swing.JComboBox<>();
        comboTipo = new javax.swing.JComboBox<>();
        lblSetor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        comboCriticidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALTA", "MEDIA", "BAIXA", "NÂO SE APLICA" }));

        comboOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anomalia", "Auditoria", "Care", "Comissionamento", "Hazard Hunter", "Hazid", "Inspeção", "Investigação", "MOC", "Outros", "Overview", "Pré-Audtoria", "Registro de Simulado de Emergência", "Simulados", "SQ Event", "VCP", "Visita Gerencial", "Crew Acceptance", "HSE View", " " }));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACIDENTE", "AUDITORIA CLIENTE", "INCIDENTE", "INSPEÇÃO", "REUNIÃO GERENCIAL", "SOLIC. DO CLIENTE", "TACO-19", "TACO-51" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        lblSetor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSetor.setText("Setor:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Criticidade:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Origem:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Tipo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSetor)
                                    .addComponent(comboSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(comboCriticidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(comboOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(btnSair))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(comboSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(comboCriticidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(comboOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addGap(19, 19, 19)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnSair)))
                .addGap(21, 21, 21)
                .addComponent(btnAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

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
    private javax.swing.JComboBox<String> comboCriticidade;
    private javax.swing.JComboBox<String> comboOrigem;
    private javax.swing.JComboBox<String> comboSetor;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSetor;
    private javax.swing.JTable tablePendencia;
    // End of variables declaration//GEN-END:variables
}
