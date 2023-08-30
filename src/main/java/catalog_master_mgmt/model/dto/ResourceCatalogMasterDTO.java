package catalog_master_mgmt.model.dto;

import java.io.Serializable;

public class ResourceCatalogMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1677962323390184347L;
	private Long resourceCatalogSeqNo;
	private Long companySeqNo;
	private String catalog;
	private String fromDttm;
	private String remark;
	private String status;
	private String toDttm;

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

	public String getFromDttm() {
		return fromDttm;
	}

	public void setFromDttm(String fromDttm) {
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

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public ResourceCatalogMasterDTO() {
		super();
	}

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public ResourceCatalogMasterDTO(Long resourceCatalogSeqNo, Long companySeqNo, String catalog, String fromDttm,
			String remark, String status, String toDttm) {
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