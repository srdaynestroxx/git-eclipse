package STRINGS;

import java.util.Scanner;

public class String_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Introducir una frase por teclado ej.: “Bienvenido a Zornotza”, luego
		// introducir la palabra
		// que se quiere sustituir (ej.: Zornotza) y luego la palabra con el que se va a
		// sustituir
		// (ej.: Amorebieta). Mostrar en pantalla la frase con la palabra sustituida

		Scanner scanner = new Scanner(System.in);
		
		String palabra;
		String palabraSustituida;
		String palabraAnterior;
		
	System.out.println("introduce la frase");
	palabra = scanner.nextLine();
		
	System.out.println("introduce la palabra por la que quieres sustituir");
	palabraSustituida = scanner.nextLine();
	
	System.out.println("introduce la palabra por la que quieres sustituir en la frase anterior");
	palabraAnterior=scanner.nextLine();
	
	palabra=palabra.replace(palabraSustituida, palabraAnterior);
	System.out.println("cambiaste "+palabraSustituida +" por " + palabra);
	scanner.close();
	}

}
