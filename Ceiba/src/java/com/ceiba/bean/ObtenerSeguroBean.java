package com.ceiba.bean;

import com.ceiba.doa.InmuebleDAO;
import com.ceiba.doa.model.Inmueble;
import com.ceiba.doa.model.tipo_inmueble;
import com.ceiba.gestor.GestorReclamo;
import com.ceiba.gestor.GestorSeguros;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class ObtenerSeguroBean {
    
    private String direccion;
    private ArrayList<tipo_inmueble> tipos;
    private tipo_inmueble tipo;
    private Integer valor;
    private Integer metraje;
    private Integer estrato;
    private Double valorPrima;
    private final GestorSeguros gestorSeguros;

    private String latitud;
    private String longitud;    
    private Integer zoom;
    
    private Inmueble inmueble = new Inmueble();
    private List<Inmueble> lstInmueble;
    private String accion;
    
    public ObtenerSeguroBean () throws Exception {
        listarInmueble();
        tipo = new tipo_inmueble();
        gestorSeguros = new GestorSeguros();
        cargarTipos();
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
    
    
    private void cargarTipos() throws Exception {
        tipos = gestorSeguros.cargarTipos();
    }
    
    public void calculaValorPrima() {
        this.valorPrima = (this.valor * 0.05)/12 + ((this.valor * 0.05)/12)*0.001;
    }
    
    public void enviarSolicitud() throws Exception {
        if(gestorSeguros.enviarSolicitud(this.direccion,this.tipo.getIdtipo_inmueble(),this.valor,this.metraje,this.estrato,this.valorPrima,this.latitud,this.longitud,this.zoom)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Solicitud registrada exitosamente","Exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hubo un problema al registrar la solicitud.","Alerta"));
        }
        limpiarForma();
    }
    
    public void limpiarForma(){
        this.tipo = new tipo_inmueble();
        this.direccion = "";
        this.valor = null;
        this.metraje = null;
        this.estrato = null;
        this.valorPrima = null;
        this.latitud = null;
        this.longitud = null;    
        this.zoom = null;
    }
    
    
        /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the tipos
     */
    public ArrayList<tipo_inmueble> getTipos() {
        return tipos;
    }

    /**
     * @param tipos the tipos to set
     */
    public void setTipos(ArrayList<tipo_inmueble> tipos) {
        this.tipos = tipos;
    }

    /**
     * @return the tipo
     */
    public tipo_inmueble getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(tipo_inmueble tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    /**
     * @return the metraje
     */
    public Integer getMetraje() {
        return metraje;
    }

    /**
     * @param metraje the metraje to set
     */
    public void setMetraje(Integer metraje) {
        this.metraje = metraje;
    }

    /**
     * @return the estrato
     */
    public Integer getEstrato() {
        return estrato;
    }

    /**
     * @param estrato the estrato to set
     */
    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }
      
    /**
     * @return the valorPrima
     */
    public Double getValorPrima() {
        return valorPrima;
    }

    /**
     * @param valorPrima the valorPrima to set
     */
    public void setValorPrima(Double valorPrima) {
        this.valorPrima = valorPrima;
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
    public Integer getZoom() {
        return zoom;
    }

    /**
     * @param zoom the zoom to set
     */
    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

}
