package com.cognizant.LearnTodayRESTAPI_anirudh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI_anirudh.DAO.DAO;
import com.cognizant.LearnTodayRESTAPI_anirudh.DAOImpl.DAOimpl;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Course;
import com.restexample.springrestexamples.DAO.employeeDAO;
import com.restexample.springrestexamples.DAOimpl.employeeDAOimpl;

@RestController
public class AdminController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/GetAllCoursesadmin")
	public ResponseEntity<Object> allcourses() {
		DAO dao = new DAOimpl();
		List<Course> courses = dao.Get_All_Courses();
		String responseString = " ";
		HttpStatus httpResponseString = null;
		if(courses.isEmpty()) {
			responseString = "No Courses Found" ;
			httpResponseString = HttpStatus.NOT_FOUND;
		}
		else {
			responseString = "Courses Found" ;
			httpResponseString = HttpStatus.OK;
		}
		return new ResponseEntity<> (courses,httpResponseString);	
	}
	
	@GetMapping("/getCourseById/{courseId}")
	public ResponseEntity<Object> getCourseById(@PathVariable int courseId){
		DAO dao = new DAOimpl();
		List<Course> courses =  dao.getCourseById(courseId);
		if(courses.isEmpty()) {
			return new ResponseEntity<>("Searched Data not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

}
	
