package com.ceiba.bean;

import com.ceiba.doa.PersonaDAO;
import com.ceiba.doa.model.Persona;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class SeguroBean {

    private Persona persona = new Persona();
    private List<Persona> lstPersona;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public List<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Persona> lstPersona) {
        this.lstPersona = lstPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        this.persona.setCodigo(0);
        this.persona.setNombre("");
        this.persona.setSexo("");
    }

    private void registrar() throws Exception {

        PersonaDAO dao;

        try {
            dao = new PersonaDAO();
            dao.registrar(persona);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro satisfactorio","Exito"));
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {

        PersonaDAO dao;

        try {
            dao = new PersonaDAO();
            dao.modificar(persona);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Modificado Satisfactoriamente"));
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar(String valor) throws Exception {

        PersonaDAO dao;

        try {
            if (valor.equals('F')) {
                if (isPostBack() == false) {
                    dao = new PersonaDAO();
                    lstPersona = dao.Listar();
                }
            } else {
                dao = new PersonaDAO();
                lstPersona = dao.Listar();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarAjax() throws Exception {

        PersonaDAO dao;

        try {

            if (isPostBack() == true) {
                dao = new PersonaDAO();
                lstPersona = dao.Listar();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Persona per) throws Exception {

        PersonaDAO dao;
        Persona temp;

        try {
            dao = new PersonaDAO();
            temp = dao.leerID(per);

            if (temp != null) {
                this.persona = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Persona per) throws Exception {

        PersonaDAO dao;

        try {
            dao = new PersonaDAO();
            dao.eliminar(per);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
}
