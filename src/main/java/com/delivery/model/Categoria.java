package com.delivery.model;
import java.util.List;
import jakarta.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  @NotBlank(message = "A descrição é obrigatória")
	    private String descricao;

	  @OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	  @JsonIgnoreProperties("categoria")
	  private List<Produto> produtos;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }

	    public List<Produto> getProdutos() {
	        return produtos;
	    }

	    public void setProdutos(List<Produto> produtos) {
	        this.produtos = produtos;
	    }

}
