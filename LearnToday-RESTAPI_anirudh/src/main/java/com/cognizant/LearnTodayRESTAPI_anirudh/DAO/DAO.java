package com.cognizant.LearnTodayRESTAPI_anirudh.DAO;

import java.util.List;

import com.cognizant.LearnTodayRESTAPI_anirudh.model.Course;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Student;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Trainer;

public interface DAO {
	
	public List<Course> Get_All_Courses();
	public List<Course> getCourseById(int courseId);
	public int signUp(Trainer trainerlogindetails);
	public int updatePassWord(String trainerId, Trainer trainer);
	public int enrolltoacourse(Student student);
	int delete(int enrollmentId);
	public List<Student> getStudentByCourseId(int courseId);
	
}
