import java.util.Random;

public class herramientas {
    public static String generarGenotipoAleatorio(int n){
        String genotipo = "";
        Random rand = new Random();

        for(int i=0;i<n;i++){
            genotipo +=  rand.nextInt(2)+"";
        }

        return genotipo;
    }
}
