#language: es

Característica: Simulador Digicredito

  Antecedentes:
    Cuando se asigna el usuario
    Y ingresa su usuario 88776655 y contrasena 4112935

  @Simulador
  Esquema del escenario:  Paso uno Datos cliente
    Entonces el usuario diligencias los campos del formulario <oficinaAsesor><nombresApellidos><numeroDocumento><fechaNacimiento><celular><correoElectronico><actividad><pagaduria><Contacto>
    Y ingresa la informacion de los valores credito a solicitar <montoSolicitado><tasa><plazo><diasIntereses>
    Y diligencia los datos financieros <ingresos><descLey><descNomina><lineaCredito><creditoPadre><vlrCompras>
    Y se validan los campos del simulador <tasa><plazo><ingresos><descLey><descNomina><pagaduria><diasIntereses><creditoPadre><vlrCompras><lineaCredito>
    Y se inicia la solicitud del credito
    Entonces El usuario carga los archivos imagen de la cedula del cliente <RutaPDF>
    Y realiza el registro del cliente paso 2 de 4 <numeroDocumento><primerNombre><segundoNombre><primerApellido><segundoApellido><fechaNacimiento><fechaExpedicion><departamentoExpedicionCC><ciudadExpedicionCC><genero>
    Y se llenan los datos adicionales <departamentoExpedicionCC><ciudadExpedicionCC>
    Entonces se realiza el proceso de Prospeccion del cliente <numeroDocumento>
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y recorre las paginas de la consulta de propeccion

    Ejemplos:
      | oficinaAsesor | nombresApellidos              | numeroDocumento | fechaNacimiento | celular      | correoElectronico         | actividad    | pagaduria     | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | vlrCompras | lineaCredito                | creditoPadre | RutaPDF                                 | estadoActual | page                     | primerNombre | segundoNombre | primerApellido | segundoApellido | fechaExpedicion | departamentoExpedicionCC | ciudadExpedicionCC | genero |
      | "Soacha"      | "OSCAR FABIAN ROJAS SOGAMOSO" | "96331519"      | "05/01/1977"    | "3183903022" | "aalvarez@excelcredit.co" | "Pensionado" | "P.A. CREMIL" | "Entidad donde trabaja" | "20000000"      | "1.70" | "60"  | "100"         | "260000"   | "100000" | "5500000" | "0"        | "Retanqueo libre inversión" | "76625"      | "src/test/resources/Data/PDFPRUEBA.pdf" | ""           | "Pendientes por Radicar" | "CARLOS"     | "FERNANDO"    | "HERRERA"      | "ARBOLEDA"      | "10/10/2010"    | "Cauca"                  | "Balboa"           | "F"    |

  @endeudamientoGlobal
  Esquema del escenario: Diligencia los datos de endeudamiento global
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y registra la informacion basica solicitante <codigoAdo><estrado><tipoVivienda><claseVivienda><posicionHogar><nivelEscolaridad>
    Y registra la informacion financiera <descLey><descNomina>
    Entonces finaliza registrando la informacion a centrales <cuotaHipotecaria><tipoDocNomina><rutaPdf><otrosIngresos>

    Ejemplos:
      | oficinaAsesor | nombresApellidos                   | numeroDocumento | fechaNacimiento | celular      | correoElectronico           | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | vlrCompras | lineaCredito                | creditoPadre | RutaPDF                                 | estadoActual | page                     | primerNombre | segundoNombre | primerApellido | segundoApellido | fechaExpedicion | departamentoExpedicionCC | ciudadExpedicionCC | genero | codigoAdo | estrado     | tipoVivienda | claseVivienda | posicionHogar   | nivelEscolaridad | cuotaHipotecaria | tipoDocNomina            | rutaPdf                                 | otrosIngresos |
      | "Soacha"      | "CARLOS FERNANDO HERRERA ARBOLEDA" | "9777757"       | "12/12/2000"    | "3204992496" | "jvcutilidades@hotmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "20000000"      | "1.70" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "200000"   | "Retanqueo libre inversión" | "88829"      | "src/test/resources/Data/PDFPRUEBA.pdf" | ""           | "Pendientes por Radicar" | "CARLOS"     | "FERNANDO"    | "HERRERA"      | "ARBOLEDA"      | "10/10/2010"    | "Cauca"                  | "Balboa"           | "F"    | "1234"    | "Estrato 1" | "Arriendo"   | "Casa"        | "Jefe de hogar" | "Universitario"  | "100000"         | "Desprendible de nómina" | "src/test/resources/Data/PDFPRUEBA.pdf" | "30000000"    |

  @desembolso
  Esquema del escenario: Diligenciamiento del desembolso
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y se selecciona la modalidad de desembolso y tipo de cliente <modalidadDesembolso><tipoCliente>

    Ejemplos:
      | oficinaAsesor | nombresApellidos              | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | vlrCompras | lineaCredito                  | creditoPadre | estadoActual                       | page | modalidadDesembolso      | tipoCliente |
      | "Soacha"      | "JORGE ANCIZAR CORTES CORREA" | "9971523"       | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "10000000"      | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "200000"   | "Retanqueo compra de cartera" | "55412"      | "En proceso calculo endeudamiento" | ""   | "Pago masivo (efectivo)" | "AAA"       |

  @datosSolicitud
  Esquema del escenario: Diligenciamiento formulario Datos Solicitud
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y registra los datos adicionales del cliente en Pagina 1 <paisNacimiento><lugarDeNacimiento><nacionalidad><estadoCivil><profesion>
    Y registra los datos adicionales del cliente en Pagina 2 <departamentoResidencia><ciudadResidencia><direccionResidencia><mesesResidencia><numeroHijos><personasACargo><departamentoCorrespondencia><ciudadCorrespondencia>
    #Y registra los datos adicionales del cliente en Pagina 3
    Y registra los datos adicionales del cliente en Pagina 4 <tipoPension><codigoProgramaNomina><fechaIngreso><fechaTerminacion><nitAfiliacion><tipoDocumento><rutaPdf><cargo>

    Ejemplos:
      | numeroDocumento | estadoActual                            | page | rutaPdf                                 | paisNacimiento | lugarDeNacimiento | nacionalidad | estadoCivil | profesion   | departamentoResidencia | ciudadResidencia | direccionResidencia   | mesesResidencia | numeroHijos | personasACargo | departamentoCorrespondencia | ciudadCorrespondencia | tipoPension | codigoProgramaNomina | fechaIngreso | fechaTerminacion | nitAfiliacion | tipoDocumento           | cargo | ingresosMensuales | totalDescuentos | totalDescuentosLey | lineaDeCredito    | estadoActual2         | montoSolicitado | tasa   | plazo | diasInteresesIniciales |
      | "9777757"       | "En registro datos adicionales cliente" | ""   | "src/test/resources/Data/PDFPRUEBA.pdf" | "colombia"     | "colombia"        | "colombiano" | "Soltera/o" | "ingeniero" | "Bogotá D.C"           | "Bogota"         | "Cra 14 No. 93a - 30" | "24"            | "2"         | "0"            | "Antioquia"                 | "Abejorral"           | "pension"   | "123456"             | "01/01/2015" | "30/12/2022"     | "123456"      | "Certificación laboral" | "CEO" | "6500000"         | "250000"        | "150000"           | "Libre inversion" | "En simulación final" | "15000000"      | "1.70" | "24"  | "120"                  |

  @seguroVida
  Esquema del escenario: Registrar beneficiarios seguro de vida
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Entonces diligencia minimo tres beneficiaros para el seguro de vida <nombreBeneficario><documentoBeneficiario><celularBeneficiario><departamento><ciudad>

    Ejemplos:
      | numeroDocumento | estadoActual                    | page | nombreBeneficario    | documentoBeneficiario | celularBeneficiario | departamento | ciudad   |
      | "91077296"      | "En registro de seguro de vida" | ""   | "Luis Perez Ramirez" | "1234567890"          | "3183903022"        | "Bogotá D.C" | "Bogota" |

  @firmaDocumentos
  Esquema del escenario: Realiza la firma final de documentos
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y consulta el codigo OTP <numeroDocumento>
    Y descarga los documentos a firmar
    Entonces diligencia el tipo de documento y adjunta el archivo <rutaPdf>

    Ejemplos:
      | numeroDocumento | estadoActual | page | rutaPdf                                 |
      | "91077296"      | ""           | ""   | "src/test/resources/Data/PDFPRUEBA.pdf" |

