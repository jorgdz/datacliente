package com.bolivariano.microservice.datacliente.services.clientes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.bolivariano.microservice.datacliente.dto.EntryClienteRequestDTO;
import com.bolivariano.microservice.datacliente.dto.IdentificacionDTO;
import com.bolivariano.microservice.datacliente.entity.Cliente;
import com.bolivariano.microservice.datacliente.exceptions.custom.BadRequestException;
import com.bolivariano.microservice.datacliente.repository.contract.ClienteRepository;
import com.bolivariano.microservice.datacliente.services.clientes.contract.ClienteService;

@ApplicationScoped
public class ClienteServiceManager implements ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Override
    public ClienteServiceManager validateGetByIdentRequest (EntryClienteRequestDTO entryCliente) {
        if (
            entryCliente.equals(null) || 
            entryCliente == null || 
            entryCliente.getCliente() == null ||
            entryCliente.getCliente().getIdentificaciones().size() == 0
        )
            throw new BadRequestException("Por favor digite una cédula para realizar la búsqueda.");
        
        return this;
    }

    @Override
    public List<Cliente> findByIden (EntryClienteRequestDTO entryCliente) throws SQLException {
        List<IdentificacionDTO> identificaciones = entryCliente.getCliente().getIdentificaciones();
      
        List<Cliente> clientes = new ArrayList<Cliente>();

        for (IdentificacionDTO identificacionDTO : identificaciones) {
            for (Cliente cliente : this.clienteRepository.findByIdentification(identificacionDTO.getIdentificacion())) {
                clientes.add(cliente);
            }
        }

        return clientes;
    }
    
}
