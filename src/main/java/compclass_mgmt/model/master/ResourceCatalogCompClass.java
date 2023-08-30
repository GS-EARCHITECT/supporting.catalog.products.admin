package compclass_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_CATALOG_COMPCLASSES database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_CATALOG_COMPCLASSES")
public class ResourceCatalogCompClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResourceCatalogCompClassPK id;

	public ResourceCatalogCompClass() {
	}

	public ResourceCatalogCompClassPK getId() {
		return this.id;
	}

	public void setId(ResourceCatalogCompClassPK id) {
		this.id = id;
	}

	public ResourceCatalogCompClass(ResourceCatalogCompClassPK id) {
		super();
		this.id = id;
	}

}