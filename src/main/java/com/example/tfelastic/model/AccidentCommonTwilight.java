package com.example.tfelastic.model;

public class AccidentCommonTwilight {
    private String id;

    private Integer cont;

    public AccidentCommonTwilight(String id, Integer cont){
        this.id = id;
        this.cont = cont;
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
