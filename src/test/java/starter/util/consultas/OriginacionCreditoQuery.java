package starter.util.consultas;

import starter.conf.ConexionBase;

import java.sql.ResultSet;

public class OriginacionCreditoQuery {
    ConexionBase dbconector = new ConexionBase();

    public ResultSet consultarCalculosSimuladorOriginacion(String Monto,int DesPrimaAntic,String Tasa,String Plazo,
                                                           String DiasHabilesIntereses,String vlrCompasSaneamientos, String Ingresos, String descLey,
                                                           String descNomina,String pagaduria) {
        String Pagaduria = "'"+pagaduria+"'";
        ResultSet r = null;
        try {
            r = dbconector.conexion("select * from public.calculos_automatizacion_pruebas_fianza ("+Monto +","+DesPrimaAntic+","+Tasa+
                    ","+Plazo+","+DiasHabilesIntereses+","+vlrCompasSaneamientos+","+Ingresos+","+descLey+
                    ","+descNomina+","+Pagaduria+");");
        } catch (Exception e) {
            System.out.println("********consultarCalculosSimuladorOriginacion() ********");
            System.out.println(e.getMessage());
        }
        return r;
    }

    public ResultSet ConsultaDescuentoPrimaAntic() {
        ResultSet r=null;
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

}
