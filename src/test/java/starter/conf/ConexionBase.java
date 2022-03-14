package starter.conf;


import starter.util.constantes.DbConfig;

import java.sql.*;


public class ConexionBase {

    private static final String instancia = DbConfig.instancia;
    private static final String dbUrl = DbConfig.dbUrl;
    private static final String username = DbConfig.username;
    private static final String password = DbConfig.password;

    public ResultSet conexion(String query) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(dbUrl + instancia, username, password);
            Statement stmt = con.createStatement();
            stmt.setFetchSize(50);
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("********ERROR CONEXION BASE DATOS LIBRANZAS*******" + e.getMessage());

        }
        return rs;
    }

    /*ThainerPerez 14/Marzo/2022 V1.0 , 1.Se crea el metodo que ejecuta querys en la base de datos */
    public void ejecutorFunciones(String sql) throws SQLException, ClassNotFoundException {
        try {
            Connection con = DriverManager.getConnection(dbUrl + instancia, username, password);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error ejecutando las funciones" + e);
        }
    }
}
