package voyage.rest;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import voyage.entities.Destination;

@Path("/promotions")
public class VoyageService {

	@PersistenceContext(unitName = "bovoyagefinale")
	private EntityManager em;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Destination[] getDestinationPromo(){
		
		List<Destination> liste = em.createNamedQuery("promotion").setParameter("b", true).getResultList();
		return liste.toArray(new Destination[0]);
		
	}
}
