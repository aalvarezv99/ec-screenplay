#language: es

Característica: Simulador Digicredito

  Antecedentes:
    Cuando se asigna el usuario
    Y ingresa su usuario 88776655 y contrasena 4112935
    Entonces ingresa a Digicredito

  @DatosCliente
  Esquema del escenario:  Paso uno Datos cliente
    Entonces el usuario diligencias los campos del formulario <nombresApellidos><numeroDocumento><fechaNacimiento><celular><correoElectronico><actividad><pagaduria><Contacto>
    Y continua el flujo
    Ejemplos:
      | nombresApellidos        | numeroDocumento | fechaNacimiento | celular      | correoElectronico     | actividad    | pagaduria                                  | Contacto                |
      | "Daniel Andres Abogado" | "10324591950"   | "24/09/1994"    | "3132739036" | "dabogadog@gmail.com" | "Pensionado" | "ALCALDIA DE CALI JUBILADOS Y PENSIONADOS" | "Entidad donde trabaja" |