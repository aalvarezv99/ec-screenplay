package starter.task.simulador;

import org.jetbrains.annotations.NotNull;
import starter.models.SimuladorModels;
import starter.util.consultas.FuncionesCreditoQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ResultadoTask {

    static FuncionesCreditoQuery consultarCalculosSimulador= new FuncionesCreditoQuery();

    public static SimuladorModels consultarCalculosSimulador(String Monto, String Tasa, String Plazo,
                                                             String DiasHabilesIntereses, String vlrCompasSaneamientos, String Ingresos, String descLey,
                                                             String descNomina, String pagaduria) throws SQLException {

        ResultSet resultado;
        int DesPrimaAntic=0;

        FuncionesCreditoQuery query = new FuncionesCreditoQuery();
        resultado = query.ConsultaDescuentoPrimaAntic();

        while (resultado.next()) {
            DesPrimaAntic = Integer.parseInt(resultado.getString(1));
        }
        System.out.println("******** Valor de prima **** " + DesPrimaAntic);
        if (Integer.valueOf(Plazo) < DesPrimaAntic) {
            int periodoGracia = (int) Math.ceil((double) Integer.parseInt(DiasHabilesIntereses)/ 30);
            DesPrimaAntic = periodoGracia + Integer.valueOf(Plazo);
            System.out.println("******** Nuevo valor de prima plazo menor a 24  **** " + DesPrimaAntic);
        }

        System.out.println("****** Calculando valores simulador Originacion por funcion SQL, OriginacionCreditosAccion -  consultarCalculosSimulador()*******");

        SimuladorModels resultSimulador = new SimuladorModels();


        ResultSet r = null;
        try {
            r = consultarCalculosSimulador.consultarCalculosSimuladorOriginacion(Monto, DesPrimaAntic, Tasa, Plazo,
                    DiasHabilesIntereses, vlrCompasSaneamientos, Ingresos, descLey,
                    descNomina, pagaduria);
            while (r.next()) {

                resultSimulador.setMontoSolicitar(r.getInt(1));
                resultSimulador.setCuotaCorriente(r.getInt(2));
                resultSimulador.setEstudioCredito(r.getInt(3));
                resultSimulador.setFianza(r.getInt(4));
                resultSimulador.setGmf4X100(r.getInt(5));
                resultSimulador.setInteresesIniciales(r.getInt(6));
                resultSimulador.setPrimaSeguroAnticipada(r.getInt(7));
                resultSimulador.setRemanenteEstimado(r.getInt(8));
                resultSimulador.setMontoMaxDesembolsar(r.getInt(9));
                resultSimulador.setCapacidadCliente(r.getInt(10));
            }
        } catch (Exception e) {
            System.out.println("########## Error - OriginacionCreditosAccion - consultarCalculosSimulador() #######" + e);

        }

        return resultSimulador;

    }



    public static SimuladorModels consultarCalculosSimuladorRetanqueo(String creditoPadre, String tasa, String plazo,
                                                                      String diasHabilesIntereses, String monto) throws SQLException {

        ResultSet resultado;
        int DesPrimaAntic=0;

        System.out.println("****** Calculando valores simulador Originacion por funcion SQL, OriginacionCreditosAccion -  consultarCalculosSimulador()*******");

        SimuladorModels resultSimulador = new SimuladorModels();
        ResultSet r = null;
        try {
            r = consultarCalculosSimulador.consultarCalculosSimuladorRetanqueo(creditoPadre,tasa,plazo,
                    diasHabilesIntereses,monto,"0");
            while (r.next()) {

                resultSimulador.setCuotaCorriente(r.getInt(3));
                resultSimulador.setEstudioCredito(r.getInt(8));
                resultSimulador.setFianza(r.getInt(7));
                resultSimulador.setGmf4X100(r.getInt(4));
                resultSimulador.setPrimaSeguroAnticipada(r.getInt(2));
                resultSimulador.setRemanenteEstimado(r.getInt(10));
            }
        } catch (Exception e) {
            System.out.println("########## Error - OriginacionCreditosAccion - consultarCalculosSimulador() #######" + e);

        }
        return resultSimulador;

    }


}
