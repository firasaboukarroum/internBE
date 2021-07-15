package com.example.CreditDecisionProject.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CreditDecisionProject.Convert.FacilityConverter;
import com.example.CreditDecisionProject.Entities.FacilityEntity;
import com.example.CreditDecisionProject.Repository.FacilityRepository;

@Service
public class FacilityServices {

	@Autowired
	FacilityRepository Repo;

	/* find all Facility */
	public List<FacilityEntity> findFacilities() {

		return Repo.findAll();
	}

	// Update Facility
	public FacilityEntity saveOrUpdate(FacilityEntity f) {
		if (f.getDescription() != null) {
			FacilityEntity Data = Repo.findById(f.getId()).orElseThrow();
			if (Data == null) {
				return Repo.save(f);
			} else {
				Data = FacilityConverter.toUpdateFacility(Data, f);
			}
			return Repo.save(Data);
		}

		return Repo.save(f);
	}
	// FindById Facility
	public FacilityEntity findById(Integer id) {
		return Repo.findById(id).orElseThrow();
	}

	// Delete Facility
	public void deleteById(Integer id) {
		FacilityEntity Data = Repo.findById(id).orElseThrow();

		Repo.deleteById(Data.getId());
	}

	// save Facility
	public FacilityEntity save(FacilityEntity f) {

		return Repo.save(f);
	}
}
