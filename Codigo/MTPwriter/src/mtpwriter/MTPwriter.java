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
        String cifrado;
        String archivo;
        
        Serializa serial = new Serializa();
        Aleatorios aleatorio = new Aleatorios();
        Cifrados cifrador = new Cifrados();
        
        Scanner scanner = new Scanner(System.in);
        
        desplazamiento = aleatorio.numeroRandom();
        frecuencia = aleatorio.numeroRandom();
        cantidad = aleatorio.numeroRandom();
        
        System.out.print("Ingresa una frase (solo letras, números y signos de puntuación básicos): ");
        mensaje = scanner.nextLine();
        
        while (!mensaje.matches("^[a-zA-Z0-9 ]*$")) {
            System.out.println("Por favor ingrese un mensaje que solo contenga números y letras.");
            mensaje = scanner.nextLine();
        }
        
        cifrado = cifrador.primerCifrado(mensaje, frecuencia, cantidad);
        
        cifrado = cifrador.segundoCifrado(cifrado, desplazamiento);

        System.out.println("Ingresa el nombre del archivo");
        archivo = scanner.nextLine();
        archivo =  archivo + ".txt";
        
        serial.serializar(cifrado,archivo);
        
        System.out.println("Frase encriptada: " + cifrado);
        System.out.println("Nombre del archivo: " + archivo);
        System.out.println("Clave secreta: " + frecuencia + cantidad + desplazamiento);
    }
    
}
