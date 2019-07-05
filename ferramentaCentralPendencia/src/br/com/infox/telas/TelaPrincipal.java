
package br.com.infox.telas;

import br.com.infox.dal.ModuloConexao;
import java.sql.*;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author luiz
 */
public class TelaPrincipal extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /*
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
       conexao = ModuloConexao.conector();

    }

    
    public void enviaEmail(){
    
    Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
 
            Session session;
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("email@gmail.com", "senhaEmail");
                    } 
                });
 
            /** Ativa Debug para sessão */
            session.setDebug(true);
            try {
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("email@gmail.com")); //Remetente
 
                  String setor = (String) comboSetor.getSelectedItem();
                  Address[] toUser = null;
                if(setor.equals("TI")){
                     toUser = InternetAddress //Destinatário(s)
                             .parse("email@email.com"); 
                } else{
                toUser = InternetAddress //Destinatário(s)
                             .parse("email@live.com");
                }
 
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Enviando email com JavaMail");//Assunto
                  message.setText("há uma nova pendencia registrada, segue um resumo com a causa raiz: \n"
                          +textCausa.getText()+"\n \n \n para mais detalhes sobre a mesma, acesse a ferramenta centralizadora de pendencias.");
                  /**Método para enviar a mensagem criada*/
                Transport.send(message);
 
                  System.out.println("Feito!!!");
 
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
    
    }
    
    
    
    
    
    
    
    
    
    public void enviar(){
        String SqlEnvia = "insert into pendencia(causaRaiz, "
                + "setorOperacaoPendencia, tipo, origem, dataPendencia,"
                + " criticidade,ordemServico, solicitaCompra, statusPendencia) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)" ;   
     
        try {
         java.sql.Date dataSql = new java.sql.Date(escolheData.getDate().getTime()); 
                String statusPend = "PENDENTE";
            

            pst = conexao.prepareStatement(SqlEnvia);
            pst.setString(1, textCausa.getText());
           pst.setString(2, (String) comboSetor.getSelectedItem());
           pst.setString(3, (String) comboTipo.getSelectedItem());
           pst.setString(4, (String) comboOrigem.getSelectedItem());
           pst.setDate(5, dataSql);
           pst.setString(6, (String) comboCriticidade.getSelectedItem());
           
           //pegar o Jtextfield da OS e SC e converter de string para int
           String numOstxt = txtOs.getText();
           int numeroOs = Integer.parseInt(numOstxt);
           pst.setInt(7, numeroOs);
           String numSctxt = txtSC.getText();
           int numeroSc = Integer.parseInt(numSctxt);
           pst.setInt(8,numeroSc);
         pst.setString(9, statusPend);

//executa a query do mysql
          pst.execute();
          
          
                   //mensagem dizendo que foi inserido o dado e redirecionando
                   //para  a pagina de cadastro novamente.
                   telaConfirma confirmacao = new telaConfirma();
                   
                   confirmacao.setVisible(true);
                   enviaEmail();
              //  JOptionPane.showMessageDialog(null, "inserido com sucesso!!!");
                this.dispose();
                 /* TelaPrincipal principal = new TelaPrincipal();
                  principal.setVisible(true);
               */
                                 

        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"falha na inserção\n"
                     + " mensagem de erro: \n\n "+e);
                 this.dispose();
                  TelaLogin login = new TelaLogin();
                  login.setVisible(true);
            
        }
            
            
        }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboTipo = new javax.swing.JComboBox<>();
        comboSetor = new javax.swing.JComboBox<>();
        comboOrigem = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEviar = new javax.swing.JButton();
        btnEnviaArquivo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        escolheData = new com.toedter.calendar.JDateChooser();
        lblAcaoSugerida = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textCausa = new javax.swing.JTextArea();
        textAcaoSugerida = new javax.swing.JTextField();
        lblCriticidade = new javax.swing.JLabel();
        comboCriticidade = new javax.swing.JComboBox<>();
        lblNumOs = new javax.swing.JLabel();
        txtOs = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSC = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de nova pendência");
        setResizable(false);

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACIDENTE", "AUDITORIA CLIENTE", "INCIDENTE", "INSPEÇÃO", "REUNIÃO GERENCIAL", "SOLIC. DO CLIENTE", "TACO-19", "TACO-51" }));

        comboSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALMOXARIFADO", "COMPRAS", "GERÊNCIA", "GESTÃO SGI", "GESTÃO SONDAS", "MANUT_ELÉTRICA", "MANUT_MECÂNICA", "OPERAÇÃO", "QSMS", "RNB" }));

        comboOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anomalia", "Auditoria", "Care", "Comissionamento", "Hazard Hunter", "Hazid", "Inspeção", "Investigação", "MOC", "Outros", "Overview", "Pré-Audtoria", "Registro de Simulado de Emergência", "Simulados", "SQ Event", "VCP", "Visita Gerencial", "Crew Acceptance", "HSE View", " " }));

        jLabel1.setText("Data:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Setor:");

        jLabel4.setText("Origem:");

        jLabel5.setText("Causa raiz:");

        btnEviar.setText("Enviar");
        btnEviar.setToolTipText("");
        btnEviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEviarActionPerformed(evt);
            }
        });

        btnEnviaArquivo.setIcon(new javax.swing.ImageIcon("/home/luiz/Downloads/iconePdf16.png")); // NOI18N
        btnEnviaArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviaArquivoActionPerformed(evt);
            }
        });

        jLabel6.setText("Arquivo:");

        lblAcaoSugerida.setText("Ação sugerida:");

        textCausa.setColumns(20);
        textCausa.setRows(5);
        jScrollPane1.setViewportView(textCausa);

        lblCriticidade.setText("Criticidade:");

        comboCriticidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALTA", "MEDIA", "BAIXA", "NÂO SE APLICA" }));

        lblNumOs.setText("Número O.S:");

        txtOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOsActionPerformed(evt);
            }
        });

        jLabel7.setText("Número S.C");

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAcaoSugerida)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1)
                                            .addComponent(escolheData, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(comboOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCriticidade, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCriticidade))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btnEnviaArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textAcaoSugerida, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNumOs, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOs, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(txtSC)
                            .addComponent(btnEviar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(escolheData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblNumOs, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCriticidade)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnviaArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboSetor)
                                .addComponent(comboOrigem)
                                .addComponent(comboCriticidade)
                                .addComponent(comboTipo)))
                        .addGap(61, 61, 61)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOs, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSC))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblAcaoSugerida, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAcaoSugerida, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEviar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        setSize(new java.awt.Dimension(1013, 506));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEviarActionPerformed
      enviar();
        
        
       
      /* JavaMailApp enviaEmail = new JavaMailApp();
       enviaEmail.enviar();*/
       
       
       
    }//GEN-LAST:event_btnEviarActionPerformed

    private void txtOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOsActionPerformed

    private void btnEnviaArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviaArquivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviaArquivoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        
        
        
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviaArquivo;
    private javax.swing.JButton btnEviar;
    private javax.swing.JComboBox<String> comboCriticidade;
    private javax.swing.JComboBox<String> comboOrigem;
    private javax.swing.JComboBox<String> comboSetor;
    private javax.swing.JComboBox<String> comboTipo;
    private com.toedter.calendar.JDateChooser escolheData;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcaoSugerida;
    private javax.swing.JLabel lblCriticidade;
    private javax.swing.JLabel lblNumOs;
    private javax.swing.JTextField textAcaoSugerida;
    private javax.swing.JTextArea textCausa;
    private javax.swing.JFormattedTextField txtOs;
    private javax.swing.JFormattedTextField txtSC;
    // End of variables declaration//GEN-END:variables
}
