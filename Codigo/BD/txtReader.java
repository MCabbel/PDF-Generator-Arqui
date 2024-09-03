package BD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class txtReader {
    private String rutaArchivoTXT;

    public txtReader() {
        this.rutaArchivoTXT = "C:/Users/Mario/OneDrive/Escritorio/Documents/DocumentosPersonales/Proyectos/Java/Arquitectura SW/Archivos/ArchivoLector.txt";
    }

    public String extraerTxt() {
        StringBuilder template = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoTXT))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                template.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template.toString();
    }
}
