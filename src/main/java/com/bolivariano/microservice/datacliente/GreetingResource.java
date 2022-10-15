package com.bolivariano.microservice.datacliente;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bolivariano.microservice.datacliente.exceptions.custom.BadRequestException;

@Path("/hello")
public class GreetingResource {

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> hello (@PathParam(value = "name") String name) throws Exception {
        if (name.length() > 5)
            throw new BadRequestException("El nombre no debe tener mas de 5 de caracteres.");

        int result = 5 / 0;
        System.out.println("La división es: " + result);
        
        Map<String, String> data = new HashMap<>();
        data.put("message", "Te saludamos " + name);
        return data;
    }
}
