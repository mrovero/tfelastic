package com.example.tfelastic.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.geo.Point;
import org.springframework.beans.factory.annotation.Value;

public class AccidentDangerousPoints {
    public String id;

    public Float startLat;

    public Float startLng;

    private Integer cont;

    public AccidentDangerousPoints(String id,
                                   Integer cont) {
        this.setId(id);
        String[] parts = id.split(",");
        String part1 = parts[0];
        String part2 = parts[1];
        this.setStartLat(Float.parseFloat(part1));
        this.setStartLng(Float.parseFloat(part2));
        this.setCont(cont);
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

    public Integer getCont() {
        return cont;
    }

    public void setCont(Integer cont) {
        this.cont = cont;
    }
}
