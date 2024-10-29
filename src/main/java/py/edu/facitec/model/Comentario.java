package py.edu.facitec.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Comentario extends General{
	
	private String texto;
	private Integer estrella;
	
	//Relacion de muchos a uno
	//Cuando la lista es más importante.
	@JsonBackReference(value = "relacion1")
	@ManyToOne
	private Post post;
	
	@ManyToOne
	private Suscrito suscrito;
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getEstrella() {
		return estrella;
	}
	public void setEstrella(Integer estrella) {
		this.estrella = estrella;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Suscrito getSuscrito() {
		return suscrito;
	}
	public void setSuscrito(Suscrito suscrito) {
		this.suscrito = suscrito;
	}
	


	}
	
	


