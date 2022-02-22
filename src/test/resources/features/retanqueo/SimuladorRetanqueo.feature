#language: es

Característica: Simulador Digicredito

  Antecedentes:
    Cuando se asigna el usuario
    Y ingresa su usuario 88776655 y contrasena 4112935

  @Simulador
  Esquema del escenario:  Paso uno Datos cliente
    Entonces el usuario diligencias los campos del formulario <oficinaAsesor><nombresApellidos><numeroDocumento><fechaNacimiento><celular><correoElectronico><actividad><pagaduria><Contacto>
    Y ingresa la informacion de los valores credito a solicitar <montoSolicitado><tasa><plazo><diasIntereses>
    Y diligencia los datos financieros <ingresos><descLey><descNomina><lineaCredito><creditoPadre><vlrCompras><pagaduria>
    Y se validan los campos del simulador <tasa><plazo><ingresos><descLey><descNomina><pagaduria><diasIntereses><creditoPadre><vlrCompras><lineaCredito>
    Y se inicia la solicitud del credito
    Entonces El usuario carga los archivos imagen de la cedula del cliente <RutaPDF>
    Y realiza el registro del cliente paso 2 de 4 <numeroDocumento><primerNombre><segundoNombre><primerApellido><segundoApellido><fechaNacimiento><fechaExpedicion><departamentoExpedicionCC><ciudadExpedicionCC><genero>
    Y se llenan los datos adicionales <departamentoExpedicionCC><ciudadExpedicionCC>
    Entonces se realiza el proceso de Prospeccion del cliente <numeroDocumento>
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y recorre las paginas de la consulta de propeccion

    Ejemplos:
      | oficinaAsesor | nombresApellidos     | numeroDocumento | fechaNacimiento | celular      | correoElectronico         | actividad    | pagaduria          | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | vlrCompras | lineaCredito                  | creditoPadre | RutaPDF                                 | estadoActual | page                     | primerNombre | segundoNombre | primerApellido | segundoApellido | fechaExpedicion | departamentoExpedicionCC | ciudadExpedicionCC | genero |
      | "Soacha"      | "LUIS CARLOS MORENO MONSALVO" | "8682110"       | "19/10/1952"    | "3133421083" | "thainer.perez@gmail.com" | "Pensionado" | "P.A COLPENSIONES" | "Entidad donde trabaja" | "20000000"      | "1.70" | "60"  | "100"         | "260000"   | "100000" | "5500000" | "300000"   | "Retanqueo compra de cartera" | "55857"      | "src/test/resources/Data/PDFPRUEBA.pdf" | ""           | "Pendientes por Radicar" | "JAIRO"      | ""            | "MENDOZA"      | "DIAZ"          | "18/01/1974"    | "Cauca"                  | "Balboa"           | "F"    |

  @endeudamientoGlobal
  Esquema del escenario: Diligencia los datos de endeudamiento global
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y registra la informacion basica solicitante <codigoAdo><estrado><tipoVivienda><claseVivienda><posicionHogar><nivelEscolaridad>
    Y registra la informacion financiera <descLey><descNomina>
    Entonces finaliza registrando la informacion a centrales <cuotaHipotecaria><tipoDocNomina><rutaPdf><otrosIngresos>

    Ejemplos:
      | numeroDocumento | descNomina | descLey  | estadoActual | page                     | codigoAdo | estrado     | tipoVivienda | claseVivienda | posicionHogar   | nivelEscolaridad | cuotaHipotecaria | tipoDocNomina            | rutaPdf                                 | otrosIngresos |
      | "9081882"       | "260000"   | "100000" | ""           | "Pendientes por Radicar" | "1234"    | "Estrato 1" | "Arriendo"   | "Casa"        | "Jefe de hogar" | "Universitario"  | "100000"         | "Desprendible de nómina" | "src/test/resources/Data/PDFPRUEBA.pdf" | "30000000"    |

  @desembolso
  Esquema del escenario: Diligenciamiento del desembolso
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y se selecciona la modalidad de desembolso y tipo de cliente <modalidadDesembolso><tipoCliente>

    Ejemplos:
      | numeroDocumento | estadoActual                       | page | modalidadDesembolso      | tipoCliente |
      | "9971523"       | "En proceso calculo endeudamiento" | ""   | "Pago masivo (efectivo)" | "AAA"       |

  @datosSolicitud
  Esquema del escenario: Diligenciamiento formulario Datos Solicitud
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y registra los datos adicionales del cliente en Pagina 1 <paisNacimiento><lugarDeNacimiento><nacionalidad><estadoCivil><profesion>
    Y registra los datos adicionales del cliente en Pagina 2 <departamentoResidencia><ciudadResidencia><direccionResidencia><mesesResidencia><numeroHijos><personasACargo><departamentoCorrespondencia><ciudadCorrespondencia>
    #Y registra los datos adicionales del cliente en Pagina 3
    Y registra los datos adicionales del cliente en Pagina 4 <tipoPension><codigoProgramaNomina><fechaIngreso><fechaTerminacion><nitAfiliacion><tipoDocumento><rutaPdf><cargo>

    Ejemplos:
      | numeroDocumento | estadoActual                            | page | rutaPdf                                 | paisNacimiento | lugarDeNacimiento | nacionalidad | estadoCivil | profesion   | departamentoResidencia | ciudadResidencia | direccionResidencia   | mesesResidencia | numeroHijos | personasACargo | departamentoCorrespondencia | ciudadCorrespondencia | tipoPension | codigoProgramaNomina | fechaIngreso | fechaTerminacion | nitAfiliacion | tipoDocumento           | cargo |
      | "9081882"       | "En registro datos adicionales cliente" | ""   | "src/test/resources/Data/PDFPRUEBA.pdf" | "colombia"     | "colombia"        | "colombiano" | "Soltera/o" | "ingeniero" | "Bogotá D.C"           | "Bogota"         | "Cra 14 No. 93a - 30" | "24"            | "2"         | "0"            | "Antioquia"                 | "Abejorral"           | "pension"   | "123456"             | "01/01/2015" | "30/12/2022"     | "123456"      | "Certificación laboral" | "CEO" |

  @datosSolicitudCredito
  Esquema del escenario: Diligenciamiento formulario Datos Solicitud Credito
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Entonces se registran los datos para el credito Retanqueo <ingresosMensuales><totalDescuentos><totalDescuentosLey><lineaDeCredito><creditoPadre>
    Y se crean los tipos de cartera o saneamiento a recoger con la linea de <lineaDeCredito>
      | Contador | Entidad             | Monto  | VlrCuota | FechaVencimiento | NumObligacion |
      | 1        | ABOGADAS Y ASESORES | 100000 | 70000    | 28/02/2022       | 21236         |
      | 2        | ABOGADAS Y ASESORES | 100000 | 70000    | 28/02/2022       | 21236         |
      | 3        | ABOGADAS Y ASESORES | 100000 | 70000    | 28/02/2022       | 21236         |
    Y diligencia los datos calculo credito <montoSolicitado><tasa><plazo><diasInteresesIniciales>
    Y se validan los datos del simulador datos solicitud <tasa><plazo><ingresosMensuales><totalDescuentosLey><totalDescuentos><pagaduria><diasInteresesIniciales><creditoPadre><vlrCompras><lineaDeCredito>
    Ejemplos:
      | numeroDocumento | estadoActual          | page | ingresosMensuales | totalDescuentos | totalDescuentosLey | lineaDeCredito                | montoSolicitado | tasa   | plazo | diasInteresesIniciales | creditoPadre | pagaduria          | vlrCompras |
      | "9081882"       | "En simulación final" | ""   | "6500000"         | "250000"        | "150000"           | "Retanqueo compra de cartera" | "25000000"      | "1.70" | "24"  | "120"                  | "55857"      | "P.A COLPENSIONES" | "300000"   |


  @seguroAP
  Esquema del escenario: Etapa de seguro AP
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Entonces Se visualizan los beneficios del seguro
    Y Se selecciona el vinculo del seguro y el plan <vinculo><plan><tomarSeguroAP>
    #Y Se llenan los campos de tomador del seguro <nombresApellidos><numeroDocumento><celular><correoElectronico><fechaNacimiento><departamento><ciudad><direccion>
    Y Se registran los beneficiarios <nombresSeguroAP><parentescoSeguroAP>

    Ejemplos:
      | nombresApellidos                 | numeroDocumento | fechaNacimiento | celular      | correoElectronico     |  estadoActual | page | vinculo        | plan     | nombresSeguroAP | parentescoSeguroAP | departamento | ciudad   | direccion         |tomarSeguroAP|
      | "RUBY ALEYDA RODRIGUEZ GONZALEZ" | "52912399"      | "06/09/1979"    | "3132739036" | "dabogadog@gmail.com" |  ""           | ""   | "Vinculado"    | "Plan 1" | "Juli Macias"   | "Prima"            | "Bogotá D.C" | "Bogota" | "calle 2d #22-52" |"Si"         |

  @referencias
  Esquema del escenario: Diligenciamiento de referencias personales y familiares
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y Se ingresa la informacion de las referencias personales <pNombreRefP><sNombreRefP><pApellidoRefP><sApellidoRefP><relacionRefP><celRefP><deptoRefP><ciudadRefP>
    Y Se ingresa la informacion de las referencias familiares <pNombreRefF><sNombreRefF><pApellidoRefF><sApellidoRefF><relacionRefF><celRefF><deptoRefF><ciudadRefF>
    Ejemplos:
      | numeroDocumento | estadoActual                 | page | pNombreRefP | sNombreRefP | pApellidoRefP | sApellidoRefP | relacionRefP | celRefP      | deptoRefP | ciudadRefP | pNombreRefF | sNombreRefF | pApellidoRefF | sApellidoRefF | relacionRefF | celRefF      | deptoRefF  | ciudadRefF |
      | "52912399"      | "En registro de referencias" | ""   | "maria"     | "camila"    | "lopez"       | "cardenas"    | "Amigo"      | "3204567894" | "Arauca"  | "Arauca"   | "juan"      | "david"     | "reyes"       | "sanchez"     | "Hijo"       | "3204047804" | "Amazonas" | "Leticia"  |


  @seguroVida
  Esquema del escenario: Registrar beneficiarios seguro de vida
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Entonces diligencia minimo tres beneficiaros para el seguro de vida <nombreBeneficario><documentoBeneficiario><celularBeneficiario><departamento><ciudad>

    Ejemplos:
      | numeroDocumento | estadoActual                    | page | nombreBeneficario    | documentoBeneficiario | celularBeneficiario | departamento | ciudad   |
      | "52912399"      | ""                              | ""   | "Luis Perez Ramirez" | "1234567890"          | "3183903022"        | "Bogotá D.C" | "Bogota" |

  @OperInternacionalesPEPS
  Esquema del escenario: Registrar operaciones internacionales y PEPS
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y llena el formulario de operaciones internacionales <monedaExtranjera><tipoTransanccion><productoBancario><banco><numProducto><tipoProducto><pais><ciudad><monto><moneda>
    Y llena el formulario de persona expuesta politicamente <funcionarioPublico><recursosPublicos><expuestoPoliticamente><fechaExpuesto>
    Ejemplos:
      | numeroDocumento | estadoActual | page | monedaExtranjera | tipoTransanccion | productoBancario | banco       | numProducto | tipoProducto         | pais       | ciudad   | monto  | moneda  | funcionarioPublico | recursosPublicos | expuestoPoliticamente | fechaExpuesto |
      | "52912399"      | ""           | ""   | "No"             | "Importaciones"  | "No"             | "Santander" | "966855"    | "Inversiones en oro" | "Alemania" | "Berlin" | "8500" | "Euros" | "No"               | "No"             | "No"                  | "12/12/2008"  |


  @firmaDocumentos
  Esquema del escenario: Realiza la firma final de documentos
    Cuando busca el credito para retomar el estado actual <numeroDocumento><estadoActual><page>
    Y consulta el codigo OTP <numeroDocumento>
    Y descarga los documentos a firmar
    Entonces diligencia el tipo de documento y adjunta el archivo <rutaPdf>

    Ejemplos:
      | numeroDocumento | estadoActual | page | rutaPdf                                 |
      | "91077296"      | ""           | ""   | "src/test/resources/Data/PDFPRUEBA.pdf" |

