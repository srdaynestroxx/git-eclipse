package NUTRICIONISTA;

import java.io.*;
import java.util.*;
import java.text.NumberFormat;
import java.text.ParseException;

public class NUTRICIONISTA {
	
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String linea = null;
        String[] campos;
        
        // Declaro mis arrays para guardar todos los datos del archivo
        String[] arrayNombre = new String[404];
        String[] arrayEstado = new String[404];
        double[] arrayCalorias = new double[404];
        double[] arrayProteinas = new double[404];
        double[] arrayGrasas = new double[404];
        double[] arrayCarbohidratos = new double[404];
        String[] arrayTipos = new String[404];
        
        // Cargo el archivo con los datos de alimentos
        File file = new File("C:\\Users\\Daymer\\Desktop\\ESTUDIOS\\tareas-trabajosFP\\program\\java\\ficheros\\janariak.txt");
        
        try {
            // Leo el archivo y guardo todos los datos en mis arrays
            Scanner scFile = new Scanner(file);
            int i = 0;
            
            while (scFile.hasNext()) {
                linea = scFile.nextLine();
                campos = linea.split(";"); // Separo los datos por punto y coma
                
                // Guardo cada dato en su array correspondiente
                arrayNombre[i] = campos[0];
                arrayEstado[i] = campos[1];
                arrayCalorias[i] = NumberFormat.getInstance().parse(campos[2]).doubleValue();
                arrayProteinas[i] = NumberFormat.getInstance().parse(campos[3]).doubleValue();
                arrayGrasas[i] = NumberFormat.getInstance().parse(campos[4]).doubleValue();
                arrayCarbohidratos[i] = NumberFormat.getInstance().parse(campos[5]).doubleValue();
                arrayTipos[i] = campos[6];
                i++;
            }
            
            scFile.close();
            System.out.println("Datos cargados correctamente! Se han leído " + i + " alimentos.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo encontrar el archivo de datos.");
            return;
        }
        
