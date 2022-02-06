package com.mockpage.schoolwebapp.schoolpage.home.exceptions;

import java.sql.SQLException;
import java.util.Date;

import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.expression.spel.SpelEvaluationException;
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
	    public String exception(final Throwable throwable,HttpServletRequest req,HttpServletResponse res, final Model model) {
	        log.error("Exception during execution of SpringSecurity application", throwable);
	        if(throwable != null) {
		        int status = res.getStatus();
		        String path = req.getRequestURI();
		        Date date = new Date();
		        model.addAttribute("path",path);
		        model.addAttribute("exception",throwable.getClass());
		        model.addAttribute("status",status);
		        model.addAttribute("message","Problem with server");		       
		        model.addAttribute("timestamp",date);
	        }
	        return "error";
	    }

	 @ExceptionHandler(ConstraintViolationException.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public String constraintexception(final Throwable throwable,HttpServletRequest req,HttpServletResponse res,final Model model) {
	        log.error("Exception during execution of SpringSecurity application", throwable);
	        if(throwable != null) {
		        int status = res.getStatus();
		        String path = req.getRequestURI();
		        Date date = new Date();
		        model.addAttribute("path",path);
		        model.addAttribute("exception",throwable.getClass());
		        model.addAttribute("status",status);
		        model.addAttribute("message","Problem with server");		       
		        model.addAttribute("timestamp",date);
	        }
	        return "error";
	    }
	 
	 @ExceptionHandler(NullPointerException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public String nullexception(final Throwable throwable,final HttpServletRequest req,HttpServletResponse res, final Model model) {
	        log.error("Exception during execution of SpringSecurity application", throwable);
	        if(throwable != null) {
		        int status = HttpServletResponse.SC_NOT_FOUND;
		        String path = req.getRequestURI();
		        Date date = new Date();
		        model.addAttribute("path",path);
		        model.addAttribute("exception",throwable.getClass());
		        model.addAttribute("status",status);
		        model.addAttribute("message","Null value found");
		        model.addAttribute("timestamp",date);
	        }
	        return "error";
	    }
	 
	 
	@ResponseStatus(value=HttpStatus.CONFLICT) 
  @ExceptionHandler(DataIntegrityViolationException.class)
  public void conflict() {
  }
  

	@ExceptionHandler({SQLException.class,DataAccessException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String sqlexception(final Throwable throwable,final HttpServletRequest req,HttpServletResponse res, final Model model) {
      log.error("Exception during execution of SpringSecurity application", throwable);
      if(throwable != null) {
	        int status = res.getStatus();
	        String path = req.getRequestURI();
	        Date date = new Date();
	        model.addAttribute("path",path);
	        model.addAttribute("exception",throwable.getClass());
	        model.addAttribute("status",status);
	        model.addAttribute("message","Problem with server");		       
	        model.addAttribute("timestamp",date);
      }
      return "error";
  }

  @ExceptionHandler({InvalidDataAccessApiUsageException.class,IllegalStateException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String dataexception(final Throwable throwable,final HttpServletRequest req,HttpServletResponse res, final Model model) {
      log.error("Exception during execution of SpringSecurity application", throwable);
      if(throwable != null) {
 	        int status = res.getStatus();
	        String path = req.getRequestURI();
	        Date date = new Date();
	        model.addAttribute("path",path);
	        model.addAttribute("exception",throwable.getClass());
	        model.addAttribute("status",status);
	        model.addAttribute("message","Problem with server");		       
	        model.addAttribute("timestamp",date);
      }
      return "error";
  }
  
  @ExceptionHandler({NonUniqueResultException.class,SpelEvaluationException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String nonuniqueresultexception(final Throwable throwable,final HttpServletRequest req,HttpServletResponse res, final Model model) {
      log.error("Exception during execution of SpringSecurity application", throwable);
      if(throwable != null) {
 	        int status = res.getStatus();
	        String path = req.getRequestURI();
	        Date date = new Date();
	        model.addAttribute("path",path);
	        model.addAttribute("exception",throwable.getClass());
	        model.addAttribute("status",status);
	        model.addAttribute("message","Problem with server");		       
	        model.addAttribute("timestamp",date);
      }
      return "error";
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String allexception(final Throwable throwable,final HttpServletRequest req,HttpServletResponse res, final Model model) {
      log.error("Exception during execution of SpringSecurity application", throwable);
      if(throwable != null) {
 	        int status = res.getStatus();
	        String path = req.getRequestURI();
	        Date date = new Date();
	        model.addAttribute("path",path);
	        model.addAttribute("exception",throwable.getClass());
	        model.addAttribute("status",status);
	        model.addAttribute("message","Problem with server");		       
	        model.addAttribute("timestamp",date);
      }
      return "error";
  }
}
