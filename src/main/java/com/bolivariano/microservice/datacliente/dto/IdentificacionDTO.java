package com.bolivariano.microservice.datacliente.dto;

import java.io.Serializable;

public class IdentificacionDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String identificacion;
    private String tipoIdentificacion;

    public IdentificacionDTO () {
        super();
    }

    public IdentificacionDTO(String identificacion, String tipoIdentificacion) {
        this.identificacion = identificacion;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @Override
    public String toString() {
        return "IdentificacionDTO [identificacion=" + identificacion + ", tipoIdentificacion=" + tipoIdentificacion
                + "]";
    }   
}
