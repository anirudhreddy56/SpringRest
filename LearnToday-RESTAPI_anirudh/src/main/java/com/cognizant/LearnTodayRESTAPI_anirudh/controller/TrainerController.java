package com.cognizant.LearnTodayRESTAPI_anirudh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI_anirudh.DAO.DAO;
import com.cognizant.LearnTodayRESTAPI_anirudh.DAOImpl.DAOimpl;
import com.cognizant.LearnTodayRESTAPI_anirudh.Exception.InvalidTrainerIdException;
import com.cognizant.LearnTodayRESTAPI_anirudh.model.Trainer;


@RestController
public class TrainerController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostMapping("/Trainer")
	public ResponseEntity<String> insertTrainerDetails(@RequestBody Trainer trainerlogindetails) {
		DAO dao = new DAOimpl();
		int result = dao.signUp(trainerlogindetails);
		String responseString = new String("");
		HttpStatus httpResponseString = null;
		if(result == 0) {
			responseString = "trainerid" + trainerlogindetails.getTrainerId() + "already exist";
			httpResponseString = HttpStatus.BAD_REQUEST;
		}
		else {
			responseString = " Trainer login details inserted successfully";
			httpResponseString = HttpStatus.OK;
		}
		return new ResponseEntity<> (responseString,httpResponseString);	
	}
	
	@PutMapping("/Update")
	public ResponseEntity<Object> updatePassword( @RequestBody Trainer trainer){
		DAO dao = new DAOimpl();
			try {
				dao.updatePassWord(trainer.getTrainerId(), trainer);
				return new ResponseEntity<>("Data updated successfully", HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Searched data not found", HttpStatus.NOT_FOUND);
			}
	}

}
