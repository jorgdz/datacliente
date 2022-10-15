package com.bolivariano.microservice.datacliente.exceptions.custom;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class BadRequestException extends WebApplicationException {
    
    /**
     * Bad Request Exception Status 400
     * 
     * @param message
     */
    public BadRequestException (String message) {
        super(message, Response.Status.BAD_REQUEST);
    }
}
