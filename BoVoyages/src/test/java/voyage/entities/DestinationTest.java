package voyage.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class DestinationTest {

	@Test
	public void testDestination() {
		Destination dest = new Destination();

		assertNull(dest.getPays());
		assertNull(dest.getRegion());
		assertNull(dest.getDescription());
		assertNull(dest.getContinent());
		assertEquals(0, dest.getId());
	

	}

	@Test
	public void testDestinationStringStringStringString() {

		Destination dest = new Destination("Continent","Pays", "Region", "Description","Image", true);

		assertEquals("Continent", dest.getContinent());
		assertEquals("Pays", dest.getPays());
		assertEquals("Region", dest.getRegion());
		assertEquals("Description", dest.getDescription());
		assertEquals("Image", dest.getImage());
		assertEquals(true, dest.isPromotion());
		assertEquals(0, dest.getId());
	}

	@Test
	public void testGetPays() {
		Destination dest = new Destination();
		dest.setPays("Pays");
		assertEquals("Pays", dest.getPays());
	}

	@Test
	public void testGetRegion() {
		Destination dest = new Destination();
		dest.setRegion("Region");
		assertEquals("Region", dest.getRegion());
	}

	@Test
	public void testGetDescription() {
		Destination dest = new Destination();
		dest.setDescription("Description");
		assertEquals("Description", dest.getDescription());
	}

	@Test
	public void testGetId() {
		Destination dest = new Destination();
		dest.setId(15);
		assertEquals(15, dest.getId());
	}

	@Test
	public void testGetContinent() {
		Destination dest = new Destination();
		dest.setContinent("Continent");
		assertEquals("Continent", dest.getContinent());
	}
	

	//@Test
//	public void testGetImage(){
		
	//	Destination dest = new Destination();
	//	dest.setImage("image");
		//assertEquals("image", dest.getImage());
	//}
	

}