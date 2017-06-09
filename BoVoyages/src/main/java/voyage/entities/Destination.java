package voyage.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <b>Destination est une classe représentant la destination d'un voyage.</b>
 * <p>
 * Une destination est caractérisée par :
 * <ul>
 * <li>Un continent</li>
 * <li>Un pays</li>
 * <li>Une région</li>
 * <li>Une description</li>
 * </ul>
 * <p>
 * 
 * @author Adminl
 * @version 2.0
 *
 */

@Entity
@Table(name="destinations")
@NamedQueries({
	@NamedQuery(name = "allDestinations", query = "SELECT d FROM Destination d"),
	@NamedQuery(name = "destinationByPays", query="SELECT d FROM Destination d WHERE d.pays = :p"),
	@NamedQuery(name = "allUniquePays",  query="SELECT DISTINCT d.pays FROM Destination d"),
	@NamedQuery(name="promotion", query="SELECT d from Destination d WHERE d.promotion= :b")
})
public class Destination implements Serializable {

	private static final long serialVersionUID = -267734845636580046L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_destination")
	private int id;	
	private String pays;
	private String continent; 
	private String region;
	private String description;
	private boolean promotion;
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_destination")
	private List<DatesVoyages> dates;


	public Destination() {}

	public Destination(String continent, String pays, String region, String description, boolean promotion) {
		super();
		
		this.pays = pays;
		this.continent = continent;
		this.region = region;
		this.description = description;
		this.promotion = promotion;
	}


	public String getPays() {
		if (pays != null) {
			return new String(pays);
		}
		return null;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRegion() {
		if (region != null) {
			return new String(region);
		}
		return null;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		if (description != null) {
			return new String(description);
		}
		return null;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<DatesVoyages> getDates() {
		return dates;
	}

	public void setDates(List<DatesVoyages> dates) {
		this.dates = dates;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dates == null) ? 0 : dates.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + (promotion ? 1231 : 1237);
		result = prime * result + ((region == null) ? 0 : region.hashCode());
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
		Destination other = (Destination) obj;
		if (dates == null) {
			if (other.dates != null)
				return false;
		} else if (!dates.equals(other.dates))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		if (promotion != other.promotion)
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}

	public void addDate(DatesVoyages dv) {
		dates.add(dv);
	}
	
	public void removeDate(DatesVoyages dv) {
		dates.remove(dv);
	}

	public boolean isPromotion() {
		return promotion;
	}

	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

}
