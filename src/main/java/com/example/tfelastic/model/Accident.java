package com.example.tfelastic.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.geo.Point;

@Document(indexName = "accidentes_db")
public class Accident {

	@Id
	public String id;

	@Field(type= FieldType.Keyword, name="City")
	public String city;

	@Field(type= FieldType.Keyword, name="Description")
	public String description;

	@Field(type= FieldType.Keyword, name="Start_Time")
	public String startTime;

	@Field(type= FieldType.Integer, name="Severity")
	public Integer severity;

	@Field(type= FieldType.Float, name="Start_Lat")
	public Float startLat;

	@Field(type= FieldType.Float, name="Start_Lng")
	public Float startLng;

	@Field(type= FieldType.Keyword, name="slocation")
	public String slocation;

	@Field(type= FieldType.Keyword, name="Weather_Condition")
	public String weatherCondition;

	@Field(type= FieldType.Keyword, name="Astronomical_Twilight")
	public String twilight;

	@Field(type= FieldType.Float, name="Distance(mi)")
	public Float distance;

	public Accident(@Value("City") String city,
					@Value("Description") String description,
					@Value("Start_Time") String startTime,
					@Value("Severity") Integer severity,
					@Value("Start_Lat") Float startLat,
					@Value("Start_Lng") Float startLng,
					@Value("slocation") String slocation,
					@Value("Weather_Condition") String weatherCondition,
					@Value("Astronomical_Twilight") String twilight,
					@Value("Distance(mi)") Float distance
	) {
		this.setCity(city);
		this.setDescription(description);
		this.setStartTime(startTime);
		this.setSeverity(severity);
		this.setStartLat(startLat);
		this.setStartLng(startLng);
		this.setSlocation(slocation);
		this.setWeatherCondition(weatherCondition);
		this.setTwilight(twilight);
		this.setDistance(distance);
	}

	public String getId() {	return this.id;	}

	public void setId(String anId) {this.id = anId;	}

	public String getCity() { return this.city;	}

	public void setCity(String city) { this.city = city;}

	public String getDescription() { return this.description;	}

	public void setDescription(String description) { this.description = description;}

	public String getStartTime() { return this.startTime;	}

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

	public Float getDistance() {return this.distance;	}

	public void setDistance(Float distance) { this.distance = distance; }

}
