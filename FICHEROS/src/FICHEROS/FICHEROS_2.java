package FICHEROS;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FICHEROS_2 {

	public static void main(String[] args) {
		Scanner daymer = new Scanner(System.in);

//		Dado el fichero pertsonak-koma.txt, leer sus datos y crear un array por cada campo. 
//		En estos arrays hay que introducir los datos de las personas.
//		Posteriormente, visualizar por pantalla los datos de la persona que se especifique.
		
		FileReader fr = null;
		BufferedReader br = null;

		int contador = 0;

		try {
			File archivo = new File("C:\\Users\\1AWA-18\\Desktop\\tareas\\PROGRAM\\java\\ficheros\\pertsonak-koma.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				contador++;
			}
			fr.close();
			br.close();

			System.out.println(contador);

			String[] id = new String[contador];
			String[] PrimerNombre = new String[contador];
			String[] SegundoNombre = new String[contador];
			String[] email = new String[contador];
			String[] email2 = new String[contador];
			String[] profesion = new String[contador];
			String[] edad = new String[contador];
			String[] salario = new String[contador];

			contador = 0;
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split(",");
				if (campos.length >= 8) { // Asegúrate de que hay suficientes campos
					id[contador] = campos[0];
					PrimerNombre[contador] = campos[1];
					SegundoNombre[contador] = campos[2];
					email[contador] = campos[3];
					email2[contador] = campos[4];
					profesion[contador] = campos[5];
					edad[contador] = campos[6];
					salario[contador] = campos[7];
					contador++;
				}
			}

			br.close();
			fr.close();

			System.out.println("Por favor introduce el ID y te proporcionamos los datos de la persona X: ");
			String Arrayid = daymer.next();
			daymer.close();

			boolean existe = false;
			for (int i = 0; i < id.length; i++) {
				if (id[i].equalsIgnoreCase(Arrayid)) {
					System.out.println("ID: " + id[i]);
					System.out.println("Primer Nombre: " + PrimerNombre[i]);
					System.out.println("Segundo Nombre: " + SegundoNombre[i]);
					System.out.println("Email: " + email[i]);
					System.out.println("Email2: " + email2[i]);
					System.out.println("Profesión: " + profesion[i]);
					System.out.println("Edad: " + edad[i]);
					System.out.println("Salario: " + salario[i]);
					existe = true;
					break;
				}
			}
			if (!existe) {
				System.out.println("Ese ID no fue encontrado.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}