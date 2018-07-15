/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAO {

    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void Conectar() throws  Exception {

        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Cerrar() throws Exception{
        try {
            if (cn != null){
                cn.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
