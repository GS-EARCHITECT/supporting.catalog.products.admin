package rating_mgmt.services;

import java.util.ArrayList;

import rating_mgmt.model.dto.ResourceCatalogRating_DTO;

public interface I_ResourceCatalogRating_Service
{
    public ResourceCatalogRating_DTO newResourceCatalogRating(ResourceCatalogRating_DTO resourceClassStructureDTO);
    public ArrayList<ResourceCatalogRating_DTO> getAllResourceCatalogRatings();
    public ArrayList<ResourceCatalogRating_DTO> getSelectResourceCatalogRatings(ArrayList<Float> rids);
    public ArrayList<ResourceCatalogRating_DTO> getSelectResourceCatalogsRatingsForCatalogs(ArrayList<Long> ids);
    public void updResourceCatalogRating(ResourceCatalogRating_DTO ResourceCatalogRating_DTO);
    public void delAllResourceCatalogRatings();    
    public void delSelectResourceCatalogRatings(ArrayList<Float> fids);
    public void delSelectResourceCatalogsRatingsForCatalogs(ArrayList<Long> ids);        
}