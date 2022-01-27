#language: es

Característica: Simulador Digicredito

  Antecedentes:
    Cuando se asigna el usuario
    Y ingresa su usuario 88776655 y contrasena 4112935

  @Simulador
  Esquema del escenario:  Paso uno Datos cliente
    Entonces el usuario diligencias los campos del formulario <oficinaAsesor><nombresApellidos><numeroDocumento><fechaNacimiento><celular><correoElectronico><actividad><pagaduria><Contacto>
    Y ingresa la informacion de los valores credito a solicitar <montoSolicitado><tasa><plazo><diasIntereses>
    Y diligencia los datos financieros retanqueo <ingresos><descLey><descNomina><lineaCredito><creditoPadre>
    Y se validan los campos del simulador retanqueo <creditoPadre><tasa><plazo><diasIntereses>
    Ejemplos:
      | oficinaAsesor | nombresApellidos              | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                | montoSolicitado | tasa   | plazo | diasIntereses | descNomina | descLey  | ingresos  | lineaCredito                | creditoPadre   |
      | "Soacha"      | "JORGE ANCIZAR CORTES CORREA" | "9971523"       | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" | "5000000"       | "1.71" | "60"  | "100"         | "260000"   | "100000" | "3500000" | "Retanqueo libre inversión" | "55412"        |