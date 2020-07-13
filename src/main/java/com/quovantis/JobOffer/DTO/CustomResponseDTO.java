package com.quovantis.JobOffer.DTO;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class CustomResponseDTO {

	private Map<String,Object> responseData;
	private int statusCode;
	private String message;
}
