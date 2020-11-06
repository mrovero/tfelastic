package com.example.tfelastic.repository;

import com.example.tfelastic.model.AccidentCommonTwilight;
import com.example.tfelastic.model.Accident;
import com.example.tfelastic.model.AccidentDangerousPoints;
import org.springframework.data.elasticsearch.annotations.Query;

import java.util.Collection;

public interface IAccidentRepository{

    Collection<AccidentCommonTwilight> findCommonTwilight();

    Collection<Accident> findAccidentsInRadius(Float pLat, Float pLng, Float pRad);

    Collection<AccidentDangerousPoints> findAccidentsDangerousPoints(Float pLat, Float pLng, Float pRad);

    Double getAverageDistance();
}
