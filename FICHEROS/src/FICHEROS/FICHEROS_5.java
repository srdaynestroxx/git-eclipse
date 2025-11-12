package FICHEROS;

import java.util.Scanner;//import del Scanner 
import java.io.*;//import todas las calses de IO

public class FICHEROS_5 {

	public static void main(String[] args) {

//		Crear un programa que escriba líneas en un fichero hasta introducir dos líneas vacias.

		String RutaGuardada = "C:\\Users\\1AWA-18\\Desktop\\tareas\\PROGRAM\\java\\ficheros\\sustituirLetra.txt";
		Scanner daymer = new Scanner(System.in);

		// Pedimos al usuario que escriba algo
		System.out.println("Introduce el texto que quieres guardar en el fichero (las 'a' se cambiarán por '*'): ");
		String textoReal = daymer.nextLine(); // Usamos nextLine() para capturar frases completas

		// Procesamos el texto introducido por el usuario
		String textoCambio = textoReal.replace('a', '*').replace('A', '*');// reemplaza las a por asteriscos

		System.out.println("Texto que se escribirá en el fichero: " + textoCambio);// imprime ese cambio de texto
																					// cambiaod

		FileWriter writer = null;
		BufferedWriter bufferEscritura = null;

		try {
			// ABRIR EL FICHERO PARA ESCRITURA
			// Esto sobrescribirá el contenido anterior del archivo
			writer = new FileWriter(RutaGuardada);
			bufferEscritura = new BufferedWriter(writer);

			// ESCRIBIR EL TEXTO PROCESADO EN EL FICHERO
			bufferEscritura.write(textoCambio);

			System.out.println("Fichero '" + RutaGuardada + "' actualizado correctamente");

			bufferEscritura.close();
			writer.close();// cierre de los escritores del archivo escritor

		} catch (IOException e) {
			System.err.println("Ocurrió un error al escribir en el fichero: " + e.getMessage());
			e.printStackTrace();// si hay un error este se camptura aqui.

		}
		daymer.close();// cierre del scanner
	}
}
