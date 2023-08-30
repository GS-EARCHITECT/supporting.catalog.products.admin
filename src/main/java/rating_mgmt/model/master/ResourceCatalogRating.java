package rating_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RESOURCE_CATALOG_RATINGS database table.
 * 
 */
@Entity
@Table(name="RESOURCE_CATALOG_RATINGS")
@NamedQuery(name="ResourceCatalogRating.findAll", query="SELECT r FROM ResourceCatalogRating r")
public class ResourceCatalogRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResourceCatalogRatingPK id;

	public ResourceCatalogRating() {
	}

	public ResourceCatalogRatingPK getId() {
		return this.id;
	}

	public void setId(ResourceCatalogRatingPK id) {
		this.id = id;
	}

}