package starter.conf;


import starter.util.constantes.DbConfig;

import java.sql.*;


public class ConexionBase {

    private static String instancia = DbConfig.instancia;
    private static String dbUrl = DbConfig.dbUrl;
    private static String username = DbConfig.username;
    private static String password = DbConfig.password;

    public ResultSet conexion(String query) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(dbUrl+instancia, username, password);
            Statement stmt = con.createStatement();
            stmt.setFetchSize(50);
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("********ERROR CONEXION BASE DATOS LIBRANZAS*******"+e.getMessage());

        }
        return rs;
    }
}
