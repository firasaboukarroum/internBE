package com.example.CreditDecisionProject.Repository;

import org.springframework.stereotype.Repository;

import com.example.CreditDecisionProject.Entities.FacilityEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FacilityRepository extends JpaRepository<FacilityEntity, Integer> {

}
