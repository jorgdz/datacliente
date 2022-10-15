package com.bolivariano.microservice.datacliente.entity;

/* import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter; */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/* @Entity
@NamedStoredProcedureQuery(
    name = "sp_clientes",
    procedureName = "sp_clientes",
    resultClasses = Cliente.class,
    parameters = {
        @StoredProcedureParameter(name = "identificacion", type = String.class, mode = ParameterMode.IN)
    }
) */
public class Cliente {
    
    //@Id
    private String identificacion;

    private String nombres;

    private String apellidos;

    public Cliente () {
        super();
    }

    public Cliente (String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}
