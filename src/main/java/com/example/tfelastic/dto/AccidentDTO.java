package com.example.tfelastic.dto;

import com.example.tfelastic.model.Accident;

public class AccidentDTO {

	public String id;
	public String city;
	public String description;
	public String startTime;
	public Integer severity;
	public Float startLat;
	public Float startLng;
	public String slocation;
	public String weatherCondition;
	public String twilight;



	public AccidentDTO(Accident anAccident) {
		this.setId(anAccident.getId());
		this.setCity(anAccident.getCity());
		this.setDescription(anAccident.getDescription());
		this.setStartTime(anAccident.getStartTime());
		this.setSeverity(anAccident.getSeverity());
		this.setStartLat(anAccident.getStartLat());
		this.setStartLng(anAccident.getStartLng());
		this.setSlocation(anAccident.getSlocation());
		this.setWeatherCondition(anAccident.getWeatherCondition());
		this.setTwilight(anAccident.getTwilight());
	}

	public String getId() {
		return this.id;
	}

	public void setId(String anId) {
		this.id = anId;
	}

	public String getCity() { return this.city;	}

	public void setCity(String city) { this.city = city;}

	public String getDescription() { return this.description;	}

	public void setDescription(String description) { this.description = description;}

	public String getStartTime() { return this.startTime; }

	public void setStartTime(String startTime) { this.startTime = startTime;}

	public Integer getSeverity() { return this.severity;	}

	public void setSeverity(Integer severity) { this.severity = severity;}

	public Float getStartLat() {return this.startLat;	}

	public void setStartLat(Float startLat) { this.startLat = startLat; }

	public Float getStartLng() {return this.startLng;	}

	public void setStartLng(Float startLng) { this.startLng = startLng; }

	public String getSlocation() { return this.slocation;	}

	public void setSlocation(String slocation) { this.slocation = slocation;}

	public String getWeatherCondition() { return this.weatherCondition;	}

	public void setWeatherCondition(String weatherCondition) { this.weatherCondition = weatherCondition;	}

	public String getTwilight() { return this.twilight; }

	public void setTwilight(String twilight) { this.twilight = twilight; }
}
