/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.model.bean;

/**
 *
 * @author luiz
 */
public class Pendencia {
     private String causaRaiz;
    private String dataPendencia;
    private String setorOperacaoPendencia;
    private String tipo;
    private String origem;
    private int idPendencia;
    private String dataPreviaTermino;
    private String acaoTomadaAdm;
    private String criticidade;
    private int ordemServico;
    private int solicitaCompra;
    private String statusPendencia;

    
    

    public String getCausaRaiz() {
        return causaRaiz;
    }

    public void setCausaRaiz(String causaRaiz) {
        this.causaRaiz = causaRaiz;
    }

    public String getDataPendencia() {
        return dataPendencia;
    }

    public void setDataPendencia(String dataPendencia) {
        this.dataPendencia = dataPendencia;
    }

    public String getSetorOperacaoPendencia() {
        return setorOperacaoPendencia;
    }

    public void setSetorOperacaoPendencia(String setorOperacaoPendencia) {
        this.setorOperacaoPendencia = setorOperacaoPendencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getIdPendencia() {
        return idPendencia;
    }

    public void setIdPendencia(int idPendencia) {
        this.idPendencia = idPendencia;
    }

    public String getDataPreviaTermino() {
        return dataPreviaTermino;
    }

    public void setDataPreviaTermino(String dataPreviaTermino) {
        this.dataPreviaTermino = dataPreviaTermino;
    }

    public String getAcaoTomadaAdm() {
        return acaoTomadaAdm;
    }

    public void setAcaoTomadaAdm(String acaoTomadaAdm) {
        this.acaoTomadaAdm = acaoTomadaAdm;
    }

    public String getCriticidade() {
        return criticidade;
    }

    public void setCriticidade(String criticidade) {
        this.criticidade = criticidade;
    }

    public int getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(int ordemServico) {
        this.ordemServico = ordemServico;
    }

    public int getSolicitaCompra() {
        return solicitaCompra;
    }

    public void setSolicitaCompra(int solicitaCompra) {
        this.solicitaCompra = solicitaCompra;
    }

    public String getStatusPendencia() {
        return statusPendencia;
    }

    public void setStatusPendencia(String statusPendencia) {
        this.statusPendencia = statusPendencia;
    }
    
}
