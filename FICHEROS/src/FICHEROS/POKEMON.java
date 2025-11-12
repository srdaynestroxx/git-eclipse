package FICHEROS;

import java.util.*;//importo mi lector 
import java.io.*;//importo todas las clases de io

public class POKEMON {

	public static void main(String[] args) throws IOException {// captura directamente el error aqui en vez del try
																// catch

		Scanner scanner = new Scanner(System.in);// contaodr para la entrada de datos por pantalla
		int opcion = 0;// contador de mis opciones en el do while
		String linea = null;
		String campos[];

		String arrayNombre[] = new String[20];// declaramos los valores en array del contenido del archivo ( ponemos 20
												// xq hay 20 nombres 9)
		String arrayTipo[] = new String[20];// lo mismo aqui, hay 20 tipos
		int arrayNivel[] = new int[20];// etc
		int arrayAtaque[] = new int[20];// etccc
		int arrayDefensa[] = new int[20];
		int arrayVelocidad[] = new int[20];

		File file = new File("C:\\Users\\1AWA-18\\Desktop\\tareas\\PROGRAM\\java\\ficheros\\pokemons.csv");

		try {

			Scanner daymer = new Scanner(file);// scanner para el archivo
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			br.readLine();// lee las lineas del fichero
			linea = br.readLine();// se salta el encabezado. . .

			while (linea != null) {// mientras que las lineas no esten vacias las va a leer
				// System.out.println(linea);//imprime las lineas leidas.
				linea = br.readLine();// se salta la linea del encabezao
			}

			br.close();// cierro el buffer
			fr.close();// cierro el file

			if (daymer.hasNextLine())
				daymer.nextLine();

			int i = 0;// contador de las opciones
			while (daymer.hasNext()) {
				linea = daymer.nextLine();
				campos = linea.split(",");// separa los elementos con coma

				arrayNombre[i] = campos[0];// la primera posicion del array es 0
				arrayTipo[i] = campos[1];// lo mismo aqui, hay 20 tipos
				arrayNivel[i] = Integer.parseInt(campos[2]);// convierte los valores en int
				arrayAtaque[i] = Integer.parseInt(campos[3]);// etc
				arrayDefensa[i] = Integer.parseInt(campos[4]);// etc. . .
				arrayVelocidad[i] = Integer.parseInt(campos[5]);
				i++;
			}

			daymer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error" + e.getMessage());
		}
		do {

			System.out.println("0-SALIR: ");
			System.out.println("1-LISTAR: ");
			System.out.println("2-GUARDAR: ");
			System.out.println("3-CONSULTAR POKEMON: ");
			System.out.println("4-MODIFICAR: ");
			System.out.println("5-BUSCAR POR NOMBRE: ");
			System.out.println("6-POKEMONS RAPIDOS: ");
			System.out.println("7-POR TIPOS: ");
			System.out.println("8-LUCAH 1: ");
			System.out.println("9-LUCHA 2: \n");

			System.out.println("selecciona una opcion del 0-9");
			opcion = scanner.nextInt();

			switch (opcion) {

			case 0:

				System.out.println("has salido correctamente del programa.");

				break;

			case 1:

				Visualizar(arrayNombre); // visualizar se llamará el nombre del metodo, uy dentro llamamos array nombre
				// oicare en visualizar y aparecera para crear el metodo automaticamente
				break;

			case 2:

				boolean existe = guardar(arrayNombre, arrayTipo, arrayNivel, arrayAtaque, arrayDefensa, arrayVelocidad,
						file);

				break;

			case 3:
				consultar(arrayNombre, arrayTipo, arrayNivel, arrayAtaque, arrayDefensa, arrayVelocidad);
				break;

			case 4:
				modificar(arrayNombre, arrayTipo, arrayNivel, arrayAtaque, arrayDefensa, arrayVelocidad);

				break;

			case 5:
				buscaNombre(arrayNombre);
				break;

			case 6:
				rapidos(arrayNombre, arrayVelocidad);
				break;

			case 7:
				buscarTipos(arrayTipo, arrayTipo, arrayNombre);
				break;

			case 8:

				break;

			case 9:

				break;
			}

		} while (opcion != 0);

	}

	private static void rapidos(String[] arrayNombre, int[] arrayVelocidad) {
		// TODO Auto-generated method stub

		int suma = 0;
		double media = 0;
		for (int i = 0; i < arrayVelocidad.length; i++) {
			suma += arrayVelocidad[i];
		}
		media = (double) suma / arrayVelocidad.length;
		for (int i = 0; i < arrayVelocidad.length; i++) {
			if (arrayVelocidad[i] > media) {
				System.out.println("los pokemons que son superior a la media:" + media + " son: " + arrayNombre[i]);
			}
		}

		System.out.println("La media es de: " + media);

	}

