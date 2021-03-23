package com.cognizant.LearnTodayRESTAPI_anirudh.model;

public class Trainer {
	String trainerId;
	String password;
	
	public Trainer(Trainer pwd) {
		this.trainerId = trainerId;
		this.password = password;
	}
	public Trainer(String trainerId, String password) {
		super();
		this.trainerId = trainerId;
		this.password = password;
	}	
	public Trainer() {
		// TODO Auto-generated constructor stub
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}