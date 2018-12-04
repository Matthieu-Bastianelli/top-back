package dev.top.service;

public enum ChampAvis {
	
	AIMER("AIMER"), DETESTER("DETESTER");
	
	private String action;

	private ChampAvis(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	

}
