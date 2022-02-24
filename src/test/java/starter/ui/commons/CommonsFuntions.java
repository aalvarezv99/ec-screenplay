package starter.ui.commons;

import java.text.Normalizer;

public class CommonsFuntions {

    public static final String limpiarCadena(String cadena) {
        cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
        cadena = cadena.replaceAll("[^\\p{ASCII}]", "");
        return cadena;
    }

    public static final String agregarComillas(String valor) {
        return "'" + valor + "'";
    }
}
