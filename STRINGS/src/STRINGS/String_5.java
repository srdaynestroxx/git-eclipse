package STRINGS;

import java.util.Scanner;

public class String_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Escribir la frase introducida sin espacios vacíos.
		
		Scanner scanner = new Scanner(System.in);
		
		String palabra;
		
		System.out.println("INTRODUCE UNA PALABRA: ");
		palabra = scanner.nextLine();
		
		String palabraCambiada =  palabra.replace(" ", "");
		
		System.out.println("la palabra cambiada es: "+palabraCambiada);
		
	}

}
