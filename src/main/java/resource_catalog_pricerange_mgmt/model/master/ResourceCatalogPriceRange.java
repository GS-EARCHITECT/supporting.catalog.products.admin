package resource_catalog_pricerange_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_CATALOG_PRICERANGE database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_CATALOG_PRICERANGE")
public class ResourceCatalogPriceRange implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResourceCatalogPriceRangePK id;

	public ResourceCatalogPriceRange() {
	}

	public ResourceCatalogPriceRangePK getId() {
		return this.id;
	}

	public void setId(ResourceCatalogPriceRangePK id) {
		this.id = id;
	}

	public ResourceCatalogPriceRange(ResourceCatalogPriceRangePK id) {
		super();
		this.id = id;
	}

}