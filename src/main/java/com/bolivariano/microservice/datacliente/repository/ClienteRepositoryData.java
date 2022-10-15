package com.bolivariano.microservice.datacliente.repository;

import java.sql.SQLException;
import java.util.List;

/* import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery; */

import com.bolivariano.microservice.datacliente.entity.Cliente;
import com.bolivariano.microservice.datacliente.repository.contract.ClienteRepository;

//@ApplicationScoped
public class ClienteRepositoryData implements ClienteRepository {
    
    //@Inject
    //EntityManager entityManager;

    @Override
    public List<Cliente> findByIdentification(String identification) throws SQLException {
        /* StoredProcedureQuery sProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("sp_clientes")
            .setParameter("identificacion", identification); */
        
        return /* sProcedureQuery.getResultList() */ null;
    }
}
