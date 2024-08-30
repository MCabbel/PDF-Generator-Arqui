# Arquitectura de Componentes – Proyecto 1

## División de Componentes bajo el Patrón MC

### Modelo (Model)

El Modelo es responsable de la lógica y el manejo de datos. Aquí colocaríamos los componentes que se encargan de gestionar, almacenar, y transformar los datos.

- **FileReaderComponent**: Se encarga de leer los datos de los archivos. Como este componente se enfoca en la obtención de datos, pertenece al Modelo.
- **CsvReaderComponent**: Similar al FileReaderComponent, este componente se encarga de leer datos estructurados desde un CSV.
- **MessageGeneratorComponent**: Este componente procesa datos y genera mensajes a partir de ellos.

### Controlador (Controller)

El Controlador es responsable del control y manejo del sistema, orquestando la interacción con el Modelo. Aquí colocaríamos los componentes que manejan la lógica del flujo de la aplicación.

- **PdfEmailGeneratorComponent**: Este componente convierte los correos generados en un PDF.
- **SystemController**: Este es el componente principal del Controlador. Maneja las interacciones entre los otros componentes y los flujos de datos entre el Modelo y (posiblemente en el futuro) la Vista.
