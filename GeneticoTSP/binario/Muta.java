package binario;

import java.util.Random;

public class Muta {
    
    public static void mutaSimple(Individuo ind){
        Random ran = new Random();
        
        int pos = Herramientas.getRandomNumber(1, ind.getFenotipo().length);
        int pos2 = Herramientas.getRandomNumber(1, ind.getFenotipo().length);
        int gen1 = ind.getFenotipo()[pos];
        int gen2 = ind.getFenotipo()[pos2];

        ind.getFenotipo()[pos] = gen2;
        ind.getFenotipo()[pos2] = gen1;

        ind.calcularFitness();
    }   
}
