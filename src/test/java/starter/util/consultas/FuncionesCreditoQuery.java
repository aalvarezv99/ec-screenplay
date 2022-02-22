package starter.util.consultas;

import starter.conf.ConexionBase;
import starter.conf.ConexionBaseToken;

import java.sql.ResultSet;

public class FuncionesCreditoQuery {
    ConexionBase dbconector = new ConexionBase();
    ConexionBaseToken dbTokenConector = new ConexionBaseToken();

    public ResultSet consultarCalculosSimuladorOriginacion(String Monto, int DesPrimaAntic, String Tasa, String Plazo,
                                                           String DiasHabilesIntereses, String vlrCompasSaneamientos, String Ingresos, String descLey,
                                                           String descNomina, String pagaduria) {
        String Pagaduria = "'" + pagaduria + "'";
        ResultSet r = null;
        try {
            String sql = "select * from public.calculos_automatizacion_pruebas_originacion (" + Monto + "," + DesPrimaAntic + "," + Tasa +
                    "," + Plazo + "," + DiasHabilesIntereses + "," + vlrCompasSaneamientos + "," + Ingresos + "," + descLey +
                    "," + descNomina + "," + Pagaduria + ");";
            r = dbconector.conexion(sql);
        } catch (Exception e) {
            System.out.println("********consultarCalculosSimuladorOriginacion() ********");
            System.out.println(e.getMessage());
        }
        return r;
    }

    public ResultSet ConsultaDescuentoPrimaAntic() {
        ResultSet r = null;
        try {
            r = dbconector.conexion("select valor\r\n"
                    + "from parametro_configuracion\r\n"
                    + "where nombre = 'PRIMA_SEGURO_PERIODOS_DESCONTAR'\r\n"
                    + "order by id desc;");


        } catch (Exception e) {
            System.out.println("********ERROR EJECUTANDO LA CONSULTA EL METODO - ConsultarRegistroCertificacion() ********");
            System.out.println(e.getMessage());
        }

        return r;
    }

    public ResultSet consultarCalculosSimuladorRetanqueo(String creditoPadre, String tasa, String plazo,
                                                         String diasHabilesIntereses, String monto, String sumaMontocCarteras) {

        ResultSet r = null;
        try {

            String sql = "select * from public.calculos_simulador_retanqueo (" + Integer.parseInt(creditoPadre) + "," + Double.parseDouble(tasa) + "," + Integer.parseInt(plazo) + "," + Integer.parseInt(diasHabilesIntereses) + "," + Integer.parseInt(monto) + "," + Integer.parseInt(sumaMontocCarteras) + ");";
            // System.out.println(sql);
            r = dbconector.conexion(sql);

        } catch (Exception e) {
            System.out.println("********consultarCalculosSimuladorRetanqueo() ********");
            System.out.println(e.getMessage());
        }
        return r;
    }

    public ResultSet consultarIdCliente(String cedula) {

        ResultSet r = null;
        try {
            r = dbconector.conexion("select id from cliente c where c.identificacion ='" + cedula + "';");
        } catch (Exception e) {
            System.out.println(" ********consultarIdCliente() ******** ");
            System.out.println(e.getMessage());
        }
        return r;
    }

    public ResultSet consultarCreditoHijo(String idCliente) {

        ResultSet r = null;
        try {
            r = dbconector.conexion("select id from credito c where c.id_cliente = '" + idCliente + "';");
        } catch (Exception e) {
            System.out.println(" ********consultarCreditoHijo() ******** ");
            System.out.println(e.getMessage());
        }
        return r;
    }

    public ResultSet consultarTokenCliente(String idCliente) {

        ResultSet r = null;
        try {
            r = dbTokenConector.conexion("select token from otp o where id_cliente = " + idCliente + " order by id desc limit 1;");
        } catch (Exception e) {
            System.out.println(" ******** consultarTokenCliente() ******** ");
            System.out.println(e.getMessage());
        }
        return r;
    }

    public ResultSet consultarEstadoUltimoCredito(String numeroDocumento){

        ResultSet r = null;
        try {
            r = dbconector.conexion("select cr.estado\n" +
                    "from credito cr\n" +
                    "inner join cliente cl on cl.id = cr.id_cliente\n" +
                    "and cl.identificacion in ('" + numeroDocumento + "')\n" +
                    "order by cr.id desc limit 1;");
        } catch (Exception e){
            System.out.println(" ******** consultarEstadoUltimoCredito() ******** ");
            System.out.println(e.getMessage());
        }
        return r;
    }
}
