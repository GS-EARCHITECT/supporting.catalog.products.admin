package resource_catalog_master_mgmt.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import resource_catalog_master_mgmt.model.dto.ResourceCatalogMasterDTO;
import resource_catalog_master_mgmt.services.I_ResourceCatalogMasterService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceCatalogManagement")
public class ResourceCatalogMasterController {

	private static final Logger logger = LoggerFactory.getLogger(ResourceCatalogMasterController.class);

	@Autowired
	private I_ResourceCatalogMasterService resourceCatalogMasterServ;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ResourceCatalogMasterDTO> getVehicleByIdAsync(@PathVariable("id") Long id) 
	{
	return resourceCatalogMasterServ.getResourceAsync(id);
	}
	
	@GetMapping(value = "/getAllResourceCatalogsForConditionsAsync", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Flux<ResourceCatalogMasterDTO>> getAllResourceCatalogsForConditionsAsync() 
	{
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		logger.info("hit at condition async : " + System.currentTimeMillis());
		Flux<ResourceCatalogMasterDTO> resourceCatalogDTOs = resourceCatalogMasterServ.getAllResourceCatalogsAsync();				
		return new ResponseEntity<>(resourceCatalogDTOs, HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<ResourceCatalogMasterDTO> newresourceCatalog(
			@RequestBody ResourceCatalogMasterDTO resourceCatalogDTO) {
		ResourceCatalogMasterDTO resourceCatalogDTO2 = resourceCatalogMasterServ.newResourceCatalog(resourceCatalogDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceCatalogDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllResourceCatalogsForAnyCondition", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogMasterDTO>> getAllResourceCatalogsForAnyCondition() {
		ArrayList<ResourceCatalogMasterDTO> resourceCatalogDTOs = resourceCatalogMasterServ
				.getAllResourceCatalogsForAnyCondition();
		return new ResponseEntity<>(resourceCatalogDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllResourceCatalogsForConditions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogMasterDTO>> getAllResourceCatalogsForConditions() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		//Date date = new Date();
		logger.info("hit at condition 2: " + System.currentTimeMillis());
		ArrayList<ResourceCatalogMasterDTO> resourceCatalogDTOs = resourceCatalogMasterServ
				.getAllResourceCatalogsForConditions(null, null, null, null);
		return new ResponseEntity<>(resourceCatalogDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllResourceCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogMasterDTO>> getAllResourceCatalogMasters() 
	{
		ArrayList<ResourceCatalogMasterDTO> resourceCatalogDTOs = resourceCatalogMasterServ.getAllResourceCatalogs();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		logger.info("hit at all : " + System.currentTimeMillis());
		return new ResponseEntity<>(resourceCatalogDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourceCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogMasterDTO>> getSelectResourceCatalogsMasters(
			@RequestBody ArrayList<Long> resourceCatalogSeqNos) {
		ArrayList<ResourceCatalogMasterDTO> resourceCatalogDTOs = resourceCatalogMasterServ
				.getSelectResourceCatalogs(resourceCatalogSeqNos);
		return new ResponseEntity<>(resourceCatalogDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourceCatalogsBetweenTimes/{fr}/{to}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogMasterDTO>> getSelectResourceCatalogsBetweenTimes(
			@PathVariable String fr, @PathVariable String to) {
		ArrayList<ResourceCatalogMasterDTO> resourceCatalogDTOs = resourceCatalogMasterServ
				.getSelectResourceCatalogsBetweenTimes(fr, to);
		return new ResponseEntity<>(resourceCatalogDTOs, HttpStatus.OK);
	}

	@PutMapping("/updResourceCatalog")
	public void updateResourceCatalog(@RequestBody ResourceCatalogMasterDTO resourceCatalogDTO) {
		resourceCatalogMasterServ.updResourceCatalog(resourceCatalogDTO);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogs")
	public void deleteSelectresourceCatalogs(@RequestBody ArrayList<Long> resourceCatalogSeqNoList) {
		resourceCatalogMasterServ.delSelectResourceCatalogs(resourceCatalogSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogsBetweenTimes/{fr}/{to}")
	public void delSelectResourceCatalogsBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		resourceCatalogMasterServ.delSelectResourceCatalogsBetweenTimes(fr, to);
		return;
	}

	@DeleteMapping("/delAllResourceCatalogs")
	public void deleteAllResourceCatalogs() {
		resourceCatalogMasterServ.delAllResourceCatalogs();
		;
		return;
	}
}