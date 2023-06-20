package resource_catalog_resource_class_structure_mgmt.services;

import java.util.ArrayList;
import resource_catalog_resource_class_structure_mgmt.model.dto.ResourceCatalogProdStructure_DTO;

public interface I_ResourceCatalogProdStructure_Service
{
    public ResourceCatalogProdStructure_DTO newResourceCatalogProdStructure(ResourceCatalogProdStructure_DTO resourceClassStructureDTO);
    public ArrayList<ResourceCatalogProdStructure_DTO> getAllResourceCatalogProdStructures();
    public ArrayList<ResourceCatalogProdStructure_DTO> getSelectResourceCatalogProdStructures(ArrayList<Long> ids, ArrayList<Long> cids);
    public ArrayList<ResourceCatalogProdStructure_DTO> getSelectResourceCatalogsStructuresForCatalogs(ArrayList<Long> ids);
    public ArrayList<ResourceCatalogProdStructure_DTO> getSelectResourceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids);    
    public void updResourceCatalogProdStructure(ResourceCatalogProdStructure_DTO ResourceCatalogProdStructure_DTO);
    public void delAllResourceCatalogProdStructures();    
    public void delSelectResourceCatalogProdStructures(ArrayList<Long> ids, ArrayList<Long> cids);
    public void delSelectResourceCatalogsStructuresForCatalogs(ArrayList<Long> ids);
    public void delSelectResourceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids);
}



