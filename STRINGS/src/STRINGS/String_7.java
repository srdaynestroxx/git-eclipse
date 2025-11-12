package STRINGS;

import java.util.Scanner;

public class String_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Escribir en tres líneas una dirección web. Se utilizará este este ejercicio
		// para analizar
		// el método substring de la clase String.
		// También se resolverá de forma alternativa mediante el uso de arrays.
		//ej.: www.berria.eus
	
		String palabras = "www.berria.eus"; 
		String caracteres = "[,\\.]";
		String[] Array = palabras.split(caracteres);

		for (String separa : Array) { 
			System.out.println(separa);
			
			

		}
	}
}
