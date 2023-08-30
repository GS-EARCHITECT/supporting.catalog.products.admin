package catalog_master_mgmt.model.repo;

import java.util.ArrayList;
import java.util.List;

import catalog_master_mgmt.model.master.ResourceCatalogReadMaster;

public interface IResourceCatalogReadMasterRepo  
{
		public List<ResourceCatalogReadMaster> findAll();
		public List<ResourceCatalogReadMaster> findAllForConditions(Integer parm, ArrayList<Long> cList, ArrayList<Long> rList, String catalog);
		public List<ResourceCatalogReadMaster> findByIdAndCompany(Long resSeqNo, Long compSeqNo);
	
}
