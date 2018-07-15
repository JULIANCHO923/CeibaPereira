package com.ceiba.bean;

import com.ceiba.doa.InmuebleDAO;
import com.ceiba.doa.model.Inmueble;
import com.ceiba.gestor.GestorReclamo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class ObtenerSeguroBean {

    private Inmueble inmueble = new Inmueble();
    private List<Inmueble> lstInmueble;
    private String accion;
    
    public ObtenerSeguroBean () throws Exception {
        listarInmueble();
    }

    public String getAccion() {
        return accion;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public List<Inmueble> getLstInmueble() {
        return lstInmueble;
    }

    public void setLstInmueble(List<Inmueble> lstInmueble) {
        this.lstInmueble = lstInmueble;
    }
    
      private boolean isPostBack() {

        boolean respt;
        respt = FacesContext.getCurrentInstance().isPostback();
        return respt;
    }
  
    public void listarInmueble() throws Exception {
        lstInmueble = GestorReclamo.ListarInmueble();
    }
    
    
    public void leerID(Inmueble pro) throws Exception {

        InmuebleDAO dao;
        Inmueble temp;

        try {
            dao = new InmuebleDAO();
            temp = dao.leerID(pro);

            if (temp != null) {
                this.inmueble = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
