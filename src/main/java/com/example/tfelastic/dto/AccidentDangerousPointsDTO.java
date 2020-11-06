package com.example.tfelastic.dto;

import com.example.tfelastic.model.AccidentDangerousPoints;
import org.springframework.data.geo.Point;

public class AccidentDangerousPointsDTO {
    private String id;

    public Float startLat;

    public Float startLng;

    private Integer cantidad;

    public AccidentDangerousPointsDTO(AccidentDangerousPoints anAccidentPoint){
        this.setId(anAccidentPoint.getId());
        this.setStartLat(anAccidentPoint.getStartLat());
        this.setStartLng(anAccidentPoint.getStartLng());
        this.setCantidad(anAccidentPoint.getCont());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getStartLat() {return this.startLat;	}

    public void setStartLat(Float startLat) { this.startLat = startLat; }

    public Float getStartLng() {return this.startLng;	}

    public void setStartLng(Float startLng) { this.startLng = startLng; }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
