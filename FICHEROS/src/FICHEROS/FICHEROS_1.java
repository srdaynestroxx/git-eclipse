package FICHEROS;

import java.io.BufferedReader; 
import java.io.File;
import java.io.FileReader;
import java.io.IOException; 

public class FICHEROS_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//    	1- Dado el fichero kaixo-fitxategiak.txt, 
//    	hacer un programa que lea su contenido línea por línea. Es necesario utilizar FileReader.
//    	hola prueba
    	
        FileReader fr = null;
        BufferedReader br = null;

        try {
            File archivo = new File("C:\\Users\\1AWA-18\\Desktop\\tareas\\PROGRAM\\java\\ficheros\\kaixo-fitxategiak.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        }
    }

