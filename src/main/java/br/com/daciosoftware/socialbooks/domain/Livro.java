package br.com.daciosoftware.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Livro {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo nome é obrigatório")
	@Size(max = 60, message = "Campo nome máxido de 60 caracteres")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo editora é obrigatório")
	@Size(max = 30, message = "Campo editora máxido de 30 caracteres")
	private String editora;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyy")
	@NotNull(message = "Campo publicação é obrigatório")
	private Date publicacao;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo resumo é obrigatório")
	@Size(max = 1500, message = "Campo resumo máxido de 1500 caracteres")
	private String resumo;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "livro", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	private List<Comentario> comentarios;
	
	@JsonInclude(Include.NON_NULL)
	@ManyToOne()
	@JoinColumn(name = "id_autor")
	@NotNull(message = "Campor autor é obrigatório")
	private Autor autor;
	
	public Livro() {
		
	}
	
	public Livro(String nome) {
		this.nome = nome;
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
	public Date getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
	
}
