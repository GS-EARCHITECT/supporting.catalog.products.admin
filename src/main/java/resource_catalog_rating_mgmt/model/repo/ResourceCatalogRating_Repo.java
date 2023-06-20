package resource_catalog_rating_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import resource_catalog_rating_mgmt.model.master.ResourceCatalogRating;
import resource_catalog_rating_mgmt.model.master.ResourceCatalogRatingPK;

@Repository("resourceCatalogRatingRepo")
public interface ResourceCatalogRating_Repo extends JpaRepository<ResourceCatalogRating, ResourceCatalogRatingPK> 
{
	@Query(value = "SELECT * FROM RESOURCE_CATALOG_RATINGS a WHERE (a.rating in :fids) order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogRating> getSelectResourceCatalogRatings(@Param("fids") ArrayList<Float> fids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_RATINGS a WHERE a.resource_catalog_seq_no in :ids order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogRating> getSelectResourceCatalogsRatingsForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_RATINGS a WHERE (a.rating in :fids)", nativeQuery = true)
	void delSelectResourceCatalogRatings(@Param("fids") ArrayList<Float> fids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_RATINGS a WHERE a.resource_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectResourceCatalogsRatingsForCatalogs(@Param("ids") ArrayList<Long> ids);
	
}
