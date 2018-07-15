package com.ceiba.bean;

import com.ceiba.doa.ProductoDAO;
import com.ceiba.doa.model.Inmueble;
import com.ceiba.doa.model.Producto;
import com.ceiba.doa.model.tipo_inmueble;
import com.ceiba.gestor.GestorSeguros;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class ObtenerSeguroBean {
    
    private String direccion;
    private ArrayList<tipo_inmueble> tipos;
    private String tipo;
    private Integer valor;
    private String metraje;
    private Integer estrato;
    private Integer valorPrima;
    private final GestorSeguros gestorSeguros;

    //private Inmueble inmueble = new Inmueble();
    private Producto producto = new Producto();
    private List<Producto> lstProducto;
    private String accion;
    
    public ObtenerSeguroBean() throws Exception {
        gestorSeguros = new GestorSeguros();
        cargarTipos();
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    private boolean isPostBack() {

        boolean respt;
        respt = FacesContext.getCurrentInstance().isPostback();
        return respt;
    }

    public void operar() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrar();
                this.limpiar();
                break;
            case "Modificar":
                this.modificar();
                this.limpiar();
                break;
        }
    }

    public void limpiar() {
        this.producto.setCodigo(0);
        this.producto.setNombre("");
        this.producto.setPrecio(0.0);
    }

    private void registrar() throws Exception {

        ProductoDAO dao;

        try {
            dao = new ProductoDAO();
            dao.registrar(producto);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {

        ProductoDAO dao;

        try {
            dao = new ProductoDAO();
            dao.modificar(producto);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar(String valor) throws Exception {

        ProductoDAO dao;

        try {
            if (valor.equals("F")) {
                if (isPostBack() == false) {
                    dao = new ProductoDAO();
                    lstProducto = dao.Listar();
                }
            } else {
                dao = new ProductoDAO();
                lstProducto = dao.Listar();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Producto pro) throws Exception {

        ProductoDAO dao;
        Producto temp;

        try {
            dao = new ProductoDAO();
            temp = dao.leerID(pro);

            if (temp != null) {
                this.producto = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Producto pro) throws Exception {

        ProductoDAO dao;

        try {
            dao = new ProductoDAO();
            dao.eliminar(pro);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
    //new

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
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
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
    public String getMetraje() {
        return metraje;
    }

    /**
     * @param metraje the metraje to set
     */
    public void setMetraje(String metraje) {
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
    public Integer getValorPrima() {
        return valorPrima;
    }

    /**
     * @param valorPrima the valorPrima to set
     */
    public void setValorPrima(Integer valorPrima) {
        this.valorPrima = valorPrima;
    }
    
    
    private void cargarTipos() throws Exception {
        tipos = gestorSeguros.cargarTipos();
    }
}
