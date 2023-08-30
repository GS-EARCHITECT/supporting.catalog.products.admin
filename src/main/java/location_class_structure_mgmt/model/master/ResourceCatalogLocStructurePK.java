package location_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_CATALOG_LOCSTRUCTURE database table.
 * 
 */
@Embeddable
public class ResourceCatalogLocStructurePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "PAR_PLACE_CLASS_SEQ_NO")
	private Long parPlaceClassSeqNo;

	@Column(name = "PLACE_CLASS_SEQ_NO")
	private Long placeClassSeqNo;

	@Column(name = "RESOURCE_CATALOG_SEQ_NO")
	private Long resourceCatalogSeqNo;

	public ResourceCatalogLocStructurePK() {
	}

	public Long getParPlaceClassSeqNo() {
		return this.parPlaceClassSeqNo;
	}

	public void setParPlaceClassSeqNo(Long parPlaceClassSeqNo) {
		this.parPlaceClassSeqNo = parPlaceClassSeqNo;
	}

	public Long getPlaceClassSeqNo() {
		return this.placeClassSeqNo;
	}

	public void setPlaceClassSeqNo(Long placeClassSeqNo) {
		this.placeClassSeqNo = placeClassSeqNo;
	}

	public Long getResourceCatalogSeqNo() {
		return this.resourceCatalogSeqNo;
	}

	public void setResourceCatalogSeqNo(Long resourceCatalogSeqNo) {
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ResourceCatalogLocStructurePK)) {
			return false;
		}
		ResourceCatalogLocStructurePK castOther = (ResourceCatalogLocStructurePK) other;
		return (this.parPlaceClassSeqNo == castOther.parPlaceClassSeqNo)
				&& (this.placeClassSeqNo == castOther.placeClassSeqNo)
				&& (this.resourceCatalogSeqNo == castOther.resourceCatalogSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.parPlaceClassSeqNo ^ (this.parPlaceClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.placeClassSeqNo ^ (this.placeClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.resourceCatalogSeqNo ^ (this.resourceCatalogSeqNo >>> 32)));

		return hash;
	}

	public ResourceCatalogLocStructurePK(Long parPlaceClassSeqNo, Long placeClassSeqNo, Long resourceCatalogSeqNo) {
		super();
		this.parPlaceClassSeqNo = parPlaceClassSeqNo;
		this.placeClassSeqNo = placeClassSeqNo;
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
	}

}