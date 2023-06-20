package resource_catalog_pricerange_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_CATALOG_PRICERANGE database table.
 * 
 */
@Embeddable
public class ResourceCatalogPriceRangePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "PRICE_FR")
	private Float priceFr;

	@Column(name = "RESOURCE_CATALOG_SEQ_NO")
	private Long resourceCatalogSeqNo;

	@Column(name = "PRICE_TO")
	private Float priceTo;

	public ResourceCatalogPriceRangePK() {
	}

	public Float getPriceFr() {
		return this.priceFr;
	}

	public void setPriceFr(Float priceFr) {
		this.priceFr = priceFr;
	}

	public Long getResourceCatalogSeqNo() {
		return this.resourceCatalogSeqNo;
	}

	public void setResourceCatalogSeqNo(Long resourceCatalogSeqNo) {
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
	}

	public Float getPriceTo() {
		return this.priceTo;
	}

	public void setPriceTo(Float priceTo) {
		this.priceTo = priceTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((priceFr == null) ? 0 : priceFr.hashCode());
		result = prime * result + ((priceTo == null) ? 0 : priceTo.hashCode());
		result = prime * result + ((resourceCatalogSeqNo == null) ? 0 : resourceCatalogSeqNo.hashCode());
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
		ResourceCatalogPriceRangePK other = (ResourceCatalogPriceRangePK) obj;
		if (priceFr == null) {
			if (other.priceFr != null)
				return false;
		} else if (!priceFr.equals(other.priceFr))
			return false;
		if (priceTo == null) {
			if (other.priceTo != null)
				return false;
		} else if (!priceTo.equals(other.priceTo))
			return false;
		if (resourceCatalogSeqNo == null) {
			if (other.resourceCatalogSeqNo != null)
				return false;
		} else if (!resourceCatalogSeqNo.equals(other.resourceCatalogSeqNo))
			return false;
		return true;
	}

	public ResourceCatalogPriceRangePK(Float priceFr, Long resourceCatalogSeqNo, Float priceTo) {
		super();
		this.priceFr = priceFr;
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
		this.priceTo = priceTo;
	}

}