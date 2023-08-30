package resource_class_structure_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import resource_class_structure_mgmt.model.dto.ResourceCatalogProdStructure_DTO;
import resource_class_structure_mgmt.model.master.ResourceCatalogProdStructure;
import resource_class_structure_mgmt.model.master.ResourceCatalogProdStructurePK;
import resource_class_structure_mgmt.model.repo.ResourceCatalogProdStucture_Repo;

@Service("resourceCatalogProdStructureServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceCatalogProdStructureService implements I_ResourceCatalogProdStructure_Service 
{

	@Autowired
	private ResourceCatalogProdStucture_Repo resourceCatalogProdStructureRepo;

	public ResourceCatalogProdStructure_DTO newResourceCatalogProdStructure(ResourceCatalogProdStructure_DTO lmsResourceCatalogProdStructure_DTO) {
		ResourceCatalogProdStructurePK lmsResourceCatalogProdStructurePK = new ResourceCatalogProdStructurePK();
		lmsResourceCatalogProdStructurePK.setParResourceClassSeqNo(lmsResourceCatalogProdStructure_DTO.getParResourceClassSeqNo());
		lmsResourceCatalogProdStructurePK.setResourceClassSeqNo(lmsResourceCatalogProdStructure_DTO.getResourceClassSeqNo());
		ResourceCatalogProdStructure_DTO lmsResourceCatalogProdStructure_DTO2 = null;
		ResourceCatalogProdStructure lmsResourceCatalogProdStructure = null;

		if (!resourceCatalogProdStructureRepo.existsById(lmsResourceCatalogProdStructurePK)) 
		{
			lmsResourceCatalogProdStructure = setResourceCatalogProdStructure(lmsResourceCatalogProdStructure_DTO);
			lmsResourceCatalogProdStructure.setId(lmsResourceCatalogProdStructurePK);
			lmsResourceCatalogProdStructure_DTO2 = getResourceCatalogProdStructure_DTO(resourceCatalogProdStructureRepo.save(lmsResourceCatalogProdStructure));
		}
		return lmsResourceCatalogProdStructure_DTO2;
	}

	public ArrayList<ResourceCatalogProdStructure_DTO> getAllResourceCatalogProdStructures() 
	{
		ArrayList<ResourceCatalogProdStructure> ResourceClassCategoryList = (ArrayList<ResourceCatalogProdStructure>) resourceCatalogProdStructureRepo
				.findAll();
		ArrayList<ResourceCatalogProdStructure_DTO> lMasterss = new ArrayList<ResourceCatalogProdStructure_DTO>();
		lMasterss = ResourceClassCategoryList != null ? this.getResourceCatalogProdStructure_DTOs(ResourceClassCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<ResourceCatalogProdStructure_DTO> getSelectResourceCatalogProdStructures(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		ArrayList<ResourceCatalogProdStructure> lMasters = resourceCatalogProdStructureRepo.getSelectResourceCatalogStructures(ids, cids);
		ArrayList<ResourceCatalogProdStructure_DTO> resourceCatalogProdStructure_DTOs = new ArrayList<ResourceCatalogProdStructure_DTO>();
		resourceCatalogProdStructure_DTOs = lMasters != null ? this.getResourceCatalogProdStructure_DTOs(lMasters) : null;
		return resourceCatalogProdStructure_DTOs;
	}

	public ArrayList<ResourceCatalogProdStructure_DTO> getSelectResourceCatalogsStructuresForCatalogs(ArrayList<Long> ids)
	{
		ArrayList<ResourceCatalogProdStructure> lMasters = resourceCatalogProdStructureRepo.getSelectResourceCatalogsStructuresForCatalogs(ids);
		ArrayList<ResourceCatalogProdStructure_DTO> resourceCatalogProdStructure_DTOs = new ArrayList<ResourceCatalogProdStructure_DTO>();
		resourceCatalogProdStructure_DTOs = lMasters != null ? this.getResourceCatalogProdStructure_DTOs(lMasters) : null;
		return resourceCatalogProdStructure_DTOs;
	}
	
	public ArrayList<ResourceCatalogProdStructure_DTO> getSelectResourceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		ArrayList<ResourceCatalogProdStructure> lMasters = resourceCatalogProdStructureRepo.getSelectResourceChildStructuresForCatalogs(ids, cids);
		ArrayList<ResourceCatalogProdStructure_DTO> resourceCatalogProdStructure_DTOs = new ArrayList<ResourceCatalogProdStructure_DTO>();
		resourceCatalogProdStructure_DTOs = lMasters != null ? this.getResourceCatalogProdStructure_DTOs(lMasters) : null;
		return resourceCatalogProdStructure_DTOs;
	}

	
	public void updResourceCatalogProdStructure(ResourceCatalogProdStructure_DTO lmsResourceCatalogProdStructure_DTO) {
		ResourceCatalogProdStructurePK lmsResourceCatalogProdStructurePK = new ResourceCatalogProdStructurePK();
		lmsResourceCatalogProdStructurePK.setParResourceClassSeqNo(lmsResourceCatalogProdStructure_DTO.getParResourceClassSeqNo());
		lmsResourceCatalogProdStructurePK.setResourceClassSeqNo(lmsResourceCatalogProdStructure_DTO.getResourceClassSeqNo());
		ResourceCatalogProdStructure lmsResourceCatalogProdStructure = null;

		if (resourceCatalogProdStructureRepo.existsById(lmsResourceCatalogProdStructurePK)) {
			lmsResourceCatalogProdStructure = this.setResourceCatalogProdStructure(lmsResourceCatalogProdStructure_DTO);
			resourceCatalogProdStructureRepo.save(lmsResourceCatalogProdStructure);
		}
		return;
	}

	public void delSelectResourceCatalogProdStructures(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		resourceCatalogProdStructureRepo.delSelectResourceCatalogStructures(ids, cids);
		return;
	}

	public void delSelectResourceCatalogsStructuresForCatalogs(ArrayList<Long> ids) 
	{
		resourceCatalogProdStructureRepo.delSelectResourceCatalogsStructuresForCatalogs(ids);
		return;
	}
	
	public void delSelectResourceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		resourceCatalogProdStructureRepo.delSelectResourceChildStructuresForCatalogs(ids, cids);
		return;
	}

	
	public void delAllResourceCatalogProdStructures() {
		resourceCatalogProdStructureRepo.deleteAll();
	}

	private ArrayList<ResourceCatalogProdStructure_DTO> getResourceCatalogProdStructure_DTOs(
			ArrayList<ResourceCatalogProdStructure> lMasters) {
		ResourceCatalogProdStructure_DTO lDTO = null;
		ArrayList<ResourceCatalogProdStructure_DTO> lMasterDTOs = new ArrayList<ResourceCatalogProdStructure_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourceCatalogProdStructure_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceCatalogProdStructure_DTO getResourceCatalogProdStructure_DTO(ResourceCatalogProdStructure lmsResourceCatalogProdStructure) 
	{
		ResourceCatalogProdStructure_DTO lDTO = new ResourceCatalogProdStructure_DTO();
		lDTO.setResourceClassSeqNo(lmsResourceCatalogProdStructure.getId().getResourceClassSeqNo());
		lDTO.setParResourceClassSeqNo(lmsResourceCatalogProdStructure.getId().getParResourceClassSeqNo());
		lDTO.setResourceCatalogSeqNo(lmsResourceCatalogProdStructure.getId().getResourceCatalogSeqNo());		
		return lDTO;
	}

	private ResourceCatalogProdStructure setResourceCatalogProdStructure(ResourceCatalogProdStructure_DTO lDTO) 
	{
		ResourceCatalogProdStructurePK lmsResourceCatalogProdStructurePK = new ResourceCatalogProdStructurePK();
		ResourceCatalogProdStructure lmsResourceCatalogProdStructure = new ResourceCatalogProdStructure();
		lmsResourceCatalogProdStructurePK.setResourceClassSeqNo(lDTO.getResourceClassSeqNo());
		lmsResourceCatalogProdStructurePK.setParResourceClassSeqNo(lDTO.getParResourceClassSeqNo());
		lmsResourceCatalogProdStructurePK.setResourceCatalogSeqNo(lDTO.getResourceCatalogSeqNo());
		lmsResourceCatalogProdStructure.setId(lmsResourceCatalogProdStructurePK);
		return lmsResourceCatalogProdStructure;
	}
}