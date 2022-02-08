package starter.ui.referencias;

import net.serenitybdd.screenplay.targets.Target;

public class ReferenciasForm {

    //Referencias Personales
    public static final Target formReferenciasP = Target.the("Ingresar primer formulario de referencias personales").locatedBy("//div[text() = 'Referencia personal {0}']");
    public static final Target primerNombreRef  = Target.the("Caja de texto para ingresar el primer nombre de la ref").locatedBy("//input[@id='{0}PrimerNombre']");
    public static final Target segundoNombreRef  = Target.the("Caja de texto para ingresar el segundo nombre de la ref").locatedBy("//input[@id='{0}SegundoNombre']");
    public static final Target primerApellidoRef  = Target.the("Caja de texto para ingresar el primer apellido de la ref").locatedBy("//input[@id='{0}PrimerApellido']");
    public static final Target segundoApellidoRef  = Target.the("Caja de texto para ingresar el segundo apellido de la ref").locatedBy("//input[@id='{0}SegundoApellido']");
    public static final Target relacionRef = Target.the("Div para desplegar valores del select relacion de la ref").locatedBy("//input[@id='{0}Relacion']/preceding-sibling::div");
    public static final Target listaRelacionRef = Target.the("lista para seleccionar valores del select relacion de la ref").locatedBy("//input[@id='{0}Relacion']/preceding-sibling::div/child::div[2]//*[text()='{1}']");
    public static final Target celularRef  = Target.the("Caja de texto para ingresar el celular de la ref").locatedBy("//input[@id='{0}Celular']");
    public static final Target departamentoRef  = Target.the("Caja de texto para ingresar el departamento de la ref").locatedBy("//input[@id='{0}State']");
    public static final Target optionDepartamentoRef = Target.the("Opción para seleccionar departamento de la ref").locatedBy("//input[@id='{0}State']/following-sibling::div/child::div");
    public static final Target ciudadRef  = Target.the("Caja de texto para ingresar la ciudad de la ref").locatedBy("//input[@id='{0}City']");
    public static final Target optionCiudadRef = Target.the("Opción para seleccionar ciudad de la ref").locatedBy("//input[@id='{0}City']/following-sibling::div/child::div");

    //Referencias Familiares
    public static final Target formReferenciasF = Target.the("Ingresar primer formulario de referencias Familiares").locatedBy("//div[text() = 'Referencia familiar {0}']");
    public static final Target relacionRefFami = Target.the("Div para desplegar valores del select relacion de la ref familiar").locatedBy("/html/body/div/main/div[2]/div[2]/div/div[2]/div[2]/div[2]/form/div[{0}]/div[2]/div[3]/div[1]/div");
    public static final Target listaRelacionRefFam = Target.the("lista para seleccionar valores del select relacion de la ref").locatedBy("/html/body/div/main/div[2]/div[2]/div/div[2]/div[2]/div[2]/form/div[{0}]/div[2]/div[3]/div[1]/div/div[2]//div[text ()='{1}']");
}