package com.quovantis.JobOffer.Service;

import java.util.List;
import java.util.Map;

import com.quovantis.JobOffer.Model.ApplicationEntity;
import com.quovantis.JobOffer.Model.OfferEntity;

public interface JobOfferService {

	Map<String, Object> generateUseroffer(OfferEntity offer);

	Map<String, Object> getUseroffer(int offerid);

	Map<String, Object> getAllUserOffer();

	Map<String, Object> generateApplication(ApplicationEntity newApplication);
}
