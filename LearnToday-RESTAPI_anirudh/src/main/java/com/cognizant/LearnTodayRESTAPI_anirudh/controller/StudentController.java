package com.cognizant.LearnTodayRESTAPI_anirudh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI_anirudh.DAO.DAO;
import com.cognizant.LearnTodayRESTAPI_anirudh.DAOImpl.DAOimpl;
import com.cognizant.LearnTodayRESTAPI_anirudh.Exception.InvalidEnrollmentIdException;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Course;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Student;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Trainer;

@RestController
public class StudentController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostMapping("/enrolltoacourse")
	public ResponseEntity<String> enrollToACourse(@RequestBody Student student) {
		DAO dao = new DAOimpl();
		int result = dao.enrolltoacourse(student);
		String responseString = new String("");
		HttpStatus httpResponseString = null;
		if(result == 0) {
			responseString = "Studentid" + student.getStudentId() + "already exist";
			httpResponseString = HttpStatus.BAD_REQUEST;
		}
		else {
			responseString = " Student enrollment details inserted successfully";
			httpResponseString = HttpStatus.OK;
		}
		return new ResponseEntity<> (responseString,httpResponseString);	
	}
	
	@DeleteMapping("/Delete/{enrollmentId}")
	public ResponseEntity<Object> deleteStudentEnrollment(@PathVariable int enrollmentId){
		DAO dao = new DAOimpl();
			try {
				dao.delete(enrollmentId);
				return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("No enrollment information found", HttpStatus.BAD_REQUEST);
			}
	}
	
	@GetMapping("/GetAllCoursesadmin/{courseId}")
	public ResponseEntity<Object> deleteEmployeeLoginDetails(@PathVariable("courseId") int courseId) {
		DAO dao = new DAOimpl();
		List<Course> courses = dao.getCourseById(courseId);
		String responseString = new String("");
		HttpStatus httpResponseString = null;
		if(courses.isEmpty()) {
			responseString = "details does not exist";
			httpResponseString = HttpStatus.NOT_FOUND;
		}
		else {
			responseString = "details of" + courseId;
			httpResponseString = HttpStatus.OK;
		}
		return new ResponseEntity<> (courses,httpResponseString);	
	}
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<Object> getAllCourses(){
		DAO dao = new DAOimpl();
		List<Course> courses =  dao.Get_All_Courses();
		if(courses.size()==0) {
			return new ResponseEntity<>("No courses found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

}
