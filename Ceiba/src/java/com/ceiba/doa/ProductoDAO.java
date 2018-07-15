package com.ceiba.doa;

import com.ceiba.doa.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ProductoDAO extends DAO {

    public void registrar(Producto pro) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO public.producto (nombre,precio)  VALUES ( ?, ?);");
            st.setString(1, pro.getNombre().toUpperCase());
            st.setDouble(2, pro.getPrecio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<Producto> Listar() throws Exception {

        List<Producto> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT idinmueble, usuario_cedula, tipo_inmueble_idtipo_inmueble, direccion, \n" +
                "  valor, estrato, metraje, valor_prima\n" +
                "  FROM public.inmueble;");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                // Se declara el Objeto Inmueble   
                Producto pro = new Producto();
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));

                lista.add(pro);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Producto leerID(Producto pro) throws Exception {

        Producto pros = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT codigo, nombre, precio FROM  public.producto WHERE codigo =?;");
            st.setInt(1, pro.getCodigo());
            st.executeQuery();
            rs = st.executeQuery();

            while (rs.next()) {
                pros = new Producto();
                pros.setCodigo(rs.getInt("codigo"));
                pros.setNombre(rs.getString("nombre"));
                pros.setPrecio(rs.getDouble("precio"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return pros;
    }

    public void modificar(Producto pro) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE public.producto set nombre = ?, precio = ? WHERE codigo = ?;");
            st.setString(1, pro.getNombre().toUpperCase());
            st.setDouble(2, pro.getPrecio());
            st.setInt(3, pro.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Producto pro) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM  public.producto WHERE codigo = ?;");
            st.setInt(1, pro.getCodigo());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
