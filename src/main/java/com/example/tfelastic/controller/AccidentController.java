package com.example.tfelastic.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import com.example.tfelastic.dto.*;
import com.example.tfelastic.model.AccidentCommonTwilight;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tfelastic.services.IAccidentService;

@RestController
public class AccidentController {

	@Inject
	private IAccidentService accidentsService;

	/**@GetMapping(value = "/api/accident")
	public ResponseEntity<?> getAccidents() {

		ResponseEntity<?> response = null;
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();

		result.addAll(this.getAccidentsService().getAccidents());

		response = ResponseEntity.ok(result);

		return response;
	}*/

	@GetMapping(value = "/api/accident/datesBetween")
	public ResponseEntity<?> getAccidentsDatesBetween(@RequestParam String desde,@RequestParam String hasta) {

		ResponseEntity<?> response = null;
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();
		result.addAll(this.getAccidentsService().getAccidentsDatesBetween(desde, hasta));
		response = ResponseEntity.ok(result);

		return response;
	}

	@GetMapping(value = "/api/accident/commonTwilight")
	public ResponseEntity<?> getCommonTwilight() {

		ResponseEntity<?> response = null;
		Collection<AccidentCommonTwilightDTO> result = new ArrayList<AccidentCommonTwilightDTO>();
		result.addAll(this.getAccidentsService().getCommonConditions());
		response = ResponseEntity.ok(result);
		return response;
	}

	@GetMapping(value = "/api/accident/accidentsInRadius")
	public ResponseEntity<?> getAccidentsInRadius(@RequestParam Float lng, @RequestParam Float lat, @RequestParam Float rad) {

		ResponseEntity<?> response = null;
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();
		result.addAll(this.getAccidentsService().getAccidentsInRadius(lng, lat, rad));
		response = ResponseEntity.ok(result);

		return response;
	}

	@GetMapping(value = "/api/accident/accidentsDangerousPoints")
	public ResponseEntity<?> getAccidentsDangerousPoints(@RequestParam Float lng, @RequestParam Float lat, @RequestParam Float rad) {

		ResponseEntity<?> response = null;
		Collection<AccidentDangerousPointsDTO> result = new ArrayList<AccidentDangerousPointsDTO>();
		result.addAll(this.getAccidentsService().getAccidentsDangerousPoint(lng, lat, rad));
		response = ResponseEntity.ok(result);

		return response;
	}

	@GetMapping(value = "/api/accident/avgDistance")
	public Double getAverageDistance() {
		return this.getAccidentsService().getAverageDistance();
	}

	public IAccidentService getAccidentsService() {
		return this.accidentsService;
	}

}
