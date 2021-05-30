import java.util.ArrayList;
import java.util.Random;

public class seleccion {
    public static Individuo seleccionAleatoria(ArrayList<Individuo> pob){
        Random ran = new Random();
        int pos = ran.nextInt(pob.size());
        return new Individuo();
    }
}
