package catalog_master_mgmt.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import catalog_master_mgmt.model.master.ResourceCatalogMaster;

@Repository("resourceCatalogMasterRepo")
public interface ResourceCatalogMasterRepo extends JpaRepository<ResourceCatalogMaster, Long> 
{
	@Query(value = "SELECT * FROM RESOURCE_CATALOG_MASTER a WHERE a.resource_catalog_seq_no in :ids order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogMaster> getSelectResourceCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_MASTER a WHERE a.company_seq_no in :ids order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogMaster> getSelectResourceCatalogsForCompanies(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM RESOURCE_CATALOG_MASTER a WHERE ((:fr BETWEEN a.FROM_DTTM and a.FROM_DTTM) and ( :to BETWEEN a.FROM_DTTM and a.FROM_DTTM)) order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogMaster> getSelectResourceCatalogsBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);
	
	@Query(value = "DELETE FROM RESOURCE_CATALOG_MASTER WHERE a.resource_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectResourceCatalogs(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELTE FROM RESOURCE_CATALOG_MASTER a WHERE ((:fr BETWEEN a.FROM_DTTM and a.FROM_DTTM) and ( :to BETWEEN a.FROM_DTTM and a.FROM_DTTM))", nativeQuery = true)
	void delSelectResourceCatalogsBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);
	
	@Query(value = "DELETE FROM RESOURCE_CATALOG_MASTER a WHERE a.company_seq_no in :ids", nativeQuery = true)
	void delSelectResourceCatalogsForCompanies(@Param("ids") ArrayList<Long> ids);
	
}
