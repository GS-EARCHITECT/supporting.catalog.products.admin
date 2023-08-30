package compclass_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_CATALOG_COMPCLASSES database table.
 * 
 */
@Embeddable
public class ResourceCatalogCompClassPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "RESOURCE_CATALOG_SEQ_NO")
	private Long resourceCatalogSeqNo;

	@Column(name = "COMPANY_CLASS_SEQ_NO")
	private Long companyClassSeqNo;

	public ResourceCatalogCompClassPK() {
	}

	public Long getResourceCatalogSeqNo() {
		return this.resourceCatalogSeqNo;
	}

	public void setResourceCatalogSeqNo(Long resourceCatalogSeqNo) {
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
	}

	public Long getCompanyClassSeqNo() {
		return this.companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ResourceCatalogCompClassPK)) {
			return false;
		}
		ResourceCatalogCompClassPK castOther = (ResourceCatalogCompClassPK) other;
		return (this.resourceCatalogSeqNo == castOther.resourceCatalogSeqNo)
				&& (this.companyClassSeqNo == castOther.companyClassSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.resourceCatalogSeqNo ^ (this.resourceCatalogSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.companyClassSeqNo ^ (this.companyClassSeqNo >>> 32)));
		return hash;
	}

	public ResourceCatalogCompClassPK(Long resourceCatalogSeqNo, Long companyClassSeqNo) {
		super();
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
		this.companyClassSeqNo = companyClassSeqNo;
	}

}