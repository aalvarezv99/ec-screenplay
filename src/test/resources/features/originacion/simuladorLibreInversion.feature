#language: es

Característica: Simulador Digicredito

  Antecedentes:
    Cuando se asigna el usuario
    Y ingresa su usuario 88776655 y contrasena 4112935

  @Simulador
  Esquema del escenario:  Simulador Inicial
    Entonces el usuario diligencias los campos del formulario <oficinaAsesor><nombresApellidos><numeroDocumento><fechaNacimiento><celular><correoElectronico><actividad><pagaduria><Contacto>
    Y ingresa la informacion de los valores credito a solicitar <montoSolicitado><tasa><plazo><diasIntereses>
    Y diligencia los datos financieros <ingresos><descLey><descNomina><lineaCredito>
    Y se validan los campos del simulador <montoSolicitado><tasa><plazo><ingresos><descLey><descNomina><pagaduria><diasIntereses>
    Y se inicia la solicitud del credito
    Entonces El usuario carga los archivos imagen de la cedula del cliente <RutaPDF>
    Y realiza el registro del cliente paso 2 de 4 <numeroDocumento><primerNombre><segundoNombre><primerApellido><segundoApellido><fechaNacimiento><fechaExpedicion><departamentoExpedicionCC><ciudadExpedicionCC><genero>
    Y se llenan los datos adicionales <departamentoExpedicionCC><ciudadExpedicionCC>
    Entonces se realiza el proceso de Prospeccion del cliente <numeroDocumento>
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y recorre las paginas de la consulta de propeccion
    Ejemplos:
      | oficinaAsesor | nombresApellidos                 | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito      | RutaPDF                                 | estadoActual | page                     | primerNombre | segundoNombre | primerApellido | segundoApellido | fechaExpedicion | departamentoExpedicionCC | ciudadExpedicionCC | genero |
      | "Soacha"      | "RUBY ALEYDA RODRIGUEZ GONZALEZ" | "52912399"      | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Libre inversion" | "src/test/resources/Data/PDFPRUEBA.pdf" | ""           | "Pendientes por Radicar" | "RUBY"       | "ALEYDA"      | "RODRIGUEZ"    | "GONZALEZ"      | "10/10/2010"    | "Cauca"                  | "Balboa"           | "F"    |

  @endeudamientoGlobal
  Esquema del escenario: Diligencia los datos de endeudamiento global
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y registra la informacion basica solicitante <codigoAdo><estrado><tipoVivienda><claseVivienda><posicionHogar><nivelEscolaridad>
    Y registra la informacion financiera <descLey><descNomina>
    Entonces finaliza registrando la informacion a centrales <cuotaHipotecaria><tipoDocNomina><rutaPdf><otrosIngresos>

    Ejemplos:
      | oficinaAsesor | nombresApellidos                 | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito                | creditoPadre | estadoActual | page | codigoAdo | estrado     | tipoVivienda | claseVivienda | posicionHogar   | nivelEscolaridad | cuotaHipotecaria | tipoDocNomina            | rutaPdf                                 | otrosIngresos |
      | "Soacha"      | "RUBY ALEYDA RODRIGUEZ GONZALEZ" | "52912399"      | "06/09/1979"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Retanqueo libre inversión" | "55412"      | ""           | ""   | "1234"    | "Estrato 1" | "Arriendo"   | "Casa"        | "Jefe de hogar" | "Universitario"  | "100000"         | "Desprendible de nómina" | "src/test/resources/Data/PDFPRUEBA.pdf" | "30000000"    |

  @desembolso
  Esquema del escenario: Diligenciamiento del desembolso
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y se selecciona la modalidad de desembolso y tipo de cliente <modalidadDesembolso><tipoCliente>

    Ejemplos:
      | oficinaAsesor | nombresApellidos                 | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito                | creditoPadre | estadoActual                       | page | modalidadDesembolso      | tipoCliente |
      | "Soacha"      | "RUBY ALEYDA RODRIGUEZ GONZALEZ" | "52912399"      | "06/09/1979"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Retanqueo libre inversión" | "55412"      | "En selección medio de desembolso" | ""   | "Pago masivo (efectivo)" | "AAA"       |

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

  @datosSolicitudCredito
  Esquema del escenario: Diligenciamiento formulario Datos Solicitud Credito
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Entonces se registran los datos para el credito Originacion <ingresosMensuales><totalDescuentos><totalDescuentosLey><lineaDeCredito>
    Y se crean los tipos de cartera o saneamiento a recoger con la linea de <lineaDeCredito>
      | Contador        | Entidad                                                    | Monto  | VlrCuota | FechaVencimiento | NumObligacion |
      | 1     | ABOGADAS Y ASESORES                                         | 100000 | 70000    | 30/12/2021       | 21236         |
      | 2     | ABOGADAS Y ASESORES                                         | 100000 | 70000    | 30/12/2021       | 21236         |
      | 3     | ABOGADAS Y ASESORES                                         | 100000 | 70000    | 30/12/2021       | 21236         |
    Y diligencia los datos calculo credito <montoSolicitado><tasa><plazo><diasInteresesIniciales>

    Ejemplos:
      | numeroDocumento | estadoActual          | page | ingresosMensuales | totalDescuentos | totalDescuentosLey | lineaDeCredito    | montoSolicitado | tasa   | plazo | diasInteresesIniciales |
      | "9777757"       | "En simulación final" | ""   | "6500000"         | "250000"        | "150000"           | "Compra de cartera" | "15000000"      | "1.70" | "24"  | "120"                  |

  @seguroAP
  Esquema del escenario: Etapa de seguro AP
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Entonces Se visualizan los beneficios del seguro
    Y Se selecciona el vinculo del seguro y el plan <vinculo><plan>
    #Y Se llenan los campos de tomador del seguro <nombresApellidos><numeroDocumento><celular><correoElectronico><fechaNacimiento><departamento><ciudad><direccion>
    Y Se registran los beneficiarios <nombresSeguroAP><parentescoSeguroAP>

    Ejemplos:
      | oficinaAsesor | nombresApellidos                 | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito                | creditoPadre | estadoActual | page | codigoAdo | estrado     | tipoVivienda | claseVivienda | posicionHogar   | nivelEscolaridad | cuotaHipotecaria | tipoDocNomina            | rutaPdf                                 | otrosIngresos | paisNacimiento | lugarDeNacimiento | nacionalidad | estadoCivil | profesion   | vinculo        | plan     | nombresSeguroAP | parentescoSeguroAP |departamento | ciudad   |direccion        |
      | "Soacha"      | "RUBY ALEYDA RODRIGUEZ GONZALEZ" | "52912399"      | "06/09/1979"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Retanqueo libre inversión" | "55412"      | ""           | ""   | "1234"    | "Estrato 1" | "Arriendo"   | "Casa"        | "Jefe de hogar" | "Universitario"  | "100000"         | "Desprendible de nómina" | "src/test/resources/Data/PDFPRUEBA.pdf" | "30000000"    | "colombia"     | "colombia"        | "colombiano" | "Soltera/o" | "ingeniero" | "No vinculado" | "Plan 1" | "Juli Macias"   | "Prima"            |"Bogotá D.C" | "Bogota" |"calle 2d #22-52"|

  @referencias
  Esquema del escenario: Diligenciamiento de referencias personales y familiares
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y Se ingresa la informacion de las referencias personales <pNombreRefP><sNombreRefP><pApellidoRefP><sApellidoRefP><relacionRefP><celRefP><deptoRefP><ciudadRefP>
    Y Se ingresa la informacion de las referencias familiares <pNombreRefF><sNombreRefF><pApellidoRefF><sApellidoRefF><relacionRefF><celRefF><deptoRefF><ciudadRefF>


    Ejemplos:
      | oficinaAsesor | nombresApellidos                 | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito                | creditoPadre | estadoActual                 | page | codigoAdo | estrado     | tipoVivienda | claseVivienda | posicionHogar   | nivelEscolaridad | cuotaHipotecaria | tipoDocNomina            | rutaPdf                                 | otrosIngresos | paisNacimiento | lugarDeNacimiento | nacionalidad | estadoCivil | profesion   | vinculo     | plan     | nombresSeguroAP | parentescoSeguroAP | pNombreRefP | sNombreRefP | pApellidoRefP | sApellidoRefP | relacionRefP | celRefP      | deptoRefP | ciudadRefP | pNombreRefF | sNombreRefF | pApellidoRefF | sApellidoRefF | relacionRefF | celRefF      | deptoRefF  | ciudadRefF |
      | "Soacha"      | "RUBY ALEYDA RODRIGUEZ GONZALEZ" | "52912399"      | "06/09/1979"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Retanqueo libre inversión" | "55412"      | "En registro de referencias" | ""   | "1234"    | "Estrato 1" | "Arriendo"   | "Casa"        | "Jefe de hogar" | "Universitario"  | "100000"         | "Desprendible de nómina" | "src/test/resources/Data/PDFPRUEBA.pdf" | "30000000"    | "colombia"     | "colombia"        | "colombiano" | "Soltera/o" | "ingeniero" | "Vinculado" | "Plan 1" | "Juli Macias"   | "Prima"            | "maria"     | "camila"    | "lopez"       | "cardenas"    | "Amigo"      | "3204567894" | "Arauca"  | "Arauca"   | "juan"      | "david"     | "reyes"       | "sanchez"     | "Hijo"       | "3204047804" | "Amazonas" | "Leticia"  |


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