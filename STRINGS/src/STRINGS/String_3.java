package STRINGS;

import java.util.Scanner; // scanner 

public class String_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Escribir una palabra introducida invertida

		String palabra = ""; // variable
		Scanner scanner = new Scanner(System.in);// lector del scanner

		System.out.println("introduce una palabra: "); // introduce una palabra
		palabra = scanner.next();// te deja introducir la palabra en la consola

		StringBuilder sb = new StringBuilder(palabra);// Crea una instancia de StringBuilder
		// pasando la cadena que quieres invertir.

		sb.reverse(); // Llama al método "reverse()" sobre esa instancia

		System.out.println("palabra revesa sería : " + sb);// llama la palabra introducida en reversa
		scanner.close();// cierre del scanner
						
	}

}
