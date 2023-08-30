package pricerange_mgmt.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import pricerange_mgmt.model.dto.ResourceCatalogPriceRange_DTO;
import pricerange_mgmt.services.I_ResourceCatalogPriceRange_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceCatalogPriceRangeManagement")
public class ResourceCatalogPriceRange_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ResourceCatalogPriceRange_Controller.class);

	@Autowired
	private I_ResourceCatalogPriceRange_Service resourceCatalogPriceRangeServ;

	@PostMapping("/new")
	public ResponseEntity<ResourceCatalogPriceRange_DTO> newResourceCatalogPriceRange(
			@RequestBody ResourceCatalogPriceRange_DTO ResourceCatalogPriceRange_DTO) {
		ResourceCatalogPriceRange_DTO ResourceCatalogPriceRange_DTO2 = resourceCatalogPriceRangeServ
				.newResourceCatalogPriceRange(ResourceCatalogPriceRange_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ResourceCatalogPriceRange_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllResourceCatalogPriceRanges", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogPriceRange_DTO>> getAllResourceCatalogPriceRanges() {
		ArrayList<ResourceCatalogPriceRange_DTO> ResourceCatalogPriceRange_DTOs = resourceCatalogPriceRangeServ
				.getAllResourceCatalogPriceRanges();
		return new ResponseEntity<>(ResourceCatalogPriceRange_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourceCatalogsBetweenPrices/{frPrice}/{toPrice}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogPriceRange_DTO>> getSelectResourceCatalogsBetweenPrices(
			@RequestBody ArrayList<Long> ids, @PathVariable Float frPrice, @PathVariable Float toPrice) {
		ArrayList<ResourceCatalogPriceRange_DTO> ResourceCatalogPriceRange_DTOs = resourceCatalogPriceRangeServ
				.getSelectResourceCatalogsBetweenPrices(ids, frPrice, toPrice);
		return new ResponseEntity<>(ResourceCatalogPriceRange_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourceCatalogsPriceRanges", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogPriceRange_DTO>> getSelectResourceCatalogsPriceRanges(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<ResourceCatalogPriceRange_DTO> ResourceCatalogPriceRange_DTOs = resourceCatalogPriceRangeServ
				.getSelectResourceCatalogsPriceRanges(ids);
		return new ResponseEntity<>(ResourceCatalogPriceRange_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourceCatalogsForPriceRange/{frPrice}/{toPrice}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogPriceRange_DTO>> getSelectResourceCatalogsForPriceRange(
			@PathVariable Float frPrice, @PathVariable Float toPrice) {
		ArrayList<ResourceCatalogPriceRange_DTO> ResourceCatalogPriceRange_DTOs = resourceCatalogPriceRangeServ
				.getSelectResourceCatalogsForPriceRange(frPrice, toPrice);
		return new ResponseEntity<>(ResourceCatalogPriceRange_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updResourceCatalogPriceRange")
	public void updateResourceCatalogPriceRange(@RequestBody ResourceCatalogPriceRange_DTO ResourceCatalogPriceRange_DTO) {
		resourceCatalogPriceRangeServ.updResourceCatalogPriceRange(ResourceCatalogPriceRange_DTO);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogsBetweenPrices/{frPrice}/{toPrice}")
	public void delSelectResourceCatalogsBetweenPrices(@RequestBody ArrayList<Long> ids, @PathVariable Float frPrice,
			@PathVariable Float toPrice) {
		resourceCatalogPriceRangeServ.delSelectResourceCatalogsBetweenPrices(ids, frPrice, toPrice);
		return;
	}

	@DeleteMapping("/deltSelectResourceCatalogsPriceRanges")
	public void delSelectResourceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) {
		resourceCatalogPriceRangeServ.deltSelectResourceCatalogsPriceRanges(ids);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogsForPriceRange/{frPrice}/{toPrice}")
	public void delSelectResourceCatalogsForPriceRange(@PathVariable Float frPrice, @PathVariable Float toPrice) {
		resourceCatalogPriceRangeServ.delSelectResourceCatalogsForPriceRange(frPrice, toPrice);
		return;
	}

	@DeleteMapping("/delAllResourceCatalogPriceRange")
	public void deleteAllResourceCatalogPriceRange() {
		resourceCatalogPriceRangeServ.delAllResourceCatalogPriceRanges();
		;
		return;
	}
}