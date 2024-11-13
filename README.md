# java-module-4
# Aplicación de Gestión de Alumnos

Esta aplicación permite gestionar la información de los alumnos, incluyendo la creación de alumnos, la asignación de materias y la gestión de notas. También es posible exportar los datos de los alumnos con sus respectivas materias y promedios a un archivo de texto.

## Funcionalidades

1. **Crear Alumnos**: Permite agregar un nuevo alumno ingresando su RUT, nombre, apellido y dirección.
2. **Listar Alumnos**: Muestra una lista de todos los alumnos con sus materias y notas.
3. **Agregar Materias**: Permite asignar una materia específica a un alumno.
4. **Agregar Notas**: Permite asignar una nota a una materia específica de un alumno.
5. **Exportar Datos**: Exporta la lista de alumnos con sus materias y notas a un archivo de texto.
6. **Salir**: Termina la ejecución del programa.

## Requisitos

- **Java 11** o superior
- **IDE** (por ejemplo, Eclipse, IntelliJ) o ejecutable desde la línea de comandos.

## Instalación y Configuración

1. **Clona o descarga el repositorio**:
    ```bash
    git clone https://github.com/tuusuario/gestion-alumnos.git
    cd gestion-alumnos
    ```

2. **Abre el proyecto en tu IDE**:
   - Importa el proyecto como un proyecto Java.
   - Asegúrate de que todas las dependencias necesarias están presentes.

3. **Configuración de la Ruta de Exportación**:
   - En el archivo `Menu.java`, hay una línea de código que especifica la ruta donde se exportará el archivo `promedios.txt`:
     ```java
     archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), "C:\\Users\\tuUsuario\\Documents\\promedios.txt");
     ```
   - Cambia `tuUsuario` por tu nombre de usuario o la ruta que prefieras para que el archivo se guarde correctamente en tu sistema.
   - Ejemplo en Windows: `C:\\Users\\miUsuario\\Documents\\promedios.txt`
   - Ejemplo en Mac/Linux: `/home/miUsuario/Documents/promedios.txt`

## Ejecución

Para iniciar la aplicación, ejecuta el método `main` de la clase principal (por ejemplo, `Main.java`). El menú interactivo te guiará a través de las distintas opciones.

## Uso

1. **Crear Alumnos**: Ingresa los datos básicos de un alumno.
2. **Listar Alumnos**: Revisa todos los alumnos registrados y sus materias/notas.
3. **Agregar Materias**: Asigna una materia a un alumno existente.
4. **Agregar Notas**: Añade una nota a una materia de un alumno.
5. **Exportar Datos**: Guarda la lista de alumnos con sus materias y notas en el archivo de exportación.

## Ejemplo de Exportación

Si la exportación es exitosa, el archivo `promedios.txt` en la ruta especificada contendrá un listado de los alumnos con sus respectivas materias y notas.

## Notas Adicionales

- Asegúrate de tener permisos de escritura en la carpeta donde planeas exportar el archivo `promedios.txt`.
- Si tienes problemas con la exportación, verifica que la ruta especificada sea válida y esté actualizada con tu nombre de usuario.

## Contribuciones

Si deseas mejorar la aplicación o agregar nuevas funcionalidades, siéntete libre de realizar un pull request o abrir un issue en el repositorio.

---

**Autor**: [José Álvarez]  
**Licencia**: MIT
