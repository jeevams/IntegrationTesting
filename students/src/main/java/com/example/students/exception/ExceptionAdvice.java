package com.example.students.exception;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {


	@ExceptionHandler(value = StudentsIdNotFound.class)

	public ResponseEntity<CustomErrorResponse> StudentsIdNotFoundException(StudentsIdNotFound e) {

		CustomErrorResponse error = new CustomErrorResponse("404","Id Not Found");

		error.setTimestamp(LocalDateTime.now());
		
		error.setStatus((HttpStatus.NOT_FOUND.value()));

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}   
	@ExceptionHandler(value = ExistsByCourseName.class)
	
	public ResponseEntity<CustomErrorResponse> existsByCourseNameException(ExistsByCourseName e) {

		CustomErrorResponse error = new CustomErrorResponse("1062", "Duplicate Entry not Allowed");

		error.setTimestamp(LocalDateTime.now());

		error.setStatus((HttpStatus.CONFLICT.value()));

		return new ResponseEntity<>(error, HttpStatus.CONFLICT);

	}
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> MethodArgumentNotValidException( MethodArgumentNotValidException ex) {


		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error ->
		errors.put(error.getField(), error.getDefaultMessage()));
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}



}