package com.cognizant.LearnTodayRESTAPI_anirudh.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;

import com.cognizant.LearnTodayRESTAPI_anirudh.model.Course;

public class CourseRowMapper implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setCourseId(rs.getInt(1));
		course.setTitle(rs.getString(2));
		course.setFees(rs.getFloat(3));
		course.setDescription(rs.getString(4));
		course.setTrainer(rs.getString(5));
		course.setStart_Date(rs.getString(6));
		return course;
	}
}