package mtpreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Obtiene {
    
    String linea;
    FileReader fileReader;
    BufferedReader bufferedReader;
    StringBuilder builder;
    
    public String obtieneLinea(String archivo) {
        
        String cifrado;
        
        try {
            builder = new StringBuilder();
            fileReader = new FileReader(archivo);
            bufferedReader = new BufferedReader(fileReader);
            
            linea = bufferedReader.readLine();
            
            while (linea != null) {
                builder.append(linea).append("");
                linea = bufferedReader.readLine();
            }
            
            System.out.println("Archivo encontrado: " + archivo);
            bufferedReader.close();
            
        } catch (IOException e) {
            
            System.err.println("Error al leer el archivo \"" + archivo + "\": " + e.getMessage());
            
        }
        
        cifrado = builder.toString();
        return cifrado;
    }
    
}
