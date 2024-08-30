import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class lectorCSV {
    private ArrayList<Integer> encabezadoEtiquetas;  // Almacena posiciones de columnas o null si no hay coincidencia
    private String rutaArchivo;

    public lectorCSV() {
        this.encabezadoEtiquetas = new ArrayList<>();
        this.rutaArchivo = "rutadelarchivo.csv";
    }

    public void setE(ArrayList<String> ListaEtiquetas) {
        for (String etiqueta : ListaEtiquetas) {
            buscarYAgregarPosicion(etiqueta);
        }
    }

    private void buscarYAgregarPosicion(String etiqueta) {
        boolean encontrado = false; // Bandera para saber si se encontró alguna coincidencia

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");

                // Itera por todas las columnas para buscar coincidencias
                for (int i = 0; i < valores.length; i++) {
                    if (valores[i].equalsIgnoreCase(etiqueta)) {
                        encabezadoEtiquetas.add(i);  // Guarda la posición de la columna donde se encontró la coincidencia
                        encontrado = true;
                        break; // Sal del bucle después de encontrar la coincidencia
                    }
                }
                
                // Si se encontró coincidencia, no es necesario seguir buscando
                if (encontrado) {
                    break;
                }
            }

            // Si no se encontró ninguna coincidencia en todo el archivo, agrega null
            if (!encontrado) {
                encabezadoEtiquetas.add(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        lectorCSV procesador = new lectorCSV("ruta/al/archivo.csv");
        ArrayList<String> terminosBusqueda = new ArrayList<>();
        terminosBusqueda.add("Titulo1");
        terminosBusqueda.add("Titulo2");

        procesador.procesarEtiquetas(terminosBusqueda);

        System.out.println("Posiciones de columnas encontradas o null si no hay coincidencias: " + procesador.getEtiquetas());
    }
}