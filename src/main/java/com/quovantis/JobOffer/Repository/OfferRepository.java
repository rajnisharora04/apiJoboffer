package com.quovantis.JobOffer.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quovantis.JobOffer.Model.OfferEntity;

@Repository
public interface OfferRepository extends CrudRepository<OfferEntity, Long>{

	OfferEntity findById(int id);
    
	@Modifying
	@Query("update OfferEntity s set s.numberOfApplications = ?1 where s.id = ?2")
	int updateNumberofApplications(int numberOfApplications, int id);
}
