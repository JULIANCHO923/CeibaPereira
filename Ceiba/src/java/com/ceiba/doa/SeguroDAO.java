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
            PreparedStatement st = dao.getCn().prepareStatement("select nombre from tipo_inmueble");
            rs = st.executeQuery();
            while (rs.next()) {
                tipo_inmueble inmueble = new tipo_inmueble();
                inmueble.setNombre(rs.getString("nombre"));
                tipos.add(inmueble);
            }
            return tipos;
        } catch (SQLException e) {
            throw e;
        }
    }

}
