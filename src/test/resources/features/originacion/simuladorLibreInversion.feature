#language: es

Característica: Simulador Digicredito

  Antecedentes:
    Cuando se asigna el usuario
    Y ingresa su usuario 88776655 y contrasena 4112935

  @Simulador
  Esquema del escenario:  Paso uno Datos cliente
    Entonces el usuario diligencias los campos del formulario <oficinaAsesor><nombresApellidos><numeroDocumento><fechaNacimiento><celular><correoElectronico><actividad><pagaduria><Contacto>
    Y ingresa la informacion de los valores credito a solicitar <montoSolicitado><tasa><plazo><diasIntereses>
    Y diligencia los datos financieros <ingresos><descLey><descNomina><lineaCredito>
    Y se validan los campos del simulador <montoSolicitado><tasa><plazo><ingresos><descLey><descNomina><pagaduria><diasIntereses>
    Ejemplos:
      | oficinaAsesor | nombresApellidos        | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito      |
      | "Soacha"      | "Daniel Andres Abogado" | "10324591950"   | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Libre inversion" |

  @endeudamientoGlobal
  Esquema del escenario: Diligencia los datos de endeudamiento global
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y registra la informacion basica solicitante <codigoAdo><estrado><tipoVivienda><claseVivienda><posicionHogar><nivelEscolaridad>
    Y registra la informacion financiera <descLey><descNomina>
    Entonces finaliza registrando la informacion a centrales <cuotaHipotecaria><tipoDocNomina>

    Ejemplos:
      | oficinaAsesor | nombresApellidos             | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito                | creditoPadre | estadoActual | page | codigoAdo | estrado     | tipoVivienda | claseVivienda | posicionHogar   | nivelEscolaridad | cuotaHipotecaria | tipoDocNomina            |
      | "Soacha"      | "ANGEL MARIA MEJIA SANDOVAL" | "91077296"      | "06/09/1979"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Retanqueo libre inversión" | "55412"      | ""           | ""   | "1234"    | "Estrato 1" | "Arriendo"   | "Casa"        | "Jefe de hogar" | "Universitario"  | "0"              | "Desprendible de nómina" |

  @desembolso
  Esquema del escenario: Diligenciamiento del desembolso
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y se selecciona la modalidad de desembolso y tipo de cliente <modalidadDesembolso><tipoCliente>

    Ejemplos:
      | oficinaAsesor | nombresApellidos                   | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito                | creditoPadre | estadoActual                       | page | modalidadDesembolso      | tipoCliente |
      | "Soacha"      | "CARLOS FERNANDO HERRERA ARBOLEDA" | "9777757"       | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Retanqueo libre inversión" | "55412"      | "En selección medio de desembolso" | ""   | "Pago masivo (efectivo)" | "AAA"       |