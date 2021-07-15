package com.example.CreditDecisionProject.Convert;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.CreditDecisionProject.DTO.FacilityDTO;
import com.example.CreditDecisionProject.Entities.FacilityEntity;

@Component
public class FacilityConverter {

	public FacilityConverter() {
	}
	// convert from dto to facility

	public static FacilityEntity toFacility(FacilityDTO dto) {
		ModelMapper mapper = new ModelMapper();
		FacilityEntity map = mapper.map(dto, FacilityEntity.class);
		return map;
	}

	// convert from entity to dto

	public static FacilityDTO toFacilityDTO(FacilityEntity s) {
		if (s == null) {
			return null;
		}

		return FacilityDTO.builder()
				.id(s.getId()) 
				.description(s.getDescription())
				.build();
	}

	// Update Facility
	public static FacilityEntity toUpdateFacility(FacilityEntity f, FacilityEntity updatest) {

		f.setDescription(updatest.getDescription() == null ? f.getDescription() : updatest.getDescription());

		return f;
	}

	// get list of Facility
	public static List<FacilityEntity> toFacility(List<FacilityDTO> fcDTOS) {
		return fcDTOS.stream().map(a -> toFacility(a)).collect(Collectors.toList());
	}

	public static List<FacilityDTO> toFacilityDTOs(List<FacilityEntity> findAll) {
		return findAll.stream().map(a -> toFacilityDTO(a)).collect(Collectors.toList());
	}
}
