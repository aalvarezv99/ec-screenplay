package starter.task.commonTask;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import starter.util.constantes.TokenVariable;

public class TokenDev {

    public static String obtenerTokenDevelopmentExcelCredit() {
        System.out.println("Obtener TOKED DEV->>>   ");
        String access_token = null;

        try {
            String developToken = TokenVariable.UrlDevelopmentExcelCredit;
            String grant_type = TokenVariable.grant_type;
            String client_id = TokenVariable.client_id;
            String client_secret = TokenVariable.client_secret;


            RestAssured.baseURI = developToken;
            RequestSpecification request = RestAssured.given()
                    .contentType("application/x-www-form-urlencoded; charset=utf-8")
                    .formParam("grant_type", grant_type)
                    .formParam("client_id", client_id)
                    .formParam("client_secret", client_secret);

            Response response = request.post("/token");

            access_token = response.then().extract().path("access_token");
            System.out.println(access_token);

        } catch (Exception e) {
            System.out.println("Error ->>>>>access_token");
        }
        return access_token;
    }

    public static String obtenerTokenAPI_notificacion_OPT(String tokenDevEC, String creditoHijo, String idCliente, String idUsuario) {
        String token_notificacion_OTP = null;

        try {
            String ulrOnboarding = "https://development.excelcredit.co/instancia4/api/excelcredit/onboardingservices/";
            RestAssured.baseURI = ulrOnboarding + "creditos/" + creditoHijo + "/prospeccion";
            RequestSpecification request = RestAssured.given();

            request.header("Authorization","Bearer "+tokenDevEC);
            request.header("content-type","application/json;charset=UTF-8");


            JSONObject requestParams = new JSONObject();
            requestParams.put("idCliente", idCliente);
            requestParams.put("idUsuario", idUsuario);
            request.body(requestParams.toJSONString());

            Response response = request.post("/notificacion-otp");

            token_notificacion_OTP = response.then().extract().path("token");
            System.out.println(token_notificacion_OTP);
        } catch (Exception e) {
            System.out.println("Error ->>>>>token_notificacion_OTP");
        }
        return token_notificacion_OTP;
    }



}
