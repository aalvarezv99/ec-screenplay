package starter.conf;


import starter.util.constantes.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConexionBaseToken {

    private static final String instancia = DbConfig.instanciaToken;
    private static final String dbUrl = DbConfig.dbTokenUrl;
    private static final String username = DbConfig.userToken;
    private static final String password = DbConfig.pswToken;

    public ResultSet conexion(String query) {
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
}
