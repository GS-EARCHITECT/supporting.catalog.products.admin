package compclass_mgmt.controller;

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

import compclass_mgmt.model.dto.ResourceCatalogCompClass_DTO;
import compclass_mgmt.services.I_ResourceCatalogCompClass_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceCatalogCompanyClassManagement")
public class ResourceCatalogCompClass_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ResourceCatalogCompClass_Controller.class);

	@Autowired
	private I_ResourceCatalogCompClass_Service resourceCatalogCompClassServ;

	@PostMapping("/new")
	public ResponseEntity<ResourceCatalogCompClass_DTO> newResourceCatalogCompClass(@RequestBody ResourceCatalogCompClass_DTO ResourceCatalogCompClass_DTO) 
	{
		ResourceCatalogCompClass_DTO ResourceCatalogCompClass_DTO2 = resourceCatalogCompClassServ.newResourceCatalogCompClass(ResourceCatalogCompClass_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ResourceCatalogCompClass_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getSelectResourceCatalogCompanyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogCompClass_DTO>> getSelectResourceCatalogCompanies(@RequestBody ArrayList<Long> fids)
	{
		ArrayList<ResourceCatalogCompClass_DTO> ResourceCatalogCompClass_DTOs = resourceCatalogCompClassServ.getSelectResourceCatalogCompanies(fids);
		return new ResponseEntity<>(ResourceCatalogCompClass_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResourceCatalogsCompanyClassesForCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogCompClass_DTO>> getSelectResourceCatalogsCompaniesForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ResourceCatalogCompClass_DTO> ResourceCatalogCompClass_DTOs = resourceCatalogCompClassServ.getSelectResourceCatalogsCompaniesForCatalogs(ids);
		return new ResponseEntity<>(ResourceCatalogCompClass_DTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllResourceCatalogCompanyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogCompClass_DTO>> getAllResourceCatalogCompanies() {
		ArrayList<ResourceCatalogCompClass_DTO> ResourceCatalogCompClass_DTOs = resourceCatalogCompClassServ.getAllResourceCatalogCompanies();
		return new ResponseEntity<>(ResourceCatalogCompClass_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updResourceCatalogCompanyClass")
	public void updateResourceCatalogCompClass(@RequestBody ResourceCatalogCompClass_DTO ResourceCatalogCompClass_DTO) {
		resourceCatalogCompClassServ.updResourceCatalogCompClass(ResourceCatalogCompClass_DTO);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogCompanyClasses")
	public void deleteSelectResourceCatalogCompanies(@RequestBody ArrayList<Long> fids)
	{
		resourceCatalogCompClassServ.delSelectResourceCatalogCompanies(fids);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogsCompanyClassesForCatalogs")
	public void delSelectResourceCatalogsCompaniesForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		resourceCatalogCompClassServ.delSelectResourceCatalogsCompaniesForCatalogs(ids);
		return;
	}
	
	@DeleteMapping("/delAllResourceCatalogCompanyClass")
	public void deleteAllResourceCatalogCompClass() {
		resourceCatalogCompClassServ.delAllResourceCatalogCompanies();		
		return;
	}
}