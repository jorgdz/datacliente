package com.bolivariano.microservice.datacliente.dto;

import java.io.Serializable;
import java.util.List;

public class ClienteRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<IdentificacionDTO> identificaciones;

    public ClienteRequestDTO () {
        super();
    }

    public ClienteRequestDTO(List<IdentificacionDTO> identificaciones) {
        this.identificaciones = identificaciones;
    }

    public List<IdentificacionDTO> getIdentificaciones() {
        return identificaciones;
    }

    public void setIdentificaciones(List<IdentificacionDTO> identificaciones) {
        this.identificaciones = identificaciones;
    }

    @Override
    public String toString() {
        return "ClienteRequestDTO [identificaciones=" + identificaciones + "]";
    }    
}
