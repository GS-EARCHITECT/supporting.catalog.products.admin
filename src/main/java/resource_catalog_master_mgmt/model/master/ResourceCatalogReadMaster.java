package resource_catalog_master_mgmt.model.master;

import java.io.Serializable;

public class ResourceCatalogReadMaster implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6962854301744333635L;
	private Long resourceCatalogSeqNo;
	private Long companySeqNo;
	private String catalog;
	private String remark;
	private String status;

	public ResourceCatalogReadMaster() {
	}

	public Long getResourceCatalogSeqNo() {
		return resourceCatalogSeqNo;
	}

	public void setResourceCatalogSeqNo(Long resourceCatalogSeqNo) {
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
	}

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime * result + ((companySeqNo == null) ? 0 : companySeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((resourceCatalogSeqNo == null) ? 0 : resourceCatalogSeqNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ResourceCatalogReadMaster other = (ResourceCatalogReadMaster) obj;
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
		return true;
	}

	public ResourceCatalogReadMaster(Long resourceCatalogSeqNo, Long companySeqNo, String catalog, String remark,
			String status) {
		super();
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
		this.companySeqNo = companySeqNo;
		this.catalog = catalog;
		this.remark = remark;
		this.status = status;
	}


}