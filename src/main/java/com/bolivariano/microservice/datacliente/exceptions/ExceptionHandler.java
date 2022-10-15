package com.bolivariano.microservice.datacliente.exceptions;

import java.util.Scanner;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bolivariano.microservice.datacliente.exceptions.custom.BadRequestException;
import com.bolivariano.microservice.datacliente.exceptions.custom.ConflictException;
import com.bolivariano.microservice.datacliente.util.ErrorResponse;

@Provider
public class ExceptionHandler implements ExceptionMapper<RuntimeException> {
    
    private static final Logger Log = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public Response toResponse (RuntimeException exception) {
        Log.error(exception.getMessage());

        if (exception instanceof BadRequestException) {
            int code = ((WebApplicationException) exception).getResponse().getStatus();
            return Response.status(code)
                .entity(new ErrorResponse(exception, code))
                .build();
        }
        
        if (exception instanceof ConflictException) {
            int code = ((WebApplicationException) exception).getResponse().getStatus();
            return Response.status(code)
                .entity(new ErrorResponse(exception, code))
                .build();
        }
       
        if (exception instanceof NotFoundException) {
            String text = new Scanner(this.getClass().getResourceAsStream("/META-INF/resources/notfound.html"), "UTF-8").useDelimiter("\\A").next();
            int code = ((WebApplicationException) exception).getResponse().getStatus();
            return Response.status(code)
                .entity(new ErrorResponse(text, exception, code))
                .build();
        }

        if (exception instanceof ArithmeticException) {
            return Response.status(Response.Status.CONFLICT)
                .entity(new ErrorResponse("Operación matemática incorrecta.", exception, Response.Status.CONFLICT.getStatusCode()))
                .build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(new ErrorResponse(exception, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()))
            .build();
    }
}
