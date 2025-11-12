package STRINGS;

import java.util.Scanner;//improt del scanner 

public class String_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Decir si una palabra es palíndroma o no.
		// Se utilizará este este ejercicio para analizar la estructura de control
		// for con varias variables al mismo tiempo y los for encadenados.

		int i;
		int j1; // variables
		boolean Espalindroma = true;
		String palindromo;

		Scanner lee = new Scanner(System.in); //

		System.out.println("ingresa una palabra : ");
		palindromo = lee.nextLine();

		palindromo = palindromo.replace(" ", " ");
		palindromo = palindromo.toLowerCase();// en java diferencia las minusculas de minusculas
												// y esto me puede dar problemas
		i = 0;
		j1 = palindromo.length() - 1;

		// para recorrer frase

		while ((i < j1) && Espalindroma) {

			if (palindromo.charAt(i) != palindromo.charAt(j1)) {
				Espalindroma = false;

			}
			i++;
			j1--;
		}
		if (Espalindroma) {
			System.out.println("es palidroma");

		} else {
			System.out.println("la palabta NO es palindroma");
		}
	}
}