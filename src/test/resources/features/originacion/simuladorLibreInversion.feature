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
    Ejemplos:
      | oficinaAsesor | nombresApellidos        | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito      | RutaPDF                                 |
      | "Soacha"      | "Daniel Andres Abogado" | "1032459194"   | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Libre inversion" | "src/test/resources/Data/PDFPRUEBA.pdf" |

  @RegistroCliente
  Esquema del escenario: Registro de Cliente
    Entonces El usuario carga los archivos imagen de la cedula del cliente <RutaPDF>
    Ejemplos:
      | oficinaAsesor | nombresApellidos        | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito      | RutaPDF                                 |
      | "Soacha"      | "Daniel Andres Abogado" | "10324591950"   | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Libre inversion" | "src/test/resources/Data/PDFPRUEBA.pdf" |
