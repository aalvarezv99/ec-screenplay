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
    Y registra los datos adicionales del cliente <paisNacimiento><lugarDeNacimiento><nacionalidad><estadoCivil><profesion>

    Ejemplos:
      | oficinaAsesor | nombresApellidos                 | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito                | creditoPadre | estadoActual                            | page | codigoAdo | estrado     | tipoVivienda | claseVivienda | posicionHogar   | nivelEscolaridad | cuotaHipotecaria | tipoDocNomina            | rutaPdf                                 | otrosIngresos | paisNacimiento | lugarDeNacimiento | nacionalidad | estadoCivil | profesion   |
      | "Soacha"      | "RUBY ALEYDA RODRIGUEZ GONZALEZ" | "52912399"      | "06/09/1979"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Retanqueo libre inversión" | "55412"      | "En registro datos adicionales cliente" | ""   | "1234"    | "Estrato 1" | "Arriendo"   | "Casa"        | "Jefe de hogar" | "Universitario"  | "100000"         | "Desprendible de nómina" | "src/test/resources/Data/PDFPRUEBA.pdf" | "30000000"    | "colombia"     | "colombia"        | "colombiano" | "Soltera/o" | "ingeniero" |


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

  @seguroVida
  Esquema del escenario: Registrar beneficiarios seguro de vida
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Entonces diligencia minimo tres beneficiaros para el seguro de vida <nombreBeneficario><documentoBeneficiario><celularBeneficiario><departamento><ciudad>

    Ejemplos:
      | numeroDocumento | estadoActual                    | page | nombreBeneficario    | documentoBeneficiario | celularBeneficiario | departamento | ciudad   |
      | "91077296"      | "En registro de seguro de vida" | ""   | "Luis Perez Ramirez" | "1234567890"          | "3183903022"        | "Bogotá D.C" | "Bogota" |

