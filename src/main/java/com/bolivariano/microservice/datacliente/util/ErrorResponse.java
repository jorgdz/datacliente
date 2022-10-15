package com.bolivariano.microservice.datacliente.util;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse implements Serializable {
    
    private String timestamps;
    
    private String message;
	
	private String exception;
	
    private int code;
	
	private List<String> errors; 
    
    public ErrorResponse (Exception ex, int code) {
        this.message = ex.getMessage();
		this.exception = ex.getClass().getSimpleName();
		this.code = code;
        this.timestamps = StandardDateTimeFormat.makeCurrentTime(LocalDateTime.now());
    }

    public ErrorResponse (String message, Exception ex, int code) {
        this.message = message;
		this.exception = ex.getClass().getSimpleName();
		this.code = code;
        this.timestamps = StandardDateTimeFormat.makeCurrentTime(LocalDateTime.now());
    }
    
    public ErrorResponse (List<String> errors, Exception ex, int code) {
        this.errors = errors;
		this.exception = ex.getClass().getSimpleName();
		this.code = code;
        this.timestamps = StandardDateTimeFormat.makeCurrentTime(LocalDateTime.now());
    }
    
    public String getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(String timestamps) {
        this.timestamps = timestamps;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "Error [message=" + message + ", exception=" + exception + ", errors="
        + errors + ", code=" + code + "]";
    }
}
