package com.quovantis.JobOffer.Controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quovantis.JobOffer.DTO.CustomResponseDTO;
import com.quovantis.JobOffer.Model.ApplicationEntity;
import com.quovantis.JobOffer.Model.OfferEntity;
import com.quovantis.JobOffer.Service.JobOfferService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
public class JobOfferController {

	@Autowired
	JobOfferService jobOfferService;
	
	// create job offer
	@PostMapping(path="/createjobOffer",produces="application/json",consumes="application/json")
	  public ResponseEntity<CustomResponseDTO> createjobOffer(@RequestBody OfferEntity newoffer) 
	  {
		CustomResponseDTO customeResponse=new CustomResponseDTO();
	    HashMap<String, Object> dataMap = new LinkedHashMap<>();
		try
		{
			
	
			Map<String, Object>responseMap = jobOfferService.generateUseroffer(newoffer);
			System.out.println(responseMap);
			
			dataMap.put("Data",responseMap);
			
			if (dataMap.isEmpty()) {
				dataMap.put("Data", null);
				customeResponse.setResponseData(dataMap);
				customeResponse.setStatusCode(201);
				customeResponse.setMessage("NO CONTENT Available");
		        return new ResponseEntity<>(customeResponse,HttpStatus.NO_CONTENT);
		      }
			else
			{
				
				customeResponse.setResponseData(dataMap);
				customeResponse.setStatusCode(200);
				customeResponse.setMessage("SUCCESS");
				return new ResponseEntity<>(customeResponse, HttpStatus.OK);	
			}

		      
		}catch(Exception e) {
			e.printStackTrace();
			dataMap.put("Data",null);
			customeResponse.setResponseData(dataMap);
			customeResponse.setStatusCode(500);
			customeResponse.setMessage("Some Error Occured");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			 
		}
	  }
	
	//get offer related to id
	@GetMapping(path="/getjobOffer/{offerid}",produces="application/json")
	  public ResponseEntity<CustomResponseDTO> getjobOfferBasisId(@PathVariable int offerid) 
	  {
		CustomResponseDTO customeResponse=new CustomResponseDTO();
		Map<String, Object> dataMap  = new LinkedHashMap<>();
		try
		{
			
	
			Map<String, Object> responseMap = jobOfferService.getUseroffer(offerid);
			System.out.println(responseMap.size());
			
			dataMap.put("Data",responseMap);
			
			if (dataMap.isEmpty()) {
				//dataMap.put("Data", null);
				customeResponse.setResponseData(dataMap);
				customeResponse.setStatusCode(201);
				customeResponse.setMessage("NO CONTENT Available");
		        return new ResponseEntity<>(customeResponse,HttpStatus.NO_CONTENT);
		      }
			else
			{
				customeResponse.setResponseData(dataMap);
				customeResponse.setStatusCode(200);
				customeResponse.setMessage("SUCCESS");
				return new ResponseEntity<>(customeResponse, HttpStatus.OK);	
			}

		      
		}catch(Exception e) {
			e.printStackTrace();
			//dataMap.put("Data",null);
			customeResponse.setResponseData(dataMap);
			customeResponse.setStatusCode(500);
			customeResponse.setMessage("Some Error Occured");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			 
		}
	  }
	
	// get all offers
	@GetMapping(path="/getAllJobOffer",produces="application/json")
	  public ResponseEntity<CustomResponseDTO> getAllJobOffer() 
	  {
		CustomResponseDTO customeResponse=new CustomResponseDTO();
	    HashMap<String, Object> dataMap = new LinkedHashMap<>();
		try
		{
			
	
			Map<String, Object>responseMap = jobOfferService.getAllUserOffer();
			System.out.println(responseMap.size());
			
			dataMap.put("Data",responseMap);
			
			if (dataMap.isEmpty()) {
				//dataMap.put("Data", null);
				customeResponse.setResponseData(dataMap);
				customeResponse.setStatusCode(201);
				customeResponse.setMessage("NO CONTENT Available");
		        return new ResponseEntity<>(customeResponse,HttpStatus.NO_CONTENT);
		      }
			else
			{
				
				customeResponse.setResponseData(dataMap);
				customeResponse.setStatusCode(200);
				customeResponse.setMessage("SUCCESS");
				return new ResponseEntity<>(customeResponse, HttpStatus.OK);	
			}

		      
		}catch(Exception e) {
			e.printStackTrace();
			dataMap.put("Data",null);
			customeResponse.setResponseData(dataMap);
			customeResponse.setStatusCode(500);
			customeResponse.setMessage("Some Error Occured");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			 
		}
	  }
	
	// create application offer
	@PostMapping(path="/createApplicationOffer",produces="application/json",consumes="application/json")
	  public ResponseEntity<CustomResponseDTO> createApplicationOffer(@RequestBody ApplicationEntity newApplication) 
	  {
		CustomResponseDTO customeResponse=new CustomResponseDTO();
	    HashMap<String, Object> dataMap = new LinkedHashMap<>();
		try
		{
			
	
			Map<String, Object>responseMap = jobOfferService.generateApplication(newApplication);
			System.out.println(responseMap);
			
			dataMap.put("Data",responseMap);
			
			if (dataMap.isEmpty()) {
				dataMap.put("Data", null);
				customeResponse.setResponseData(dataMap);
				customeResponse.setStatusCode(201);
				customeResponse.setMessage("1 Row created");
		        return new ResponseEntity<>(customeResponse,HttpStatus.CREATED);
		      }
			else
			{
				
				customeResponse.setResponseData(dataMap);
				customeResponse.setStatusCode(200);
				customeResponse.setMessage("SUCCESS");
				return new ResponseEntity<>(customeResponse, HttpStatus.OK);	
			}

		      
		}catch(Exception e) {
			e.printStackTrace();
			dataMap.put("Data",null);
			customeResponse.setResponseData(dataMap);
			customeResponse.setStatusCode(500);
			customeResponse.setMessage("Some Error Occured");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			 
		}
	  }
}