	private static void modificar(String[] arrayNombre, String[] arrayTipo, int[] arrayNivel, int[] arrayAtaque,
			int[] arrayDefensa, int[] arrayVelocidad) {
		// TODO Auto-generated method stub
		String nombre = "";
		String respuesta = "";
		String tipo = "";
		int nivel = 0;
		int ataque = 0;
		int defensa = 0;
		int velocidad = 0;

		boolean lista = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("introduce el nombre del pokemon");
		respuesta = scanner.nextLine();

		for (int i = 0; i < arrayNombre.length; i++) {
			if (respuesta.equalsIgnoreCase(arrayNombre[i])) {
				lista = true;
				System.out.println("los datos del pokemon " + arrayNombre[i] + " son " + arrayNombre[i] + ","
						+ arrayTipo[i] + "," + arrayNivel[i] + "," + arrayAtaque[i] + "," + arrayDefensa[i] + ","
						+ arrayVelocidad[i]);
				System.out.println("los datos a cambiar: \n");

				System.out.println("nuevo tipo :");
				tipo = scanner.nextLine();
				arrayTipo[i] = tipo;

				System.out.println("nuevo nivel: ");
				nivel = scanner.nextInt();
				arrayNivel[i] = nivel;

				System.out.println("nuevo ataque: ");
				ataque = scanner.nextInt();
				arrayAtaque[i] = ataque;

				System.out.println("nuevo defensa: ");
				defensa = scanner.nextInt();
				arrayDefensa[i] = defensa;

				System.out.println("nueva velocidad: ");
				velocidad = scanner.nextInt();
				arrayVelocidad[i] = velocidad;

			}

		}
		if (lista != true) {
			System.out.println("el pokemon que buscas no esta en lista.");
		}
	}

	private static void buscaNombre(String[] arrayNombre) {
		// TODO Auto-generated method stub
//		Buscar por nombre: el programa pedirá una cadena y se visualizarán todos los Pokemon que tengan esa cadena en su nombre.
		Scanner buscaNombre = new Scanner(System.in);

		System.out.println("dame una letra y te dire que pokemons la tienen por igual: ");
		String letra = buscaNombre.next();

	}

	private static void consultar(String[] arrayNombre, String[] arrayTipo, int[] arrayNivel, int[] arrayAtaque,
			int[] arrayDefensa, int[] arrayVelocidad) {
		// TODO Auto-generated method stub
		Scanner consultar = new Scanner(System.in);
		String nombre;
		boolean existe = false;
		System.out.println("introduce el nombre del pokemon");
		nombre = consultar.next();
		for (int i = 0; i < arrayNombre.length; i++) {
			if (arrayNombre[i].equalsIgnoreCase(arrayNombre[i])) {
				String pokemon;
				existe = true;
				pokemon = arrayTipo[i] + ", " + arrayNivel[i] + ", " + arrayAtaque[i] + ", " + arrayDefensa[i] + ", "
						+ arrayVelocidad[i];
				System.out.println("El pokemon " + arrayNombre[i] + " tiene la siguiente información: " + pokemon);
			}
		}
		if (existe != true) {
			System.out.println("El pokemon no esta en la lista");
		}
	}

	private static void buscarTipos(String[] arrayTipo, String[] arrayTipo2, String[] arrayNombre) {
		// TODO Auto-generated method stub
		String tipo;
		Scanner buscarTipo = new Scanner(System.in);// en cada metodo uno crea sus scanner dentro
		System.out.println("introduce un tipo desea encontrar? ");
		tipo = buscarTipo.next();
		boolean disponible = false;

		for (int i = 0; i < arrayTipo.length; i++) {
			if (tipo.contains(arrayTipo[i])) {
				String pokemon = "";// usa como variable temporal para guardar el nombre del Pokémon en esa posición
									// del array antes de imprimirlo.
				disponible = true;

				System.out.println("los pokemon del tipo" + tipo + "son" + pokemon);

			}
		}
		if (disponible != true) {
			System.out.println("AVISO");

		}

	}

	private static void Visualizar(String[] arrayNombre) {// metodo array nombre
		// TODO Auto-generated method stub
		for (int i = 0; i < arrayNombre.length; i++) {// recorre todo el array

			System.out.println("Nombres: " + arrayNombre[i]);// imprime todos los nombres ( es el primer punto ). . .

		}
	}

	private static boolean guardar(String[] arrayNombre, String[] arrayTipo, int[] arrayNivel, int[] arrayAtaque,
			int[] arrayDefensa, int[] arrayVelocidad, File file) {

		try (PrintWriter escritor = new PrintWriter(new FileWriter(file))) {

			// Escribir el encabezado
			escritor.println("Nombre,Tipo,Nivel,Ataque,Defensa,Velocidad");

			// Escribir todos los datos
			for (int i = 0; i < arrayNombre.length; i++) {
				if (arrayNombre[i] != null) { // Solo si hay datos
					escritor.println(arrayNombre[i] + "," + arrayTipo[i] + "," + arrayNivel[i] + "," + arrayAtaque[i]
							+ "," + arrayDefensa[i] + "," + arrayVelocidad[i]);
				}
			}

			System.out.println(" Datos guardados correctamente en: " + file.getName());
			return true;

		} catch (IOException e) {
			System.out.println(" Error al guardar: " + e.getMessage());
			return false;
		}
	}

}