package resource_catalog_resource_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_CATALOG_PRODSTRUCTURE database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_CATALOG_PRODSTRUCTURE")
public class ResourceCatalogProdStructure implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResourceCatalogProdStructurePK id;

	public ResourceCatalogProdStructure() {
	}

	public ResourceCatalogProdStructurePK getId() {
		return this.id;
	}

	public void setId(ResourceCatalogProdStructurePK id) {
		this.id = id;
	}

	public ResourceCatalogProdStructure(ResourceCatalogProdStructurePK id) {
		super();
		this.id = id;
	}

}