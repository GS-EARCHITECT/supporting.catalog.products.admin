package compclass_mgmt.services;

import java.util.ArrayList;

import compclass_mgmt.model.dto.ResourceCatalogCompClass_DTO;

public interface I_ResourceCatalogCompClass_Service
{
    public ResourceCatalogCompClass_DTO newResourceCatalogCompClass(ResourceCatalogCompClass_DTO resourceClassStructureDTO);
    public ArrayList<ResourceCatalogCompClass_DTO> getAllResourceCatalogCompanies();
    public ArrayList<ResourceCatalogCompClass_DTO> getSelectResourceCatalogCompanies(ArrayList<Long> rids);
    public ArrayList<ResourceCatalogCompClass_DTO> getSelectResourceCatalogsCompaniesForCatalogs(ArrayList<Long> ids);
    public void updResourceCatalogCompClass(ResourceCatalogCompClass_DTO resourceCatalogCompClass_DTO);
    public void delAllResourceCatalogCompanies();    
    public void delSelectResourceCatalogCompanies(ArrayList<Long> fids);
    public void delSelectResourceCatalogsCompaniesForCatalogs(ArrayList<Long> ids);
}