package resource_catalog_resource_class_structure_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource_catalog_resource_class_structure_mgmt.model.dto.ResourceCatalogProdStructure_DTO;
import resource_catalog_resource_class_structure_mgmt.services.I_ResourceCatalogProdStructure_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceCatalogProdStructureManagement")
public class ResourceCatalogProdStructure_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ResourceCatalogProdStructure_Controller.class);

	@Autowired
	private I_ResourceCatalogProdStructure_Service resourceCatalogProdStructureServ;

	@PostMapping("/new")
	public ResponseEntity<ResourceCatalogProdStructure_DTO> newResourceCatalogProdStructure(@RequestBody ResourceCatalogProdStructure_DTO ResourceCatalogProdStructure_DTO) 
	{
		ResourceCatalogProdStructure_DTO ResourceCatalogProdStructure_DTO2 = resourceCatalogProdStructureServ.newResourceCatalogProdStructure(ResourceCatalogProdStructure_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ResourceCatalogProdStructure_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getSelectResourceCatalogProdStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogProdStructure_DTO>> getSelectResourceCatalogProdStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		ArrayList<ResourceCatalogProdStructure_DTO> ResourceCatalogProdStructure_DTOs = resourceCatalogProdStructureServ.getSelectResourceCatalogProdStructures(ids, pids);
		return new ResponseEntity<>(ResourceCatalogProdStructure_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResourceCatalogsStructuresForCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogProdStructure_DTO>> getSelectResourceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ResourceCatalogProdStructure_DTO> ResourceCatalogProdStructure_DTOs = resourceCatalogProdStructureServ.getSelectResourceCatalogsStructuresForCatalogs(ids);
		return new ResponseEntity<>(ResourceCatalogProdStructure_DTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllResourceCatalogProdStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogProdStructure_DTO>> getAllResourceCatalogProdStructures() {
		ArrayList<ResourceCatalogProdStructure_DTO> ResourceCatalogProdStructure_DTOs = resourceCatalogProdStructureServ.getAllResourceCatalogProdStructures();
		return new ResponseEntity<>(ResourceCatalogProdStructure_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updResourceCatalogProdStructure")
	public void updateResourceCatalogProdStructure(@RequestBody ResourceCatalogProdStructure_DTO ResourceCatalogProdStructure_DTO) {
		resourceCatalogProdStructureServ.updResourceCatalogProdStructure(ResourceCatalogProdStructure_DTO);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogProdStructures")
	public void deleteSelectResourceCatalogProdStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		resourceCatalogProdStructureServ.delSelectResourceCatalogProdStructures(ids, pids);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogsStructuresForCatalogs")
	public void delSelectResourceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		resourceCatalogProdStructureServ.delSelectResourceCatalogsStructuresForCatalogs(ids);
		return;
	}
	
	@DeleteMapping("/delSelectResourceChildStructuresForCatalogs")
	public void delSelectResourceChildStructuresForCatalogs(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> cids) 
	{
		resourceCatalogProdStructureServ.delSelectResourceChildStructuresForCatalogs(ids, cids);
		return;
	}
	
	@DeleteMapping("/delAllResourceCatalogProdStructure")
	public void deleteAllResourceCatalogProdStructure() {
		resourceCatalogProdStructureServ.delAllResourceCatalogProdStructures();
		;
		return;
	}
}