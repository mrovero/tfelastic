package com.example.tfelastic.dto;

import com.example.tfelastic.model.AccidentCommonTwilight;

public class AccidentCommonTwilightDTO {
    private String id;

    private Integer cont;

    public AccidentCommonTwilightDTO(AccidentCommonTwilight aCommonTwilight) {
        this.setId(aCommonTwilight.getId());
        this.setCont(aCommonTwilight.getCont());
    }

    public String getId() {
        return this.id;
    }

    public void setId(String anId) {
        this.id = anId;
    }

    public Integer getCont() {
        return this.cont;
    }

    public void setCont(Integer aCont) {
        this.cont = aCont;
    }
}
