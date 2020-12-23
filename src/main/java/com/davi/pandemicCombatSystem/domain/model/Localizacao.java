package com.davi.pandemicCombatSystem.domain.model;

public class Localizacao {
	private float latitude;
	private float longitude;
	
	public Localizacao(float latitude,float longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	

}
