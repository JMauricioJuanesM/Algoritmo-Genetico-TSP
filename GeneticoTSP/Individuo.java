import java.util.Arrays;

public class Individuo{

    public static void main(String Args[]){
        herramientas herr = new herramientas();
        String genotipo = herr.generarGenotipoAleatorio(5);
        System.out.println(genotipoAfenotipo(genotipo));
        System.out.println(calculateFitness(genotipoAfenotipo(genotipo)));

        System.out.println("Mejor cruza: "+metodoDeCruza("10101",herr.generarGenotipoAleatorio(5), herr.generarGenotipoAleatorio(5)));
    }

    public static int genotipoAfenotipo(String genotipo) {
        int fenotipo = Integer.parseInt(genotipo, 2);
        return fenotipo;
    }

    public static int calculateFitness(int fenotipo) {
        return fenotipo*fenotipo;
    }

    public static String metodoDeCruza(String mascara, String genotipo0, String genotipo1){
        String cruza0 = "";
        String cruza1 = "";
        String mejorCruza = "";
        int fenotipo_cruza0 = 0;
        int fenotipo_cruza1 = 0;

        int[] int_mascara, int_genotipo0, int_genotipo1;
        int_mascara = stringToIntArray(mascara);
        int_genotipo0 = stringToIntArray(genotipo0);
        int_genotipo1 = stringToIntArray(genotipo1);

        for(int i=0;i<mascara.length();i++){
            if(int_mascara[i]==1){
                cruza0 += int_genotipo0[i]+"";
            }else{
                cruza0 += int_genotipo1[i]+"";
            }
        }

        for(int i=0;i<mascara.length();i++){
            if(int_mascara[i]==1){
                cruza1 += int_genotipo1[i]+"";
            }else{
                cruza1 += int_genotipo0[i]+"";
            }
        }

        fenotipo_cruza0 = genotipoAfenotipo(cruza0);
        fenotipo_cruza1 = genotipoAfenotipo(cruza1);

        if(calculateFitness(fenotipo_cruza0)>calculateFitness(fenotipo_cruza1)){
            mejorCruza = cruza0;
        }else{
            mejorCruza = cruza1;
        }

        return mejorCruza;
    }

    public static int[] stringToIntArray(String in){
        char[] out = new char[in.length()];
        int[] out_int = new int[in.length()];

        for (int i = 0; i < in.length(); i++) { 
            out[i] = in.charAt(i); 
            out_int[i] = Integer.parseInt(out[i]+"");
        }
        return out_int;
    }
}