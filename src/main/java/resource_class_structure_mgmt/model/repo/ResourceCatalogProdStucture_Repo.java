package resource_class_structure_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import resource_class_structure_mgmt.model.master.ResourceCatalogProdStructure;
import resource_class_structure_mgmt.model.master.ResourceCatalogProdStructurePK;

@Repository("resourceCatalogProdStuctureRepo")
public interface ResourceCatalogProdStucture_Repo extends JpaRepository<ResourceCatalogProdStructure, ResourceCatalogProdStructurePK> 
{
	@Query(value = "SELECT * FROM RESOURCE_CATALOG_PRODSTRUCTURE a WHERE (a.resource_class_seq_no in :ids and a.par_resource_class_seq_no in :pids) order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogProdStructure> getSelectResourceCatalogStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_PRODSTRUCTURE a WHERE a.company_catalog_seq_no in :ids order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogProdStructure> getSelectResourceCatalogsStructuresForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_PRODSTRUCTURE a WHERE (a.company_catalog_seq_no in :ids and a.resource_class_seq_no in :cids) order by resource_catalog_seq_no", nativeQuery = true)
	ArrayList<ResourceCatalogProdStructure> getSelectResourceChildStructuresForCatalogs(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
	
	@Query(value = "DELETE FROM RESOURCE_CATALOG_PRODSTRUCTURE a WHERE (a.resource_class_seq_no in :ids and a.par_resource_class_seq_no in :pids)", nativeQuery = true)
	void delSelectResourceCatalogStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_PRODSTRUCTURE a WHERE a.company_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectResourceCatalogsStructuresForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_PRODSTRUCTURE a WHERE (a.company_catalog_seq_no in :ids and a.resource_class_seq_no in :cids)", nativeQuery = true)
	void delSelectResourceChildStructuresForCatalogs(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
}
