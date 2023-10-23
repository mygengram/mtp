package mtpwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MTPwriter {  
    public static void main(String[] args) {
        
        int frecuencia;
        int cantidad;
        int desplazamiento;
        String mensaje;
        String cifrado1;
        String cifrado2;
        
        Serializa serial = new Serializa();
        Aleatorios aleatorio = new Aleatorios();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa una frase (solo letras, números y signos de puntuación básicos): ");
        mensaje = scanner.nextLine();
        
        desplazamiento = aleatorio.numeroRandom();
        frecuencia = aleatorio.numeroRandom();
        cantidad = aleatorio.numeroRandom();
        
        cifrado1 = encriptarFrase(mensaje,frecuencia,cantidad);
        
        
        
        mensaje = cifrado1;
        
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
        
        serial.serializar(textoASerializar, nombreDelArchivo);
        
        System.out.println("Primer número aleatorio generado: " + primerNumeroAleatorio);
        System.out.println("Segundo número aleatorio generado: " + segundoNumeroAleatorio);
        System.out.println("Segundo número aleatorio generado: " + numeroD);
        System.out.println("Frase encriptada: " + encriptado);
        System.out.println("Clave: " + primerNumeroAleatorio + segundoNumeroAleatorio + numeroD);
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
   
}
