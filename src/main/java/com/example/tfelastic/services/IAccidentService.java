package com.example.tfelastic.services;

import java.util.Collection;

import com.example.tfelastic.dto.AccidentCommonTwilightDTO;
import com.example.tfelastic.dto.AccidentDTO;
import com.example.tfelastic.dto.AccidentDangerousPointsDTO;

public interface IAccidentService {
	/**Collection<AccidentDTO> getAccidents();*/

	Collection<AccidentDTO> getAccidentsDatesBetween(String pDesde, String pHasta);

	Collection<AccidentCommonTwilightDTO>  getCommonConditions();

	Collection<AccidentDTO> getAccidentsInRadius(Float pLat, Float pLng, Float pRad);

	Collection<AccidentDangerousPointsDTO> getAccidentsDangerousPoint(Float pLat, Float pLng, Float pRad);

	Double getAverageDistance();
}
