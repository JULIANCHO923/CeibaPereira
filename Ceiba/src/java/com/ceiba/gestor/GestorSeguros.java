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
    
    public GestorSeguros() {    
        this.dao = new DAO();
    }
    
    public ArrayList<tipo_inmueble> cargarTipos() throws Exception {
        dao.Conectar();
        ArrayList<tipo_inmueble> tipos;
        tipos = sdao.cargarTipos(dao);
        dao.Cerrar();
        return tipos;
    }
}
