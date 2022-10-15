package com.bolivariano.microservice.datacliente.exceptions.custom;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class NotFoundHttpException extends WebApplicationException {
    
    public NotFoundHttpException (String message) {
        super(message, Response.Status.NOT_FOUND);
    }
}
