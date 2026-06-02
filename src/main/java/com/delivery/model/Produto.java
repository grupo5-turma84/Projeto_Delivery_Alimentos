package com.delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 @NotBlank(message = "O nome é obrigatório")
	    private String nome;
	 @NotBlank(message = "A descrição é obrigatória")
	    private String descricao;
	 @NotNull(message = "O preço é obrigatório")
	    private Double preco;
	 @NotNull(message = "As calorias são obrigatórias")

	    private Integer calorias;

	    @ManyToOne
	    @JoinColumn(name = "usuario_id")
	    @JsonIgnoreProperties("produtos")
	    private Usuario usuario;

	    @ManyToOne
	    @JoinColumn(name = "categoria_id")
	    @JsonIgnoreProperties("produtos")
	    private Categoria categoria;
	    
	    private String foto;

	    public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
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

	    public Double getPreco() {
	        return preco;
	    }

	    public void setPreco(Double preco) {
	        this.preco = preco;
	    }

	    public Integer getCalorias() {
	        return calorias;
	    }

	    public void setCalorias(Integer calorias) {
	        this.calorias = calorias;
	    }

	    public Usuario getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(Usuario usuario) {
	        this.usuario = usuario;
	    }

	    public Categoria getCategoria() {
	        return categoria;
	    }

	    public void setCategoria(Categoria categoria) {
	        this.categoria = categoria;
	    }

}
