/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.doa;

import com.ceiba.doa.model.DetalleVenta;
import com.ceiba.doa.model.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Verónica
 */
public class ventaDAO extends DAO {

    public void registrar(Venta venta, List<DetalleVenta> lista) throws Exception {

        try {
            this.Conectar();
            this.getCn().setAutoCommit(false);
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO public.venta(fecha, codigo_persona, monto) VALUES ( current_date, ?, ?);");
            st.setInt(1, venta.getPersona().getCodigo());
            st.setDouble(2, venta.getVenta());
            st.executeUpdate();
            st.close();

            PreparedStatement str = this.getCn().prepareStatement("SELECT MAX(CODIGO)+1 FROM venta;");
            ResultSet rst;
            int codVenta = 0;
            rst = str.executeQuery();
            while (rst.next()) {
                codVenta = rst.getInt(1);
            }
                rst.close();
                
            for (DetalleVenta det : lista) {
                PreparedStatement sts = this.getCn().prepareStatement("INSERT INTO public.detalle_venta(cod_venta, cod_producto, cantidad)  VALUES (?, ?, ?);");
                sts.setInt(1, codVenta);
                sts.setInt(2, det.getProducto().getCodigo());
                sts.setDouble(3, det.getCantidad());
                sts.executeUpdate();
                sts.close();
            }
            this.getCn().commit();
        } catch (Exception e) {
            this.getCn().rollback();
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
