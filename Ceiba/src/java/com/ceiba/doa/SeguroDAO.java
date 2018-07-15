/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.doa;

import com.ceiba.doa.model.tipo_inmueble;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class SeguroDAO {

    String sql;
    ResultSet rs;

    public ArrayList<tipo_inmueble> cargarTipos(DAO dao) throws Exception {
        ArrayList<tipo_inmueble> tipos = new ArrayList<>();
        try {
            PreparedStatement st = dao.getCn().prepareStatement("select idtipo_inmueble,nombre from tipo_inmueble");
            rs = st.executeQuery();
            while (rs.next()) {
                tipo_inmueble inmueble = new tipo_inmueble();
                inmueble.setIdtipo_inmueble(rs.getInt("idtipo_inmueble"));
                inmueble.setNombre(rs.getString("nombre"));
                tipos.add(inmueble);
            }
            return tipos;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void enviarSolicitud(String direccion, Integer tipo, Integer valor, Integer metraje, Integer estrato, Double valorPrima,DAO dao) throws SQLException {        
        try {
            PreparedStatement st = dao.getCn().prepareStatement("insert into inmueble (usuario_cedula,direccion,tipo_inmueble_idtipo_inmueble,valor,metraje,estrato,valor_prima) values (?,?,?,?,?,?,?)");
            st.setString(1, "200");
            st.setString(2, direccion.toUpperCase());
            st.setInt(3, tipo);
            st.setInt(4, valor);
            st.setInt(5, metraje);
            st.setInt(6, estrato);
            st.setDouble(7, valorPrima);
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

}
