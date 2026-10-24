package com.ca.transport.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "transports")
public class Transport {

    @Id
    private String id;

    @NotBlank(message = "ATCO Code is required")
    private String atcoCode;

    @NotBlank(message = "Stop name is required")
    private String commonName;

    private String street;

    private String locality;

    private Double latitude;

    private Double longitude;

    @NotBlank(message = "Stop type is required")
    private String stopType;

    private String busStopType;

    private String status;

    private String timingStatus;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAtcoCode() { return atcoCode; }
    public void setAtcoCode(String atcoCode) { this.atcoCode = atcoCode; }

    public String getCommonName() { return commonName; }
    public void setCommonName(String commonName) { this.commonName = commonName; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getLocality() { return locality; }
    public void setLocality(String locality) { this.locality = locality; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public String getStopType() { return stopType; }
    public void setStopType(String stopType) { this.stopType = stopType; }

    public String getBusStopType() { return busStopType; }
    public void setBusStopType(String busStopType) { this.busStopType = busStopType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTimingStatus() { return timingStatus; }
    public void setTimingStatus(String timingStatus) { this.timingStatus = timingStatus; }
}