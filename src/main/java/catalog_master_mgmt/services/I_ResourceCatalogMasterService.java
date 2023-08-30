package catalog_master_mgmt.services;

import java.util.ArrayList;

import catalog_master_mgmt.model.dto.ResourceCatalogMasterDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface I_ResourceCatalogMasterService
{
	abstract public Flux<ResourceCatalogMasterDTO> getAllResourceCatalogsAsync();
	abstract public Mono<ResourceCatalogMasterDTO> getResourceAsync(Long resSeqNo);
	abstract public ResourceCatalogMasterDTO newResourceCatalog(ResourceCatalogMasterDTO catalogMasterDTO);
    abstract public ArrayList<ResourceCatalogMasterDTO> getAllResourceCatalogs();
    abstract public ArrayList<ResourceCatalogMasterDTO> getAllResourceCatalogsForAnyCondition();
    abstract public ArrayList<ResourceCatalogMasterDTO> getAllResourceCatalogsForConditions(Integer parmLength, ArrayList<Long> cList, ArrayList<Long> rList, String catalog);
    abstract public ArrayList<ResourceCatalogMasterDTO> getSelectResourceCatalogsBetweenTimes(String fr, String to);
    abstract public ArrayList<ResourceCatalogMasterDTO> getSelectResourceCatalogs(ArrayList<Long> ids);
    abstract public ArrayList<ResourceCatalogMasterDTO> getSelectResourceCatalogsForCompanies(ArrayList<Long> ids);
    abstract public void updResourceCatalog(ResourceCatalogMasterDTO ResourceCatalogMasterDTO);
    abstract public void delAllResourceCatalogs();    
    abstract public void delSelectResourceCatalogs(ArrayList<Long> ids);
    abstract public void delSelectResourceCatalogsBetweenTimes(String fr, String to);    
    abstract public void delSelectResourceCatalogsForCompanies(ArrayList<Long> ids);
}