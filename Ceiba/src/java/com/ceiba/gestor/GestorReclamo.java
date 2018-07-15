/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.gestor;

import com.ceiba.doa.DAO;
import com.ceiba.doa.InmuebleDAO;
import com.ceiba.doa.SeguroDAO;
import com.ceiba.doa.model.Inmueble;
import com.ceiba.doa.model.tipo_inmueble;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

public class GestorReclamo {

    public static List<Inmueble> ListarInmueble;

   
    private final DAO dao;
    private final SeguroDAO sdao = new SeguroDAO();
    private Inmueble inmueble = new Inmueble();

    public GestorReclamo() {
        this.dao = new DAO();
    }

    
     public static List<Inmueble> ListarInmueble() throws Exception {
        
        InmuebleDAO dao;
        
        List<Inmueble> lstInmueble;

        try {
            dao = new InmuebleDAO();
            lstInmueble = dao.Listar();
            return lstInmueble;

        } catch (Exception e) {
            throw e;
        }
    }

    private boolean isPostBack() {

        boolean respt;
        respt = FacesContext.getCurrentInstance().isPostback();
        return respt;
    }

}
