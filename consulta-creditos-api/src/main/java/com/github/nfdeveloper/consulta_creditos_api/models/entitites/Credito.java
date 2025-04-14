package com.github.nfdeveloper.consulta_creditos_api.models.entitites;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="credito")
public class Credito {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "numero_credito")
    private String numeroCredito;
	
    @Column(name = "numero_nfse")
    private String numeroNfse;
	
    @Column(name = "data_constituicao")
    private LocalDate dataConstituicao;
	
    @Column(name = "valor_issqn")
    private BigDecimal valorIssqn;
	
    @Column(name = "tipo_credito")
    private String tipoCredito;
	
    @Column(name = "simples_nacional")
    private boolean simplesNacional;
	
    @Column(name = "aliquota")
    private BigDecimal aliquota;
	
    @Column(name = "valor_faturado")
    private BigDecimal valorFaturado;
	
    @Column(name = "valor_deducao")
    private BigDecimal valorDeducao;
	
    @Column(name = "base_calculo")
    private BigDecimal baseCalculo;

    public Credito() {
    }

    public Credito(Long id, String numeroCredito, String numeroNfse, LocalDate dataConstituicao, BigDecimal valorIssqn,
            String tipoCredito, boolean simplesNacional, BigDecimal aliquota, BigDecimal valorFaturado,
            BigDecimal valorDeducao, BigDecimal baseCalculo) {
        this.id = id;
        this.numeroCredito = numeroCredito;
        this.numeroNfse = numeroNfse;
        this.dataConstituicao = dataConstituicao;
        this.valorIssqn = valorIssqn;
        this.tipoCredito = tipoCredito;
        this.simplesNacional = simplesNacional;
        this.aliquota = aliquota;
        this.valorFaturado = valorFaturado;
        this.valorDeducao = valorDeducao;
        this.baseCalculo = baseCalculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public void setNumeroCredito(String numeroCredito) {
        this.numeroCredito = numeroCredito;
    }

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public void setNumeroNfse(String numeroNfse) {
        this.numeroNfse = numeroNfse;
    }

    public LocalDate getDataConstituicao() {
        return dataConstituicao;
    }

    public void setDataConstituicao(LocalDate dataConstituicao) {
        this.dataConstituicao = dataConstituicao;
    }

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public void setValorIssqn(BigDecimal valorIssqn) {
        this.valorIssqn = valorIssqn;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public boolean getIsSimplesNacional() {
        return simplesNacional;
    }

    public void setSimplesNacional(boolean simplesNacional) {
        this.simplesNacional = simplesNacional;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getValorFaturado() {
        return valorFaturado;
    }

    public void setValorFaturado(BigDecimal valorFaturado) {
        this.valorFaturado = valorFaturado;
    }

    public BigDecimal getValorDeducao() {
        return valorDeducao;
    }

    public void setValorDeducao(BigDecimal valorDeducao) {
        this.valorDeducao = valorDeducao;
    }

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(BigDecimal baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    
}
