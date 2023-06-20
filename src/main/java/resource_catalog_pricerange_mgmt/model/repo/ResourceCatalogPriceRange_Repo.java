package resource_catalog_pricerange_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import resource_catalog_pricerange_mgmt.model.master.ResourceCatalogPriceRange;
import resource_catalog_pricerange_mgmt.model.master.ResourceCatalogPriceRangePK;

@Repository("resourceCatalogPriceRangeRepo")
public interface ResourceCatalogPriceRange_Repo extends JpaRepository<ResourceCatalogPriceRange, ResourceCatalogPriceRangePK> 
{

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_TIMERANGE a WHERE (a.resource_catalog_SEQ_NO in :ids and ((:frPrice >= b.price_fr and :frPrice <= b.price_to) and (:toPrice >= b.price_fr and :toPrice <= b.price_to)) order by resource_catalog_SEQ_NO", nativeQuery = true)
	ArrayList<ResourceCatalogPriceRange> getSelectResourceCatalogsBetweenPrices(@Param("ids") ArrayList<Long> ids,
	@Param("frPrice") Float frPrice, @Param("toPrice") Float toPrice);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_TIMERANGE a WHERE (a.resource_class_seq_no in :ids) order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogPriceRange> getSelectResourceCatalogsPriceRanges(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_TIMERANGE a WHERE ((:frPrice >= b.price_fr and :frPrice <= b.price_to) and (:toPrice >= b.price_fr and :toPrice <= b.price_to)) order by resource_catalog_SEQ_NO", nativeQuery = true)
	ArrayList<ResourceCatalogPriceRange> getSelectResourceCatalogsForPriceRange(@Param("frPrice") Float frPrice, @Param("toPrice") Float toPrice);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_TIMERANGE a WHERE (a.resource_catalog_SEQ_NO in :ids and ((:frPrice >= b.price_fr and :frPrice <= b.price_to) and (:toPrice >= b.price_fr and :toPrice <= b.price_to)))", nativeQuery = true)
	void delSelectResourceCatalogsBetweenPrices(@Param("ids") ArrayList<Long> ids, @Param("frPrice") Float frPrice, @Param("toPrice") Float toPrice);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_TIMERANGE a WHERE (a.resource_class_seq_no in :ids)", nativeQuery = true)
	void deltSelectResourceCatalogsPriceRanges(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_TIMERANGE a WHERE ((:frPrice >= b.price_fr and :frPrice <= b.price_to) and (:toPrice >= b.price_fr and :toPrice <= b.price_to))", nativeQuery = true)
	void delSelectResourceCatalogsForPriceRange(@Param("frPrice") Float frPrice, @Param("toPrice") Float toPrice);
}
