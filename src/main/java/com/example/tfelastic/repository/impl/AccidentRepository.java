package com.example.tfelastic.repository.impl;

import com.example.tfelastic.dto.AccidentCommonTwilightDTO;
import com.example.tfelastic.model.Accident;
import com.example.tfelastic.model.AccidentCommonTwilight;
import com.example.tfelastic.model.AccidentDangerousPoints;
import com.example.tfelastic.repository.IAccidentRepository;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.*;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.aggregations.*;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.NumericMetricsAggregation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchHitsIterator;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import  org.elasticsearch.search.aggregations.bucket.MultiBucketsAggregation.Bucket;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository
public class AccidentRepository implements IAccidentRepository {

    @Autowired
    private final ElasticsearchRestTemplate elasticsearchTemplate;

    public AccidentRepository(ElasticsearchRestTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    @Override
    public Collection<AccidentCommonTwilight> findCommonTwilight() {
        AbstractAggregationBuilder aggregation = AggregationBuilders.terms("Astronomical_Twilight").field("Astronomical_Twilight.keyword");
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery()).addAggregation(aggregation).build();
        SearchHits<Accident> searchHits = elasticsearchTemplate.search(searchQuery, Accident.class, IndexCoordinates.of("accidentes_db"));
        ParsedStringTerms buck = (ParsedStringTerms) searchHits.getAggregations().asMap().get("Astronomical_Twilight");

        List<AccidentCommonTwilight> result = new ArrayList<>();
        buck.getBuckets().forEach(aBucket -> {
            result.add(new AccidentCommonTwilight(aBucket.getKeyAsString(),(int) aBucket.getDocCount()));
        });
        return result;
    }

    @Override
    public Collection<Accident> findAccidentsInRadius(Float pLat, Float pLng, Float pRad) {
        GeoDistanceQueryBuilder geoDistanceQueryBuilder = QueryBuilders.geoDistanceQuery("start_location").point((double) pLng, (double) pLat).distance(pRad.toString(), DistanceUnit.KILOMETERS);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).filter(geoDistanceQueryBuilder);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        SearchHitsIterator<Accident> searchHits = elasticsearchTemplate.searchForStream(searchQuery, Accident.class, IndexCoordinates.of("accidentes_db"));
        List<Accident> result = new ArrayList();
        while(searchHits.hasNext()){
            result.add(searchHits.next().getContent());
        }
        return  result;
    }

    @Override
    public Collection<AccidentDangerousPoints> findAccidentsDangerousPoints(Float pLat, Float pLng, Float pRad) {
        GeoDistanceQueryBuilder geoDistanceQueryBuilder = QueryBuilders.geoDistanceQuery("start_location").point((double) pLng, (double) pLat).distance(pRad.toString(), DistanceUnit.KILOMETERS);
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).filter(geoDistanceQueryBuilder);
        AbstractAggregationBuilder aggregationDanger = AggregationBuilders.terms("Dangerous").field("slocation.keyword").minDocCount(1).size(5);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).addAggregation(aggregationDanger).build();
        SearchHits<Accident> searchHits = elasticsearchTemplate.search(searchQuery, Accident.class, IndexCoordinates.of("accidentes_db"));
        ParsedStringTerms aBucketResult = (ParsedStringTerms) searchHits.getAggregations().asMap().get("Dangerous");
        List<AccidentDangerousPoints> result = new ArrayList<>();
        aBucketResult.getBuckets().forEach(aBucket -> {
            result.add(new AccidentDangerousPoints(aBucket.getKey().toString(), (int) aBucket.getDocCount()));
        });
        return result;
    }

    @Override
    public Double getAverageDistance() {
        AvgAggregationBuilder aggregation = AggregationBuilders.avg("Distance").field("Distance(mi)").script(new Script("_value * 1609"));
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery()).addAggregation(aggregation).build();
        SearchHits<Accident> searchHits = elasticsearchTemplate.search(searchQuery, Accident.class, IndexCoordinates.of("accidentes_db"));
        Avg average = searchHits.getAggregations().get("Distance");
        Double result = average.getValue();
        return result;
    }


}
