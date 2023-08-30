package resource_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_CATALOG_PRODSTRUCTURE database table.
 * 
 */
@Embeddable
public class ResourceCatalogProdStructurePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "RESOURCE_CLASS_SEQ_NO")
	private Long resourceClassSeqNo;

	@Column(name = "PAR_RESOURCE_CLASS_SEQ_NO")
	private Long parResourceClassSeqNo;

	@Column(name = "RESOURCE_CATALOG_SEQ_NO")
	private Long resourceCatalogSeqNo;

	public ResourceCatalogProdStructurePK() {
	}

	public Long getResourceClassSeqNo() {
		return this.resourceClassSeqNo;
	}

	public void setResourceClassSeqNo(Long resourceClassSeqNo) {
		this.resourceClassSeqNo = resourceClassSeqNo;
	}

	public Long getParResourceClassSeqNo() {
		return this.parResourceClassSeqNo;
	}

	public void setParResourceClassSeqNo(Long parResourceClassSeqNo) {
		this.parResourceClassSeqNo = parResourceClassSeqNo;
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
		if (!(other instanceof ResourceCatalogProdStructurePK)) {
			return false;
		}
		ResourceCatalogProdStructurePK castOther = (ResourceCatalogProdStructurePK) other;
		return (this.resourceClassSeqNo == castOther.resourceClassSeqNo)
				&& (this.parResourceClassSeqNo == castOther.parResourceClassSeqNo)
				&& (this.resourceCatalogSeqNo == castOther.resourceCatalogSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.resourceClassSeqNo ^ (this.resourceClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parResourceClassSeqNo ^ (this.parResourceClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.resourceCatalogSeqNo ^ (this.resourceCatalogSeqNo >>> 32)));

		return hash;
	}

	public ResourceCatalogProdStructurePK(Long resourceClassSeqNo, Long parResourceClassSeqNo,
			Long resourceCatalogSeqNo) {
		super();
		this.resourceClassSeqNo = resourceClassSeqNo;
		this.parResourceClassSeqNo = parResourceClassSeqNo;
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
	}

}