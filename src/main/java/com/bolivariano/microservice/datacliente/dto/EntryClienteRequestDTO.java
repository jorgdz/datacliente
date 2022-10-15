package com.bolivariano.microservice.datacliente.dto;

import java.io.Serializable;

public class EntryClienteRequestDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String canal;

    private String depuracion;

    private String oficina;

    private String transaccion;

    private String secuencial;

    private String usuario;

    private ClienteRequestDTO cliente;

    public EntryClienteRequestDTO () {
        super();
    }

    public EntryClienteRequestDTO(String canal, String depuracion, String oficina, String transaccion,
            String secuencial, String usuario, ClienteRequestDTO cliente) {
        this.canal = canal;
        this.depuracion = depuracion;
        this.oficina = oficina;
        this.transaccion = transaccion;
        this.secuencial = secuencial;
        this.usuario = usuario;
        this.cliente = cliente;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getDepuracion() {
        return depuracion;
    }

    public void setDepuracion(String depuracion) {
        this.depuracion = depuracion;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public String getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(String secuencial) {
        this.secuencial = secuencial;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ClienteRequestDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRequestDTO cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "EntryClienteRequestDTO [canal=" + canal + ", depuracion=" + depuracion + ", oficina=" + oficina
                + ", transaccion=" + transaccion + ", secuencial=" + secuencial + ", usuario=" + usuario + ", cliente="
                + cliente + "]";
    }
}
