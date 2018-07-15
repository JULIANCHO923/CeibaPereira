package com.ceiba.doa;

import com.ceiba.doa.model.Inmueble;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class InmuebleDAO extends DAO {

    public List<Inmueble> Listar() throws Exception {

        List<Inmueble> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT idinmueble, usuario_cedula, tipo_inmueble_idtipo_inmueble, direccion, \n"
                    + "  valor, estrato, metraje, valor_prima\n"
                    + "  FROM public.inmueble;");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                // Se declara el Objeto Inmueble   
                Inmueble inmueble = new Inmueble();
                
                inmueble.setIdinmueble(rs.getString("idinmueble"));
                inmueble.setUsuario_cedula(rs.getString("usuario_cedula"));
                inmueble.setTipo_inmueble_idtipo_inmueble(rs.getString("tipo_inmueble_idtipo_inmueble"));
                inmueble.setDireccion(rs.getString("direccion"));
                inmueble.setValor(rs.getDouble("valor"));
                inmueble.setEstrato(rs.getInt("estrato"));
                inmueble.setMetraje(rs.getDouble("metraje"));
                inmueble.setValor_prima(rs.getDouble("valor_prima"));

                lista.add(inmueble);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Inmueble leerID(Inmueble pro) throws Exception {

        Inmueble pros = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT codigo, nombre, precio FROM  public.producto WHERE codigo =?;");
            st.setString(1, pro.getIdinmueble());
            st.executeQuery();
            rs = st.executeQuery();

            while (rs.next()) {
                pros = new Inmueble();
        //        pros.setCodigo(rs.getInt("codigo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return pros;
    }


}
