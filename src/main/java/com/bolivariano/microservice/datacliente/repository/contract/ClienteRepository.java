package com.bolivariano.microservice.datacliente.repository.contract;

import java.sql.SQLException;
import java.util.List;

import com.bolivariano.microservice.datacliente.entity.Cliente;

public interface ClienteRepository {
    
    /**
     * 
     * Funcion utilizada para listar los clientes por cedula
     * 
     * @param identification
     * @return
     */
    public List<Cliente> findByIdentification (String identification) throws SQLException;

}
