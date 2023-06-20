package resource_catalog_rating_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_CATALOG_RATINGS database table.
 * 
 */
@Embeddable
public class ResourceCatalogRatingPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "RESOURCE_CATALOG_SEQ_NO")
	private Long resourceCatalogSeqNo;

	@Column(name = "RATING")
	private Float rating;

	public ResourceCatalogRatingPK() {
	}

	public Long getResourceCatalogSeqNo() {
		return this.resourceCatalogSeqNo;
	}

	public void setResourceCatalogSeqNo(Long resourceCatalogSeqNo) {
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
	}

	public Float getRating() {
		return this.rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public ResourceCatalogRatingPK(Long resourceCatalogSeqNo, Float rating) {
		super();
		this.resourceCatalogSeqNo = resourceCatalogSeqNo;
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
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
		ResourceCatalogRatingPK other = (ResourceCatalogRatingPK) obj;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (resourceCatalogSeqNo == null) {
			if (other.resourceCatalogSeqNo != null)
				return false;
		} else if (!resourceCatalogSeqNo.equals(other.resourceCatalogSeqNo))
			return false;
		return true;
	}

}