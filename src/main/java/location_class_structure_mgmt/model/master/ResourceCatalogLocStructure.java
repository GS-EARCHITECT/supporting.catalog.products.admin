package location_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_CATALOG_LOCSTRUCTURE database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_CATALOG_LOCSTRUCTURE")
public class ResourceCatalogLocStructure implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResourceCatalogLocStructurePK id;

	public ResourceCatalogLocStructure() {
	}

	public ResourceCatalogLocStructurePK getId() {
		return this.id;
	}

	public void setId(ResourceCatalogLocStructurePK id) {
		this.id = id;
	}

	public ResourceCatalogLocStructure(ResourceCatalogLocStructurePK id) {
		super();
		this.id = id;
	}

}