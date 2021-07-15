package com.example.CreditDecisionProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CreditDecisionProject.Convert.FacilityConverter;
import com.example.CreditDecisionProject.DTO.FacilityDTO;
import com.example.CreditDecisionProject.Entities.FacilityEntity;
import com.example.CreditDecisionProject.Services.FacilityServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Facilities")
public class Controller {

	@Autowired
	private FacilityServices facilityService;

	Logger logger = LoggerFactory.getLogger(Controller.class);

	/**
	 * add Facility
	 */
	@PostMapping("/AddFacility")
	public boolean AddFacility(@RequestBody FacilityDTO fDTO) {

		FacilityEntity f = FacilityConverter.toFacility(fDTO);

		if (f.getDescription() == null) {
			logger.info("DATA ERROR");
			return false;
		} else {
			FacilityEntity facility = facilityService.save(f);
			if (facility != null) {
				logger.info("Added Success");
				return true;
			} else {
				logger.info("ERROR");
				return false;
			}
		}

	}

	/**
	 * @return list of Facility
	 */
	@GetMapping("/AllFacilities")
	public List<FacilityDTO> findAll() {
		List<FacilityEntity> findAll = facilityService.findFacilities();
		return FacilityConverter.toFacilityDTOs(findAll);
	}

	/** delete facility */

	@DeleteMapping("/deleteByFacilityID/{facilityID}")
	public void deleteByFacilityId(@PathVariable("facilityID") Integer id) {
		facilityService.deleteById(id);
		logger.info("Deleted");
	}

	// update facility rest api

	@PutMapping("/UpdateFacility/{id}")
	public boolean updateStudent(@PathVariable Integer id, @RequestBody FacilityDTO fdetails) {

		FacilityEntity updatedf = null;
		FacilityEntity f = facilityService.findById(id);
		FacilityEntity ft = FacilityConverter.toFacility(fdetails);

		if (ft.getDescription() == null) {
			logger.info("DATA ERROR");
			return false;
		} else {
			if (f == null) {
				logger.info("Incorrect ID");

			} else {

				f.setDescription(ft.getDescription());
				updatedf = facilityService.save(f);

			}
			if (updatedf == null) {
				logger.info("DATA ERROR");
				return false;
			} else {
				logger.info("Updated Success");
				return true;
			}
		}
	}

	// get Facility by id
	@GetMapping("/Facility/{id}")
	public FacilityDTO getstudentByID(@PathVariable("id") Integer id) {
		FacilityEntity find = facilityService.findById(id);
		return FacilityConverter.toFacilityDTO(find);
	}

}
