package com.nischal.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {

	@Id
	private int stationId;
	private String stationName;
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	
	public void setId(int id) {
		this.stationId = id;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String station_name) {
		this.stationName = station_name;
	}
	@Override
	public String toString() {
		return "Station [id=" + stationId + ", station_name=" + stationName + "]";
	}
	public Station(int id, String station_name) {
		super();
		this.stationId = id;
		this.stationName = station_name;
	}
	public Station() {
	
	}
}
