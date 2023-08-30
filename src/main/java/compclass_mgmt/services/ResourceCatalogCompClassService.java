package compclass_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import compclass_mgmt.model.dto.ResourceCatalogCompClass_DTO;
import compclass_mgmt.model.master.ResourceCatalogCompClass;
import compclass_mgmt.model.master.ResourceCatalogCompClassPK;
import compclass_mgmt.model.repo.ResourceCatalogCompClass_Repo;

@Service("resourceCatalogCompClassServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceCatalogCompClassService implements I_ResourceCatalogCompClass_Service 
{

	@Autowired
	private ResourceCatalogCompClass_Repo resourceCatalogCompClassRepo;

	public ResourceCatalogCompClass_DTO newResourceCatalogCompClass(ResourceCatalogCompClass_DTO resourceCatalogCompClass_DTO) {
		ResourceCatalogCompClassPK resourceCatalogCompClassPK = new ResourceCatalogCompClassPK();
		resourceCatalogCompClassPK.setCompanyClassSeqNo(resourceCatalogCompClass_DTO.getCompanyClassSeqNo());
		resourceCatalogCompClassPK.setResourceCatalogSeqNo(resourceCatalogCompClass_DTO.getResourceCatalogSeqNo());
		ResourceCatalogCompClass_DTO resourceCatalogCompClass_DTO2 = null;
		ResourceCatalogCompClass resourceCatalogCompClass = null;

		if (!resourceCatalogCompClassRepo.existsById(resourceCatalogCompClassPK)) {
			resourceCatalogCompClass = setResourceCatalogCompClass(resourceCatalogCompClass_DTO);
			resourceCatalogCompClass.setId(resourceCatalogCompClassPK);
			resourceCatalogCompClass_DTO2 = getResourceCatalogCompClass_DTO(
					resourceCatalogCompClassRepo.save(resourceCatalogCompClass));
		}
		return resourceCatalogCompClass_DTO2;
	}

	public ArrayList<ResourceCatalogCompClass_DTO> getAllResourceCatalogCompanies() 
	{
		ArrayList<ResourceCatalogCompClass> ResourceClassCategoryList = (ArrayList<ResourceCatalogCompClass>) resourceCatalogCompClassRepo
				.findAll();
		ArrayList<ResourceCatalogCompClass_DTO> lMasterss = new ArrayList<ResourceCatalogCompClass_DTO>();
		lMasterss = ResourceClassCategoryList != null ? this.getResourceCatalogCompClass_DTOs(ResourceClassCategoryList)
				: null;
		return lMasterss;
	}

	public ArrayList<ResourceCatalogCompClass_DTO> getSelectResourceCatalogCompanies(ArrayList<Long> rids) {
		ArrayList<ResourceCatalogCompClass> lMasters = resourceCatalogCompClassRepo.getSelectResourceCatalogCompanyClasses(rids);
		ArrayList<ResourceCatalogCompClass_DTO> resourceCatalogCompClass_DTOs = new ArrayList<ResourceCatalogCompClass_DTO>();
		resourceCatalogCompClass_DTOs = lMasters != null ? this.getResourceCatalogCompClass_DTOs(lMasters) : null;
		return resourceCatalogCompClass_DTOs;
	}

	public ArrayList<ResourceCatalogCompClass_DTO> getSelectResourceCatalogsCompaniesForCatalogs(ArrayList<Long> ids) {
		ArrayList<ResourceCatalogCompClass> lMasters = resourceCatalogCompClassRepo.getSelectResourceCatalogsCompanyClassesForCatalogs(ids);
		ArrayList<ResourceCatalogCompClass_DTO> resourceCatalogCompClass_DTOs = new ArrayList<ResourceCatalogCompClass_DTO>();
		resourceCatalogCompClass_DTOs = lMasters != null ? this.getResourceCatalogCompClass_DTOs(lMasters) : null;
		return resourceCatalogCompClass_DTOs;
	}
	
	public void updResourceCatalogCompClass(ResourceCatalogCompClass_DTO resourceCatalogCompClass_DTO) 
	{
		ResourceCatalogCompClassPK resourceCatalogCompClassPK = new ResourceCatalogCompClassPK();
		resourceCatalogCompClassPK.setCompanyClassSeqNo(resourceCatalogCompClass_DTO.getCompanyClassSeqNo());
		resourceCatalogCompClassPK.setResourceCatalogSeqNo(resourceCatalogCompClass_DTO.getResourceCatalogSeqNo());
		ResourceCatalogCompClass resourceCatalogCompClass = null;

		if (resourceCatalogCompClassRepo.existsById(resourceCatalogCompClassPK)) {
			resourceCatalogCompClass = this.setResourceCatalogCompClass(resourceCatalogCompClass_DTO);
			resourceCatalogCompClassRepo.save(resourceCatalogCompClass);
		}
		return;
	}


	public void delSelectResourceCatalogCompanies(ArrayList<Long> rids)
	{
		resourceCatalogCompClassRepo.delSelectResourceCatalogCompanyClasses(rids);
		return;
	}

	public void delSelectResourceCatalogsCompaniesForCatalogs(ArrayList<Long> ids)
	{
		resourceCatalogCompClassRepo.delSelectResourceCatalogsCompanyClassesForCatalogs(ids);
		return;
	}

	
	public void delAllResourceCatalogCompanies() {
		resourceCatalogCompClassRepo.deleteAll();
	}

	private ArrayList<ResourceCatalogCompClass_DTO> getResourceCatalogCompClass_DTOs(
			ArrayList<ResourceCatalogCompClass> lMasters) {
		ResourceCatalogCompClass_DTO lDTO = null;
		ArrayList<ResourceCatalogCompClass_DTO> lMasterDTOs = new ArrayList<ResourceCatalogCompClass_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourceCatalogCompClass_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceCatalogCompClass_DTO getResourceCatalogCompClass_DTO(ResourceCatalogCompClass resourceCatalogCompClass) {
		ResourceCatalogCompClass_DTO lDTO = new ResourceCatalogCompClass_DTO();
		lDTO.setCompanyClassSeqNo(resourceCatalogCompClass.getId().getCompanyClassSeqNo());		
		lDTO.setResourceCatalogSeqNo(resourceCatalogCompClass.getId().getResourceCatalogSeqNo());
		return lDTO;
	}

	private ResourceCatalogCompClass setResourceCatalogCompClass(ResourceCatalogCompClass_DTO lDTO) 
	{
		ResourceCatalogCompClassPK resourceCatalogCompClassPK = new ResourceCatalogCompClassPK();
		ResourceCatalogCompClass resourceCatalogCompClass = new ResourceCatalogCompClass();
		resourceCatalogCompClassPK.setCompanyClassSeqNo(lDTO.getCompanyClassSeqNo());		
		resourceCatalogCompClassPK.setResourceCatalogSeqNo(lDTO.getResourceCatalogSeqNo());
		resourceCatalogCompClass.setId(resourceCatalogCompClassPK);
		return resourceCatalogCompClass;
	}
}