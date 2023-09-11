package mtpreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MTPreader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder contenidoArchivo = new StringBuilder();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        
        try {
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contenidoArchivo.append(linea).append(""); 
            }
            
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        String contenido = contenidoArchivo.toString();
        System.out.println("Contenido del archivo:" + contenido);

        System.out.print("Ingresa el primer número de la clave: ");
        int primerNumero = scanner.nextInt();

        System.out.print("Ingresa el segundo número de la clave: ");
        int segundoNumero = scanner.nextInt();
        
        System.out.print("Ingresa el tercer número de la clave: ");
        int numeroD = scanner.nextInt();

        char arrayD[] = contenido.toCharArray();

        for (int i = 0; i < arrayD.length; i++){
            arrayD[i] = (char)(arrayD[i]-(char)numeroD);
        }
        
        String desencriptado = String.valueOf(arrayD);
        
        String fraseOriginal = desencriptarFrase(desencriptado, primerNumero, segundoNumero);

        System.out.println("Frase original desencriptada: " + fraseOriginal);
    }

    public static String desencriptarFrase(String desencriptado, int primerNumero, int segundoNumero) {
        StringBuilder resultado = new StringBuilder();
        int contador = 0, contador2 = 0;
        
        char caracter;
        for (int i = 0; i < desencriptado.length(); i++) {
            if (++contador <= primerNumero){
                caracter = desencriptado.charAt(i);
            }else{
                for(int j = 0; j < segundoNumero; j++){
                    if(++contador2 < segundoNumero){
                        break;
                    }
                    else{
                        contador2 = 0;
                        contador = 0;
                        break;
                    }
                }
                
                caracter = '\0';
            }
            resultado.append(caracter);
            
        }

        return resultado.toString();
    }
}
