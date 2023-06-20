package resource_catalog_location_class_structure_mgmt.controller;

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

import resource_catalog_location_class_structure_mgmt.model.dto.ResourceCatalogLocStructure_DTO;
import resource_catalog_location_class_structure_mgmt.services.I_ResourceCatalogLocStructure_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceCatalogLocStructureManagement")
public class ResourceCatalogLocStructure_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ResourceCatalogLocStructure_Controller.class);

	@Autowired
	private I_ResourceCatalogLocStructure_Service resourceCatalogLocStructureServ;

	@PostMapping("/new")
	public ResponseEntity<ResourceCatalogLocStructure_DTO> newResourceCatalogLocStructure(@RequestBody ResourceCatalogLocStructure_DTO ResourceCatalogLocStructure_DTO) 
	{
		ResourceCatalogLocStructure_DTO ResourceCatalogLocStructure_DTO2 = resourceCatalogLocStructureServ.newResourceCatalogLocStructure(ResourceCatalogLocStructure_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ResourceCatalogLocStructure_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getSelectResourceCatalogLocStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogLocStructure_DTO>> getSelectResourceCatalogLocStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		ArrayList<ResourceCatalogLocStructure_DTO> ResourceCatalogLocStructure_DTOs = resourceCatalogLocStructureServ.getSelectResourceCatalogLocStructures(ids, pids);
		return new ResponseEntity<>(ResourceCatalogLocStructure_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResourceCatalogsStructuresForCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogLocStructure_DTO>> getSelectResourceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ResourceCatalogLocStructure_DTO> ResourceCatalogLocStructure_DTOs = resourceCatalogLocStructureServ.getSelectResourceCatalogsStructuresForCatalogs(ids);
		return new ResponseEntity<>(ResourceCatalogLocStructure_DTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllResourceCatalogLocStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogLocStructure_DTO>> getAllResourceCatalogLocStructures() {
		ArrayList<ResourceCatalogLocStructure_DTO> ResourceCatalogLocStructure_DTOs = resourceCatalogLocStructureServ.getAllResourceCatalogLocStructures();
		return new ResponseEntity<>(ResourceCatalogLocStructure_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updResourceCatalogLocStructure")
	public void updateResourceCatalogLocStructure(@RequestBody ResourceCatalogLocStructure_DTO ResourceCatalogLocStructure_DTO) {
		resourceCatalogLocStructureServ.updResourceCatalogLocStructure(ResourceCatalogLocStructure_DTO);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogLocStructures")
	public void deleteSelectResourceCatalogLocStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		resourceCatalogLocStructureServ.delSelectResourceCatalogLocStructures(ids, pids);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogsStructuresForCatalogs")
	public void delSelectResourceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		resourceCatalogLocStructureServ.delSelectResourceCatalogsStructuresForCatalogs(ids);
		return;
	}
	
	@DeleteMapping("/delSelectResourceChildStructuresForCatalogs")
	public void delSelectResourceChildStructuresForCatalogs(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> cids) 
	{
		resourceCatalogLocStructureServ.delSelectResourceChildStructuresForCatalogs(ids, cids);
		return;
	}
	
	@DeleteMapping("/delAllResourceCatalogLocStructure")
	public void deleteAllResourceCatalogLocStructure() {
		resourceCatalogLocStructureServ.delAllResourceCatalogLocStructures();
		;
		return;
	}
}