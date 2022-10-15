package com.bolivariano.microservice.datacliente.exceptions.custom;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ConflictException extends WebApplicationException {
    
    /**
     * 
     * Conflict exception Status 409
     * @param message
     */
    public ConflictException (String message) {
        super(message, Response.Status.CONFLICT);
    }
}
