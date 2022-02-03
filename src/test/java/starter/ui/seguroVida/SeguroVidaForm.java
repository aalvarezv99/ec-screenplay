package starter.ui.seguroVida;

import net.serenitybdd.screenplay.targets.Target;

public class SeguroVidaForm {
    public static final Target botonAgreagarBeneficiarios = Target.the("Botón para agregar beneficiarios").locatedBy("//button[text() = '+ Agregar otro beneficiario']");
    public static final Target inputNombreDelBeneficiario = Target.the("Input nombre del beneficiario").locatedBy("//input[@id = 'nombres_apellidos{0}']");
    public static final Target inputDocumentoDelBeneficiario = Target.the("Input documento del beneficiario").locatedBy("//input[@id = 'documento{0}']");
    public static final Target inputCelularDelBeneficiario = Target.the("Input celular del beneficiario").locatedBy("//input[@id = 'celular{0}']");
    public static final Target inputDepartamentoDelBeneficiario = Target.the("Input departamento del beneficiario").locatedBy("//input[@id = 'departamento{0}']");
    public static final Target optionDepartamento = Target.the("Opción para seleccionar departamento").locatedBy("//input[@id = 'departamento{0}']/following-sibling::div/child::div");
    public static final Target inputCiudadDelBeneficiario = Target.the("Input ciudad del beneficiario").locatedBy("//input[@id = 'ciudad{0}']");
    public static final Target optionCiudad = Target.the("Opción para seleccionar ciudad").locatedBy("//input[@id = 'ciudad{0}']/following-sibling::div/child::div");
    public static final Target inputPorcentajeDelBeneficiario = Target.the("Input porcentaje del beneficiario").locatedBy("//input[@id = 'tasa{0}']");
}
