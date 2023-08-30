package catalog_master_mgmt.services;

import org.slf4j.Logger;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import catalog_master_mgmt.model.dto.ResourceCatalogMasterDTO;
import catalog_master_mgmt.model.master.ResourceCatalogMaster;
import catalog_master_mgmt.model.master.ResourceCatalogReadMaster;
import catalog_master_mgmt.model.repo.IResourceCatalogReadMasterRepo;
import catalog_master_mgmt.model.repo.ResourceCatalogMasterRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("resourceCatalogMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceCatalogMasterService implements I_ResourceCatalogMasterService 
{
//	private static final Logger logger = LoggerFactory.getLogger(ResourceCatalogMasterService.class);
	
	@Autowired
	private ResourceCatalogMasterRepo resourceCatalogMasterRepo;

	@Autowired
	private IResourceCatalogReadMasterRepo resourceCatalogMasterReadRepo;

	public Mono<ResourceCatalogMasterDTO> getResourceAsync(Long resSeqNo) {

		CompletableFuture<ResourceCatalogMasterDTO> future = CompletableFuture.supplyAsync(() -> {
			Optional<ResourceCatalogMaster> resOptional = resourceCatalogMasterRepo.findById(resSeqNo);
			ResourceCatalogMasterDTO rdto = null;

			if (resOptional.isPresent()) {
				ResourceCatalogMaster v = resOptional.get();
				rdto = this.getResourceCatalogMasterDTO(v);
			}
			return rdto;
		});
		Mono<ResourceCatalogMasterDTO> monoFromFuture = Mono.fromFuture(future);

		return monoFromFuture;
	}

	@Override
	public Flux<ResourceCatalogMasterDTO> getAllResourceCatalogsAsync() {
		return Flux.create((emitter) -> {
			CompletableFuture<ArrayList<ResourceCatalogMasterDTO>> future = CompletableFuture.supplyAsync(() -> {
				ArrayList<ResourceCatalogMaster> resCatList = (ArrayList<ResourceCatalogMaster>) resourceCatalogMasterRepo
						.findAll();
				ArrayList<ResourceCatalogMasterDTO> resCatDtoList = this.getResourceCatalogMasterDTOs(resCatList);
				return resCatDtoList;
			});
			future.whenComplete((resCatDtoList, exception) -> {
				if (exception == null) {
					resCatDtoList.forEach(emitter::next);
					emitter.complete();
				} else {
					emitter.complete();
				}
			});
		});
	}

	public ResourceCatalogMasterDTO newResourceCatalog(ResourceCatalogMasterDTO lMaster) {
		if (!resourceCatalogMasterRepo.existsById(lMaster.getResourceCatalogSeqNo())) {
			ResourceCatalogMaster resourceCatalogMaster = resourceCatalogMasterRepo
					.save(this.setResourceCatalogMaster(lMaster));
			lMaster = getResourceCatalogMasterDTO(resourceCatalogMaster);
		}
		return lMaster;
	}

	public ArrayList<ResourceCatalogMasterDTO> getAllResourceCatalogsForAnyCondition() {
		ArrayList<ResourceCatalogReadMaster> resourceCatalogReadList = (ArrayList<ResourceCatalogReadMaster>) resourceCatalogMasterReadRepo
				.findAll();
		ArrayList<ResourceCatalogMasterDTO> lMasters = new ArrayList<ResourceCatalogMasterDTO>();
		lMasters = resourceCatalogReadList != null ? this.getResourceCatalogReadMasterDTOs(resourceCatalogReadList)
				: null;
		return lMasters;
	}

	public ArrayList<ResourceCatalogMasterDTO> getAllResourceCatalogsForConditions(Integer parmLength,
			ArrayList<Long> cList, ArrayList<Long> rList, String catalog) {
		ArrayList<Long> compList = new ArrayList<Long>();
		ArrayList<Long> resList = new ArrayList<Long>();
		String catalog2 = "ibm";
		Integer parmLength2 = 3;
		compList.add((long) 2);
		compList.add((long) 15);
		resList.add((long) 1);
		resList.add((long) 2);
		List<ResourceCatalogReadMaster> compResourceCatalogReadList = resourceCatalogMasterReadRepo
				.findAllForConditions(parmLength2, compList, resList, catalog2);
		ArrayList<ResourceCatalogReadMaster> resourceCatalogReadList = (ArrayList<ResourceCatalogReadMaster>) compResourceCatalogReadList;
		ArrayList<ResourceCatalogMasterDTO> lMasters = new ArrayList<ResourceCatalogMasterDTO>();
		lMasters = resourceCatalogReadList != null ? this.getResourceCatalogReadMasterDTOs(resourceCatalogReadList)
				: null;
		return lMasters;
	}

	public ArrayList<ResourceCatalogMasterDTO> getAllResourceCatalogs() {
		ArrayList<ResourceCatalogMaster> resourceCatalogList = (ArrayList<ResourceCatalogMaster>) resourceCatalogMasterRepo
				.findAll();
		ArrayList<ResourceCatalogMasterDTO> lMasters = new ArrayList<ResourceCatalogMasterDTO>();
		lMasters = resourceCatalogList != null ? this.getResourceCatalogMasterDTOs(resourceCatalogList) : null;
		return lMasters;
	}

	public ArrayList<ResourceCatalogMasterDTO> getSelectResourceCatalogsBetweenTimes(String fr, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		ArrayList<ResourceCatalogMaster> lMasters = resourceCatalogMasterRepo
				.getSelectResourceCatalogsBetweenTimes(ts_Fr, ts_To);
		ArrayList<ResourceCatalogMasterDTO> resourceCatalogMasterDTOs = new ArrayList<ResourceCatalogMasterDTO>();
		resourceCatalogMasterDTOs = lMasters != null ? this.getResourceCatalogMasterDTOs(lMasters) : null;
		return resourceCatalogMasterDTOs;
	}

	public ArrayList<ResourceCatalogMasterDTO> getSelectResourceCatalogs(ArrayList<Long> ids) {
		ArrayList<ResourceCatalogMaster> lMasters = resourceCatalogMasterRepo.getSelectResourceCatalogs(ids);
		ArrayList<ResourceCatalogMasterDTO> resourceCatalogMasterDTOs = new ArrayList<ResourceCatalogMasterDTO>();
		resourceCatalogMasterDTOs = lMasters != null ? this.getResourceCatalogMasterDTOs(lMasters) : null;
		return resourceCatalogMasterDTOs;
	}

	public ArrayList<ResourceCatalogMasterDTO> getSelectResourceCatalogsForCompanies(ArrayList<Long> ids) {
		ArrayList<ResourceCatalogMaster> lMasters = resourceCatalogMasterRepo
				.getSelectResourceCatalogsForCompanies(ids);
		ArrayList<ResourceCatalogMasterDTO> resourceCatalogMasterDTOs = new ArrayList<ResourceCatalogMasterDTO>();
		resourceCatalogMasterDTOs = lMasters != null ? this.getResourceCatalogMasterDTOs(lMasters) : null;
		return resourceCatalogMasterDTOs;
	}

	public void updResourceCatalog(ResourceCatalogMasterDTO lMaster) {
		ResourceCatalogMaster resourceCatalogMaster = this.setResourceCatalogMaster(lMaster);
		if (resourceCatalogMasterRepo.existsById(lMaster.getResourceCatalogSeqNo())) {
			resourceCatalogMaster.setResourceCatalogSeqNo(lMaster.getResourceCatalogSeqNo());
			resourceCatalogMasterRepo.save(resourceCatalogMaster);
		}
		return;
	}

	public void delSelectResourceCatalogsBetweenTimes(String fr, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		resourceCatalogMasterRepo.delSelectResourceCatalogsBetweenTimes(ts_Fr, ts_To);
		return;
	}

	public void delSelectResourceCatalogs(ArrayList<Long> ids) {
		resourceCatalogMasterRepo.delSelectResourceCatalogs(ids);
		return;
	}

	public void delSelectResourceCatalogsForCompanies(ArrayList<Long> ids) {
		resourceCatalogMasterRepo.delSelectResourceCatalogsForCompanies(ids);
		return;
	}

	public void delAllResourceCatalogs() {
		resourceCatalogMasterRepo.deleteAll();
	}

	private ArrayList<ResourceCatalogMasterDTO> getResourceCatalogMasterDTOs(ArrayList<ResourceCatalogMaster> lMaster) {
		ResourceCatalogMasterDTO lDTO = null;
		ArrayList<ResourceCatalogMasterDTO> lMasterDTOs = new ArrayList<ResourceCatalogMasterDTO>();
		for (int i = 0; i < lMaster.size(); i++) {
			lDTO = getResourceCatalogMasterDTO(lMaster.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ArrayList<ResourceCatalogMasterDTO> getResourceCatalogReadMasterDTOs(
			ArrayList<ResourceCatalogReadMaster> lMaster) {
		ResourceCatalogMasterDTO lDTO = null;
		ArrayList<ResourceCatalogMasterDTO> lMasterDTOs = new ArrayList<ResourceCatalogMasterDTO>();
		for (int i = 0; i < lMaster.size(); i++) {
			lDTO = getResourceCatalogReadMasterDTO(lMaster.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceCatalogMasterDTO getResourceCatalogReadMasterDTO(ResourceCatalogReadMaster lMaster) {
		ResourceCatalogMasterDTO lDTO = new ResourceCatalogMasterDTO();
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy
		// HH:mm:ss");
		// lDTO.setFromDttm(formatter.format(lMaster.getFromDttm().toLocalDateTime()));
		// lDTO.setToDttm(formatter.format(lMaster.getToDttm().toLocalDateTime()));
		lDTO.setCatalog(lMaster.getCatalog());
		lDTO.setRemark(lMaster.getRemark());
		lDTO.setResourceCatalogSeqNo(lMaster.getResourceCatalogSeqNo());
		lDTO.setStatus(lMaster.getStatus());
		return lDTO;
	}

	private ResourceCatalogMasterDTO getResourceCatalogMasterDTO(ResourceCatalogMaster lMaster) {
		ResourceCatalogMasterDTO lDTO = new ResourceCatalogMasterDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		lDTO.setFromDttm(formatter.format(lMaster.getFromDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(lMaster.getToDttm().toLocalDateTime()));
		lDTO.setCatalog(lMaster.getCatalog());
		lDTO.setRemark(lMaster.getRemark());
		lDTO.setResourceCatalogSeqNo(lMaster.getResourceCatalogSeqNo());
		lDTO.setStatus(lMaster.getStatus());
		return lDTO;
	}

	private ResourceCatalogMaster setResourceCatalogMaster(ResourceCatalogMasterDTO lDTO) {
		ResourceCatalogMaster lMaster = new ResourceCatalogMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(lDTO.getFromDttm(), formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(lDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		lMaster.setFromDttm(ts_Fr);
		lMaster.setToDttm(ts_To);
		lMaster.setCatalog(lDTO.getCatalog());
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setStatus(lDTO.getStatus());
		return lMaster;
	}
}