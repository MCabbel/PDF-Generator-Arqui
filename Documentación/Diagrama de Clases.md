# Documentación de Clases

En este documento encontrarás la descripción detallada de las clases que componen el proyecto, incluyendo sus campos, métodos y las conexiones entre ellas. Cada clase está diseñada para cumplir con una función específica dentro del sistema, y esta documentación te guiará a través de sus responsabilidades, cómo interactúan entre sí, y cómo se utilizan para lograr los objetivos del proyecto.

# Clase: Vista

La clase `Vista` es la representación gráfica que tendrá el usuario para el uso del programa. En estas primeras versiones del proyecto, solo contará con un método `main` que ejecutará el programa.

## Campos

- **PDF**: Un objeto de la clase `PDF` que funcionará como controlador.

## Métodos

- **botonGenerarPDF()**: Función que iniciará el controlador utilizando la función `generarPDF()`.


# Clase: Correos

El objeto `Correos` es la abstracción del correo a imprimir en el PDF. Este cuenta con los datos y funciones necesarias para obtener de manera correcta y versátil los correos con sus respectivas etiquetas.

## Campos

- **Etiquetas**: Variable de tipo `ArrayList<String>` que contendrá las etiquetas obtenidas del template del correo. Este campo será actualizado a través de la función `obtenerEtiquetas()`.

- **templateCorreo**: Variable de tipo `String`, que almacenará el template del correo con sus respectivas etiquetas y formato. Este campo será actualizado a través de la función `obtenerTemplate()`.

## Métodos

- **extraerEtiquetaDelTemplate()**: Esta función utilizará el campo propio `templateCorreo` y buscará los símbolos `<` y `>` para extraer las etiquetas a leer, asignándolas al `ArrayList<String> Etiquetas`.

- **obtenerTemplateDelTxt()**: Esta función llamará a una función a través de un objeto de la clase `txtReader`, que es `extraerTxt()`, para obtener un string que será asignado al campo `templateCorreo`.

- **remplazarEtiquetas()**: Esta función recibirá un objeto tipo `lectorCSV` y un índice. Llamará a la función `obtenerEtiqueta()` y el string devuelto será utilizado en un nuevo string Template, donde se reemplazará la etiqueta con su valor correspondiente.

- **generarCorreo()**: Esta función recibe un índice `int` y crea un objeto de la clase `lectorCSV`. Utilizará las funciones `obtenerTemplate()`, `extraerEtiquetaDelTemplate()`, `obtenerEncabezados()` y `remplazarEtiquetas()`, mediante ciclos y variables string, para devolver un string con el correo que contiene las etiquetas con la información correcta.
