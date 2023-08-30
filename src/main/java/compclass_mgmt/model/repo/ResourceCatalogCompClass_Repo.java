package compclass_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import compclass_mgmt.model.master.ResourceCatalogCompClass;
import compclass_mgmt.model.master.ResourceCatalogCompClassPK;

@Repository("resourceCatalogCompClassRepo")
public interface ResourceCatalogCompClass_Repo extends JpaRepository<ResourceCatalogCompClass, ResourceCatalogCompClassPK> 
{
	@Query(value = "SELECT * FROM RESOURCE_CATALOG_COMPANIES a WHERE (a.company_class_seq_no in :ids) order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogCompClass> getSelectResourceCatalogCompanyClasses(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_COMPANIES a WHERE a.resource_catalog_seq_no in :ids order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogCompClass> getSelectResourceCatalogsCompanyClassesForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_COMPANIES a WHERE (a.company_class_seq_no in :cids)", nativeQuery = true)
	void delSelectResourceCatalogCompanyClasses(@Param("fids") ArrayList<Long> cids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_COMPANIES a WHERE a.resource_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectResourceCatalogsCompanyClassesForCatalogs(@Param("ids") ArrayList<Long> ids);

}
