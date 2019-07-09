/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

import br.com.infox.DAO.PendenciaDAO;
import br.com.infox.dal.ModuloConexao;
import br.com.infox.model.bean.Pendencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz
 */
public class AdministradorPendenciaDetalhada extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    
    
    public AdministradorPendenciaDetalhada() {
        initComponents();
        setaValor();
               conexao = ModuloConexao.conector();

    }

   public void setaValor(){
      
       
      
   PendenciaDAO pdao = new PendenciaDAO();
   String origemDetalhe;
         int osDetalhe;
         int scDetalhe;
   for (Pendencia p : pdao.lerComDetalhes(TelaAdministrador.SetorVariavel, TelaAdministrador.causaRaizVariavel, TelaAdministrador.tipoVariavel)) {

         
               origemDetalhe= p.getOrigem();
              osDetalhe =  p.getOrdemServico();
               scDetalhe= p.getSolicitaCompra();
             
               String scString = Integer.toString(scDetalhe);
               String osString = Integer.toString(osDetalhe);
            
    labelCausaRaiz.setText(TelaAdministrador.causaRaizVariavel);
   lblTipoMostra.setText(TelaAdministrador.tipoVariavel);
   lblNivelCriticidade.setText(TelaAdministrador.criticidadeVariavel);
   lblData.setText(TelaAdministrador.dataVariavel);
   lblOrigemMostra.setText(origemDetalhe);
   lblSolicitaCompMostra.setText(scString);
   lblOrdemServMostra.setText(osString);
            

        }
   
   
   
   
   }
   
   
   
   
   
   
    public void enviar(){
                  java.sql.Date dataSql = new java.sql.Date(dataTermino.getDate().getTime()); 
                  java.sql.Date dataDaProvidencia1 = new java.sql.Date(dataProvid1.getDate().getTime());
                  java.sql.Date dataDaProvidencia2 = new java.sql.Date(dataProvid2.getDate().getTime());
                  java.sql.Date dataDaProvidencia3 = new java.sql.Date(dataProvid3.getDate().getTime());
                  
                  String TodaProvid1 = dataDaProvidencia1+" "+txtProvid1.getText();
                  String TodaProvid2= dataDaProvidencia2+" "+txtProvid2.getText();
                  String TodaProvid3 = dataDaProvidencia3+" "+txtProvid3.getText();
                  
                  
                      // String SqlEnvia = "UPDATE pendencia SET acaoTomadaAdm=?, dataPreviaTermino=?, providencia1=?, providencia2=?, providencia3=? WHERE causaRaiz=?";   

 
     
       try {
                String statusPend = "PENDENTE";
            
                    
            pst = conexao.prepareStatement(SqlEnvia);
           pst.setString(1, (String) txtAcaoTomada.getText());
           pst.setDate(2, dataSql);
           
           
          
           
           pst.setString(3, TodaProvid1);
           pst.setString(4, TodaProvid2);
           pst.setString(5, TodaProvid3);
            pst.setString(6, labelCausaRaiz.getText());
            
            
            
            if(dataProvid1.equals(null)){
                
                
                                       String SqlEnvia = "UPDATE pendencia SET acaoTomadaAdm=? WHERE causaRaiz=?";   

                  
            pst = conexao.prepareStatement(SqlEnvia);
           pst.setString(1, (String) txtAcaoTomada.getText());
           pst.setDate(2, dataSql);
           
           
          
           
          
            pst.setString(3, labelCausaRaiz.getText());
            
            }else if(dataProvid2.equals(null)){
                
                
                                       String SqlEnvia = "UPDATE pendencia SET acaoTomadaAdm=?, dataPreviaTermino=?, providencia1=? WHERE causaRaiz=?";   

                  
            pst = conexao.prepareStatement(SqlEnvia);
           pst.setString(1, (String) txtAcaoTomada.getText());
           pst.setDate(2, dataSql);
           pst.setString(3, TodaProvid1);

                
            
            }else if(dataProvid3.equals(null)){
                    String SqlEnvia = "UPDATE pendencia SET acaoTomadaAdm=?, dataPreviaTermino=?, providencia1=?, providencia WHERE causaRaiz=?";   

                  
            pst = conexao.prepareStatement(SqlEnvia);
           pst.setString(1, (String) txtAcaoTomada.getText());
           pst.setDate(2, dataSql);
           pst.setString(3, TodaProvid1);
            
            }
            
           
           
           
          

//executa a query do mysql
          pst.execute();
          
          
                   //mensagem dizendo que foi inserido o dado e redirecionando
                   //para  a pagina de cadastro novamente.
                   telaConfirma confirmacao = new telaConfirma();
                   
                   confirmacao.setVisible(true);
             
                this.dispose();
              
                            

        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"falha na inserção\n"
                     + " mensagem de erro: \n\n "+e);
                 this.dispose();
                  TelaLogin login = new TelaLogin();
                  login.setVisible(true);
            
        } 
                   
            
            
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTipoAdm = new javax.swing.JLabel();
        lblTipoMostra = new javax.swing.JLabel();
        lblOrigemAdm = new javax.swing.JLabel();
        lblOrigemMostra = new javax.swing.JLabel();
        lblDataAdm = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblCriticidadeAdm = new javax.swing.JLabel();
        lblNivelCriticidade = new javax.swing.JLabel();
        btnArquivoDownload = new javax.swing.JButton();
        lblAcaoTomada = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        lblstatusAdm = new javax.swing.JLabel();
        lblprovid1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAcaoTomada = new javax.swing.JTextArea();
        dataProvid1 = new com.toedter.calendar.JDateChooser();
        txtProvid1 = new javax.swing.JTextField();
        dataProvid2 = new com.toedter.calendar.JDateChooser();
        txtProvid2 = new javax.swing.JTextField();
        lblprovid2 = new javax.swing.JLabel();
        dataProvid3 = new com.toedter.calendar.JDateChooser();
        txtProvid3 = new javax.swing.JTextField();
        lblprovid3 = new javax.swing.JLabel();
        lblOsAdm = new javax.swing.JLabel();
        lblOrdemServMostra = new javax.swing.JLabel();
        lblAcAdm = new javax.swing.JLabel();
        lblSolicitaCompMostra = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dataTermino = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelCausaRaiz = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administração Pendência");
        setResizable(false);

        lblTipoAdm.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTipoAdm.setText("Tipo:");

        lblTipoMostra.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTipoMostra.setText("ACIDENTE");

        lblOrigemAdm.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblOrigemAdm.setText("Origem:");

        lblOrigemMostra.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblOrigemMostra.setText("ANOMALIA");

        lblDataAdm.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDataAdm.setText("Data:");

        lblData.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblData.setText("13/06/2019");

        lblCriticidadeAdm.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCriticidadeAdm.setText("Criticidade:");

        lblNivelCriticidade.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNivelCriticidade.setText("ALTA");

        btnArquivoDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/iconePdf36.png"))); // NOI18N
        btnArquivoDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArquivoDownloadActionPerformed(evt);
            }
        });

        lblAcaoTomada.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblAcaoTomada.setText("Ação tomada:");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDENTE", "EM ANDAMENTO", "CONCLUÍDO" }));

        lblstatusAdm.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblstatusAdm.setText("Status:");

        lblprovid1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblprovid1.setText("Providência 1:");

        txtAcaoTomada.setColumns(20);
        txtAcaoTomada.setRows(5);
        jScrollPane2.setViewportView(txtAcaoTomada);

        txtProvid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvid1ActionPerformed(evt);
            }
        });

        txtProvid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvid2ActionPerformed(evt);
            }
        });

        lblprovid2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblprovid2.setText("Providência 2:");

        txtProvid3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvid3ActionPerformed(evt);
            }
        });

        lblprovid3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblprovid3.setText("Providência 3:");

        lblOsAdm.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblOsAdm.setText("O.S:");

        lblOrdemServMostra.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblOrdemServMostra.setText("122345");

        lblAcAdm.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblAcAdm.setText("S.C:");

        lblSolicitaCompMostra.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSolicitaCompMostra.setText("235564");

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Data término:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Causa Raiz:");

        labelCausaRaiz.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCausaRaiz.setText("Causa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCausaRaiz)
                    .addComponent(jLabel4)
                    .addComponent(lblAcaoTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprovid1)
                            .addComponent(dataProvid1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblprovid2)
                            .addComponent(dataProvid2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblprovid3)
                                    .addComponent(dataProvid3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProvid1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProvid2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtProvid3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOsAdm)
                                    .addComponent(lblOrdemServMostra, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAcAdm)
                                    .addComponent(lblSolicitaCompMostra)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(dataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1088, 1088, 1088)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipoAdm)
                            .addComponent(lblTipoMostra))
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrigemAdm)
                            .addComponent(lblOrigemMostra))
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblData))
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCriticidadeAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNivelCriticidade))
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblstatusAdm)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(124, 124, 124)
                        .addComponent(btnArquivoDownload)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipoAdm)
                        .addGap(11, 11, 11)
                        .addComponent(lblTipoMostra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrigemAdm)
                        .addGap(18, 18, 18)
                        .addComponent(lblOrigemMostra))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDataAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(lblData))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCriticidadeAdm)
                                .addGap(6, 6, 6)
                                .addComponent(lblNivelCriticidade))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblstatusAdm)
                                .addGap(6, 6, 6)
                                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnArquivoDownload))))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCausaRaiz)
                .addGap(51, 51, 51)
                .addComponent(lblAcaoTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblprovid1)
                        .addGap(9, 9, 9)
                        .addComponent(dataProvid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lblprovid2)
                        .addGap(9, 9, 9)
                        .addComponent(dataProvid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lblprovid3)
                        .addGap(9, 9, 9)
                        .addComponent(dataProvid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblOsAdm)
                            .addGap(6, 6, 6)
                            .addComponent(lblOrdemServMostra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(lblAcAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(lblSolicitaCompMostra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtProvid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(txtProvid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(txtProvid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1302, 590));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnArquivoDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArquivoDownloadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArquivoDownloadActionPerformed

    private void txtProvid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvid1ActionPerformed

    private void txtProvid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvid2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvid2ActionPerformed

    private void txtProvid3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvid3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvid3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        enviar();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AdministradorPendenciaDetalhada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorPendenciaDetalhada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorPendenciaDetalhada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorPendenciaDetalhada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorPendenciaDetalhada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArquivoDownload;
    private javax.swing.JComboBox<String> comboStatus;
    private com.toedter.calendar.JDateChooser dataProvid1;
    private com.toedter.calendar.JDateChooser dataProvid2;
    private com.toedter.calendar.JDateChooser dataProvid3;
    private com.toedter.calendar.JDateChooser dataTermino;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCausaRaiz;
    private javax.swing.JLabel lblAcAdm;
    private javax.swing.JLabel lblAcaoTomada;
    private javax.swing.JLabel lblCriticidadeAdm;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataAdm;
    private javax.swing.JLabel lblNivelCriticidade;
    private javax.swing.JLabel lblOrdemServMostra;
    private javax.swing.JLabel lblOrigemAdm;
    private javax.swing.JLabel lblOrigemMostra;
    private javax.swing.JLabel lblOsAdm;
    private javax.swing.JLabel lblSolicitaCompMostra;
    private javax.swing.JLabel lblTipoAdm;
    private javax.swing.JLabel lblTipoMostra;
    private javax.swing.JLabel lblprovid1;
    private javax.swing.JLabel lblprovid2;
    private javax.swing.JLabel lblprovid3;
    private javax.swing.JLabel lblstatusAdm;
    private javax.swing.JTextArea txtAcaoTomada;
    private javax.swing.JTextField txtProvid1;
    private javax.swing.JTextField txtProvid2;
    private javax.swing.JTextField txtProvid3;
    // End of variables declaration//GEN-END:variables
}
