package catalog_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the RESOURCE_CATALOG_MASTER database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_CATALOG_MASTER")
public class ResourceCatalogMaster implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1684688624624285250L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESOURCE_CATALOG_SEQUENCE")
	@SequenceGenerator(name = "RESOURCE_CATALOG_SEQUENCE", sequenceName = "RESOURCE_CATALOG_SEQUENCE", allocationSize = 1)
	@Column(name = "RESOURCE_CATALOG_SEQ_NO")
	private Long resourceCatalogSeqNo;

	@Column(name = "COMPANY_SEQ_NO")
	private Long companySeqNo;

	@Column(name = "CATALOG")
	private String catalog;

	@Column(name = "FROM_DTTM")
	private Timestamp fromDttm;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public ResourceCatalogMaster() {
	}

	public Long getResourceCatalogSeqNo() {
		return resourceCatalogSeqNo;
	}

	public void setResourceCatalogSeqNo(Long resourceCatalogSeqNo) {
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public Timestamp getFromDttm() {
		return fromDttm;
	}

	public void setFromDttm(Timestamp fromDttm) {
		this.fromDttm = fromDttm;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getToDttm() {
		return toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime * result + ((companySeqNo == null) ? 0 : companySeqNo.hashCode());
		result = prime * result + ((fromDttm == null) ? 0 : fromDttm.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((resourceCatalogSeqNo == null) ? 0 : resourceCatalogSeqNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((toDttm == null) ? 0 : toDttm.hashCode());
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
		ResourceCatalogMaster other = (ResourceCatalogMaster) obj;
		if (catalog == null) {
			if (other.catalog != null)
				return false;
		} else if (!catalog.equals(other.catalog))
			return false;
		if (companySeqNo == null) {
			if (other.companySeqNo != null)
				return false;
		} else if (!companySeqNo.equals(other.companySeqNo))
			return false;
		if (fromDttm == null) {
			if (other.fromDttm != null)
				return false;
		} else if (!fromDttm.equals(other.fromDttm))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (resourceCatalogSeqNo == null) {
			if (other.resourceCatalogSeqNo != null)
				return false;
		} else if (!resourceCatalogSeqNo.equals(other.resourceCatalogSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (toDttm == null) {
			if (other.toDttm != null)
				return false;
		} else if (!toDttm.equals(other.toDttm))
			return false;
		return true;
	}

	public ResourceCatalogMaster(Long resourceCatalogSeqNo, Long companySeqNo, String catalog, Timestamp fromDttm,
			String remark, String status, Timestamp toDttm) {
		super();
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
		this.companySeqNo = companySeqNo;
		this.catalog = catalog;
		this.fromDttm = fromDttm;
		this.remark = remark;
		this.status = status;
		this.toDttm = toDttm;
	}

}