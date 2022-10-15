package com.bolivariano.microservice.datacliente.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.bolivariano.microservice.datacliente.dto.EntryClienteRequestDTO;
import com.bolivariano.microservice.datacliente.entity.Cliente;
import com.bolivariano.microservice.datacliente.services.clientes.contract.ClienteService;

@Path("/api")
public class ClienteController {
    
    @Inject
    ClienteService clienteService;
  
    @GET
    @Path("/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> index (EntryClienteRequestDTO entryClienteRequestDTO) throws Exception {
        List<Cliente> clientes = this.clienteService
            .validateGetByIdentRequest(entryClienteRequestDTO)
            .findByIden(entryClienteRequestDTO);    
        
        return clientes;
    }
}
