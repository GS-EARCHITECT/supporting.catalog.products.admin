package resource_catalog_location_class_structure_mgmt.services;

import java.util.ArrayList;

import resource_catalog_location_class_structure_mgmt.model.dto.ResourceCatalogLocStructure_DTO;

public interface I_ResourceCatalogLocStructure_Service
{
    public ResourceCatalogLocStructure_DTO newResourceCatalogLocStructure(ResourceCatalogLocStructure_DTO resourceClassStructureDTO);
    public ArrayList<ResourceCatalogLocStructure_DTO> getAllResourceCatalogLocStructures();
    public ArrayList<ResourceCatalogLocStructure_DTO> getSelectResourceCatalogLocStructures(ArrayList<Long> ids, ArrayList<Long> cids);
    public ArrayList<ResourceCatalogLocStructure_DTO> getSelectResourceCatalogsStructuresForCatalogs(ArrayList<Long> ids);
    public ArrayList<ResourceCatalogLocStructure_DTO> getSelectResourceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids);    
    public void updResourceCatalogLocStructure(ResourceCatalogLocStructure_DTO ResourceCatalogLocStructure_DTO);
    public void delAllResourceCatalogLocStructures();    
    public void delSelectResourceCatalogLocStructures(ArrayList<Long> ids, ArrayList<Long> cids);
    public void delSelectResourceCatalogsStructuresForCatalogs(ArrayList<Long> ids);
    public void delSelectResourceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids);
}



