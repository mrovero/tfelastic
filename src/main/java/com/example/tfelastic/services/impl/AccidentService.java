package com.example.tfelastic.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.example.tfelastic.dto.AccidentDTO;
import com.example.tfelastic.dto.AccidentCommonTwilightDTO;
import com.example.tfelastic.dto.AccidentDangerousPointsDTO;
import com.example.tfelastic.repository.IAccidentRepositoryES;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tfelastic.repository.IAccidentRepository;
import com.example.tfelastic.services.IAccidentService;

@Service
@Transactional
public class AccidentService implements IAccidentService {

	@Inject
	public IAccidentRepository accidentRepository;

	@Inject
	public IAccidentRepositoryES accidentRepositoryES;

	/**@Override
	public Collection<AccidentDTO> getAccidents() {
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();
		this.getAccidentRepositoryES().findAll().stream().map(a -> new AccidentDTO(a))
				.collect(Collectors.toCollection(() -> result));
		return result;
	}*/


	/** 1 - Devolver todos los accidentes ocurridos entre 2 fechas dadas - METODO ELASTIC*/
	@Override
	public Collection<AccidentDTO> getAccidentsDatesBetween(String pDesde, String pHasta) {
		long inicio = new Date().getTime();
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();
		this.getAccidentRepositoryES().findByStartTimeBetween(pDesde, pHasta).stream().map(a -> new AccidentDTO(a))
				.collect(Collectors.toCollection(() -> result));
		long fin = new Date().getTime();
		System.out.println("Tiempo Consulta N 1 - getDatesBetween(): " + (fin - inicio) + " ms");
		return result;
	}

	@Override
	public Collection<AccidentCommonTwilightDTO> getCommonConditions() {
		long inicio = new Date().getTime();
		Collection<AccidentCommonTwilightDTO> result = new ArrayList<AccidentCommonTwilightDTO>();
		this.getAccidentRepository().findCommonTwilight().stream().map(a -> new AccidentCommonTwilightDTO(a))
				.collect(Collectors.toCollection(() -> result));
		long fin = new Date().getTime();
		System.out.println("Tiempo Consulta N 2 - getCommonCOnditions(): " + (fin - inicio) + " ms");
		return result;
	}

	@Override
	public Collection<AccidentDTO> getAccidentsInRadius(Float pLat, Float pLng, Float pRad) {
		long inicio = new Date().getTime();
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();
		this.getAccidentRepository().findAccidentsInRadius(pLat, pLng, pRad).stream().map(a -> new AccidentDTO(a))
				.collect(Collectors.toCollection(() -> result));
		long fin = new Date().getTime();
		System.out.println("Tiempo Consulta N 3 - getAccidentsInRadius(): " + (fin - inicio) + " ms");
		return result;
	}

	@Override
	public Collection<AccidentDangerousPointsDTO> getAccidentsDangerousPoint(Float pLat, Float pLng, Float pRad) {
		long inicio = new Date().getTime();
		Collection<AccidentDangerousPointsDTO> result = new ArrayList<AccidentDangerousPointsDTO>();
		this.getAccidentRepository().findAccidentsDangerousPoints(pLat, pLng, pRad).stream().map(a -> new AccidentDangerousPointsDTO(a))
				.collect(Collectors.toCollection(() -> result));
		long fin = new Date().getTime();
		System.out.println("Tiempo Consulta N 4 - getAccidentsDangerousPoint(): " + (fin - inicio) + " ms");
		return result;
	}

	@Override
	public Double getAverageDistance() {
		return this.getAccidentRepository().getAverageDistance();
	}

	public IAccidentRepository getAccidentRepository() {
		return this.accidentRepository;
	}

	public void setAccidentRepository(IAccidentRepository aRepository) {
		this.accidentRepository = aRepository;
	}

	public IAccidentRepositoryES getAccidentRepositoryES() {
		return this.accidentRepositoryES;
	}

	public void setAccidentRepositoryES(IAccidentRepositoryES aRepositoryEs) {
		this.accidentRepositoryES = aRepositoryEs;
	}
}