        // Menú principal del programa
        do {
            System.out.println("\n=== MENÚ NUTRICIONISTA ===");
            System.out.println("0 - SALIR");
            System.out.println("1 - LISTAR TODOS LOS ALIMENTOS");
            System.out.println("2 - BUSCAR ALIMENTO POR NOMBRE");
            System.out.println("3 - BUSCAR POR TIPO DE ALIMENTO");
            System.out.println("4 - ALIMENTOS BAJOS EN CALORÍAS");
            System.out.println("5 - ALIMENTOS ALTOS EN PROTEÍNAS");
            System.out.println("6 - GUARDAR DATOS EN NUEVO ARCHIVO");
            System.out.println("7 - CONSULTAR INFORMACIÓN COMPLETA");
            
            System.out.print("Selecciona una opción (0-7): ");
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 0:
                    System.out.println("¡Gracias por usar el programa! ¡Hasta pronto!");
                    break;
                    
                case 1:
                    listarAlimentos(arrayNombre, arrayEstado, arrayTipos);
                    break;
                    
                case 2:
                    buscarPorNombre(arrayNombre, arrayEstado, arrayCalorias, arrayProteinas, arrayGrasas, arrayCarbohidratos, arrayTipos);
                    break;
                    
                case 3:
                    buscarPorTipo(arrayNombre, arrayTipos);
                    break;
                    
                case 4:
                    alimentosBajosCalorias(arrayNombre, arrayCalorias, arrayTipos);
                    break;
                    
                case 5:
                    alimentosAltosProteinas(arrayNombre, arrayProteinas, arrayTipos);
                    break;
                    
                case 6:
                    guardarDatos(arrayNombre, arrayEstado, arrayCalorias, arrayProteinas, arrayGrasas, arrayCarbohidratos, arrayTipos);
                    break;
                    
                case 7:
                    consultarInformacionCompleta(arrayNombre, arrayEstado, arrayCalorias, arrayProteinas, arrayGrasas, arrayCarbohidratos, arrayTipos);
                    break;
                    
                default:
                    System.out.println("Opción no válida. Por favor, elige entre 0 y 7.");
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
    
    // Método para listar todos los alimentos
    private static void listarAlimentos(String[] nombres, String[] estados, String[] tipos) {
        System.out.println("\n=== LISTA DE TODOS LOS ALIMENTOS ===");
        for(int i = 0; i < nombres.length && nombres[i] != null; i++) {
            System.out.println((i+1) + ". " + nombres[i] + " - " + estados[i] + " - " + tipos[i]);
        }
    }
    
    // Método para buscar un alimento por nombre
    private static void buscarPorNombre(String[] nombres, String[] estados, double[] calorias, 
                                      double[] proteinas, double[] grasas, double[] carbohidratos, String[] tipos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del alimento a buscar: ");
        String nombreBuscado = scanner.next().toLowerCase();
        
        boolean encontrado = false;
        
        for(int i = 0; i < nombres.length && nombres[i] != null; i++) {
            if(nombres[i].toLowerCase().contains(nombreBuscado)) {
                encontrado = true;
                System.out.println("\n--- INFORMACIÓN NUTRICIONAL ---");
                System.out.println("Nombre: " + nombres[i]);
                System.out.println("Estado: " + estados[i]);
                System.out.println("Tipo: " + tipos[i]);
                System.out.println("Calorías: " + calorias[i] + " kcal");
                System.out.println("Proteínas: " + proteinas[i] + " g");
                System.out.println("Grasas: " + grasas[i] + " g");
                System.out.println("Carbohidratos: " + carbohidratos[i] + " g");
                System.out.println("--------------------------------");
            }
        }
        
        if(!encontrado) {
            System.out.println("No se encontró ningún alimento con ese nombre.");
        }
    }
    
    // Método para buscar alimentos por tipo
    private static void buscarPorTipo(String[] nombres, String[] tipos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el tipo de alimento (hotaliza, frutafresca, lacteo, etc.): ");
        String tipoBuscado = scanner.next().toLowerCase();
        
        boolean encontrado = false;
        System.out.println("\n=== ALIMENTOS DEL TIPO: " + tipoBuscado.toUpperCase() + " ===");
        
        for(int i = 0; i < tipos.length && tipos[i] != null; i++) {
            if(tipos[i].toLowerCase().equals(tipoBuscado)) {
                encontrado = true;
                System.out.println("- " + nombres[i]);
            }
        }
        
        if(!encontrado) {
            System.out.println("No se encontraron alimentos de ese tipo.");
        }
    }
    
    // Método para mostrar alimentos bajos en calorías (menos de 50 kcal)
    private static void alimentosBajosCalorias(String[] nombres, double[] calorias, String[] tipos) {
        System.out.println("\n=== ALIMENTOS BAJOS EN CALORÍAS (< 50 kcal) ===");
        boolean encontrado = false;
        
        for(int i = 0; i < calorias.length && nombres[i] != null; i++) {
            if(calorias[i] < 50) {
                encontrado = true;
                System.out.println("- " + nombres[i] + " (" + calorias[i] + " kcal) - " + tipos[i]);
            }
        }
        
        if(!encontrado) {
            System.out.println("No se encontraron alimentos bajos en calorías.");
        }
    }
    
    // Método para mostrar alimentos altos en proteínas (más de 20g)
    private static void alimentosAltosProteinas(String[] nombres, double[] proteinas, String[] tipos) {
        System.out.println("\n=== ALIMENTOS ALTOS EN PROTEÍNAS (> 20g) ===");
        boolean encontrado = false;
        
        for(int i = 0; i < proteinas.length && nombres[i] != null; i++) {
            if(proteinas[i] > 20) {
                encontrado = true;
                System.out.println("- " + nombres[i] + " (" + proteinas[i] + " g proteínas) - " + tipos[i]);
            }
        }
        
        if(!encontrado) {
            System.out.println("No se encontraron alimentos altos en proteínas.");
        }
    }
    
    // Método para guardar los datos en un nuevo archivo
    private static void guardarDatos(String[] nombres, String[] estados, double[] calorias, 
                                   double[] proteinas, double[] grasas, double[] carbohidratos, String[] tipos) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Daymer\\Desktop\\ESTUDIOS\\tareas-trabajosFP\\program\\java\\ficheros\\datos_nutricionales_guardados.txt");
            
            writer.write("=== DATOS NUTRICIONALES GUARDADOS ===\n\n");
            
            for(int i = 0; i < nombres.length && nombres[i] != null; i++) {
                writer.write("Alimento: " + nombres[i] + "\n");
                writer.write("Estado: " + estados[i] + "\n");
                writer.write("Tipo: " + tipos[i] + "\n");
                writer.write("Calorías: " + calorias[i] + " kcal\n");
                writer.write("Proteínas: " + proteinas[i] + " g\n");
                writer.write("Grasas: " + grasas[i] + " g\n");
                writer.write("Carbohidratos: " + carbohidratos[i] + " g\n");
                writer.write("-----------------------------------\n");
            }
            
            writer.close();
            System.out.println("Datos guardados correctamente en 'datos_nutricionales_guardados.txt'");
            
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo.");
        }
    }
    
    // Método para consultar información completa de un alimento específico
    private static void consultarInformacionCompleta(String[] nombres, String[] estados, double[] calorias, 
                                                   double[] proteinas, double[] grasas, double[] carbohidratos, String[] tipos) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== CONSULTA DE INFORMACIÓN COMPLETA ===");
        System.out.print("Introduce el número del alimento (1-" + contarAlimentos(nombres) + "): ");
        int numero = scanner.nextInt() - 1;
        
        if(numero >= 0 && numero < contarAlimentos(nombres)) {
            System.out.println("\n--- INFORMACIÓN COMPLETA ---");
            System.out.println("Nombre: " + nombres[numero]);
            System.out.println("Estado: " + estados[numero]);
            System.out.println("Tipo: " + tipos[numero]);
            System.out.println("Calorías: " + calorias[numero] + " kcal");
            System.out.println("Proteínas: " + proteinas[numero] + " g");
            System.out.println("Grasas: " + grasas[numero] + " g");
            System.out.println("Carbohidratos: " + carbohidratos[numero] + " g");
            System.out.println("-----------------------------");
        } else {
            System.out.println("Número de alimento no válido.");
        }
    }
    
    // Método auxiliar para contar cuántos alimentos hay
    private static int contarAlimentos(String[] nombres) {
        int count = 0;
        for(int i = 0; i < nombres.length && nombres[i] != null; i++) {
            count++;
        }
        return count;
    }
}