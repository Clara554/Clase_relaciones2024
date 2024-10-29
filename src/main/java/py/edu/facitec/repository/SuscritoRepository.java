package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.facitec.model.Suscrito;
                                                       //Entidad Tipo de dato del pak    
public interface SuscritoRepository extends JpaRepository<Suscrito, Long> {
	

}
