package com.ecommerce.domain.model;

<<<<<<< HEAD

import java.math.BigDecimal;
=======
>>>>>>> 471787e (feat(Model):Update)
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto {


  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome", nullable = false)
  private String nome;

  @Column(name = "descricao", nullable = false)
  private String descricao;

  @Column(name = "qtd_estoque", nullable = false)
  private Long quantidadeEstoque;

  @Column(name = "data_cadastro")
  private Date dataCadastro;

  @Column(name = "valor_unitario", nullable = false)
  private BigDecimal valorUnitario;
  //imagem
  //id_categoria
  
<<<<<<< HEAD
=======
    @Column(name = "nome",nullable = false)
    private String nome;
  
    @Column(name = "descricao", nullable = false)
    private String descricao;
  
    @Column(name = "qtd_estoque", nullable = false)
    private Long quantidadeEstoque;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

	// imagem

>>>>>>> 471787e (feat(Model):Update)
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@OneToOne
	private ItemPedido itemPedido;

<<<<<<< HEAD
=======
	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Long quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	

>>>>>>> 471787e (feat(Model):Update)
}
