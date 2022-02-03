package com.mockpage.schoolwebapp.schoolpage.home.exceptions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	 @ExceptionHandler(Throwable.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public String exception(final Throwable throwable, final Model model) {
	        log.error("Exception during execution of SpringSecurity application", throwable);
	        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
	        model.addAttribute("errorMessage", errorMessage);
	        return "error";
	    }

	@ResponseStatus(value=HttpStatus.CONFLICT,
                  reason="Data integrity violation") 
  @ExceptionHandler(DataIntegrityViolationException.class)
  public void conflict() {
  }
  
  @ExceptionHandler({SQLException.class,DataAccessException.class})
  public String databaseError(HttpServletRequest req, Exception ex) {
	    log.error("Request: " + req.getRequestURL() + " raised " + ex);
    return "error";
  }

  @ExceptionHandler(Exception.class)
  public String handleError(HttpServletRequest req, Exception ex) {
    log.error("Request: " + req.getRequestURL() + " raised " + ex);

    return "error";
  }

  @ResponseStatus(value=HttpStatus.NOT_FOUND,
          reason="not found") 
  @ExceptionHandler(NullPointerException.class)
  public String nullError(HttpServletRequest req, Exception ex, Throwable throwable, Model model) {
    log.error("Request: " + req.getRequestURL() + " raised " + ex);
    String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
    model.addAttribute("errorMessage", errorMessage);
    return "error";
  }
}
