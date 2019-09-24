package com.everis.practicacloudcompra.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config")
public class ReordenModel {
	private int reorden;

	public int getReorden() {
		return reorden;
	}

	public void setReorden(int reorden) {
		this.reorden = reorden;
	}
	
	
	
}
