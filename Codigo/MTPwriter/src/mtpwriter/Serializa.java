package mtpwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Serializa {
    
    File archivo;
    FileWriter escritor;
    BufferedWriter buffer;
    
    public void serializar(String cifrado, String nombreArchivo) {
        
        try {
            archivo = new File(nombreArchivo);
            escritor = new FileWriter(archivo);
            buffer = new BufferedWriter(escritor);
            buffer.write(cifrado);
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
