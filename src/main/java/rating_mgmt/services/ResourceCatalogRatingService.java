package rating_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rating_mgmt.model.dto.ResourceCatalogRating_DTO;
import rating_mgmt.model.master.ResourceCatalogRating;
import rating_mgmt.model.master.ResourceCatalogRatingPK;
import rating_mgmt.model.repo.ResourceCatalogRating_Repo;

@Service("resourceCatalogRatingServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceCatalogRatingService implements I_ResourceCatalogRating_Service {

	@Autowired
	private ResourceCatalogRating_Repo resourceCatalogRatingRepo;

	public ResourceCatalogRating_DTO newResourceCatalogRating(ResourceCatalogRating_DTO lmsResourceCatalogRating_DTO) {
		ResourceCatalogRatingPK lmsResourceCatalogRatingPK = new ResourceCatalogRatingPK();
		lmsResourceCatalogRatingPK.setRating(lmsResourceCatalogRating_DTO.getRating());
		lmsResourceCatalogRatingPK.setResourceCatalogSeqNo(lmsResourceCatalogRating_DTO.getResourceCatalogSeqNo());
		ResourceCatalogRating_DTO lmsResourceCatalogRating_DTO2 = null;
		ResourceCatalogRating lmsResourceCatalogRating = null;

		if (!resourceCatalogRatingRepo.existsById(lmsResourceCatalogRatingPK)) {
			lmsResourceCatalogRating = setResourceCatalogRating(lmsResourceCatalogRating_DTO);
			lmsResourceCatalogRating.setId(lmsResourceCatalogRatingPK);
			lmsResourceCatalogRating_DTO2 = getResourceCatalogRating_DTO(
					resourceCatalogRatingRepo.save(lmsResourceCatalogRating));
		}
		return lmsResourceCatalogRating_DTO2;
	}

	public ArrayList<ResourceCatalogRating_DTO> getAllResourceCatalogRatings() {
		ArrayList<ResourceCatalogRating> ResourceClassCategoryList = (ArrayList<ResourceCatalogRating>) resourceCatalogRatingRepo
				.findAll();
		ArrayList<ResourceCatalogRating_DTO> lMasterss = new ArrayList<ResourceCatalogRating_DTO>();
		lMasterss = ResourceClassCategoryList != null ? this.getResourceCatalogRating_DTOs(ResourceClassCategoryList)
				: null;
		return lMasterss;
	}

	public ArrayList<ResourceCatalogRating_DTO> getSelectResourceCatalogRatings(ArrayList<Float> rids) {
		ArrayList<ResourceCatalogRating> lMasters = resourceCatalogRatingRepo.getSelectResourceCatalogRatings(rids);
		ArrayList<ResourceCatalogRating_DTO> resourceCatalogRating_DTOs = new ArrayList<ResourceCatalogRating_DTO>();
		resourceCatalogRating_DTOs = lMasters != null ? this.getResourceCatalogRating_DTOs(lMasters) : null;
		return resourceCatalogRating_DTOs;
	}

	public ArrayList<ResourceCatalogRating_DTO> getSelectResourceCatalogsRatingsForCatalogs(ArrayList<Long> ids) {
		ArrayList<ResourceCatalogRating> lMasters = resourceCatalogRatingRepo
				.getSelectResourceCatalogsRatingsForCatalogs(ids);
		ArrayList<ResourceCatalogRating_DTO> resourceCatalogRating_DTOs = new ArrayList<ResourceCatalogRating_DTO>();
		resourceCatalogRating_DTOs = lMasters != null ? this.getResourceCatalogRating_DTOs(lMasters) : null;
		return resourceCatalogRating_DTOs;
	}

	public void updResourceCatalogRating(ResourceCatalogRating_DTO lmsResourceCatalogRating_DTO) {
		ResourceCatalogRatingPK lmsResourceCatalogRatingPK = new ResourceCatalogRatingPK();
		lmsResourceCatalogRatingPK.setRating(lmsResourceCatalogRating_DTO.getRating());
		lmsResourceCatalogRatingPK.setResourceCatalogSeqNo(lmsResourceCatalogRating_DTO.getResourceCatalogSeqNo());
		ResourceCatalogRating lmsResourceCatalogRating = null;

		if (resourceCatalogRatingRepo.existsById(lmsResourceCatalogRatingPK)) {
			lmsResourceCatalogRating = this.setResourceCatalogRating(lmsResourceCatalogRating_DTO);
			resourceCatalogRatingRepo.save(lmsResourceCatalogRating);
		}
		return;
	}

	public void delSelectResourceCatalogRatings(ArrayList<Float> rids)
	{
		resourceCatalogRatingRepo.delSelectResourceCatalogRatings(rids);
		return;
	}

	public void delSelectResourceCatalogsRatingsForCatalogs(ArrayList<Long> ids)
	{
		resourceCatalogRatingRepo.delSelectResourceCatalogsRatingsForCatalogs(ids);
		return;
	}

	
	public void delAllResourceCatalogRatings() {
		resourceCatalogRatingRepo.deleteAll();
	}

	private ArrayList<ResourceCatalogRating_DTO> getResourceCatalogRating_DTOs(
			ArrayList<ResourceCatalogRating> lMasters) {
		ResourceCatalogRating_DTO lDTO = null;
		ArrayList<ResourceCatalogRating_DTO> lMasterDTOs = new ArrayList<ResourceCatalogRating_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourceCatalogRating_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceCatalogRating_DTO getResourceCatalogRating_DTO(ResourceCatalogRating lmsResourceCatalogRating) {
		ResourceCatalogRating_DTO lDTO = new ResourceCatalogRating_DTO();
		lDTO.setRating(lmsResourceCatalogRating.getId().getRating());		
		lDTO.setResourceCatalogSeqNo(lmsResourceCatalogRating.getId().getResourceCatalogSeqNo());
		return lDTO;
	}

	private ResourceCatalogRating setResourceCatalogRating(ResourceCatalogRating_DTO lDTO) 
	{
		ResourceCatalogRatingPK lmsResourceCatalogRatingPK = new ResourceCatalogRatingPK();
		ResourceCatalogRating lmsResourceCatalogRating = new ResourceCatalogRating();
		lmsResourceCatalogRatingPK.setRating(lDTO.getRating());		
		lmsResourceCatalogRatingPK.setResourceCatalogSeqNo(lDTO.getResourceCatalogSeqNo());
		lmsResourceCatalogRating.setId(lmsResourceCatalogRatingPK);
		return lmsResourceCatalogRating;
	}
}