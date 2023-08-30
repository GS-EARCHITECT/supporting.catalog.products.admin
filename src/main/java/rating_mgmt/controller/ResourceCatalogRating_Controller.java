package rating_mgmt.controller;

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

import rating_mgmt.model.dto.ResourceCatalogRating_DTO;
import rating_mgmt.services.I_ResourceCatalogRating_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceCatalogRatingManagement")
public class ResourceCatalogRating_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ResourceCatalogRating_Controller.class);

	@Autowired
	private I_ResourceCatalogRating_Service resourceCatalogRatingServ;

	@PostMapping("/new")
	public ResponseEntity<ResourceCatalogRating_DTO> newResourceCatalogRating(@RequestBody ResourceCatalogRating_DTO ResourceCatalogRating_DTO) 
	{
		ResourceCatalogRating_DTO ResourceCatalogRating_DTO2 = resourceCatalogRatingServ.newResourceCatalogRating(ResourceCatalogRating_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ResourceCatalogRating_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getSelectResourceCatalogRatings", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogRating_DTO>> getSelectResourceCatalogRatings(@RequestBody ArrayList<Float> fids)
	{
		ArrayList<ResourceCatalogRating_DTO> ResourceCatalogRating_DTOs = resourceCatalogRatingServ.getSelectResourceCatalogRatings(fids);
		return new ResponseEntity<>(ResourceCatalogRating_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResourceCatalogsRatingsForCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogRating_DTO>> getSelectResourceCatalogsRatingsForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ResourceCatalogRating_DTO> ResourceCatalogRating_DTOs = resourceCatalogRatingServ.getSelectResourceCatalogsRatingsForCatalogs(ids);
		return new ResponseEntity<>(ResourceCatalogRating_DTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllResourceCatalogRatings", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceCatalogRating_DTO>> getAllResourceCatalogRatings() {
		ArrayList<ResourceCatalogRating_DTO> ResourceCatalogRating_DTOs = resourceCatalogRatingServ.getAllResourceCatalogRatings();
		return new ResponseEntity<>(ResourceCatalogRating_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updResourceCatalogRating")
	public void updateResourceCatalogRating(@RequestBody ResourceCatalogRating_DTO ResourceCatalogRating_DTO) {
		resourceCatalogRatingServ.updResourceCatalogRating(ResourceCatalogRating_DTO);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogRatings")
	public void deleteSelectResourceCatalogRatings(@RequestBody ArrayList<Float> fids)
	{
		resourceCatalogRatingServ.delSelectResourceCatalogRatings(fids);
		return;
	}

	@DeleteMapping("/delSelectResourceCatalogsRatingsForCatalogs")
	public void delSelectResourceCatalogsRatingsForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		resourceCatalogRatingServ.delSelectResourceCatalogsRatingsForCatalogs(ids);
		return;
	}
	
	@DeleteMapping("/delAllResourceCatalogRating")
	public void deleteAllResourceCatalogRating() {
		resourceCatalogRatingServ.delAllResourceCatalogRatings();
		;
		return;
	}
}