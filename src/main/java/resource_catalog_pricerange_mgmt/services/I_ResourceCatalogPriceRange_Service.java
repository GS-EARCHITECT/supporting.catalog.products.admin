package resource_catalog_pricerange_mgmt.services;

import java.util.ArrayList;

import resource_catalog_pricerange_mgmt.model.dto.ResourceCatalogPriceRange_DTO;

public interface I_ResourceCatalogPriceRange_Service
{
    public ResourceCatalogPriceRange_DTO newResourceCatalogPriceRange(ResourceCatalogPriceRange_DTO resourceClassStructureDTO);
    public ArrayList<ResourceCatalogPriceRange_DTO> getAllResourceCatalogPriceRanges();
    public ArrayList<ResourceCatalogPriceRange_DTO> getSelectResourceCatalogsBetweenPrices(ArrayList<Long> ids, Float frPrice, Float toPrice);
    public ArrayList<ResourceCatalogPriceRange_DTO> getSelectResourceCatalogsPriceRanges(ArrayList<Long> ids);
    public ArrayList<ResourceCatalogPriceRange_DTO> getSelectResourceCatalogsForPriceRange(Float frPrice, Float toPrice);
    public void updResourceCatalogPriceRange(ResourceCatalogPriceRange_DTO ResourceCatalogPriceRange_DTO);
    public void delAllResourceCatalogPriceRanges();    
    public void delSelectResourceCatalogsBetweenPrices(ArrayList<Long> ids, Float frPrice, Float toPrice);
    public void deltSelectResourceCatalogsPriceRanges(ArrayList<Long> ids);
    public void delSelectResourceCatalogsForPriceRange(Float frPrice, Float toPrice);
}



