package Controlador;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import BD.lectorCSV;
import BD.txtReader;

public class Correos {

    private ArrayList<String> etiquetas;
    private String templateCorreo;

    public Correos() {
        this.etiquetas = new ArrayList<>();
        this.templateCorreo = "";
    }

    private void obtenerTemplateDelTxt(txtReader objLector) {
        this.templateCorreo = objLector.extraerTxt();
        System.out.println("Template del texto extraído.");
    }

    private void extraeEtiquetaDelTemplate() {
        // Expresión regular para buscar texto entre '<' y '>'
        Pattern pattern = Pattern.compile("<(.*?)>");
        Matcher matcher = pattern.matcher(this.templateCorreo);
        
        // Limpiar la lista de etiquetas antes de agregar nuevas
        this.etiquetas.clear();

        // Añadir todas las etiquetas encontradas en el template
        while (matcher.find()) {
            this.etiquetas.add(matcher.group(1));
        }
        System.out.println("Etiquetas extraídas: " + this.etiquetas);
    }

    private ArrayList<String> buscarEtiquetas(int indice, lectorCSV lectorExcel) {
        ArrayList<String> etiquetasInfo = lectorExcel.obtenerEtiquetasCSV(indice);
        System.out.println("Etiquetas encontradas para el índice " + indice + ": " + etiquetasInfo);
        return etiquetasInfo;
    }

    private String remplazarEtiquetas(ArrayList<String> etiquetasInfo) {
        String correo = this.templateCorreo;
        for (int i = 0; i < etiquetasInfo.size(); i++) {
            correo = correo.replace("<" + this.etiquetas.get(i) + ">", etiquetasInfo.get(i));
        }
        return correo;
    }

    public ArrayList<String> generarCorreoPDF() {
        lectorCSV lectorExcel = new lectorCSV();
        txtReader objLector = new txtReader();
        
        obtenerTemplateDelTxt(objLector);
        extraeEtiquetaDelTemplate();

        ArrayList<String> etiquetasInfo;
        ArrayList<String> correos = new ArrayList<>();
        lectorExcel.setEtiquetas(this.etiquetas);
        
        int indice = 1;
        while (!(etiquetasInfo = buscarEtiquetas(indice, lectorExcel)).isEmpty()) {
            boolean allNulls = etiquetasInfo.stream().allMatch(String::isEmpty);
            if (allNulls) {
                break;
            }
            correos.add(remplazarEtiquetas(etiquetasInfo));
            indice++;
        }

        return correos;
    }
}
