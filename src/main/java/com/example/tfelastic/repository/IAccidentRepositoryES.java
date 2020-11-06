package com.example.tfelastic.repository;

import com.example.tfelastic.model.Accident;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Collection;
import java.util.List;

public interface IAccidentRepositoryES extends ElasticsearchRepository<Accident, String> {

    /** 1 - Devolver todos los accidentes ocurridos entre 2 fechas dadas */
    List<Accident> findByStartTimeBetween(String pDesde, String pHasta);
}
