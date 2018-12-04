package dev.top.entities;

import dev.top.service.ChampAvis;

public class Avis {
	
	private ChampAvis action;
	
	public Avis() {
	}

	public Avis(ChampAvis action) {
		super();
		this.action = action;
	}

	public ChampAvis getAction() {
		return action;
	}

	public void setAction(ChampAvis action) {
		this.action = action;
	}
	
	

}
