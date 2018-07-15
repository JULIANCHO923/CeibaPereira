/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.mock;

/**
 *
 * @author JULY92
 */
public class mockEstrato {
   
    /**
     * Mock utlizado para validar el estrato de una casa, dado los datos de geolozalización
     * Definiremos que la zoom <= 14 el estrato es 2 sino sera estrato 3     
     *      
     * @param latitud dada por el google maps al escoger direccion
     * @param longitud dada por el google maps al escoger direccion
     * @param zoom dada por el google maps al escoger direccion
     * @return  1 estrato coincide, 0 estrato no coincide
     */
    public int validarEstrato(String latitud, String longitud, int zoom, int estrato){
        double lat = Double.parseDouble(latitud);
        double lng = Double.parseDouble(longitud);        
        int estratoAux = 0;
        
        if(zoom < 14){
            estratoAux = 2;
        }else{
            estratoAux = 3;
        }
        
        if(estratoAux == estrato){
            return 1;   
        }else{
            return 0;   
        }                    
    }
    
}
