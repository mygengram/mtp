package mtpwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MTPwriter {  
    public static void main(String[] args) {
        Random rand = new Random();
        int numeroD = rand.nextInt(9) + 1;

        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa una frase (solo letras, números y signos de puntuación básicos): ");
        String frase = scanner.nextLine();
        
        int primerNumeroAleatorio = generarNumeroAleatorio();
        int segundoNumeroAleatorio = generarNumeroAleatorio();
        
        String fraseEncriptada = encriptarFrase(frase, primerNumeroAleatorio, segundoNumeroAleatorio);
        
        
        
        String mensaje = fraseEncriptada;
        
        while (!mensaje.matches("^[a-zA-Z0-9 ]*$")) {
            System.out.println("Por favor ingrese un mensaje que solo contenga números y letras.");
            mensaje = scanner.nextLine();
        }

        char desface[] = mensaje.toCharArray();

        for (int i = 0; i < desface.length; i++){
            desface[i] = (char)(desface[i] + (char)numeroD);
        }
        String encriptado = String.valueOf(desface);

        String textoASerializar = encriptado;
        
        System.out.println("Ingresa el nombre del archivo");
        String archivo = scanner.nextLine();
        String nombreDelArchivo =  archivo + ".txt";
        System.out.println(numeroD);

        textoArchivo(textoASerializar, nombreDelArchivo);
        
        System.out.println("Primer número aleatorio generado: " + primerNumeroAleatorio);
        System.out.println("Segundo número aleatorio generado: " + segundoNumeroAleatorio);
        System.out.println("Segundo número aleatorio generado: " + numeroD);
        System.out.println("Frase encriptada: " + encriptado);
        System.out.println("Clave: " + primerNumeroAleatorio + segundoNumeroAleatorio + numeroD);
    }
    
    public static int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(5) + 1; // Genera un número aleatorio entre 1 y 9
    }
    
    public static String encriptarFrase(String frase, int primerNumero, int segundoNumero) {
        StringBuilder resultado = new StringBuilder();
        Random random = new Random();
        
        int contador = 0;
        
        for (int i = 0; i < frase.length(); i++) {
            resultado.append(frase.charAt(i));
            
            if (++contador == primerNumero) {
                for (int j = 0; j < segundoNumero; j++) {
                    char caracterAleatorio = generarCaracterAleatorio(random);
                    resultado.append(caracterAleatorio);
                }
                contador = 0;
            }
        }
        
        return resultado.toString();
    }
    
    public static char generarCaracterAleatorio(Random random) {
        String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int indice = random.nextInt(caracteresPermitidos.length());
        return caracteresPermitidos.charAt(indice);
    }
    public static void textoArchivo(String texto, String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);

            FileWriter escritor = new FileWriter(archivo);

            BufferedWriter bufferEscritura = new BufferedWriter(escritor);
            bufferEscritura.write(texto);
            bufferEscritura.close();

            System.out.println("Texto guardado en el archivo " + nombreArchivo);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
