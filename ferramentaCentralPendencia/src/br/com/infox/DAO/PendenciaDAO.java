/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.DAO;


import br.com.infox.dal.ModuloConexao;
import br.com.infox.model.bean.Pendencia;
import br.com.infox.telas.TelaLogin;
import br.com.infox.telas.telaConfirma;
import br.com.infox.telas.TelaPrincipal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz
 */
public class PendenciaDAO {
    
    public List<Pendencia> read() {

        Connection conexao = ModuloConexao.conector();
        
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Pendencia> pendencia = new ArrayList<>();

        try {
            pst = conexao.prepareStatement("SELECT * FROM pendencia");
            rs = pst.executeQuery();

            while (rs.next()) {

                Pendencia pendencias = new Pendencia();

                pendencias.setCausaRaiz(rs.getString("causaRaiz"));
                pendencias.setTipo(rs.getString("tipo"));
                pendencias.setOrigem(rs.getString("origem"));
                pendencias.setDataPendencia(rs.getString("dataPendencia"));
                pendencias.setSetorOperacaoPendencia(rs.getString("setorOperacaoPendencia"));
                pendencias.setCriticidade(rs.getString("criticidade"));
                pendencias.setOrdemServico(rs.getInt("ordemServico"));
                pendencias.setSolicitaCompra(rs.getInt("solicitaCompra"));
                pendencias.setStatusPendencia(rs.getString("statusPendencia"));
                
                
                
              pendencia.add(pendencias);
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(PendenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           //ModuloConexao.closeConnection(conexao, pst, rs);
        }

       return pendencia;

}
    
    
    public List<Pendencia> readForDesc(String desc) {
       
    
        Connection conexao = ModuloConexao.conector();
        
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Pendencia> pendDesc = new ArrayList<>();

        try {
            pst = conexao.prepareStatement("SELECT * FROM pendencia WHERE setorOperacaoPendencia LIKE ?");
            pst.setString(1, "%"+desc+"%");
            
            rs = pst.executeQuery();

            while (rs.next()) {

                Pendencia pendenciaDesc = new Pendencia();

                pendenciaDesc.setCausaRaiz(rs.getString("causaRaiz"));
                pendenciaDesc.setTipo(rs.getString("tipo"));
                pendenciaDesc.setOrigem(rs.getString("origem"));
                pendenciaDesc.setDataPendencia(rs.getString("dataPendencia"));
                 pendenciaDesc.setSetorOperacaoPendencia(rs.getString("setorOperacaoPendencia"));
                pendenciaDesc.setCriticidade(rs.getString("criticidade"));
                pendenciaDesc.setOrdemServico(rs.getInt("ordemServico"));
                pendenciaDesc.setSolicitaCompra(rs.getInt("solicitaCompra"));
                pendenciaDesc.setStatusPendencia(rs.getString("statusPendencia"));
                        
               pendDesc.add(pendenciaDesc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PendenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           // ModuloConexao.closeConnection(conexao, pst, rs);
        }

        return pendDesc;
    
    
    
}
    
    
    
    
    
      public List<Pendencia> lerComDetalhes(String setor, String causa, String tipo) {
       
    
        Connection conexao = ModuloConexao.conector();
        
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Pendencia> pendDesc = new ArrayList<>();

        try {
            pst = conexao.prepareStatement("SELECT * FROM pendencia WHERE setorOperacaoPendencia=? and causaRaiz=? and tipo=?");
            pst.setString(1, setor);
            pst.setString(2, causa);
            pst.setString(3, tipo);
            
            rs = pst.executeQuery();

            while (rs.next()) {

                Pendencia pendenciaDesc = new Pendencia();

                
                pendenciaDesc.setOrigem(rs.getString("origem"));
                pendenciaDesc.setOrdemServico(rs.getInt("ordemServico"));
                pendenciaDesc.setSolicitaCompra(rs.getInt("solicitaCompra"));
                        
               pendDesc.add(pendenciaDesc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PendenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           // ModuloConexao.closeConnection(conexao, pst, rs);
        }

        return pendDesc;
    
    
    
}
    
    
    
    
    
    
    

}
