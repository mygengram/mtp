package mtpreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MTPreader {
    public static void main(String[] args) {
        
        String archivo, cifrado, mensaje, clave;
        int frecuencia, cantidad, desplazamiento;
        
        Scanner scanner = new Scanner(System.in);
        
        Obtiene obtener = new Obtiene();
        Descifrados descifra = new Descifrados();

        System.out.print("Ingrese el nombre del archivo: ");
        archivo = scanner.nextLine()+".txt";
        
        cifrado = obtener.obtieneLinea(archivo);
        
        System.out.println("Contenido del archivo: " + cifrado);

        System.out.print("Ingresa la clave: ");
        clave = scanner.nextLine();
        
        frecuencia = Character.getNumericValue(clave.charAt(0));
        cantidad = Character.getNumericValue(clave.charAt(1));
        desplazamiento = Character.getNumericValue(clave.charAt(2));
                
        cifrado = descifra.primerDescifrado(cifrado, desplazamiento);
        mensaje = descifra.segundoDescifrado(cifrado,frecuencia,cantidad);

        System.out.println("Frase original desencriptada: " + mensaje);
        
    }

}
