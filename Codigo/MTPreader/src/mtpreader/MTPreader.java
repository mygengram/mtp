package mtpreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MTPreader {
    public static void main(String[] args) {
        
        String archivo, cifrado, mensaje;
        int frecuencia, cantidad, desplazamiento;
        
        Scanner scanner = new Scanner(System.in);
        
        Obtiene obtener = new Obtiene();
        Descifrados descifra = new Descifrados();

        System.out.print("Ingrese el nombre del archivo: ");
        archivo = scanner.nextLine()+".txt";
        
        cifrado = obtener.obtieneLinea(archivo);
        
        System.out.println("Contenido del archivo:" + cifrado);

        System.out.print("Ingresa el primer número de la clave: ");
        frecuencia = scanner.nextInt();

        System.out.print("Ingresa el segundo número de la clave: ");
        cantidad = scanner.nextInt();
        
        System.out.print("Ingresa el tercer número de la clave: ");
        desplazamiento = scanner.nextInt();

        cifrado = descifra.primerDescifrado(cifrado, desplazamiento);
        mensaje = descifra.segundoDescifrado(cifrado,frecuencia,cantidad);

        System.out.println("Frase original desencriptada: " + mensaje);
        
    }

}
