package mtpwriter;

import java.util.Random;

public class Cifrados {

    StringBuilder builder;
    Random random;
    
    public String primerCifrado(String mensaje,int frecuencia,int cantidad) {
        
        builder = new StringBuilder();
        random = new Random();
        
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
    }
}
