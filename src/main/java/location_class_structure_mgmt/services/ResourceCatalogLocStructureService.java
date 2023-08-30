package location_class_structure_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import location_class_structure_mgmt.model.dto.ResourceCatalogLocStructure_DTO;
import location_class_structure_mgmt.model.master.ResourceCatalogLocStructure;
import location_class_structure_mgmt.model.master.ResourceCatalogLocStructurePK;
import location_class_structure_mgmt.model.repo.ResourceCatalogLocStucture_Repo;

@Service("resourceCatalogLocStructureServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceCatalogLocStructureService implements I_ResourceCatalogLocStructure_Service 
{

	@Autowired
	private ResourceCatalogLocStucture_Repo resourceCatalogLocStructureRepo;

	public ResourceCatalogLocStructure_DTO newResourceCatalogLocStructure(ResourceCatalogLocStructure_DTO lmsResourceCatalogLocStructure_DTO) {
		ResourceCatalogLocStructurePK lmsResourceCatalogLocStructurePK = new ResourceCatalogLocStructurePK();
		lmsResourceCatalogLocStructurePK.setParPlaceClassSeqNo(lmsResourceCatalogLocStructure_DTO.getParLocationClassSeqNo());
		lmsResourceCatalogLocStructurePK.setPlaceClassSeqNo(lmsResourceCatalogLocStructure_DTO.getLocationClassSeqNo());
		ResourceCatalogLocStructure_DTO lmsResourceCatalogLocStructure_DTO2 = null;
		ResourceCatalogLocStructure lmsResourceCatalogLocStructure = null;

		if (!resourceCatalogLocStructureRepo.existsById(lmsResourceCatalogLocStructurePK)) 
		{
			lmsResourceCatalogLocStructure = setResourceCatalogLocStructure(lmsResourceCatalogLocStructure_DTO);
			lmsResourceCatalogLocStructure.setId(lmsResourceCatalogLocStructurePK);
			lmsResourceCatalogLocStructure_DTO2 = getResourceCatalogLocStructure_DTO(resourceCatalogLocStructureRepo.save(lmsResourceCatalogLocStructure));
		}
		return lmsResourceCatalogLocStructure_DTO2;
	}

	public ArrayList<ResourceCatalogLocStructure_DTO> getAllResourceCatalogLocStructures() 
	{
		ArrayList<ResourceCatalogLocStructure> ResourceClassCategoryList = (ArrayList<ResourceCatalogLocStructure>) resourceCatalogLocStructureRepo
				.findAll();
		ArrayList<ResourceCatalogLocStructure_DTO> lMasterss = new ArrayList<ResourceCatalogLocStructure_DTO>();
		lMasterss = ResourceClassCategoryList != null ? this.getResourceCatalogLocStructure_DTOs(ResourceClassCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<ResourceCatalogLocStructure_DTO> getSelectResourceCatalogLocStructures(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		ArrayList<ResourceCatalogLocStructure> lMasters = resourceCatalogLocStructureRepo.getSelectResourceCatalogStructures(ids, cids);
		ArrayList<ResourceCatalogLocStructure_DTO> resourceCatalogLocStructure_DTOs = new ArrayList<ResourceCatalogLocStructure_DTO>();
		resourceCatalogLocStructure_DTOs = lMasters != null ? this.getResourceCatalogLocStructure_DTOs(lMasters) : null;
		return resourceCatalogLocStructure_DTOs;
	}

	public ArrayList<ResourceCatalogLocStructure_DTO> getSelectResourceCatalogsStructuresForCatalogs(ArrayList<Long> ids)
	{
		ArrayList<ResourceCatalogLocStructure> lMasters = resourceCatalogLocStructureRepo.getSelectResourceCatalogsStructuresForCatalogs(ids);
		ArrayList<ResourceCatalogLocStructure_DTO> resourceCatalogLocStructure_DTOs = new ArrayList<ResourceCatalogLocStructure_DTO>();
		resourceCatalogLocStructure_DTOs = lMasters != null ? this.getResourceCatalogLocStructure_DTOs(lMasters) : null;
		return resourceCatalogLocStructure_DTOs;
	}
	
	public ArrayList<ResourceCatalogLocStructure_DTO> getSelectResourceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		ArrayList<ResourceCatalogLocStructure> lMasters = resourceCatalogLocStructureRepo.getSelectResourceChildStructuresForCatalogs(ids, cids);
		ArrayList<ResourceCatalogLocStructure_DTO> resourceCatalogLocStructure_DTOs = new ArrayList<ResourceCatalogLocStructure_DTO>();
		resourceCatalogLocStructure_DTOs = lMasters != null ? this.getResourceCatalogLocStructure_DTOs(lMasters) : null;
		return resourceCatalogLocStructure_DTOs;
	}

	
	public void updResourceCatalogLocStructure(ResourceCatalogLocStructure_DTO lmsResourceCatalogLocStructure_DTO) {
		ResourceCatalogLocStructurePK lmsResourceCatalogLocStructurePK = new ResourceCatalogLocStructurePK();
		lmsResourceCatalogLocStructurePK.setParPlaceClassSeqNo(lmsResourceCatalogLocStructure_DTO.getParLocationClassSeqNo());
		lmsResourceCatalogLocStructurePK.setPlaceClassSeqNo(lmsResourceCatalogLocStructure_DTO.getLocationClassSeqNo());
		ResourceCatalogLocStructure_DTO lmsResourceCatalogLocStructure_DTO2 = null;
		ResourceCatalogLocStructure lmsResourceCatalogLocStructure = null;

		if (resourceCatalogLocStructureRepo.existsById(lmsResourceCatalogLocStructurePK)) {
			lmsResourceCatalogLocStructure = this.setResourceCatalogLocStructure(lmsResourceCatalogLocStructure_DTO);
			resourceCatalogLocStructureRepo.save(lmsResourceCatalogLocStructure);
		}
		return;
	}

	public void delSelectResourceCatalogLocStructures(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		resourceCatalogLocStructureRepo.delSelectResourceCatalogStructures(ids, cids);
		return;
	}

	public void delSelectResourceCatalogsStructuresForCatalogs(ArrayList<Long> ids) 
	{
		resourceCatalogLocStructureRepo.delSelectResourceCatalogsStructuresForCatalogs(ids);
		return;
	}
	
	public void delSelectResourceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		resourceCatalogLocStructureRepo.delSelectResourceChildStructuresForCatalogs(ids, cids);
		return;
	}

	
	public void delAllResourceCatalogLocStructures() {
		resourceCatalogLocStructureRepo.deleteAll();
	}

	private ArrayList<ResourceCatalogLocStructure_DTO> getResourceCatalogLocStructure_DTOs(
			ArrayList<ResourceCatalogLocStructure> lMasters) {
		ResourceCatalogLocStructure_DTO lDTO = null;
		ArrayList<ResourceCatalogLocStructure_DTO> lMasterDTOs = new ArrayList<ResourceCatalogLocStructure_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourceCatalogLocStructure_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceCatalogLocStructure_DTO getResourceCatalogLocStructure_DTO(ResourceCatalogLocStructure lmsResourceCatalogLocStructure) 
	{
		ResourceCatalogLocStructure_DTO lDTO = new ResourceCatalogLocStructure_DTO();
		lDTO.setLocationClassSeqNo(lmsResourceCatalogLocStructure.getId().getPlaceClassSeqNo());
		lDTO.setParLocationClassSeqNo(lmsResourceCatalogLocStructure.getId().getParPlaceClassSeqNo());
		lDTO.setResourceCatalogSeqNo(lmsResourceCatalogLocStructure.getId().getResourceCatalogSeqNo());		
		return lDTO;
	}

	private ResourceCatalogLocStructure setResourceCatalogLocStructure(ResourceCatalogLocStructure_DTO lDTO) 
	{
		ResourceCatalogLocStructurePK lmsResourceCatalogLocStructurePK = new ResourceCatalogLocStructurePK();
		ResourceCatalogLocStructure lmsResourceCatalogLocStructure = new ResourceCatalogLocStructure();
		lmsResourceCatalogLocStructurePK.setPlaceClassSeqNo(lDTO.getLocationClassSeqNo());
		lmsResourceCatalogLocStructurePK.setParPlaceClassSeqNo(lDTO.getParLocationClassSeqNo());
		lmsResourceCatalogLocStructurePK.setResourceCatalogSeqNo(lDTO.getResourceCatalogSeqNo());
		lmsResourceCatalogLocStructure.setId(lmsResourceCatalogLocStructurePK);
		return lmsResourceCatalogLocStructure;
	}
}