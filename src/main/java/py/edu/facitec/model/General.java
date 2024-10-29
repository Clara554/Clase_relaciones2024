package py.edu.facitec.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

//Aplicacion de Herencia 
//para la persistecia
@MappedSuperclass
public abstract class General {
	
	@Id             //Para crear pk de la bd
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "General [id=" + id + "]";
	}
	
	
	
	
	

}
