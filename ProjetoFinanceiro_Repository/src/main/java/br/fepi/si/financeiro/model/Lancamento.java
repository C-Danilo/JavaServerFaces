package br.fepi.si.financeiro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity	//MBean
@Table(name = "lancamento")	//MBean
public class Lancamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Pessoa pessoa;
	private String descricao;
	private BigDecimal valor;
	private TipoLancamentoEnum tipo;
	private Date dataVencimento;
	private Date dataPagamento;
	
	@Id //MBean
	@GeneratedValue //MBean
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull//BeanValidation
	@ManyToOne(optional = false) //MBean
	@JoinColumn(name = "pessoa_id") //MBean
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@NotEmpty //BeanValidation
	@Size(max = 60) //BeanValidation
	@Column(length = 40, nullable =	false) //MBean
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
	@NotNull //BeanValidation
	@DecimalMin ("0") //BeanValidation
	@Column(precision = 10, scale = 2, nullable = false) //MBean
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}	
	
	@NotNull //BeanValidation
	@Enumerated (EnumType.STRING) //MBean
	@Column(nullable = false) //MBean
	public TipoLancamentoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoLancamentoEnum tipo) {
		this.tipo = tipo;
	}
	
	@NotNull //BeanValidation
	@Temporal(TemporalType.DATE) //MBean
	@Column(name = "data_vencimento", nullable = false) //MBean
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@Temporal(TemporalType.DATE) //MBean
	@Column(name = "data_pagamento", nullable = true) //MBean
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
