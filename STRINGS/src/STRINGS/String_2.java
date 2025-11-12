package STRINGS;

import java.util.Scanner; //import del scanner 

public class String_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Introducir por teclado una frase y sacar por pantalla un carácter por cada
		// línea. Se utilizará este este ejercicio para analizar
		// las diferencias entre los métodos next y nextLine de la clase Scanner.

		String frase; // variable

		Scanner scanner = new Scanner(System.in); // lector del scanner

		System.out.println("introduce una frase : ");// introduccion de palabra
		frase = scanner.nextLine();// permite introducir la palabra con el scanner y hace salto de lineas con
									// nextLine
		for (int i = 0; i < frase.length(); i++) { // declaramos la variable " i " y la inicializamos a cero, i
													// siempresera menor que frase y el i++
													// nos sumara las letras de la palabra con nexLine haciendonos un
													// salto de linea.

			System.out.println(frase.charAt(i)); // cuenta el numero de palabras

		}
		scanner.close(); // cierre del scanner
	}
}