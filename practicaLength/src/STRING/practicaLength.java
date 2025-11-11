package STRING;

import java.util.Scanner;

public class practicaLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		String palabras = "www.berria.eus";
		String[] palabras1 = palabras.split("\\.");
		
		for (int i =0; i< palabras1.length; i++) {
			
			System.out.println(palabras1[i]);
		}

		}
	}

