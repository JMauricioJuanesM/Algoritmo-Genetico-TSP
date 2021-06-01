  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.ArrayList;
import java.util.spi.CurrencyNameProvider;

/**
 *
 * @author working
 */
public class Individuo {
        
    // atributos de un individuo simple
    int n;
    private int[][] genotipo;
    private int[] fenotipo;
    private int fitness;
    private int ciudadInicial;
    private int[][] matrizDistancias;
    private int[][] matrizInclinaciones;
    

    public Individuo(int n, int[][] matrizDistancias, int ciudadInicial, int[][] matrizInclinaciones) {
        this.n = n;
        this.genotipo = new int[n][n];
        this.fenotipo = new int[n];
        this.ciudadInicial = ciudadInicial;
        this.matrizDistancias = matrizDistancias;
        this.matrizInclinaciones = matrizInclinaciones;
        // valorar su inicio aleatorio
        this.genotipo = Herramientas.generarTableroAleatorio(n);
        calcularFenotipo();
        calcularFitness();
    }
    
    public Individuo(int[][] gen, int[][] matrizDistancias, int ciudadInicial, int[][] matrizInclinaciones) {
        this.n = gen.length;
        this.genotipo = new int[n][n];
        this.fenotipo = new int[n];
        this.ciudadInicial = ciudadInicial;
        this.matrizDistancias = matrizDistancias;
        this.matrizInclinaciones = matrizInclinaciones;
        // valorar su inicio aleatorio
        this.genotipo = gen.clone();
        calcularFenotipo();
        calcularFitness();
    }

    public Individuo(int[] fen, int[][] matrizDistancias, int ciudadInicial, int[][] matrizInclinaciones) {
        this.n = fen.length;
        this.genotipo = new int[n][n];
        this.fenotipo = fen.clone();
        this.ciudadInicial = ciudadInicial;
        this.matrizDistancias = matrizDistancias.clone();
        this.matrizInclinaciones = matrizInclinaciones.clone();
        // valorar su inicio aleatorio
        calcularFitness();
    }

    public Individuo(Individuo i, int[][] matrizDistancias, int ciudadInicial, int[][] matrizInclinaciones) {
        //this.n = getGenotipo().length;
        
        this.genotipo = i.getGenotipo().clone();
        this.fenotipo = i.getFenotipo().clone();
        this.ciudadInicial = ciudadInicial;
        this.matrizDistancias = matrizDistancias.clone();
        this.matrizInclinaciones = matrizInclinaciones.clone();
        // this.genotipo = new int[n][n];
        // this.fenotipo = new int[n];
        this.fitness = i.getFitness();
    }

    private void calcularFenotipo (){
        // conversión entre la  representacion del arreglo de enteros a un valor decimal
        ArrayList<Integer> feno = new ArrayList<>();
        fenotipo[0] = ciudadInicial;
        feno.add(ciudadInicial);
        for(int i=1;i<n;i++){
            do{
                //int temp = (int) ((Math.random() * (n - 0)) + 0);
                int temp = Herramientas.getRandomNumber(0, n);

                boolean existe = feno.contains(temp);
                if (existe) {
                    //System.out.println("El elemento SÍ existe en la lista");
                } else {
                    fenotipo[i] = temp;
                    feno.add(temp);
                    break;
                    //System.out.println("El elemento no existe");
                }
            }while(true);
        }
    }

    public Boolean searchInArray(int search, int[]arr){
        Boolean finded = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==search){
                finded = true;
                break;
            }else{
                finded = false;
            }
        }
        return finded;
    }
    
    public void calcularFitness(){
       
        this.fitness = 0;
        int temp = 0;
        for(int i=0;i<fenotipo.length-1;i++){
            temp += matrizDistancias[fenotipo[i]][fenotipo[i+1]]*matrizInclinaciones[fenotipo[i]][fenotipo[i+1]];
        }
        temp += matrizDistancias[fenotipo[0]][fenotipo[fenotipo.length-1]]*matrizInclinaciones[fenotipo[0]][fenotipo[fenotipo.length-1]];
        this.fitness = temp;
    }

    /**
     * @return the genotipo
     */
    public int[][] getGenotipo() {
        return genotipo;
    }

    /**
     * @param genotipo the genotipo to set
     */
    public void setGenotipo(int[][] genotipo) {
        this.genotipo = genotipo;
    }

    /**
     * @return the fenotipo
     */
    public int[] getFenotipo() {
        return fenotipo;
    }

    /**
     * @param fenotipo the fenotipo to set
     */
    public void setFenotipo(int[] fenotipo) {
        this.fenotipo = fenotipo;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return fitness;
    }

    /**
     * @param fitness the fitness to set
     */
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        
        String aux = "Gen: "+ this.genotipo.toString()+" Fen: "+
        this.fenotipo+" Fit: "+this.fitness;
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
}
