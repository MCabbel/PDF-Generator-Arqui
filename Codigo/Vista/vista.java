package Vista;

import Controlador.Correos;
import java.util.ArrayList;

public class vista {
    public static void main(String[] args) {
        // Crear una instancia de la clase Correos
        Correos objCorreos = new Correos();
        
        ArrayList<String> correos = new ArrayList<>();
        // Llamar al método generarCorreoPDF
        correos = objCorreos.generarCorreoPDF();

        // Imprimir los correos generados
        for (String correo : correos) {
            System.out.println(correo);
        }
    }
}
