
package com.ceiba.doa.model;


public class Producto {
    
    private int codigo;
    private String nombre;
    private Double precio;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

   
    

    @Override
    public String toString() {
        return String.format("%s[codigo=%d]",getClass().getSimpleName(),getCodigo() );
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


}
