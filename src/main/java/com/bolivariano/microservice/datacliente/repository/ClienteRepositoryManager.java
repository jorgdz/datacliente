package com.bolivariano.microservice.datacliente.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.bolivariano.microservice.datacliente.entity.Cliente;
import com.bolivariano.microservice.datacliente.repository.contract.ClienteRepository;
import io.agroal.api.AgroalDataSource;

@ApplicationScoped
public class ClienteRepositoryManager implements ClienteRepository {
 
    @Inject
    AgroalDataSource dataSource;
 
    public List<Cliente> findByIdentification (String identification) throws SQLException {
        Connection connection = null;
        CallableStatement cstmt = null;
        ResultSet resultSet = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            connection = dataSource.getConnection();
            cstmt = connection.prepareCall("{call gizlo_test..sp_clientes (?)}");
            cstmt.setString(1, identification);
            resultSet = cstmt.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdentificacion(resultSet.getString("identificacion"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                clientes.add(cliente);
            }
        } finally {
            resultSet.close();
            cstmt.close();
            connection.close();
        }

        return clientes;
    }
}
