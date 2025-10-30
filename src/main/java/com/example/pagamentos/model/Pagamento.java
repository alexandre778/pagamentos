package com.example.pagamentos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_empresa", nullable = false)
    private String nomeEmpresa;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_imposto", nullable = false)
    private TipoImposto tipoImposto;

    @Column(name = "pis_debito", columnDefinition = "DECIMAL(15,2) DEFAULT 0")
    private BigDecimal pisDebito = BigDecimal.ZERO;

    @Column(name = "pis_credito", columnDefinition = "DECIMAL(15,2) DEFAULT 0")
    private BigDecimal pisCredito = BigDecimal.ZERO;

    @Column(name = "ipi_frete", columnDefinition = "DECIMAL(15,2) DEFAULT 0")
    private BigDecimal ipiFrete = BigDecimal.ZERO;

    @Column(name = "ipi_seguro", columnDefinition = "DECIMAL(15,2) DEFAULT 0")
    private BigDecimal ipiSeguro = BigDecimal.ZERO;

    @Column(name = "ipi_outras", columnDefinition = "DECIMAL(15,2) DEFAULT 0")
    private BigDecimal ipiOutras = BigDecimal.ZERO;

    @Column(name = "ipi_aliquota", columnDefinition = "DECIMAL(10,4) DEFAULT 0")
    private BigDecimal ipiAliquota = BigDecimal.ZERO;

    @Column(name = "ipi_valor_produto", columnDefinition = "DECIMAL(15,2) DEFAULT 0")
    private BigDecimal ipiValorProduto = BigDecimal.ZERO;

    @Column(length = 500)
    private String descricao;

    @Column(name = "valor_calculado", columnDefinition = "DECIMAL(15,2) DEFAULT 0")
    private BigDecimal valorCalculado = BigDecimal.ZERO;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm = LocalDateTime.now();

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeEmpresa() { return nomeEmpresa; }
    public void setNomeEmpresa(String nomeEmpresa) { this.nomeEmpresa = nomeEmpresa; }
    public TipoImposto getTipoImposto() { return tipoImposto; }
    public void setTipoImposto(TipoImposto tipoImposto) { this.tipoImposto = tipoImposto; }
    public BigDecimal getPisDebito() { return pisDebito; }
    public void setPisDebito(BigDecimal pisDebito) { this.pisDebito = pisDebito; }
    public BigDecimal getPisCredito() { return pisCredito; }
    public void setPisCredito(BigDecimal pisCredito) { this.pisCredito = pisCredito; }
    public BigDecimal getIpiFrete() { return ipiFrete; }
    public void setIpiFrete(BigDecimal ipiFrete) { this.ipiFrete = ipiFrete; }
    public BigDecimal getIpiSeguro() { return ipiSeguro; }
    public void setIpiSeguro(BigDecimal ipiSeguro) { this.ipiSeguro = ipiSeguro; }
    public BigDecimal getIpiOutras() { return ipiOutras; }
    public void setIpiOutras(BigDecimal ipiOutras) { this.ipiOutras = ipiOutras; }
    public BigDecimal getIpiAliquota() { return ipiAliquota; }
    public void setIpiAliquota(BigDecimal ipiAliquota) { this.ipiAliquota = ipiAliquota; }
    public BigDecimal getIpiValorProduto() { return ipiValorProduto; }
    public void setIpiValorProduto(BigDecimal ipiValorProduto) { this.ipiValorProduto = ipiValorProduto; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getValorCalculado() { return valorCalculado; }
    public void setValorCalculado(BigDecimal valorCalculado) { this.valorCalculado = valorCalculado; }
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}

