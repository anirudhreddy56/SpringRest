package com.cognizant.LearnTodayRESTAPI_anirudh.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.LearnTodayRESTAPI_anirudh.DAO.DAO;
import com.cognizant.LearnTodayRESTAPI_anirudh.Exception.InvalidEnrollmentIdException;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Course;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Student;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Trainer;


public class DAOimpl implements DAO {
	
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/casestudy");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

	@Override
	public List<Course> Get_All_Courses() {
		List<Course> courses = jdbcTemplate.query("select * from course_anirudh", new ResultSetExtractor<List<Course>>() {
		    @Override
			public List<Course> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Course> courseObj = new ArrayList<>();
				while(rs.next()) {
					Course course = new Course();
					course.setCourseId(rs.getInt("CourseId"));
					course.setTitle(rs.getString("Title"));
					course.setFees(rs.getFloat("Fees"));
					course.setDescription(rs.getString("Description"));
					course.setTrainer(rs.getString("Trainer"));
					course.setStart_Date(rs.getString("Start_Date"));
					courseObj.add(course);
				}
				// TODO Auto-generated method stub
				return courseObj;
			}
		});
		
		return courses;
	}

	@Override
    public List<Course> getCourseById(int courseId) {
		  
		List<Course> courses = jdbcTemplate.query("select * from course_anirudh where courseId=?", new ResultSetExtractor<List<Course>>() {

			@Override
			public List<Course> extractData(ResultSet rs) {
				List<Course> courseobj = new ArrayList<>();
				while(rs.next()) {
					Course course = new Course();
					course.setCourseId(rs.getInt("CourseId"));
				}
				
				return null;
			}
		}

	@Override
	public int signUp(Trainer trainerlogindetails) {
		String sql = "insert into Trainer_anirudh values(?,?)";
		int result = jdbcTemplate.update(sql,trainerlogindetails.getTrainerId(),trainerlogindetails.getPassword());
		return result;
	}

	@Override
	public int updatePassWord(String trainerId, Trainer trainer) {
		String sql = "update Trainer_anirudh set Password=? where TrainerId=?";
		int rowsAffected = jdbcTemplate.update(sql, trainer.getPassword(), trainerId);
		return rowsAffected;
	}

	@Override
	public int enrolltoacourse(Student student) {
		String sql = "insert into Student_anirudh values(?,?,?)";
		int result = jdbcTemplate.update(sql,student.getEnrollmentId(),student.getStudentId(),student.getCourseId());
		return result;	
	}

	@Override
	public int delete(int enrollmentId) {
		String sql = "delete from Student_anirudh where EnrollmentId =?";
		int rowAffected = jdbcTemplate.update(sql, enrollmentId);
		return rowAffected;
	}

	@Override
	public List<Student> getStudentByCourseId(int courseId){
		String sql = "select enrollmentid, studentid, s.courseid from Student_anirudh s, course_anirudh c where c.CourseId = s.CourseId and c.CourseId =?";
		List<Student> students = jdbcTemplate.query(sql, courseId);
		return students;
	}
	

}
