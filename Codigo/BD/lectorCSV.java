package BD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class lectorCSV {
    private ArrayList<Integer> encabezadoEtiquetas;
    private String rutaArchivo;

    public lectorCSV() {
        this.encabezadoEtiquetas = new ArrayList<>();
        this.rutaArchivo = "C:/Users/Mario/OneDrive/Escritorio/Documents/DocumentosPersonales/Proyectos/Java/Arquitectura SW/Archivos/LectorExcel.csv";
    }

    public void setEtiquetas(ArrayList<String> listaEtiquetas) {
        encabezadoEtiquetas.clear(); // Limpiar antes de agregar nuevas posiciones
        for (String etiqueta : listaEtiquetas) {
            buscarYAgregarPosicion(etiqueta);
        }
    }

    private void buscarYAgregarPosicion(String etiqueta) {
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine(); // Leer solo la primera línea para obtener los encabezados
            if (linea != null) {
                String[] valores = linea.split(";");
                for (int i = 0; i < valores.length; i++) {
                    if (valores[i].equalsIgnoreCase(etiqueta)) {
                        encabezadoEtiquetas.add(i);
                        encontrado = true;
                        break;
                    }
                }
            }

            if (!encontrado) {
                encabezadoEtiquetas.add(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> obtenerEtiquetasCSV(int indice) {
        ArrayList<String> resultado = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int filaActual = 0;

            while ((linea = br.readLine()) != null) {
                if (filaActual == indice) {
                    String[] valores = linea.split(";");
                    for (Integer columna : encabezadoEtiquetas) {
                        if (columna != null && columna >= 0 && columna < valores.length) {
                            resultado.add(valores[columna].trim()); // Elimina espacios en blanco
                        } else {
                            resultado.add("");
                        }
                    }
                    return resultado;
                }
                filaActual++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
