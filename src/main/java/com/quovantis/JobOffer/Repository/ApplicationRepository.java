package com.quovantis.JobOffer.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quovantis.JobOffer.Model.ApplicationEntity;

@Repository
public interface ApplicationRepository extends CrudRepository<ApplicationEntity, Long> {

	List<ApplicationEntity> findAllByOfferId(int id);
}
