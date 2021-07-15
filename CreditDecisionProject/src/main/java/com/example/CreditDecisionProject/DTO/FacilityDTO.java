package com.example.CreditDecisionProject.DTO;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class FacilityDTO {

	@JsonProperty(value = "id")
	private int id;
	@JsonProperty(value = "description")
	private String description;

}