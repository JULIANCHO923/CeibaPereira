/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.doa.model;

public class Inmueble {
    
    private String idinmueble;
    private String usuario_cedula;
    private String tipo_inmueble_idtipo_inmueble;
    private double valor;
    private int estrato;
    private double metraje;
    private double valor_prima;
    private String direccion;

    private String latitud;
    private String longitud;    
    private String zoom;
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario_cedula() {
        return usuario_cedula;
    }

    public void setUsuario_cedula(String usuario_cedula) {
        this.usuario_cedula = usuario_cedula;
    }

    public String getTipo_inmueble_idtipo_inmueble() {
        return tipo_inmueble_idtipo_inmueble;
    }

    public void setTipo_inmueble_idtipo_inmueble(String tipo_inmueble_idtipo_inmueble) {
        this.tipo_inmueble_idtipo_inmueble = tipo_inmueble_idtipo_inmueble;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public double getMetraje() {
        return metraje;
    }

    public void setMetraje(double metraje) {
        this.metraje = metraje;
    }

    public double getValor_prima() {
        return valor_prima;
    }

    public void setValor_prima(double valor_prima) {
        this.valor_prima = valor_prima;
    }

    public String getIdinmueble() {
        return idinmueble;
    }

    public void setIdinmueble(String idinmueble) {
        this.idinmueble = idinmueble;
    }

    /**
     * @return the latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the zoom
     */
    public String getZoom() {
        return zoom;
    }

    /**
     * @param zoom the zoom to set
     */
    public void setZoom(String zoom) {
        this.zoom = zoom;
    }    
    
}
