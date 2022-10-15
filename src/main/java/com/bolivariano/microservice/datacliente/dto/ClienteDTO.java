package com.bolivariano.microservice.datacliente.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteDTO {
    
  private String identificacion;

  private String nombres;

  private String apellidos;

  public ClienteDTO () {
      super();
  }

  public ClienteDTO (String nombres, String apellidos) {
      this.nombres = nombres;
      this.apellidos = apellidos;
  }
}
