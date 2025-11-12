package FICHEROS;

import java.io.*;
import java.util.Scanner;

public class FICHEROS_4 {

    public static void main(String[] args) {
    	
//    	Crear un programa que escriba líneas en un fichero hasta introducir dos líneas vacias.
    	
        // Creo un objeto Scanner para poder escribir cosas desde el teclado
        Scanner daymer = new Scanner(System.in);

    

        try {
        	
        	   // Ruta donde se va a crear o guardar mi archivo
            String ruta = "C:\\Users\\1AWA-18\\Desktop\\tareas\\PROGRAM\\java\\ficheros\\archivoEscribir";
            
            // Abro o creo el archivo para poder escribir dentro de él
            FileWriter archivoEscribir = new FileWriter(ruta);
            // Uso BufferedWriter para poder escribir líneas completas más fácil
            BufferedWriter buffer = new BufferedWriter(archivoEscribir);

            // Variable para contar cuántas líneas vacías seguidas escribo
            int vaciasSeguidas = 0;

            System.out.println("Escribe líneas (deja dos veces Enter para terminar):");

            // Bucle que se repite hasta que escriba dos líneas vacías seguidas
            while (true) {
                // Leo lo que el usuario escribe
                String linea = daymer.nextLine();

                // Si la línea está vacía (el usuario solo da Enter)
                if (linea.isEmpty()) {
                    vaciasSeguidas++; // aumento el contador de líneas vacías
                    // Si ya van dos vacías seguidas, salgo del bucle
                    if (vaciasSeguidas == 2) {
                        System.out.println("Fin de escritura.");
                        break;
                    }
                } else {
                    // Si la línea NO está vacía, reinicio el contador
                    vaciasSeguidas = 0;
                    // Escribo la línea en el archivo
                    buffer.write(linea);
                    // Añado un salto de línea en el archivo
                    buffer.newLine();
                }
            }

            // Cierro el buffer para guardar todo correctamente
            buffer.close();

            // Ahora leo el archivo para mostrar su contenido en pantalla
            System.out.println("\nContenido del archivo:");
            BufferedReader leyendo = new BufferedReader(new FileReader(ruta));

            String lineaLeida;
            // Leo línea a línea hasta que no haya más texto
            while ((lineaLeida = leyendo.readLine()) != null) {
                System.out.println(lineaLeida);
            }

            // Cierro el lector
            leyendo.close();

        } catch (IOException e) {
            // Si algo falla (por ejemplo, no se puede abrir el archivo), muestro el error
            System.out.println("Error: " + e.getMessage());
        }

        // Cierro el Scanner (buena práctica)
        daymer.close();
    }
}