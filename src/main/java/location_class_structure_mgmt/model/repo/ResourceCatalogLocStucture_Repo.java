package location_class_structure_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import location_class_structure_mgmt.model.master.ResourceCatalogLocStructure;
import location_class_structure_mgmt.model.master.ResourceCatalogLocStructurePK;

@Repository("resourceCatalogLocStuctureRepo")
public interface ResourceCatalogLocStucture_Repo extends JpaRepository<ResourceCatalogLocStructure, ResourceCatalogLocStructurePK> 
{
	@Query(value = "SELECT * FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE (a.location_class_seq_no in :ids and a.par_location_class_seq_no in :pids) order by location_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogLocStructure> getSelectResourceCatalogStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE a.resource_catalog_seq_no in :ids order by location_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogLocStructure> getSelectResourceCatalogsStructuresForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE (a.resource_catalog_seq_no in :ids and a.location_class_seq_no in :cids) order by location_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogLocStructure> getSelectResourceChildStructuresForCatalogs(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
	
	@Query(value = "DELETE FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE (a.location_class_seq_no in :ids and a.par_location_class_seq_no in :pids)", nativeQuery = true)
	void delSelectResourceCatalogStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE a.resource_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectResourceCatalogsStructuresForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE (a.resource_catalog_seq_no in :ids and a.location_class_seq_no in :cids)", nativeQuery = true)
	void delSelectResourceChildStructuresForCatalogs(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
}
