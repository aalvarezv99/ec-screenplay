package starter.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooksPrueba {

    @Before("@login2")
    public static void beforeHook(){
        System.out.println("**************** Prueba de before  *********************");
    }
    @After
    public static void afterHook(){
        System.out.println("**************** Prueba de after  *********************");
    }
}
