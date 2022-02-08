#language: es

Característica: Simulador Digicredito

  Antecedentes:
    Cuando se asigna el usuario
    Y ingresa su usuario 88776655 y contrasena 4112935

  @Simulador
  Esquema del escenario:  Paso uno Datos cliente
    Entonces el usuario diligencias los campos del formulario <oficinaAsesor><nombresApellidos><numeroDocumento><fechaNacimiento><celular><correoElectronico><actividad><pagaduria><Contacto>
    Y ingresa la informacion de los valores credito a solicitar <montoSolicitado><tasa><plazo><diasIntereses>
    Y diligencia los datos financieros retanqueo <ingresos><descLey><descNomina><lineaCredito><creditoPadre><vlrCompras>
    Y se validan los campos del simulador retanqueo <creditoPadre><tasa><plazo><diasIntereses><vlrCompras>
    Y se inicia la solicitud del credito

    Ejemplos:
      | oficinaAsesor | nombresApellidos              | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos | vlrCompras | lineaCredito                | creditoPadre | estadoActual                       |
      | "Soacha"      | "JORGE ANCIZAR CORTES CORREA" | "9971523"       | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "10000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000"| "200000" | "Retanqueo compra de cartera" | "55412"      | "En proceso calculo endeudamiento" |

  @endeudamientoGlobal
  Esquema del escenario: Diligencia los datos de endeudamiento global
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y registra la informacion basica solicitante <codigoAdo><estrado><tipoVivienda><claseVivienda><posicionHogar><nivelEscolaridad>
    Y registra la informacion financiera <descLey><descNomina>
    Entonces finaliza registrando la informacion a centrales <cuotaHipotecaria><tipoDocNomina><rutaPdf><otrosIngresos>

    Ejemplos:
      | oficinaAsesor | nombresApellidos              | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos | vlrCompras | lineaCredito                | creditoPadre | estadoActual                       |
      | "Soacha"      | "JORGE ANCIZAR CORTES CORREA" | "9971523"       | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "10000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000"| "200000" | "Retanqueo compra de cartera" | "55412"      | "En proceso calculo endeudamiento" |

  @desembolso
  Esquema del escenario: Diligenciamiento del desembolso
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y se selecciona la modalidad de desembolso y tipo de cliente <modalidadDesembolso><tipoCliente>

    Ejemplos:
      | oficinaAsesor | nombresApellidos              | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos | vlrCompras | lineaCredito                | creditoPadre | estadoActual                       |
      | "Soacha"      | "JORGE ANCIZAR CORTES CORREA" | "9971523"       | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "10000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000"| "200000" | "Retanqueo compra de cartera" | "55412"      | "En proceso calculo endeudamiento" |

  @seguroVida
  Esquema del escenario: Registrar beneficiarios seguro de vida
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Entonces diligencia minimo tres beneficiaros para el seguro de vida <nombreBeneficario><documentoBeneficiario><celularBeneficiario><departamento><ciudad>

    Ejemplos:
      | oficinaAsesor | nombresApellidos              | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos | vlrCompras | lineaCredito                | creditoPadre | estadoActual                       |
      | "Soacha"      | "JORGE ANCIZAR CORTES CORREA" | "9971523"       | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "10000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000"| "200000" | "Retanqueo compra de cartera" | "55412"      | "En proceso calculo endeudamiento" |