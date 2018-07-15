/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.gestor;

import com.ceiba.doa.DAO;
import com.ceiba.doa.SeguroDAO;
import com.ceiba.doa.model.tipo_inmueble;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class GestorSeguros {
    
    private final DAO dao;
    private final SeguroDAO sdao = new SeguroDAO();
    
    public GestorSeguros() throws Exception {    
        this.dao = new DAO();
        dao.Conectar();
    }
    
    public ArrayList<tipo_inmueble> cargarTipos() throws Exception {
        //dao.Conectar();
        ArrayList<tipo_inmueble> tipos;
        tipos = sdao.cargarTipos(dao);
        dao.Cerrar();
        return tipos;
    }

    public boolean enviarSolicitud(String direccion, Integer tipo, Integer valor, Integer metraje, Integer estrato, Double valorPrima, String latitud, String longitud, Integer zoom ) throws Exception {
        Boolean completa = true;
        dao.Conectar();
        completa = sdao.enviarSolicitud(direccion,tipo,valor,metraje,estrato,valorPrima,latitud,longitud,zoom, dao);
        dao.Cerrar();
        return completa;
    }
}
