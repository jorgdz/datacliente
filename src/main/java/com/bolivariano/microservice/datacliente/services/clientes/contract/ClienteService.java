package com.bolivariano.microservice.datacliente.services.clientes.contract;

import java.sql.SQLException;
import java.util.List;

import com.bolivariano.microservice.datacliente.dto.EntryClienteRequestDTO;
import com.bolivariano.microservice.datacliente.entity.Cliente;

public interface ClienteService {
    
    /**
     * 
     * Permite validar que los datos enviados en el request sean correctos. 
     * Esta funcion puede ser encadenada a findByIden en caso de querer validarse o no.
     * 
     * @param entryClienteRequestDTO
     * @return
     */
    public ClienteService validateGetByIdentRequest(EntryClienteRequestDTO entryCliente);

    /**
     * 
     * Devuelve una lista de clientes.
     * 
     * @param entryClienteRequestDTO
     * @return
     * @throws SQLException
     */
    public List<Cliente> findByIden (EntryClienteRequestDTO entryClienteRequestDTO) throws SQLException;
    
}
