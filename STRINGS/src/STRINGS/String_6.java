package STRINGS;

import java.util.Scanner;

public class String_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

//Contar las vocales y los consonantes 
		// de una frase, los espacios en blanco no cuentan.

		String palabra;
		int n_conso=0;
		int n_vocal=0;
		
		System.out.println("introduce una frase, te dire las vocales y consonantes : ");
		palabra = scanner.nextLine();

		 palabra = palabra.replace(" ", ""); //reeemplaza espacios
		System.out.println("LA PALABRA INTRODUCIDA ES : " + palabra.toLowerCase()); //pone todo en minusculas
			
		//es vocal o es consosnante??
		for(int i=0; i<palabra.length(); i++) {
			if(palabra.charAt(i)=='a' || palabra.charAt(i)=='e' || palabra.charAt(i)=='i' || palabra.charAt(i)=='o' || palabra.charAt(i)=='u') {
				n_vocal++;
			}else {
				n_conso++;

			}
		
	}
		System.out.println("las vocales de las frase que haz puesto tienen este numero de vocales :"+n_vocal);
		System.out.println("las consosnantes de las frase que haz puesto tienen este numero de consonantes :"+n_conso);
		scanner.close();
}
}