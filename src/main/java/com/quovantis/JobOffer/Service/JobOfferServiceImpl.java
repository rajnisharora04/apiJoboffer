package com.quovantis.JobOffer.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quovantis.JobOffer.Model.ApplicationEntity;
import com.quovantis.JobOffer.Model.OfferEntity;
import com.quovantis.JobOffer.Repository.ApplicationRepository;
import com.quovantis.JobOffer.Repository.OfferRepository;

@Service
public class JobOfferServiceImpl implements JobOfferService{

	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	Map<String, Object> resp=new LinkedHashMap<String, Object>();
	
	@Override
	public Map<String, Object> generateUseroffer(OfferEntity offer) {
		// save the offer details
		offerRepository.save(offer);
		resp.put("response", "1 row created");
		return resp;
		
	}

	@Override
	public Map<String, Object> getUseroffer(int offerid) {
		//get offer by id
		OfferEntity oneoffer=offerRepository.findById(offerid);
		
		resp.put("response", oneoffer);
		return resp;
	}

	@Override
	public Map<String, Object> getAllUserOffer() {
		List<OfferEntity> oneoffer=(List<OfferEntity>) offerRepository.findAll();
		resp.put("response", oneoffer);
		return resp;
	}

	@Override
	@Transactional
	public Map<String, Object> generateApplication(ApplicationEntity newApplication) {
		// create application
		ApplicationEntity response=applicationRepository.save(newApplication);
		
		//get the application list basis offer id
		List<ApplicationEntity> applicationList=applicationRepository.findAllByOfferId(newApplication.getOffer().getId());
		int numberOfApplications=applicationList.size();
		System.out.println("number os applications ::"+numberOfApplications);
		//update the number of applications field in offer table basis the offer id and list size
		int response1=offerRepository.updateNumberofApplications(numberOfApplications,newApplication.getOffer().getId());
		
		resp.put("response", "1 row created");
		return resp;
	}

}
