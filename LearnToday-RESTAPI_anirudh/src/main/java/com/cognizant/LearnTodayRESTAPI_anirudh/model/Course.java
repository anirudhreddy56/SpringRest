package com.cognizant.LearnTodayRESTAPI_anirudh.model;

public class Course {
	int courseId;
	String title;
	float fees;
	String description;
	String trainer;
	String start_Date;
	public Course(int courseId, String title, float fees, String description, String trainer, String start_Date) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.fees = fees;
		this.description = description;
		this.trainer = trainer;
		this.start_Date = start_Date;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getStart_Date() {
		return start_Date;
	}
	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}
	
}