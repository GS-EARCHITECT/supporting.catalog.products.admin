package pricerange_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pricerange_mgmt.model.dto.ResourceCatalogPriceRange_DTO;
import pricerange_mgmt.model.master.ResourceCatalogPriceRange;
import pricerange_mgmt.model.master.ResourceCatalogPriceRangePK;
import pricerange_mgmt.model.repo.ResourceCatalogPriceRange_Repo;

@Service("resourceCatalogPriceRangeServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceCatalogPriceRangeService implements I_ResourceCatalogPriceRange_Service 
{

	@Autowired
	private ResourceCatalogPriceRange_Repo resourceCatalogPriceRangeRepo;

	public ResourceCatalogPriceRange_DTO newResourceCatalogPriceRange(ResourceCatalogPriceRange_DTO resourceCatalogPriceRange_DTO) 
	{
		ResourceCatalogPriceRangePK resourceCatalogPriceRangePK = new ResourceCatalogPriceRangePK();
		resourceCatalogPriceRangePK.setPriceFr(resourceCatalogPriceRange_DTO.getPriceFr());
		resourceCatalogPriceRangePK.setPriceTo(resourceCatalogPriceRange_DTO.getPriceTo());
		resourceCatalogPriceRangePK.setResourceCatalogSeqNo(resourceCatalogPriceRange_DTO.getResourceCatalogSeqNo());		
		ResourceCatalogPriceRange_DTO resourceCatalogPriceRange_DTO2 = null;
		ResourceCatalogPriceRange resourceCatalogPriceRange = null;

		if (!resourceCatalogPriceRangeRepo.existsById(resourceCatalogPriceRangePK)
				) 
		{
			resourceCatalogPriceRange = setResourceCatalogPriceRange(resourceCatalogPriceRange_DTO);
			resourceCatalogPriceRange.setId(resourceCatalogPriceRangePK);
			resourceCatalogPriceRange_DTO2 = getResourceCatalogPriceRange_DTO(resourceCatalogPriceRangeRepo.save(resourceCatalogPriceRange));
		}
		return resourceCatalogPriceRange_DTO2;
	}

	public ArrayList<ResourceCatalogPriceRange_DTO> getSelectResourceCatalogsPriceRanges(ArrayList<Long> ids) 
	{
		ArrayList<ResourceCatalogPriceRange> ResourceClassCategoryList = (ArrayList<ResourceCatalogPriceRange>) resourceCatalogPriceRangeRepo.getSelectResourceCatalogsPriceRanges(ids);
				
		ArrayList<ResourceCatalogPriceRange_DTO> lMasterss = new ArrayList<ResourceCatalogPriceRange_DTO>();
		lMasterss = ResourceClassCategoryList != null ? this.getResourceCatalogPriceRange_DTOs(ResourceClassCategoryList) : null;
		return lMasterss;
	}

	
	public ArrayList<ResourceCatalogPriceRange_DTO> getAllResourceCatalogPriceRanges() 
	{
		ArrayList<ResourceCatalogPriceRange> ResourceClassCategoryList = (ArrayList<ResourceCatalogPriceRange>) resourceCatalogPriceRangeRepo
				.findAll();
		ArrayList<ResourceCatalogPriceRange_DTO> lMasterss = new ArrayList<ResourceCatalogPriceRange_DTO>();
		lMasterss = ResourceClassCategoryList != null ? this.getResourceCatalogPriceRange_DTOs(ResourceClassCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<ResourceCatalogPriceRange_DTO> getSelectResourceCatalogsBetweenPrices(ArrayList<Long> ids, Float frPrice, Float toPrice) 
	{
		ArrayList<ResourceCatalogPriceRange> lMasters = resourceCatalogPriceRangeRepo.getSelectResourceCatalogsBetweenPrices(ids, frPrice, toPrice);
		ArrayList<ResourceCatalogPriceRange_DTO> resourceCatalogPriceRange_DTOs = new ArrayList<ResourceCatalogPriceRange_DTO>();
		resourceCatalogPriceRange_DTOs = lMasters != null ? this.getResourceCatalogPriceRange_DTOs(lMasters) : null;
		return resourceCatalogPriceRange_DTOs;
	}

	public ArrayList<ResourceCatalogPriceRange_DTO> getSelectResourceCatalogsForPriceRange(Float frPrice, Float toPrice)
	{
		ArrayList<ResourceCatalogPriceRange> lMasters = resourceCatalogPriceRangeRepo.getSelectResourceCatalogsForPriceRange(frPrice, toPrice);
		ArrayList<ResourceCatalogPriceRange_DTO> resourceCatalogPriceRange_DTOs = new ArrayList<ResourceCatalogPriceRange_DTO>();
		resourceCatalogPriceRange_DTOs = lMasters != null ? this.getResourceCatalogPriceRange_DTOs(lMasters) : null;
		return resourceCatalogPriceRange_DTOs;
	}
	
	
	public void updResourceCatalogPriceRange(ResourceCatalogPriceRange_DTO resourceCatalogPriceRange_DTO) 
	{
		ResourceCatalogPriceRangePK resourceCatalogPriceRangePK = new ResourceCatalogPriceRangePK();
		resourceCatalogPriceRangePK.setPriceFr(resourceCatalogPriceRange_DTO.getPriceFr());
		resourceCatalogPriceRangePK.setPriceTo(resourceCatalogPriceRange_DTO.getPriceTo());
		resourceCatalogPriceRangePK.setResourceCatalogSeqNo(resourceCatalogPriceRange_DTO.getResourceCatalogSeqNo());		
		ResourceCatalogPriceRange_DTO resourceCatalogPriceRange_DTO2 = null;
		ResourceCatalogPriceRange resourceCatalogPriceRange = null;
		if (resourceCatalogPriceRangeRepo.existsById(resourceCatalogPriceRangePK)) 
		{
			resourceCatalogPriceRange = this.setResourceCatalogPriceRange(resourceCatalogPriceRange_DTO);
			resourceCatalogPriceRangeRepo.save(resourceCatalogPriceRange);
		}
		return;
	}

	public void delSelectResourceCatalogsBetweenPrices(ArrayList<Long> ids, Float frPrice, Float toPrice) 
	{
		resourceCatalogPriceRangeRepo.delSelectResourceCatalogsBetweenPrices(ids, frPrice, toPrice);
		return;
	}

	public void delSelectResourceCatalogsForPriceRange( Float frPrice, Float toPrice) 
	{
		resourceCatalogPriceRangeRepo.delSelectResourceCatalogsForPriceRange(frPrice, toPrice);
		return;
	}
	
	
	public void delAllResourceCatalogPriceRanges() {
		resourceCatalogPriceRangeRepo.deleteAll();
	}

	public void deltSelectResourceCatalogsPriceRanges(ArrayList<Long> ids) 
	{
		resourceCatalogPriceRangeRepo.deltSelectResourceCatalogsPriceRanges(ids);
		return;
	}

	
	private ArrayList<ResourceCatalogPriceRange_DTO> getResourceCatalogPriceRange_DTOs(
			ArrayList<ResourceCatalogPriceRange> lMasters) {
		ResourceCatalogPriceRange_DTO lDTO = null;
		ArrayList<ResourceCatalogPriceRange_DTO> lMasterDTOs = new ArrayList<ResourceCatalogPriceRange_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourceCatalogPriceRange_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceCatalogPriceRange_DTO getResourceCatalogPriceRange_DTO(ResourceCatalogPriceRange resourceCatalogPriceRange) 
	{
		ResourceCatalogPriceRange_DTO lDTO = new ResourceCatalogPriceRange_DTO();		
		lDTO.setPriceFr(resourceCatalogPriceRange.getId().getPriceFr());
		lDTO.setPriceTo(resourceCatalogPriceRange.getId().getPriceTo());
		lDTO.setResourceCatalogSeqNo(resourceCatalogPriceRange.getId().getResourceCatalogSeqNo());		
		return lDTO;
	}

	private ResourceCatalogPriceRange setResourceCatalogPriceRange(ResourceCatalogPriceRange_DTO lDTO) 
	{
		ResourceCatalogPriceRangePK resourceCatalogPriceRangePK = new ResourceCatalogPriceRangePK();
		ResourceCatalogPriceRange resourceCatalogPriceRange = new ResourceCatalogPriceRange();		
		resourceCatalogPriceRangePK.setPriceFr(lDTO.getPriceFr());
		resourceCatalogPriceRangePK.setPriceTo(lDTO.getPriceTo());
		resourceCatalogPriceRangePK.setResourceCatalogSeqNo(lDTO.getResourceCatalogSeqNo());
		return resourceCatalogPriceRange;
	}
}